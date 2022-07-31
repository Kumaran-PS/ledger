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
        Double totalAmountToBePaid = loanDetails.emiDetails();
        Double totalAmountPaid = loanDetails.emiPaidUntilMonth(emiNumber) + lumpSumPaid;
        Double remainingAmount = getRemainingAmount(totalAmountToBePaid,totalAmountPaid);
        int remainingEmi = loanDetails.getRemainingEmi(remainingAmount);
        if(totalAmountPaid > totalAmountToBePaid) totalAmountPaid = totalAmountToBePaid;
        displayOutput(remainingEmi , totalAmountPaid , bankName , personName);
    }

    private Double calculateLumpSumPaid(String personName,int emiNumber,String bankName) {
        Double lumpSumPaid = DEFAULT;
        List<Transactions> paymentsList = loanTransactions.getOrDefault((bankName+"-"+personName),new ArrayList<>());
        if(!paymentsList.isEmpty()) {
            for (Transactions payments : paymentsList) {
                boolean considerEmi = payments.isConsiderEmi(emiNumber);
                if (considerEmi) {
                    lumpSumPaid = payments.addLumpSum(lumpSumPaid);
                }
            }
        }
        return lumpSumPaid;
    }

    private int getRemainingEmi(Double remainingAmount, int monthlyEmi) {
        return (int) Math.ceil(remainingAmount / monthlyEmi);
    }

    private Double getRemainingAmount(Double totalAmountToBePaid, Double totalAmountPaid) {
        if(totalAmountPaid > totalAmountToBePaid) return DEFAULT;
        else return (totalAmountToBePaid - totalAmountPaid);
    }

    private void displayOutput(int remainingEmi, Double totalAmountPaid,String bankName , String personName) {
        String totalAmount = String.format("%.0f", totalAmountPaid);
        System.out.println(bankName+SPACE+personName+SPACE+totalAmount+SPACE+remainingEmi);
    }

}
