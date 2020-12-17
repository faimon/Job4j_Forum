package ru.job4j.forum.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.Post;

import java.util.Collection;

public interface PostRepository extends CrudRepository<Post, Integer> {
    Collection<Post> findPostsByTopicId(int id);
}
