package com.sweethome.payment.entity;


import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class TransactionDetailsEntity {
    @Id
    @Column(name="transaction_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String paymentMode;

    @Column(name="booking_id",nullable = false)
    private Integer bookingId;


    private String upiId;

    private String cardNumber;

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + id +
                ", paymentMode='" + paymentMode + '\'' +
                ", bookingId=" + bookingId +
                ", upiId='" + upiId + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer transactionId) {
        this.id = transactionId;
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
