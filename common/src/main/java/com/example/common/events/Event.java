package com.example.common.events;

import com.example.common.domain.aggregate.Aggregate;

public interface Event {

    void apply(Aggregate aggregate);

}
