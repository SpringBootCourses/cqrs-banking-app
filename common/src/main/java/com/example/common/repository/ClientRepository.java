package com.example.common.repository;

import com.example.common.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {

    Optional<Client> findByUsername(String username);

    boolean existsByUsername(String username);

    Optional<Client> findByAccountId(UUID accountId);

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(value = """
            INSERT INTO clients_cards
            VALUES (:clientId, :cardId)
            """, nativeQuery = true
    )
    void addCard(
            @Param("clientId") String clientId,
            @Param("cardId") String cardId
    );

}
