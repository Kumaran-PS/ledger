package com.example.geektrust.Model;

import com.example.geektrust.Utils.ApplicationConstants;


public class Payment implements ApplicationConstants {
    String bankName;
    String personName;
    Double lumpSumPayment;
    int emiNumber;

    public Payment(String bankName, String personName, Double lumpSumPayment, int emiNumber) {
        this.bankName = bankName;
        this.personName = personName;
        this.lumpSumPayment = lumpSumPayment;
        this.emiNumber = emiNumber;
    }

    public boolean isConsiderEmi(int emiNumber) {
        return emiNumber >= (this.emiNumber);
    }

    public Double addLumpSum(Double lumpSumPaid) {
        return lumpSumPaid + lumpSumPayment;
    }
}
