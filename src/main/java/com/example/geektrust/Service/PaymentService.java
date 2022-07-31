package com.example.geektrust.Service;

import com.example.geektrust.Model.Payment;
import com.example.geektrust.Utils.ApplicationConstants;

import java.util.ArrayList;
import java.util.List;

public class PaymentService implements ApplicationConstants, LedgerApplication {

    public final String[] inputData;
    public PaymentService(String inputData[]) {
        this.inputData = inputData;
    }
    public void process() {
        String personName = inputData[2];
        String bankName = inputData[1];
        if (personLoanData.containsKey((bankName+"-"+personName))) {
            Double lumpSumPayment = Double.parseDouble(inputData[3]);
            int emiNumber = Integer.parseInt(inputData[4]);
            Payment payment = new Payment(bankName, personName, lumpSumPayment, emiNumber);
            List<Payment> paymentList = loanTransactions.getOrDefault((bankName+"-"+personName), new ArrayList<>());
            paymentList.add(payment);
            loanTransactions.put((bankName+"-"+personName), paymentList);

        } else {
            System.out.println("Invalid person : " + personName);
            System.out.println("Please enter valid person name");
        }

    }
}
