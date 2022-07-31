package com.example.geektrust.Service;

import com.example.geektrust.Model.Loan;
import com.example.geektrust.Utils.ApplicationConstants;

public class LoanService implements ApplicationConstants, LedgerApplication {

    public final String[] loanData;
    public LoanService(String loanData[]) {
        this.loanData = loanData;
    }

    public void process() {
        String personName = loanData[2];
        String bankName = loanData[1];
        if(!personLoanData.containsKey((bankName+"-"+personName))) {
            Double principleAmount = Double.parseDouble(loanData[3]);
            int loanPeriod = Integer.parseInt(loanData[4]);
            int interestRate = Integer.parseInt(loanData[5]);
            Loan loan = new Loan(personName,bankName,loanPeriod,interestRate,principleAmount);
            loan.emiDetails();
            personLoanData.put((bankName+"-"+personName), loan);
        }
        else{
            System.out.println( personName + " loan data already exist");
        }
    }
}
