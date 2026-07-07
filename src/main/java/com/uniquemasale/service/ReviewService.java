package com.uniquemasale.service;

import com.uniquemasale.model.Review;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Supplies customer testimonials shown on the home page.
 */
@Service
public class ReviewService {

    private final List<Review> reviews = List.of(
            new Review("Sunita Deshmukh", "Pune",
                    "The garam masala tastes exactly like my grandmother used to make. Pure, aromatic and completely homemade!",
                    "reviewer-1.png", 5),
            new Review("Rajesh Patil", "Kolhapur",
                    "Ordered the Kolhapuri and kala masala for my restaurant. My customers keep asking what makes the food so special.",
                    "reviewer-2.png", 5),
            new Review("Priya Joshi", "Mumbai",
                    "Fresh, hygienic and no artificial colours. The pickles and ladoo remind me of home. Highly recommended!",
                    "reviewer-3.png", 5)
    );

    /**
     * @return an unmodifiable list of all customer reviews.
     */
    public List<Review> getAllReviews() {
        return reviews;
    }
}
