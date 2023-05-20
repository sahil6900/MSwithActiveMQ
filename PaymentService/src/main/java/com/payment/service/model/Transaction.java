package com.payment.service.model;

import com.payment.service.enums.TransactionalState;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Long senderId;
    private Long beneficiaryId;
    private double amount;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private TransactionalState transactionalState;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(Long beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public TransactionalState getTransactionalState() {
        return transactionalState;
    }

    public void setTransactionalState(TransactionalState transactionalState) {
        this.transactionalState = transactionalState;
    }
}
