package com.sample.customer.operations;

import com.sample.customer.model.CustomerModel;
import com.sample.customer.requests.*;
import com.sample.customer.response.CustomerResp;
import com.sample.customer.tasks.*;
import com.sample.customer.tasks.UpdateCustomerEmailTasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerOperationsImpl implements CustomerOperations {

    @Autowired
    private SaveCustomerTasks saveCustomerTasks;
    @Autowired
    private DeleteCustomerTasks deleteCustomerTasks;
    @Autowired
    private GetCustomerTasks getCustomerTasks;
    @Autowired
    private UpdateCustomerEmailTasks updateCustomerTasks;
    @Autowired
    private UpdateCustomerAddressTasks updateCustomerAddressTasks;
    @Autowired
    private UpdateCustomerSubsTasks updateCustomerSubsTasks;
    @Autowired
    private DeleteSubscriptionTasks deleteSubscriptionTasks;
    @Override
    public ResponseEntity<CustomerResp> getCustomer(Long customerId) {
    CustomerResp retrievedCustomer = getCustomerTasks.getCustomer(customerId);
    return new ResponseEntity<>(retrievedCustomer, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CustomerModel> saveCustomer(Customer customer) {
        CustomerModel createdCustomer =  saveCustomerTasks.createCustomer(customer);
        return new ResponseEntity<>(createdCustomer, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteCustomer(String customerId) {
        String status = deleteCustomerTasks.deleteCustomer(Long.valueOf(customerId));
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteSubscription(String customerId,String subscriptionId){
        String status = deleteSubscriptionTasks.deleteSubs(Long.valueOf(customerId), Long.valueOf(subscriptionId));
        return  new ResponseEntity<>(status, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CustomerModel> modifyCustomerEmail(ModifyEmailRequest customerParam) {

        CustomerModel customerModel = updateCustomerTasks.updateCustomerEmail(customerParam);
        return new ResponseEntity<>(customerModel, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<CustomerModel> modifyCustomerAddress(ModifyAddressRequest customerParam) {

        CustomerModel customerModel = updateCustomerAddressTasks.updateCustomerAddress(customerParam);
        return new ResponseEntity<>(customerModel, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CustomerModel> modifyCustomerSubs(ModifySubsRequests customerParam){
        CustomerModel customerModel = updateCustomerSubsTasks.updateCustomerSubs(customerParam);
        return new ResponseEntity<>(customerModel, HttpStatus.OK);
    }
}
