package com.order.service.service;

import com.order.service.model.Transaction;
import com.order.service.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    public Transaction insertTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
