package org.gk.controllers;

import org.gk.data.repositories.interfaces.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {

    private NewsRepository newsRepository;

    @Autowired
    public HomeController(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute(newsRepository.getNews(20));
        return "home";
    }
}
