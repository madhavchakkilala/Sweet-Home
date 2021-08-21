package com.sweethome.booking.validation;

import com.sweethome.booking.exception.InvalidPaymentModeExcpetion;
import com.sweethome.booking.model.TransactionInformationDto;

public class Validators {
    public static void paymentModeValidator(TransactionInformationDto transactionInformation) throws InvalidPaymentModeExcpetion {
        if(!transactionInformation.getPaymentMode().equalsIgnoreCase("card") && !transactionInformation.getPaymentMode().equalsIgnoreCase("upi")){
            throw new InvalidPaymentModeExcpetion("Invalid mode of payment");
        }
        if(transactionInformation.getPaymentMode().equalsIgnoreCase("card")){
            if(transactionInformation.getCardNumber() == null || transactionInformation.getCardNumber().equals("")){
                throw new InvalidPaymentModeExcpetion("Card number should not be empty when the payment mode is card");
            }
        }
        if(transactionInformation.getPaymentMode().equalsIgnoreCase("upi")){
            if(transactionInformation.getUpiId() == null || transactionInformation.getUpiId().equals("")){
                throw new InvalidPaymentModeExcpetion("Upi id should not be empty when the payment mode is upi");
            }
        }
    }
}
