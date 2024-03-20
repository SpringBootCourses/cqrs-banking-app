package com.example.eventhandler.config;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

@Component
public class LocalDateTimeDeserializer
        implements JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(
            final JsonElement json,
            final Type typeOfT,
            final JsonDeserializationContext context
    ) {
        return LocalDateTime.ofInstant(
                Instant.ofEpochMilli(
                        json.getAsLong() / 1000
                ),
                TimeZone.getDefault()
                        .toZoneId()
        );
    }

}

