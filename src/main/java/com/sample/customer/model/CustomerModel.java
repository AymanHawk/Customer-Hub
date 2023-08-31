package com.sample.customer.model;

import com.sample.customer.requests.Address;
import com.sample.customer.requests.Subscriptions;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Document(collection = "customer")

public class CustomerModel {
     @Id
    private Long customerId;

    private String firstName;
    @NotEmpty
    private String lastName;
    @Email(message = "Not valid email")
    private String email;

    private Address address;


    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    private List<Subscriptions> subscriptions;
//    private List<Subscriptions> subs;
//
//    public List<Subscriptions> getSubs() {
//        return subs;
//    }
//
//    public void setSubs(List<Subscriptions> subs) {
//        this.subs = subs;
//    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public Address getAddress() {

        return address;
    }

    public void setAddress(Address address) {

        this.address = address;
    }

    public List<Subscriptions> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscriptions> subscriptions) {
        this.subscriptions = subscriptions;
    }

}
