package com.sweethome.booking.controller;


import com.sweethome.booking.validation.Validators;
import com.sweethome.booking.entity.BookingInfoEntity;
import com.sweethome.booking.exception.InvalidBookingIdException;
import com.sweethome.booking.exception.InvalidDatesPassedException;
import com.sweethome.booking.exception.InvalidPaymentModeExcpetion;
import com.sweethome.booking.model.BookingInfoDto;
import com.sweethome.booking.model.TransactionInformationDto;
import com.sweethome.booking.services.RoomBookingQueryService;
import com.sweethome.booking.services.RoomBookingService;
import com.sweethome.booking.services.RoomBookingUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
@RequestMapping("/hotel")
public class BookingController {

    @Autowired
    private RoomBookingService roomBookingService;

    @Autowired
    private RoomBookingUpdateService roomBookingUpdateService;

    @Autowired
    private RoomBookingQueryService roomBookingQueryService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/booking")
    public ResponseEntity<BookingInfoEntity> InitiateBooking(@RequestBody BookingInfoDto bookingInfoDto) throws InvalidDatesPassedException, InvalidPaymentModeExcpetion {
        System.out.println(bookingInfoDto.toString());
        BookingInfoEntity bookingInformation = roomBookingService.bookRoom(bookingInfoDto);
        return new ResponseEntity(bookingInformation, HttpStatus.CREATED);
    }

    @PostMapping("/booking/{bookingId}/transaction")
    public ResponseEntity<BookingInfoEntity> HandlePayment(@PathVariable Integer bookingId, @RequestBody TransactionInformationDto transactionInformationDto) throws InvalidPaymentModeExcpetion, InvalidBookingIdException {
        HashMap<String,String> requestBody = new HashMap<>();
        Validators.paymentModeValidator(transactionInformationDto);
        requestBody.put("bookingId",String.valueOf(transactionInformationDto.getBookingId()));
        requestBody.put("paymentMode",transactionInformationDto.getPaymentMode());
        requestBody.put("upiId",transactionInformationDto.getUpiId());
        requestBody.put("cardNumber",transactionInformationDto.getCardNumber());
        String paymentAppUrl = "http://localhost:8083/payment/transaction";
        BookingInfoEntity bookingInfoEntity = roomBookingQueryService.getBookingInformation(bookingId);
        ResponseEntity<Integer> response = restTemplate.postForEntity(paymentAppUrl,requestBody,Integer.class);
        String message = "Booking confirmed for user with aadhaar number: "
                + bookingInfoEntity.getAadharNumber()
                +    "    |    "
                + "Here are the booking details:    " + bookingInfoEntity.toString();
        System.out.println(message);
        roomBookingUpdateService.updateBookingStatus(bookingInfoEntity, response.getBody());
        return new ResponseEntity(bookingInfoEntity,HttpStatus.CREATED);
    }
}
