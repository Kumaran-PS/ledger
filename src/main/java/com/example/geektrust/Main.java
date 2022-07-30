package com.example.geektrust;

import com.example.geektrust.Controller.LoanController;
import com.example.geektrust.Utils.ApplicationConstants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main implements ApplicationConstants {
    public static void main(String[] args) {
        LoanController loanController = LoanController.getInstance();
        try {
            FileInputStream inputFile = new FileInputStream(FILEPATH);
            Scanner sc = new Scanner(inputFile);
            while (sc.hasNextLine()) {
                String inputLine = sc.nextLine();
                String[] inputData = inputLine.split(SPACE);
                loanController.transactionOperation(inputData);
            }
            sc.close();
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
