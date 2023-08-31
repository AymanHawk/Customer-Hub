package com.sample.customer.model;

import org.springframework.data.annotation.Id;

public class SubscriptionsModel
{

    @Id
    private Long subscriptionId;
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
