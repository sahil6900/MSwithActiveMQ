package com.payment.service.service;

import com.payment.service.enums.TransactionalState;
import com.payment.service.model.Transaction;
import com.payment.service.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction fetchTransactionById(Long id) {
        return transactionRepository.findById(id).get();
    }


    public Transaction updateTransaction(Transaction transaction, TransactionalState transactionalState) {
        transaction.setTransactionalState(transactionalState);
        return transactionRepository.save(transaction);
    }
}
