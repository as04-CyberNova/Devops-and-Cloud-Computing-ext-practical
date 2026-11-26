package com.devops.lab.controller;

import com.devops.lab.model.Feedback;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FeedbackController {

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("feedback", new Feedback());
        return "feedback-form";
    }

    @PostMapping("/submitFeedback")
    public String submitFeedback(@ModelAttribute Feedback feedback, Model model) {
        model.addAttribute("feedback", feedback);
        model.addAttribute("message", "Thank you for your feedback! Your response has been recorded successfully.");
        return "feedback-result";
    }
}
