package com.sample.customer.tasks;

import com.sample.customer.exception.ApiRequestException;
import com.sample.customer.model.CustomerModel;
import com.sample.customer.repository.CustomerRepositoryHelper;
import com.sample.customer.requests.Customer;
import com.sample.customer.response.CustomerResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetCustomerTasks {

    @Autowired
    private CustomerRepositoryHelper customerRepositoryHelper;

    public CustomerResp getCustomer(Long customerId){
        CustomerModel customerModel = customerRepositoryHelper.findById(customerId);
        if(customerModel != null) {
            return buildCustResponse(customerModel);
        }else {
            throw new ApiRequestException("Customer does not exist/ CUSTOM EXCEPTION");
        }
    }

    private CustomerResp buildCustResponse(CustomerModel customerModel) {

        CustomerResp cusRes = new CustomerResp();
        cusRes.setCustomerId(customerModel.getCustomerId());
        cusRes.setFirstName(customerModel.getFirstName());
        cusRes.setLastName(customerModel.getLastName());
        cusRes.setNumOfSubscriptions(Optional.ofNullable(customerModel.getSubscriptions())
                .map(s -> s.size()).orElse(0));

        return cusRes;
    }



}
