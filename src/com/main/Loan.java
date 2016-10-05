package com.main;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.DoubleSummaryStatistics;

public class Loan {

    private Double principleAmount;
    private Double interestRunningAmount=0.0;
    private Double interestRate;
    private Date startDate;
    private Double weeklyPayment;

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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
        interestRunningAmount += getDailyInterestAmount();
        interestRunningAmount = round(interestRunningAmount);
    }

    public Double getInterestRunningAmount() {
        return interestRunningAmount;
    }

    public void setInterestRunningAmount(Double interestRunningAmount) {
        this.interestRunningAmount = interestRunningAmount;
    }

    public void runPayment()
    {
        weeklyPayment = weeklyPayment - interestRunningAmount;
        interestRunningAmount = 0.0;
        principleAmount = principleAmount - weeklyPayment;
    }

    public Double round(Double value)
    {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
