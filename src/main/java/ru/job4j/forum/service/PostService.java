package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private final List<Post> posts = new ArrayList<>();

    public PostService() {
        posts.add(Post.of("Правила форума."));
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public Post getPostById(int id) {
        return posts.get(id);
    }

    public List<Post> getAll() {
        return posts;
    }
}
