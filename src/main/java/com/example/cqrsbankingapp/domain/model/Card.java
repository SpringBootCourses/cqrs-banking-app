package com.example.cqrsbankingapp.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Table(name = "cards")
@Entity
@Getter
@Setter
public class Card {

    @Id
    @GeneratedValue
    private UUID id;

    private String number;
    private String date;
    private String cvv;

    @ManyToOne
    private Account account;

}
