package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Message;
import ru.job4j.forum.repository.MessageRepository;

import java.util.Collection;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Collection<Message> getMessagesByPostId(int postId) {
        return messageRepository.findMessagesByPostId(postId);
    }

    public void addMessage(Message message) {
        messageRepository.save(message);
    }
}
