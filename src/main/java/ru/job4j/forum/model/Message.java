package ru.job4j.forum.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Objects;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    private String username;
    private LocalDate created;

    @ManyToOne
    private Post post;

    public Message(String text, String username) {
        this.text = text;
        this.username = username;
        this.created = LocalDate.now();
    }

    public Message() {
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
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

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
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