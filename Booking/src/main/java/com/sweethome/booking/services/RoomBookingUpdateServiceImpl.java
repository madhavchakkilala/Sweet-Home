package com.sweethome.booking.services;

import com.sweethome.booking.dao.BookingDAO;
import com.sweethome.booking.entity.BookingInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomBookingUpdateServiceImpl implements RoomBookingUpdateService {

    @Autowired
    private BookingDAO bookingDAO;



    @Override
    public void updateBookingStatus(BookingInfoEntity bookingInfoEntity,Integer transactionId) {
        bookingInfoEntity.setTransactionId(transactionId);
        bookingDAO.save(bookingInfoEntity);
    }
}
