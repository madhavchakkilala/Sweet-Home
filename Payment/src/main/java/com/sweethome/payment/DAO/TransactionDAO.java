package com.sweethome.payment.DAO;

import com.sweethome.payment.entity.TransactionDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionDAO extends JpaRepository<TransactionDetailsEntity,Integer> {
    Optional<TransactionDetailsEntity> findOneById(Integer transactionId);
}
