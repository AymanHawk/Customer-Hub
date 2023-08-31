package com.sample.customer.requests;


import com.sample.customer.model.CustomerModel;
import com.sample.customer.model.SubscriptionsModel;

import javax.validation.constraints.NotNull;
import java.util.List;

public class ModifySubsRequests {

    @NotNull
    private Long customerId;

    private Long subscriptionId;

    private Subscriptions subscriptions;

    private CustomerModel cusmod;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<Subscriptions> getSubscriptions(){
        return cusmod.getSubscriptions();
    }

    public Subscriptions getSubs() {
        return subscriptions;
    }

    public void setSubs(Subscriptions subs) {
        this.subscriptions = subs;
    }
}
