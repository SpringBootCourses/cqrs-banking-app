package com.example.cqrsbankingapp.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Table(name = "cards")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Card implements Serializable {

    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    private String number;
    private String date;
    private String cvv;

    @OneToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "card_id"),
            inverseJoinColumns = @JoinColumn(name = "transaction_id")
    )
    private List<Transaction> transactions;

    @ManyToOne
    private Account account;

    public Card(
            final Account account
    ) {
        this.account = account;
    }

    @Override
    public boolean equals(
            final Object o
    ) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Card card = (Card) o;
        return id.equals(card.id)
                && Objects.equals(number, card.number)
                && Objects.equals(date, card.date)
                && Objects.equals(cvv, card.cvv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, date, cvv);
    }

}
