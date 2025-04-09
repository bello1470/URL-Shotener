package com.bellotech.urlshortener.web.controller;

import com.bellotech.urlshortener.domain.entities.ShortUrl;
import com.bellotech.urlshortener.domain.models.ShortUrlDto;
import com.bellotech.urlshortener.services.ShortUrlService;
import com.bellotech.urlshortener.web.dtos.CreateShortUrlForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class HomeController {

    private final ShortUrlService shortUrlService;

    public HomeController(ShortUrlService shortUrlService) {
        this.shortUrlService = shortUrlService;
    }


    @GetMapping("/")
    public String home (Model model) {
        List<ShortUrlDto > shortUrls = shortUrlService.findByPublicShortUrls();
        model.addAttribute("shortUrls", shortUrls);
        model.addAttribute("baseUrl", "http://localhost:8080/");
        model.addAttribute("createShortUrlForm", new CreateShortUrlForm(""));
        return "index";
    }


    @PostMapping("/short-urls")
    String creatShortURlForm(@ModelAttribute("createShortUrlForm") @Valid CreateShortUrlForm createShortUrlForm,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             Model model) {
        if (bindingResult.hasErrors()) {
            List<ShortUrlDto > shortUrls = shortUrlService.findByPublicShortUrls();
            model.addAttribute("shortUrls", shortUrls);
            model.addAttribute("baseUrl", "http://localhost:8080/");
            return "index";
        }
        redirectAttributes.addFlashAttribute("successMessage", "ShortUrl created successfully");
        return "redirect:/";
    }
}
