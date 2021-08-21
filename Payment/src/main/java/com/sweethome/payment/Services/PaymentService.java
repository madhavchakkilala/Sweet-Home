package com.sweethome.payment.Services;

import com.sweethome.payment.entity.TransactionDetailsEntity;
import com.sweethome.payment.models.PaymentDetailsDto;

public interface PaymentService {
    public TransactionDetailsEntity makePayment(PaymentDetailsDto paymentInfo);
}
