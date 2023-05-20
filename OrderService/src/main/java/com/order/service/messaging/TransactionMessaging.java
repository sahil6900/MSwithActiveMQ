package com.order.service.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class TransactionMessaging {

    @Autowired
    private JmsTemplate jmsTemplate;
    public void publishTransaction(Long id){
        String queueName = "transaction-approval";

        jmsTemplate.convertAndSend(queueName,id);
    }
}
