package com.example.geektrust.Controller;

import com.example.geektrust.Service.BalanceService;
import com.example.geektrust.Service.LoanService;
import com.example.geektrust.Service.PaymentService;
import com.example.geektrust.Utils.ApplicationConstants;

public class LoanController implements ApplicationConstants {

    private static LoanController loanController = null;
    private LoanController() {}
    public static LoanController getInstance() {
        if (loanController != null) return loanController;
        loanController = new LoanController();
        return loanController;
    }

    public void transactionOperation(String[] inputData){
        switch (inputData[0]) {
            case LOAN:
                LoanService loanService = LoanService.getInstance();
                loanService.processLoan(inputData);
                break;
            case PAYMENT:
                PaymentService paymentService = PaymentService.getInstance();
                paymentService.processPayment(inputData);
                break;
            case BALANCE:
                BalanceService balanceService = BalanceService.getInstance();
                balanceService.processBalance(inputData);
                break;
            default:
                throw new IllegalStateException("Unexpected value");
        }
    }
}
