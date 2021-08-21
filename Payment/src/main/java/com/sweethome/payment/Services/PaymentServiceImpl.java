package com.sweethome.payment.Services;

import com.sweethome.payment.DAO.TransactionDAO;
import com.sweethome.payment.entity.TransactionDetailsEntity;
import com.sweethome.payment.models.PaymentDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private TransactionDAO transactionDAO;

    public TransactionDetailsEntity makePayment(PaymentDetailsDto paymentInfo){
        TransactionDetailsEntity userTransactionDetailsEntity = new TransactionDetailsEntity();
        userTransactionDetailsEntity.setPaymentMode(paymentInfo.getPaymentMode());
        userTransactionDetailsEntity.setBookingId(paymentInfo.getBookingId());
        userTransactionDetailsEntity.setCardNumber(paymentInfo.getCardNumber());
        userTransactionDetailsEntity.setUpiId(paymentInfo.getUpiId());
        transactionDAO.save(userTransactionDetailsEntity);
        return userTransactionDetailsEntity;
    }
}
