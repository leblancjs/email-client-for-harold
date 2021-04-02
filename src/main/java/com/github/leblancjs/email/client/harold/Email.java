package com.github.leblancjs.email.client.harold;

public class Email {
    private final String sender;
    private final String subject;
    private final String message;

    public Email(String sender, String subject, String message) {
        this.sender = sender;
        this.subject = subject;
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }
}
