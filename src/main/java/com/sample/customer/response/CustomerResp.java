package com.sample.customer.response;

public class CustomerResp {

    private Long customerId;

    private String firstName;
    private String lastName;

    private int numOfSubscriptions;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumOfSubscriptions() {
        return numOfSubscriptions;
    }

    public void setNumOfSubscriptions(int numOfSubscriptions) {
        this.numOfSubscriptions = numOfSubscriptions;
    }
}
