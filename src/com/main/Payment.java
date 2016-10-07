package com.main;

import java.util.Date;

/**
 * Created by coltonshibe on 10/6/16.
 */
public class Payment {
    private Double amount;
    private Date paymentDate;

    public Payment(Double amount, Date paymentDate)
    {
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
