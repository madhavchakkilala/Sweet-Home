package com.sweethome.booking.services;

import com.sweethome.booking.entity.BookingInfoEntity;
import com.sweethome.booking.exception.InvalidDatesPassedException;
import com.sweethome.booking.exception.InvalidPaymentModeExcpetion;
import com.sweethome.booking.model.BookingInfoDto;

public interface RoomBookingService {
    public BookingInfoEntity bookRoom(BookingInfoDto bookingInformation) throws InvalidDatesPassedException, InvalidPaymentModeExcpetion;
}
