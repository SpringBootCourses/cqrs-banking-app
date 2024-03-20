package com.example.eventhandler.handler;

import com.google.gson.JsonObject;

public interface EventHandler {

    void handle(JsonObject object);

}
