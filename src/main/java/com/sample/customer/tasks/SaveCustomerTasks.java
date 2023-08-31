package com.sample.customer.tasks;

import com.sample.customer.model.AddressModel;
import com.sample.customer.model.CustomerModel;
import com.sample.customer.model.SubscriptionsModel;
import com.sample.customer.repository.CustomerRepositoryHelper;
import com.sample.customer.requests.Address;
import com.sample.customer.requests.Customer;
import com.sample.customer.requests.Subscriptions;

import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SaveCustomerTasks {

    @Autowired
    private CustomerRepositoryHelper customerRepoHelper;
    public CustomerModel createCustomer(Customer customer){
       try{
           CustomerModel customerModel = buildCustomer(customer);
            return customerRepoHelper.saveCustomerObject(customerModel);

       }catch(Exception e){
          throw new RuntimeException("Error occured while saving cutomer");
       }
        /**
         * BUSINESS LOGIC
         */
    }


    private CustomerModel buildCustomer(Customer customer) {
        CustomerModel custModel = new CustomerModel();

        custModel.setCustomerId(getUniqueId());
        custModel.setFirstName(customer.getFirstName());
        custModel.setLastName(Optional.ofNullable(customer.getLastName()).filter(ln-> ! StringUtils.isEmpty(ln)).orElse("LNU"));
        custModel.setEmail(Optional.ofNullable(customer.getEmail()).filter(em-> ! StringUtils.isEmpty(em)).orElse("Email Not Provided"));
        custModel.setAddress(createAddress(customer.getAddress()));
        custModel.setSubscriptions(createSubscriptions(customer.getSubscriptions()));

        return custModel;
    }

    private List<Subscriptions> createSubscriptions(List<Subscriptions> subscriptions) {

//        Subscriptions subs = new Subscriptions();
//        subs.setSubscriptionId(getUniqueId());
       return Optional.ofNullable(subscriptions)
               .orElse(Collections.emptyList())
               .stream()
               .map(srcSubs -> {

                   Subscriptions subsModel = new Subscriptions();

                   BeanUtils.copyProperties(srcSubs,subsModel);
                   subsModel.setSubscriptionId(getUniqueId());
                   return subsModel;

               })
               .collect(Collectors.toList());
    }

    private Address createAddress(Address address) {


       return Optional.ofNullable(address)
                .map(add -> {
                    Address Address = new Address();

                    BeanUtils.copyProperties(add,Address);
                    return Address;
                })
                .orElse(new Address());
    }

    public Long getUniqueId() {
        ObjectId source = ObjectId.get();
        String strValue = new BigInteger(source.toString(), 16).toString();
        String a = new StringBuffer(strValue.substring(0, 1)).append(strValue.substring(20)).toString();
        return Long.valueOf(a);
    }

}
