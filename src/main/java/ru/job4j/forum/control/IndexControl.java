package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.forum.service.TopicService;

import java.security.Principal;

@Controller
public class IndexControl {
    private final TopicService topicService;

    public IndexControl(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model, Principal principal) {
        model.addAttribute("topics", topicService.getAllTopics());
        model.addAttribute("username", principal.getName());
        return "index";
    }
}
