package com.example.geektrust.Service;

import com.example.geektrust.Model.Loan;
import com.example.geektrust.Utils.ApplicationConstants;

public class LoanService implements ApplicationConstants {

    private static LoanService loanService = null;
    private LoanService() {}
    public static LoanService getInstance() {
        if (loanService != null) return loanService;
        loanService = new LoanService();
        return loanService;
    }

    public void processLoan(String[] loanData) {
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
