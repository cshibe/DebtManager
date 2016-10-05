package com.main;

/**
 * Created by coltonshibe on 10/4/16.
 */
public class Setup {
    public Setup(){}
    public void init()
    {
        Loan carLoan = new Loan();
        carLoan.setInterestRate(0.069);
        carLoan.setPrincipleAmount(26422.65);
        carLoan.setWeeklyPayment(108.0);

        carLoan.runDay();

        for(int i=0; i <8; i++)
        {
            carLoan.runDay();
        }
        System.out.println(carLoan.getInterestRunningAmount());
        System.out.println(carLoan.getDailyInterestAmount());
        System.out.println(carLoan.getPrincipleAmount());

        carLoan.runPayment();
        System.out.println(carLoan.getInterestRunningAmount());
        System.out.println(carLoan.getDailyInterestAmount());
        System.out.println(carLoan.getPrincipleAmount());
    }
}
