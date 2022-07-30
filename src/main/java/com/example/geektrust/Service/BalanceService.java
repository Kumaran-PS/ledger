package com.example.geektrust.Service;

import com.example.geektrust.Model.LoanDetails;
import com.example.geektrust.Model.Transactions;
import com.example.geektrust.Utils.ApplicationConstants;

import java.util.ArrayList;
import java.util.List;

public class BalanceService implements ApplicationConstants {

    private static BalanceService balanceService = null;
    private BalanceService() {}
    public static BalanceService getInstance() {
        if (balanceService != null) return balanceService;
        balanceService = new BalanceService();
        return balanceService;
    }

    public void processBalance(String[] inputData) {
        String personName = inputData[2];
        String bankName = inputData[1];
        int emiNumber = Integer.parseInt(inputData[3]);
        Double lumpSumPaid = calculateLumpSumPaid(personName,emiNumber,bankName);
        LoanDetails loanDetails = personLoanData.get((bankName+"-"+personName));
        int monthlyEmi = loanDetails.getMonthlyEmi();
        Double totalAmountToBePaid = loanDetails.getTotalAmount();
        Double totalAmountPaid = getTotalEmiPaid(emiNumber,monthlyEmi) + lumpSumPaid;
        Double remainingAmount = getRemainingAmount(totalAmountToBePaid,totalAmountPaid);
        int remainingEmi = getRemainingEmi(remainingAmount,monthlyEmi);
        if(totalAmountPaid > totalAmountToBePaid) totalAmountPaid = totalAmountToBePaid;
        displayOutput(remainingEmi , totalAmountPaid , bankName , personName);
    }

    private Double calculateLumpSumPaid(String personName,int emiNumber,String bankName) {
        Double lumpSumPaid = DEFAULT;
        List<Transactions> paymentsList = loanTransactions.getOrDefault((bankName+"-"+personName),new ArrayList<>());
        if(!paymentsList.isEmpty()) {
            for (Transactions payments : paymentsList) {
                int paidPeriod = payments.getEmiNumber();
                if (paidPeriod <= emiNumber) {
                    lumpSumPaid += payments.getLumpSumPayment();
                }
            }
        }
        return lumpSumPaid;
    }

    private int getTotalEmiPaid(int emiNumber, int monthlyEmi) {
        return (emiNumber * monthlyEmi);
    }

    private int getRemainingEmi(Double remainingAmount, int monthlyEmi) {
        return (int) Math.ceil(remainingAmount / monthlyEmi);
    }

    private Double getRemainingAmount(Double totalAmountToBePaid, Double totalAmountPaid) {
        if(totalAmountPaid > totalAmountToBePaid) return DEFAULT;
        else return (totalAmountToBePaid - totalAmountPaid);
    }

    private void displayOutput(int remainingEmi, Double totalAmountPaid,String bankName , String personName) {
        System.out.println(bankName+SPACE+personName+SPACE+totalAmountPaid+SPACE+remainingEmi);
    }

}
