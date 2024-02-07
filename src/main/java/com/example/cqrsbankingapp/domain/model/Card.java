package com.example.cqrsbankingapp.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Table(name = "cards")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue
    private UUID id;

    private String number;
    private String date;
    private String cvv;

    @OneToMany
    private List<Transaction> transactions;

    @ManyToOne
    private Account account;

    public Card(
            final Account account
    ) {
        this.account = account;
    }

}
