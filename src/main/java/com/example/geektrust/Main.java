package com.example.geektrust;

import com.example.geektrust.Service.LoanController;
import com.example.geektrust.Utils.ApplicationConstants;
import com.example.geektrust.Service.LedgerApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main implements ApplicationConstants {
    public static void main(String[] args) {
        LoanController loanController = LoanController.getInstance();
        try {
            FileInputStream inputFile = new FileInputStream(args[0]);
            Scanner sc = new Scanner(inputFile);
            while (sc.hasNextLine()) {
                String inputLine = sc.nextLine();
                String[] inputData = inputLine.split(SPACE);
                LedgerApplication ledgerApplication = loanController.transactionOperation(inputData);
                ledgerApplication.process();
            }
            sc.close();
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
