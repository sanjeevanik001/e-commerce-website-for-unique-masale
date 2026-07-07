package com.uniquemasale.service;

import com.uniquemasale.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Supplies the catalogue of products. In a real deployment this could be
 * backed by a database; here the data is curated in-memory so the site is
 * fast and self-contained.
 */
@Service
public class ProductService {

    private final List<Product> products = List.of(
            new Product("Red Chilli Powder",
                    "Fiery, vibrant chilli powder ground from sun-dried red chillies for bold colour and heat.",
                    "red-chilli.png", "powder"),
            new Product("Turmeric Powder",
                    "Pure golden turmeric with a warm aroma and natural health benefits for everyday cooking.",
                    "turmeric.png", "powder"),
            new Product("Coriander Powder",
                    "Freshly ground coriander seeds delivering a mild, earthy fragrance to any dish.",
                    "coriander.png", "powder"),
            new Product("Garam Masala",
                    "A classic blend of hand-roasted whole spices that adds warmth and depth to curries.",
                    "garam-masala.png", "masala"),
            new Product("Goda Masala",
                    "Authentic Maharashtrian sweet-spice blend with coconut, essential for traditional recipes.",
                    "goda-masala.png", "masala"),
            new Product("Kala Masala",
                    "Bold dark-roasted Maharashtrian masala with a rich, smoky and spicy character.",
                    "kala-masala.png", "masala"),
            new Product("Kitchen King Masala",
                    "An all-rounder blend that makes everyday vegetables and gravies taste restaurant-style.",
                    "kitchen-king.png", "masala"),
            new Product("Biryani Masala",
                    "Aromatic blend of premium spices crafted for fragrant, flavourful biryanis and pulao.",
                    "biryani-masala.png", "masala"),
            new Product("Sabji Masala",
                    "A balanced everyday masala that brings out the best in all your vegetable dishes.",
                    "sabji-masala.png", "masala"),
            new Product("Pav Bhaji Masala",
                    "Tangy, spicy blend that recreates the beloved Mumbai street-food pav bhaji at home.",
                    "pav-bhaji-masala.png", "masala"),
            new Product("Tea Masala",
                    "Fragrant chai masala with cardamom, ginger and cinnamon for the perfect cup of tea.",
                    "tea-masala.png", "masala"),
            new Product("Sambar Masala",
                    "South-Indian style masala for rich, tangy sambar bursting with authentic flavour.",
                    "sambar-masala.png", "masala"),
            new Product("Kolhapuri Masala",
                    "Signature fiery Kolhapuri blend for those who love their food hot and full of character.",
                    "kolhapuri-masala.png", "masala"),
            new Product("Pickles",
                    "Homemade pickles prepared in traditional oil and spices for a tangy, spicy kick.",
                    "pickles.png", "food"),
            new Product("Papad",
                    "Crispy, thin papad made from quality lentils, perfect as a side or a snack.",
                    "papad.png", "food"),
            new Product("Ladoo",
                    "Melt-in-the-mouth homemade ladoos made with pure ingredients and lots of love.",
                    "ladoo.png", "food"),
            new Product("Chutneys",
                    "Flavour-packed dry chutneys made from roasted spices, peanuts and garlic.",
                    "chutneys.png", "food"),
            new Product("Other Homemade Products",
                    "A range of other traditional homemade food products, made fresh on order.",
                    "other-products.png", "food")
    );

    /**
     * @return an unmodifiable list of every product in the catalogue.
     */
    public List<Product> getAllProducts() {
        return products;
    }
}
