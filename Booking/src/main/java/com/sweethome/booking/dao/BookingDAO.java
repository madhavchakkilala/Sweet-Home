package com.sweethome.booking.dao;

import com.sweethome.booking.entity.BookingInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDAO extends JpaRepository<BookingInfoEntity, Integer> {
}
