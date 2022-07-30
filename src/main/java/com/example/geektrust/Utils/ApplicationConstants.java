package com.example.geektrust.Utils;

import com.example.geektrust.Model.LoanDetails;
import com.example.geektrust.Model.Transactions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface ApplicationConstants {
    String FILEPATH = "sample_input/input2.txt";
    String SPACE = " ";
    int INPUT_TYPE = 0;
    int PERCENT = 100;
    String LOAN = "LOAN";
    String BALANCE = "BALANCE";
    String PAYMENT = "PAYMENT";
    int NO_OF_MONTHS = 12;
    Double DEFAULT = (double) 0;
    List<Transactions>DEFAULT_LIST = new ArrayList<>();

    HashMap<String, LoanDetails> personLoanData = new HashMap<>();

    HashMap<String, List<Transactions>> loanTransactions = new HashMap<>();


}
