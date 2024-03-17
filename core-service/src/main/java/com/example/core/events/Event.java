package com.example.core.events;

import com.example.core.domain.aggregate.Aggregate;

public interface Event {

    void apply(Aggregate aggregate);

}
