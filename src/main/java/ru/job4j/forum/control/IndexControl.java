package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.forum.service.TopicService;

@Controller
public class IndexControl {
    private final TopicService topicService;

    public IndexControl(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("topics", topicService.getAllTopics());
        return "index";
    }
}
