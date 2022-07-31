package com.example.geektrust.Model;

import com.example.geektrust.Utils.ApplicationConstants;

public class Loan implements ApplicationConstants {
    String personName;
    String bankName;
    int loanPeriod;
    int interestRate;
    Double principleAmount;
    int emi;


    public Loan(String personName, String bankName, int loanPeriod, int interestRate, Double principleAmount) {
        this.personName = personName;
        this.bankName = bankName;
        this.loanPeriod = loanPeriod;
        this.interestRate = interestRate;
        this.principleAmount = principleAmount;
    }

    public double emiDetails(){
        int totalEmiCount = loanPeriod * NO_OF_MONTHS;
        Double interest = (principleAmount*loanPeriod*interestRate) / PERCENT;
        this.emi = (int) Math.ceil((principleAmount + interest) / totalEmiCount);
        return (principleAmount+interest);
    }

    public int getRemainingEmi(Double remainingAmount) {
        return (int) Math.ceil(remainingAmount / emi);
    }


    public int emiPaidUntilMonth(int emiNumber) {
        return emiNumber * emi;
    }

}
