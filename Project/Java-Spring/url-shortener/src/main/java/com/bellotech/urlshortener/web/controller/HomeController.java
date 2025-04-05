package com.bellotech.urlshortener.web.controller;

import com.bellotech.urlshortener.domain.entities.ShortUrl;
import com.bellotech.urlshortener.services.ShortUrlService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final ShortUrlService shortUrlService;

    public HomeController(ShortUrlService shortUrlService) {
        this.shortUrlService = shortUrlService;
    }


    @GetMapping("/")
    public String home (Model model) {
        List<ShortUrl> shortUrls = shortUrlService.findByPublicShortUrls();
        model.addAttribute("shortUrls", shortUrls);
        model.addAttribute("baseUrl", "http://localhost:8080/");
        return "index";
    }
}
