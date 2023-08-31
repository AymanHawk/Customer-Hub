package com.sample.customer.tasks;

import com.sample.customer.model.CustomerModel;
import com.sample.customer.repository.CustomerRepositoryHelper;
import com.sample.customer.requests.Customer;
import com.sample.customer.requests.ModifyEmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class UpdateCustomerEmailTasks {

    @Autowired
    private CustomerRepositoryHelper customerRepoHelper;
    public CustomerModel updateCustomerEmail(ModifyEmailRequest customerParam){
        try{
            CustomerModel customerModel = customerRepoHelper.findById(customerParam.getCustomerId());
            return changeCustomerEmail(customerModel, customerParam);

        }catch(Exception e){
            throw new RuntimeException("Error occured while updating cutomer email");
        }
    }


    private CustomerModel changeCustomerEmail(CustomerModel customer, ModifyEmailRequest customerParam) {
       customer.setEmail(customerParam.getEmail());
       return customerRepoHelper.saveCustomerObject(customer);
    }

}
