package com.example.geektrust.Service;

import com.example.geektrust.Model.Loan;
import com.example.geektrust.Model.Payment;
import com.example.geektrust.Utils.ApplicationConstants;

import java.util.ArrayList;
import java.util.List;

public class BalanceService implements ApplicationConstants, LedgerApplication {


    public final String[] inputData;
    public BalanceService(String inputData[]) {
        this.inputData = inputData;
    }

    public void process() {
        String personName = inputData[2];
        String bankName = inputData[1];
        int emiNumber = Integer.parseInt(inputData[3]);
        Double lumpSumPaid = calculateLumpSumPaid(personName,emiNumber,bankName);
        Loan loan = personLoanData.get((bankName+"-"+personName));
        Double totalAmountToBePaid = loan.emiDetails();
        Double totalAmountPaid = loan.emiPaidUntilMonth(emiNumber) + lumpSumPaid;
        Double remainingAmount = getRemainingAmount(totalAmountToBePaid,totalAmountPaid);
        int remainingEmi = loan.getRemainingEmi(remainingAmount);
        if(totalAmountPaid > totalAmountToBePaid) totalAmountPaid = totalAmountToBePaid;
        displayOutput(remainingEmi , totalAmountPaid , bankName , personName);
    }

    private Double calculateLumpSumPaid(String personName,int emiNumber,String bankName) {
        Double lumpSumPaid = DEFAULT;
        List<Payment> paymentsList = loanTransactions.getOrDefault((bankName+"-"+personName),new ArrayList<>());
        if(!paymentsList.isEmpty()) {
            for (Payment payments : paymentsList) {
                boolean considerEmi = payments.isConsiderEmi(emiNumber);
                if (considerEmi) {
                    lumpSumPaid = payments.addLumpSum(lumpSumPaid);
                }
            }
        }
        return lumpSumPaid;
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
