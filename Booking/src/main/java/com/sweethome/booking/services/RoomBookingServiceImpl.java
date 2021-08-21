package com.sweethome.booking.services;

import com.sweethome.booking.dao.BookingDAO;
import com.sweethome.booking.entity.BookingInfoEntity;
import com.sweethome.booking.exception.InvalidDatesPassedException;
import com.sweethome.booking.exception.InvalidPaymentModeExcpetion;
import com.sweethome.booking.model.BookingInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.Date;
import java.util.concurrent.TimeUnit;


@Service
public class RoomBookingServiceImpl implements RoomBookingService {

    @Autowired
    private RandomRoomNumberService randomRoomNumberService;

    @Autowired
    private BookingDAO bookingDAO;

    @Override
    public BookingInfoEntity bookRoom(BookingInfoDto bookingInformation) throws InvalidDatesPassedException, InvalidPaymentModeExcpetion {
        Date currentDate = new Date();
        /*
        uncomment the below code to disable booking of date before todays date.
        if(bookingInformation.getFromDate().compareTo(currentDate) < 0){
            throw new InvalidDatesPassedException("From date should always be greater than or equal to todays date");
        }
        */
        if(bookingInformation.getAadharNumber().equals("") || bookingInformation.getAadharNumber() == null){
            throw new InvalidPaymentModeExcpetion("Aadhar number should never be null or empty string");
        }
        long differenceInMilliSeconds = Math.abs(bookingInformation.getToDate().getTime() - bookingInformation.getFromDate().getTime());
        long numberOfDays = TimeUnit.DAYS.convert(differenceInMilliSeconds,TimeUnit.MILLISECONDS);
        int dateComparision = bookingInformation.getToDate().compareTo(bookingInformation.getFromDate());
        if(dateComparision < 1){
            throw new InvalidDatesPassedException("From date should always be less than the to date of the booking");
        }
        BookingInfoEntity bookingInfoEntity = new BookingInfoEntity();
        bookingInfoEntity.setNumOfRooms(bookingInformation.getNumOfRooms());
        bookingInfoEntity.setAadharNumber(bookingInformation.getAadharNumber());
        bookingInfoEntity.setFromDate(bookingInformation.getFromDate());
        bookingInfoEntity.setToDate(bookingInformation.getToDate());
        bookingInfoEntity.setNumOfRooms(bookingInformation.getNumOfRooms());
        long roomPrice = 1000 * numberOfDays * bookingInformation.getNumOfRooms();
        bookingInfoEntity.setRoomPrice(roomPrice);
        String roomNumbers = randomRoomNumberService.getRoomNumbers(bookingInformation.getNumOfRooms());
        bookingInfoEntity.setRoomNumbers(roomNumbers);
        bookingInfoEntity.setBookedOn(new Date());
        bookingInfoEntity.setTransactionId(0);
        bookingDAO.save(bookingInfoEntity);
        return bookingInfoEntity;
    }
}
