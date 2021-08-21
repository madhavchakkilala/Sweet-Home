package com.sweethome.payment.validation;

import com.sweethome.payment.exception.InvalidPaymentCredentialsException;
import com.sweethome.payment.models.PaymentDetailsDto;

public class Validator {
    public static void paymentModeValidator(PaymentDetailsDto paymentDetails) throws InvalidPaymentCredentialsException {
        if(!paymentDetails.getPaymentMode().equalsIgnoreCase("card") && !paymentDetails.getPaymentMode().equalsIgnoreCase("upi")){
            throw new InvalidPaymentCredentialsException("Invalid mode of payment");
        }
        if(paymentDetails.getPaymentMode().equalsIgnoreCase("card")){
            if(paymentDetails.getCardNumber().equals("") || paymentDetails.getCardNumber() == null){
                throw new InvalidPaymentCredentialsException("Card number should not be empty when the payment mode is card");
            }
        }
        else if(paymentDetails.getPaymentMode().equalsIgnoreCase("upi")){
            if(paymentDetails.getUpiId().equals("") || paymentDetails.getUpiId() == null){
                throw new InvalidPaymentCredentialsException("Upi id should not be empty when the payment mode is upi");
            }
        }
        if(paymentDetails.getBookingId() == null){
            throw new InvalidPaymentCredentialsException("booking Id should not be null");
        }
    }
}
