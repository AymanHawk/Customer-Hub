package com.sample.customer.tasks;

import com.sample.customer.exception.ApiRequestException;
import com.sample.customer.model.CustomerModel;
import com.sample.customer.repository.CustomerRepositoryHelper;
import com.sample.customer.requests.Customer;
import com.sample.customer.requests.ModifySubsRequests;
import com.sample.customer.requests.Subscriptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeleteSubscriptionTasks {

    private static  final String SUCCESS_MESSAGE = "Customer %s removed successfully";

    private static  final String FAILURE_MESSAGE = "Customer with ID %s does not exist";

    @Autowired
    private CustomerRepositoryHelper customerRepositoryHelper;

    public CustomerModel fetchCustomer(Long customerId){
        return customerRepositoryHelper.findById(customerId);
    }

    public String deleteSubs(Long customerID, Long subscriptionId){
try{
        CustomerModel custFromDB = fetchCustomer(customerID);

        List<Subscriptions> finalSubs = Optional.ofNullable(custFromDB)
                .map(cust-> cust.getSubscriptions())
                .orElse(Collections.emptyList())
                .stream() // similar to for loop -> will iterate through each index
                .filter(s ->   ! subscriptionId.equals(s.getSubscriptionId()))
                .collect(Collectors.toList());
        custFromDB.setSubscriptions(finalSubs);

        customerRepositoryHelper.saveCustomerObject(custFromDB);
        return "subscription removed successfully";
        }catch(Exception e){
            throw new ApiRequestException(FAILURE_MESSAGE);
        }


    }
    private BigDecimal converToBigDecimal(Long val){
        return new BigDecimal(val);
    }
    private boolean customerExists(Long customerID) {

        return customerRepositoryHelper.findById(customerID) !=null;
    }


}


