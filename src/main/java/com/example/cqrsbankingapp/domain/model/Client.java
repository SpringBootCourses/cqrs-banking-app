package com.example.cqrsbankingapp.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Table(name = "clients")
@Entity
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @OneToMany
    private List<Card> cards;

    @OneToOne
    private Account account;

}
