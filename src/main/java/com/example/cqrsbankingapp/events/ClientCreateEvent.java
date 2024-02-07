package com.example.cqrsbankingapp.events;

import com.example.cqrsbankingapp.domain.aggregate.Aggregate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientCreateEvent extends AbstractEvent {

    @Override
    public void apply(Aggregate aggregate) {
        //TODO implement
    }

}
