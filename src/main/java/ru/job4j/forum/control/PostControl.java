package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.MessageService;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.TopicService;

import java.security.Principal;

@Controller
public class PostControl {
    private final PostService postService;
    private final MessageService messageService;
    private final TopicService topicService;

    public PostControl(PostService postService, MessageService messageService, TopicService topicService) {
        this.postService = postService;
        this.messageService = messageService;
        this.topicService = topicService;
    }

    @GetMapping("/post")
    public String getPost(@RequestParam int id, Model model, Principal principal) {
        model.addAttribute("posts", postService.findAllPostByTopicId(id));
        model.addAttribute("topic", topicService.findTopicById(id));
        model.addAttribute("username", principal.getName());
        return "post";
    }

    @GetMapping("/message")
    public String getMessages(@RequestParam int id, Model model, Principal principal) {
        model.addAttribute("messages", messageService.getMessagesByPostId(id));
        model.addAttribute("username", principal.getName());
        model.addAttribute("post", postService.findPostById(id));
        return "postMessage";
    }

    @GetMapping("/edit")
    public String getAddPage(Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        return "edit";
    }

    @PostMapping("/edit")
    public String savePost(@ModelAttribute Post post) {
        postService.addPost(post);
        return "redirect:/index";
    }
}
