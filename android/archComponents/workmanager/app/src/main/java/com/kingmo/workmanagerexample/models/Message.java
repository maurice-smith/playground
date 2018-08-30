package com.kingmo.workmanagerexample.models;

public class Message {
    public static final String MSG_KEY = "MSG_PREF_KEY";

    private int id;
    private String message;

    public Message(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
