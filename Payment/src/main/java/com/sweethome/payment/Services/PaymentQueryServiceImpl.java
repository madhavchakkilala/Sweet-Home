package com.sweethome.payment.Services;

import com.sweethome.payment.DAO.TransactionDAO;
import com.sweethome.payment.entity.TransactionDetailsEntity;
import com.sweethome.payment.exception.TransactionNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentQueryServiceImpl implements PaymentQueryService {

    @Autowired
    private TransactionDAO transactionDAO;

    @Override
    public TransactionDetailsEntity getTransaction(Integer transactionId){
        TransactionDetailsEntity transactionDetails =  transactionDAO.findOneById(transactionId).orElse(null);
        return transactionDetails;
    }
}
