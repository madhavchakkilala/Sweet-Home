package com.sweethome.booking.services;

import com.sweethome.booking.dao.BookingDAO;
import com.sweethome.booking.entity.BookingInfoEntity;
import com.sweethome.booking.exception.InvalidBookingIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoomBookingQueryServiceImpl implements RoomBookingQueryService {
    @Autowired
    private BookingDAO bookingDAO;

    @Override
    public BookingInfoEntity getBookingInformation(Integer id) throws InvalidBookingIdException {
        BookingInfoEntity bookingInfoEntity = bookingDAO.findById(id).orElse(null);
        if(bookingInfoEntity == null){
            throw new InvalidBookingIdException("Invalid Booking Id");
        }
        return bookingInfoEntity;
    }
}
