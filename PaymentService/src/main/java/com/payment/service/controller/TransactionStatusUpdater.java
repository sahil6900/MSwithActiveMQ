package com.payment.service.controller;

import com.payment.service.enums.TransactionalState;
import com.payment.service.model.Transaction;
import com.payment.service.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@EnableJms
public class TransactionStatusUpdater {
    @Autowired
    private TransactionService transactionService;

    @JmsListener(destination = "transaction-approval")
    public void getTransactionId(Long id) {
        Scanner sc = new Scanner(System.in);

        Transaction transaction = transactionService.fetchTransactionById(id);
        System.out.println("***********************---------------************************");
        System.out.println("Sender ID:" + transaction.getSenderId());
        System.out.println("Benificiary ID:" + transaction.getBeneficiaryId());
        System.out.println("Amount:" + transaction.getAmount());
        System.out.println("Processing Date:" + transaction.getDate());
        System.out.println("***********************---------------************************");
        System.out.println("Do you wish to approve?");
        System.out.println("Press 1.Yes | 2.No");
        int resp = sc.nextInt();
        System.out.println("Enter your password");
        String password = sc.next();

        if(resp==1 && password.equals("1234")){
            transactionService.updateTransaction(transaction,TransactionalState.APPROVED);
            System.out.println("Transaction Approved");
        }else {
            transactionService.updateTransaction(transaction, TransactionalState.DENIED);
            System.out.println("Transaction Denied");
            System.out.println("Wrong Password Entered");
        }

    }

}
