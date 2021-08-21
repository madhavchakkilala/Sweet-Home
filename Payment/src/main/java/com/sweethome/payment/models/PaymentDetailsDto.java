package com.sweethome.payment.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class PaymentDetailsDto {
    @NotBlank(message="Booking Id cannot be blank")
    private Integer bookingId;
    @NotBlank(message="Payment mode cannot be blank")
    private String paymentMode;
    private String upiId;
    @Pattern(regexp = "(^[0-9]{16})",message = "Please enter a valid card number")
    private String cardNumber;

    @Override
    public String toString() {
        return "PaymentDetails{" +
                "bookingId=" + bookingId +
                ", paymentMode='" + paymentMode + '\'' +
                ", upiId='" + upiId + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }


}
