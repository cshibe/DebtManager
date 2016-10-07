package com.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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

    public void init2()
    {
        Loan carLoan = new Loan();
        carLoan.setInterestRate(0.069);
        carLoan.setPrincipleAmount(26422.65);
        carLoan.setWeeklyPayment(108.0);
        carLoan.setStartDate(new GregorianCalendar(2016,7,15 ));
        Calendar calendar = new GregorianCalendar(2016,7,15 );
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");
        Calendar date = new GregorianCalendar(2016,7,15);
        System.out.println(sdf.format(calendar.getTime()));
        if(date.getTime().equals(calendar.getTime()))
        {
            System.out.println("True");
        }
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        System.out.println(sdf.format(calendar.getTime()));

    }

    public void init3()
    {
        Loan carLoan = new Loan();
        carLoan.setInterestRate(0.069);
        carLoan.setPrincipleAmount(26422.65);
        carLoan.setWeeklyPayment(500.0);
        carLoan.setStartDate(new GregorianCalendar(2016,7,15 ));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");

        for(int i=0; i <15; i++)
        {
            carLoan.runDay();
        }

        while(carLoan.getPrincipleAmount() > 0)
        {
                carLoan.runPayment();
            for(int i=0; i <8; i++)
            {
                carLoan.runDay();
            }
        }

        System.out.println(carLoan.getTotalAmountPaid());
        System.out.println(carLoan.getTotalInterestAmountPaid());
        System.out.println(sdf.format(carLoan.getCurrentDate().getTime()));
    }
}
