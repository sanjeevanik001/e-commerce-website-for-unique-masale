package com.uniquemasale.model;

/**
 * Customer testimonial displayed in the "Customer Reviews" section.
 *
 * @param name    reviewer's name
 * @param location reviewer's city / area
 * @param message the testimonial text
 * @param image   path to the reviewer's profile image under /static/images
 * @param rating  star rating from 1 to 5
 */
public record Review(
        String name,
        String location,
        String message,
        String image,
        int rating
) {
}
