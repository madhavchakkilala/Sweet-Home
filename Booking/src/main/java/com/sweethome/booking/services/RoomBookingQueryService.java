package com.sweethome.booking.services;


import com.sweethome.booking.entity.BookingInfoEntity;
import com.sweethome.booking.exception.InvalidBookingIdException;

public interface RoomBookingQueryService {
    public BookingInfoEntity getBookingInformation(Integer id) throws InvalidBookingIdException;
}
