package com.example.eventhandler.service;

import com.example.eventhandler.handler.EventHandler;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class DebeziumEventConsumerImpl implements CDCEventConsumer {

    private final Map<String, EventHandler> factories;

    @KafkaListener(topics = "events")
    public void process(
            final String payload,
            final Acknowledgment acknowledgment
    ) {
        try {
            log.info("Received message: {}", payload);
            JsonObject json = JsonParser.parseString(payload)
                    .getAsJsonObject()
                    .get("payload")
                    .getAsJsonObject();
            String type = json.get("type")
                    .getAsString();
            factories.get(type)
                    .handle(
                            json,
                            acknowledgment
                    );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
