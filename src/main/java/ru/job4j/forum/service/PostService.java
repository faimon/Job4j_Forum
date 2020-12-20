package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostRepository;
import ru.job4j.forum.repository.TopicRepository;

import java.time.LocalDate;
import java.util.Collection;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final TopicRepository topicRepository;

    public PostService(PostRepository postRepository, TopicRepository topicRepository) {
        this.postRepository = postRepository;
        this.topicRepository = topicRepository;
    }

    public void addPost(Post post, int topic_id) {
        post.setTopic(topicRepository.findById(topic_id).get());
        post.setCreated(LocalDate.now());
        postRepository.save(post);
    }

    public Post getPostById(int id) {
        return postRepository.findById(id).get();
    }

    public Collection<Post> getAll() {
        return (Collection<Post>) postRepository.findAll();
    }

    public Post findPostById(int id) {
        return postRepository.findById(id).orElse(null);
    }

    public Collection<Post> findAllPostByTopicId(int topicId) {
        return postRepository.findPostsByTopicId(topicId);
    }
}
