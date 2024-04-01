package com.example.eventhandler.service;

import org.springframework.kafka.support.Acknowledgment;

public interface CDCEventConsumer {

    void process(
            String payload,
            Acknowledgment acknowledgment
    );

}
