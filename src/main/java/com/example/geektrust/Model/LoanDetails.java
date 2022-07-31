package com.example.geektrust.Model;

import com.example.geektrust.Utils.ApplicationConstants;

public class LoanDetails implements ApplicationConstants {
    String personName;
    String bankName;
    int loanPeriod;
    int interestRate;
    Double principleAmount;
    int monthlyEmi;
    int totalEmiCount;

    public LoanDetails(String personName, String bankName, int loanPeriod, int interestRate, Double principleAmount) {
        this.personName = personName;
        this.bankName = bankName;
        this.loanPeriod = loanPeriod;
        this.interestRate = interestRate;
        this.principleAmount = principleAmount;
    }

    public double emiDetails(){
        this.totalEmiCount = loanPeriod * NO_OF_MONTHS;
        Double interest = (principleAmount*loanPeriod*interestRate) / PERCENT;
        this.monthlyEmi = (int) Math.ceil((principleAmount + interest) / totalEmiCount);
        return (principleAmount+interest);
    }

    public int getRemainingEmi(Double remainingAmount) {
        return (int) Math.ceil(remainingAmount / monthlyEmi);
    }


    public int emiPaidUntilMonth(int emiNumber) {
        return emiNumber * monthlyEmi;
    }
}
