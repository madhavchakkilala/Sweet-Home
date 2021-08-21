package com.sweethome.booking.services;

import com.sweethome.booking.entity.BookingInfoEntity;

public interface RoomBookingUpdateService {
    public void updateBookingStatus(BookingInfoEntity bookingInfoEntity,Integer transactionId);
}
