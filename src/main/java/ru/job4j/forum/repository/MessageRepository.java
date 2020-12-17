package ru.job4j.forum.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.Message;

import java.util.Collection;

public interface MessageRepository extends CrudRepository<Message, Integer> {

    Collection<Message> findMessagesByPostId(int id);
}
