package com.sweethome.payment.Services;

import com.sweethome.payment.entity.TransactionDetailsEntity;
import com.sweethome.payment.exception.TransactionNotFoundException;

public interface PaymentQueryService {
    public TransactionDetailsEntity getTransaction(Integer transactionId) throws TransactionNotFoundException;
}
