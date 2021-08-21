package com.sweethome.booking.model;

public class TransactionInformationDto {
    private String paymentMode;
    private Integer bookingId;
    private String upiId;
    private String cardNumber;

    @Override
    public String toString() {
        return "TransactionInformationDto{" +
                "paymentMode='" + paymentMode + '\'' +
                ", bookingId=" + bookingId +
                ", upiId=" + upiId +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
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
