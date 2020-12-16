package ru.job4j.forum.model;

import java.util.List;
import java.util.Objects;

public class Topic {
    private int id;
    private String name;
    private String desc;
    private List<Post> posts;

    public Topic(int id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topic topic = (Topic) o;
        return Objects.equals(name, topic.name) &&
                Objects.equals(desc, topic.desc) &&
                Objects.equals(posts, topic.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, desc, posts);
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", posts=" + posts +
                '}';
    }
}
