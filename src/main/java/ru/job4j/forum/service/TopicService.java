package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Topic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class TopicService {

    private final List<Topic> topics = new ArrayList<>();

    public TopicService() {
        topics.add(new Topic(0,"Обсуждение", "Говорите о спорте, развлечениях, музыке, фильмах, о своем любимом цвете, говорите обо всем."));
        topics.add(new Topic(1, "Работа", "Раздел с вакансиями"));
        topics.add(new Topic(2, "Флудилка", "Что угодно"));
    }

    public Collection<Topic> getAllTopics() {
        return topics;
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }
}
