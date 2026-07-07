package com.uniquemasale.model;

/**
 * Immutable representation of a single product shown on the website.
 *
 * @param name        display name of the product
 * @param description short marketing description
 * @param image       path to the product image under /static/images
 * @param category    category slug used by the frontend filter
 */
public record Product(
        String name,
        String description,
        String image,
        String category
) {
}
