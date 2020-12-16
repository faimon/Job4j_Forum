package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.service.PostService;

import java.security.Principal;

@Controller
public class PostControl {
    private final PostService postService;

    public PostControl(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post")
    public String getPost(@RequestParam int id, Model model, Principal principal) {
        model.addAttribute("post", postService.getPostById(id));
        model.addAttribute("username", principal.getName());
        return "index";
    }
}
