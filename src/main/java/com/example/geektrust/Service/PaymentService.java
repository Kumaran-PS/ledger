package com.example.geektrust.Service;

import com.example.geektrust.Model.Transactions;
import com.example.geektrust.Utils.ApplicationConstants;
import java.util.ArrayList;
import java.util.List;

public class PaymentService implements ApplicationConstants {

    private static PaymentService paymentService = null;
    private PaymentService() {}
    public static PaymentService getInstance() {
        if (paymentService != null) return paymentService;
        paymentService = new PaymentService();
        return paymentService;
    }

    public void processPayment(String[] inputData) {
        String personName = inputData[2];
        String bankName = inputData[1];
        if (personLoanData.containsKey((bankName+"-"+personName))) {
            Double lumpSumPayment = Double.parseDouble(inputData[3]);
            int emiNumber = Integer.parseInt(inputData[4]);
            Transactions transactions = new Transactions(bankName, personName, lumpSumPayment, emiNumber);
            List<Transactions> paymentList = loanTransactions.getOrDefault((bankName+"-"+personName), new ArrayList<>());
            paymentList.add(transactions);
            loanTransactions.put((bankName+"-"+personName), paymentList);

        } else {
            System.out.println("Invalid person : " + personName);
            System.out.println("Please enter valid person name");
        }

    }
}
