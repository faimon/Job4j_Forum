package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Message;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.MessageRepository;
import ru.job4j.forum.repository.PostRepository;

import java.time.LocalDate;
import java.util.Collection;

@Service
public class MessageService {
    private final MessageRepository messageRepository;
    private final PostRepository postRepository;

    public MessageService(MessageRepository messageRepository, PostRepository postRepository) {
        this.messageRepository = messageRepository;
        this.postRepository = postRepository;
    }

    public Collection<Message> getMessagesByPostId(int postId) {
        return messageRepository.findMessagesByPostId(postId);
    }

    public void addMessage(Message message, Post post) {
        message.setPost(post);
        message.setCreated(LocalDate.now());
        messageRepository.save(message);
    }

    public void addMessage(Message message, int postId) {
        message.setPost(postRepository.findById(postId).get());
        message.setCreated(LocalDate.now());
        messageRepository.save(message);
    }
}
