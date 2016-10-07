package com.main;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Loan {

    private Double principleAmount;
    private Double interestRunningAmount = 0.0;
    private Double interestRate;
    private Calendar startDate;
    private Calendar currentDate;
    private Double weeklyPayment;
    private Double totalAmountPaid = 0.0;
    private Double totalInterestAmountPaid = 0.0;
    private Collection<Payment> payments = new ArrayList<>();

    public Loan() {}

    public Double getPrincipleAmount() {
        return principleAmount;
    }

    public void setPrincipleAmount(Double principleAmount) {
        this.principleAmount = principleAmount;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
        this.currentDate = startDate;
    }

    public Double getWeeklyPayment() {
        return weeklyPayment;
    }

    public void setWeeklyPayment(Double weeklyPayment) {
        this.weeklyPayment = weeklyPayment;
    }

    public Double getDailyInterestAmount()
    {
        return round((principleAmount * interestRate) / 365);
    }

    public void runDay()
    {
        currentDate.add(Calendar.DAY_OF_MONTH, 1);
        interestRunningAmount += getDailyInterestAmount();
        interestRunningAmount = round(interestRunningAmount);
    }

    public Calendar getCurrentDate() {
        return currentDate;
    }

    public Double getInterestRunningAmount() {
        return interestRunningAmount;
    }

    public void setInterestRunningAmount(Double interestRunningAmount) {
        this.interestRunningAmount = interestRunningAmount;
    }

    public void runPayment()
    {
        totalAmountPaid += weeklyPayment;
        totalInterestAmountPaid += interestRunningAmount;
        Double remainingAmount = weeklyPayment - interestRunningAmount;
        interestRunningAmount = 0.0;
        principleAmount = principleAmount - remainingAmount;
    }

    public Double round(Double value)
    {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.CEILING);
        return bd.doubleValue();
    }

    public Double getTotalAmountPaid() {
        return totalAmountPaid;
    }

    public void setTotalAmountPaid(Double totalAmountPaid) {
        this.totalAmountPaid = totalAmountPaid;
    }

    public Double getTotalInterestAmountPaid() {
        return round(totalInterestAmountPaid);
    }

    public void setTotalInterestAmountPaid(Double totalInterestAmountPaid) {
        this.totalInterestAmountPaid = totalInterestAmountPaid;
    }

    public void addPayment(Payment payment)
    {
        payments.add(payment);
    }

    public Collection<Payment> getPayments()
    {
        Collection<Payment> copy = payments;
        return  copy;
    }
}
