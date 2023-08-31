package com.sample.customer.requests;

import com.sample.customer.model.AddressModel;

import javax.validation.constraints.NotNull;

public class ModifyAddressRequest {

    @NotNull
    private Long customerId;

    private Address address;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
