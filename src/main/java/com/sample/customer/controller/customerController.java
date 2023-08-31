package com.sample.customer.controller;

import com.sample.customer.model.CustomerModel;
import com.sample.customer.operations.CustomerOperations;
import com.sample.customer.requests.Customer;
import com.sample.customer.requests.ModifyAddressRequest;
import com.sample.customer.requests.ModifyEmailRequest;
import com.sample.customer.requests.ModifySubsRequests;
import com.sample.customer.response.CustomerResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/Customers")
public class customerController {
    @Autowired
    private CustomerOperations customerOperations;

    @PostMapping(value = "/save")
    public ResponseEntity<CustomerModel> saveCustomer(@Valid @RequestBody Customer customer) {

        return customerOperations.saveCustomer(customer);

    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<CustomerResp> getCustomer(@PathVariable Long id){
        return customerOperations.getCustomer(id);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> deleteCustomer(@RequestParam(name = "customerID", required = true) String customerId){
        return customerOperations.deleteCustomer(customerId);
    }

    @DeleteMapping(value = "/deleteSubs")
    public ResponseEntity<String> deleteSubscription(@RequestParam(name = "customerId", required = true) String customerId,
                                                     @RequestParam(name = "subscriptionId", required = true) String subscriptionId){
        return customerOperations.deleteSubscription(customerId , subscriptionId);
    }

    @PutMapping(value = "/modify/email")
    public ResponseEntity<CustomerModel> modifyCustomerEmail(@Valid @RequestBody ModifyEmailRequest modifyEmail) {
        return customerOperations.modifyCustomerEmail(modifyEmail);
    }
    @PutMapping(value = "/modify/address")
    public ResponseEntity<CustomerModel> modifyCustomerAddress(@Valid @RequestBody ModifyAddressRequest customer) {
        return customerOperations.modifyCustomerAddress(customer);
    }
    @PutMapping(value = "/modify/subscriptions")
    public ResponseEntity<CustomerModel> modifyCustomerSubs(@Valid @RequestBody ModifySubsRequests customer){
        return customerOperations.modifyCustomerSubs(customer);
    }

}
