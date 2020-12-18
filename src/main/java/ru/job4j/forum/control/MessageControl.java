package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Message;
import ru.job4j.forum.service.MessageService;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.TopicService;

import java.security.Principal;

@Controller
public class MessageControl {
    private final PostService postService;
    private final MessageService messageService;
    private final TopicService topicService;

    public MessageControl(PostService postService, MessageService messageService, TopicService topicService) {
        this.postService = postService;
        this.messageService = messageService;
        this.topicService = topicService;
    }

    @GetMapping("/message")
    public String getMessages(@RequestParam int id, Model model, Principal principal) {
        model.addAttribute("messages", messageService.getMessagesByPostId(id));
        model.addAttribute("username", principal.getName());
        model.addAttribute("post", postService.findPostById(id));
        return "messages";
    }

    @PostMapping("/message")
    public String saveMessage(@ModelAttribute Message message, @RequestParam int postId) {
        messageService.addMessage(message, postId);
        return "redirect:/message?id=" + postId;
    }
}
