package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostRepository;

import java.time.LocalDate;
import java.util.Collection;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void addPost(Post post) {
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
        return postRepository.findById(id).get();
    }

    public Collection<Post> findAllPostByTopicId(int topicId) {
        return postRepository.findPostsByTopicId(topicId);
    }
}
