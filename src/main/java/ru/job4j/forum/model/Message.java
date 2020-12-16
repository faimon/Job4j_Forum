package ru.job4j.forum.model;

import java.util.Calendar;
import java.util.Objects;

public class Message {
    private int id;
    private String text;
    private String username;
    private Calendar created;

    public Message(String text, String username) {
        this.text = text;
        this.username = username;
        this.created = Calendar.getInstance();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Calendar getCreated() {
        return created;
    }

    public void setCreated(Calendar created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id == message.id &&
                Objects.equals(text, message.text) &&
                Objects.equals(username, message.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, username);
    }
}