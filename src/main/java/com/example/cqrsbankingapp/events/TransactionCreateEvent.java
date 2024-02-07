package com.example.cqrsbankingapp.events;

import com.example.cqrsbankingapp.domain.aggregate.Aggregate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionCreateEvent extends AbstractEvent {

    public TransactionCreateEvent(
            final Object payload
    ) {
        super(null, EventType.TRANSACTION_CREATE, payload);
    }

    @Override
    public void apply(
            final Aggregate aggregate
    ) {
        //TODO implement
    }

}
