package com.sample.customer.tasks;

import com.sample.customer.model.CustomerModel;
import com.sample.customer.repository.CustomerRepositoryHelper;
import com.sample.customer.requests.ModifyAddressRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateCustomerAddressTasks {

    @Autowired
    private CustomerRepositoryHelper customerRepositoryHelper;
    public CustomerModel updateCustomerAddress(ModifyAddressRequest customerParam){
        try{
            CustomerModel customerModel = customerRepositoryHelper.findById(customerParam.getCustomerId());
            return changeCustomerAddress(customerModel, customerParam);
        }catch(Exception e){
            throw new RuntimeException("Error occurred while changing customer address");
        }
    }

    private CustomerModel changeCustomerAddress(CustomerModel customer, ModifyAddressRequest customerParam) {
        customer.setAddress(customerParam.getAddress());
        return customerRepositoryHelper.saveCustomerObject(customer);
    }
}
