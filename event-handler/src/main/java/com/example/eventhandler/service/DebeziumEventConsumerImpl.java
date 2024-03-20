package com.example.eventhandler.service;

import com.example.common.events.EventType;
import com.example.eventhandler.handler.EventHandler;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class DebeziumEventConsumerImpl implements CDCEventConsumer {

    private final Map<EventType, EventHandler> factories;

    @KafkaListener(topics = "events")
    public void process(
            final String message
    ) {
        try {
            JsonObject json = JsonParser.parseString(message)
                    .getAsJsonObject()
                    .get("payload")
                    .getAsJsonObject();
            EventType type = EventType.valueOf(
                    json.get("dtype")
                            .getAsString()
            );
            factories.get(type)
                    .handle(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
