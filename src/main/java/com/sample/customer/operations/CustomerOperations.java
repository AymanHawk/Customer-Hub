package com.sample.customer.operations;

import com.sample.customer.model.CustomerModel;
import com.sample.customer.requests.Customer;
import com.sample.customer.requests.ModifyAddressRequest;
import com.sample.customer.requests.ModifyEmailRequest;
import com.sample.customer.requests.ModifySubsRequests;
import com.sample.customer.response.CustomerResp;
import org.springframework.http.ResponseEntity;

public interface CustomerOperations {

    public ResponseEntity<CustomerResp> getCustomer(Long customerId);


    public ResponseEntity<CustomerModel> saveCustomer(Customer customer);


    public ResponseEntity<String> deleteCustomer(String customerId);

    public ResponseEntity<String> deleteSubscription(String customerId, String subscriptionId);


    public ResponseEntity<CustomerModel> modifyCustomerEmail(ModifyEmailRequest customer);

    public ResponseEntity<CustomerModel> modifyCustomerAddress(ModifyAddressRequest customer);

    public ResponseEntity<CustomerModel> modifyCustomerSubs(ModifySubsRequests customer);

}
