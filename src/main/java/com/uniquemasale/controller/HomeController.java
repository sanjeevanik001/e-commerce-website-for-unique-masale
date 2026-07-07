package com.uniquemasale.controller;

import com.uniquemasale.model.ContactMessage;
import com.uniquemasale.service.ProductService;
import com.uniquemasale.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Serves the single-page website and handles contact-form submissions.
 * All sections (Home, About, Products, Reviews, Gallery, Contact) live on
 * one Thymeleaf template and are navigated to via in-page anchors.
 */
@Controller
public class HomeController {

    private final ProductService productService;
    private final ReviewService reviewService;

    public HomeController(ProductService productService, ReviewService reviewService) {
        this.productService = productService;
        this.reviewService = reviewService;
    }

    /**
     * Populates the model shared by every request to the home page.
     */
    private void addSharedAttributes(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("reviews", reviewService.getAllReviews());
    }

    /**
     * Renders the home page.
     */
    @GetMapping("/")
    public String home(Model model) {
        addSharedAttributes(model);
        if (!model.containsAttribute("contactMessage")) {
            model.addAttribute("contactMessage", new ContactMessage());
        }
        return "index";
    }

    /**
     * Handles contact-form submissions. On validation errors the form is
     * redisplayed with messages; on success a confirmation flag is set.
     */
    @PostMapping("/contact")
    public String submitContact(@Valid @ModelAttribute("contactMessage") ContactMessage contactMessage,
                                BindingResult bindingResult,
                                Model model,
                                RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            addSharedAttributes(model);
            return "index";
        }

        // In production this is where the message would be persisted or emailed.
        // For now we simply acknowledge the submission.
        redirectAttributes.addFlashAttribute("contactSuccess", true);
        return "redirect:/#contact";
    }
}
