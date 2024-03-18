package com.example.core.events;

import com.example.core.domain.aggregate.Aggregate;
import com.example.core.domain.model.Card;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CardCreateEvent extends AbstractEvent {

    public CardCreateEvent(
            final Card payload
    ) {
        super(null, EventType.CARD_CREATE, payload);
    }

    @Override
    public void apply(
            final Aggregate aggregate
    ) {
        //TODO implement
    }

}
