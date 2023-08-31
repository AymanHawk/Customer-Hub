package com.sample.customer.requests;

import org.springframework.data.annotation.Id;

public class Subscriptions
{


    private Long subscriptionId;

    public Long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    private String lineNo;

    private String lineAlias;

    public String getLineNo() {
        return lineNo;
    }

    public void setLineNo(String lineNo) {
        this.lineNo = lineNo;
    }

    public String getLineAlias() {
        return lineAlias;
    }

    public void setLineAlias(String lineAlias) {
        this.lineAlias = lineAlias;
    }
}
