package com.example.geektrust.Service;

import com.example.geektrust.Utils.ApplicationConstants;

public class LoanController implements ApplicationConstants {

    private static LoanController loanController = null;
    private LoanController() {}
    public static LoanController getInstance() {
        if (loanController != null) return loanController;
        loanController = new LoanController();
        return loanController;
    }

    public LedgerApplication transactionOperation(String[] inputData){
        switch (inputData[0]) {
            case LOAN:
                return new LoanService(inputData);
            case PAYMENT:
                return new PaymentService(inputData);
            case BALANCE:
                return  new BalanceService(inputData);
            default:
                throw new IllegalStateException("Unexpected value");
        }
    }
}
