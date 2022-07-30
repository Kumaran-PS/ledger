package com.example.geektrust.Model;

import com.example.geektrust.Utils.ApplicationConstants;


public class Transactions implements ApplicationConstants {
    String bankName;
    String personName;
    Double lumpSumPayment;
    int emiNumber;

    public Transactions(String bankName, String personName, Double lumpSumPayment, int emiNumber) {
        this.bankName = bankName;
        this.personName = personName;
        this.lumpSumPayment = lumpSumPayment;
        this.emiNumber = emiNumber;
    }

    public Double getLumpSumPayment() {
        return lumpSumPayment;
    }

    public int getEmiNumber() {
        return emiNumber;
    }

}
