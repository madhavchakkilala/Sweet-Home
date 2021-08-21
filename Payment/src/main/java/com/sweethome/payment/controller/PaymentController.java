package com.sweethome.payment.controller;


import com.sweethome.payment.Services.PaymentQueryService;
import com.sweethome.payment.Services.PaymentService;
import com.sweethome.payment.entity.TransactionDetailsEntity;
import com.sweethome.payment.exception.InvalidPaymentCredentialsException;
import com.sweethome.payment.exception.TransactionNotFoundException;
import com.sweethome.payment.models.PaymentDetailsDto;
import com.sweethome.payment.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private PaymentQueryService paymentQueryService;

    @PostMapping("/transaction")
    public ResponseEntity<Integer> recievePayment(@RequestBody PaymentDetailsDto paymentDetailsDto) throws InvalidPaymentCredentialsException {
        Validator.paymentModeValidator(paymentDetailsDto);
        TransactionDetailsEntity userTransactionDetailsEntity = paymentService.makePayment(paymentDetailsDto);
        return new ResponseEntity(userTransactionDetailsEntity.getId(), HttpStatus.CREATED);
    }

    @GetMapping("/transaction/{id}")
    public ResponseEntity<TransactionDetailsEntity> getPaymentDetails(@PathVariable Integer id) throws TransactionNotFoundException{
        TransactionDetailsEntity transactionDetails = paymentQueryService.getTransaction(id);
        if(transactionDetails == null){
            throw new TransactionNotFoundException("No transaction is present with the given id");
        }
        return new ResponseEntity(transactionDetails,HttpStatus.OK);
    }
}
