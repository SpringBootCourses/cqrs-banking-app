package com.example.cqrsbankingapp.events;

import com.example.cqrsbankingapp.domain.aggregate.Aggregate;

public interface Event {

    void apply(Aggregate aggregate);

}
