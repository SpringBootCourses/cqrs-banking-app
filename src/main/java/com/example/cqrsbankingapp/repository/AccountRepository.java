package com.example.cqrsbankingapp.repository;

import com.example.cqrsbankingapp.domain.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
}
