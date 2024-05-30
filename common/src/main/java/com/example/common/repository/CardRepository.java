package com.example.common.repository;

import com.example.common.domain.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, UUID> {

    boolean existsByNumberAndDate(
            String number,
            String date
    );

    Optional<Card> findByNumberAndDateAndCvv(
            String number,
            String date,
            String cvv
    );

    Optional<Card> findByNumberAndDate(
            String number,
            String date
    );

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(value = """
            INSERT INTO cards_transactions
            VALUES (:cardId, :transactionId)
            """, nativeQuery = true)
    void addTransaction(
            @Param("cardId") String cardId,
            @Param("transactionId") String transactionId
    );

}
