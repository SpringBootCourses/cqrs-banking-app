package com.example.core.repository;

import com.example.core.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {

    Optional<Client> findByUsername(String username);

    boolean existsByUsername(String username);

}
