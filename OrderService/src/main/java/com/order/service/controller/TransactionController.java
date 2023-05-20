package com.order.service.controller;

import com.order.service.dtos.TransactionDto;
import com.order.service.enums.TransactionalState;
import com.order.service.messaging.TransactionMessaging;
import com.order.service.model.Transaction;
import com.order.service.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/trns")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TransactionMessaging transactionMessaging;

    @PostMapping("/process")
    public ResponseEntity<?> processTransaction(@RequestBody TransactionDto transactionDto, Transaction transaction){
        transaction.setSenderId(transactionDto.getSenderId());
        transaction.setBeneficiaryId(transactionDto.getBeneficiaryId());
        transaction.setAmount(transactionDto.getAmount());
        transaction.setDate(LocalDate.now());
        transaction.setTransactionalState(TransactionalState.PROCESSING);
        transactionService.insertTransaction(transaction);
        transactionMessaging.publishTransaction(transaction.getId());

        return ResponseEntity.status(HttpStatus.OK).body("Transaction is being processed please wait...");
    }
}
