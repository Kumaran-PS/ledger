package com.example.geektrust.Model;

import com.example.geektrust.Utils.ApplicationConstants;

public class LoanDetails implements ApplicationConstants {
    String personName;
    String bankName;
    int loanPeriod;
    int interestRate;
    Double principleAmount;
    int monthlyEmi;
    Double totalAmount;
    int totalEmiCount;

    public LoanDetails(String personName, String bankName, int loanPeriod, int interestRate, Double principleAmount) {
        this.personName = personName;
        this.bankName = bankName;
        this.loanPeriod = loanPeriod;
        this.interestRate = interestRate;
        this.principleAmount = principleAmount;
    }

    public void setEmiDetails(){
        this.totalEmiCount = loanPeriod * NO_OF_MONTHS;
        Double interest = (principleAmount*loanPeriod*interestRate) / 100;
        this.totalAmount = principleAmount + interest ;
        this.monthlyEmi = (int) Math.ceil(totalAmount / totalEmiCount);
    }

    public int getMonthlyEmi() {
        return monthlyEmi;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public String getBankName() {
        return bankName;
    }
}
