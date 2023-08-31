package com.sample.customer.tasks;

import com.sample.customer.model.CustomerModel;
import com.sample.customer.model.SubscriptionsModel;
import com.sample.customer.repository.CustomerRepositoryHelper;
import com.sample.customer.requests.ModifySubsRequests;
import com.sample.customer.requests.Subscriptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdateCustomerSubsTasks {

    @Autowired
    private CustomerRepositoryHelper customerRepositoryHelper;

    public CustomerModel updateCustomerSubs(ModifySubsRequests customerParam){
        try{
            CustomerModel customerModel = customerRepositoryHelper.findById(customerParam.getCustomerId());
            return changeCustomerSubs(customerModel, customerParam);
        }catch(Exception e){
            throw new RuntimeException("Error occured while updating customer subs");
        }
    }

    private CustomerModel changeCustomerSubs(CustomerModel customer, ModifySubsRequests customerParam) {
        customer.setSubscriptions(customerParam.getSubscriptions());
        return customerRepositoryHelper.saveCustomerObject(customer);
    }
}
