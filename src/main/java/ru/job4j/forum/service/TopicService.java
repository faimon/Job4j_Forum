package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Topic;
import ru.job4j.forum.repository.TopicRepository;

import java.util.Collection;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public Collection<Topic> getAllTopics() {
        return (Collection<Topic>) topicRepository.findAll();
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public Topic findTopicById(int id) {
        return topicRepository.findById(id).get();
    }
}
