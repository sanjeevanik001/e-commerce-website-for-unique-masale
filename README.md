# Unique Masale &amp; Food Products

A modern, premium, responsive website for an Indian homemade food brand, built with
**Java Spring Boot + Thymeleaf + Maven** and **Bootstrap 5**.

## Features

- Sticky, blurred navbar with active-section highlighting
- Animated hero with spice photography
- About, Products, Why Choose Us, Reviews, Gallery and Contact sections
- Product **search** and **category filter** (Powders / Masala Blends / Food Products)
- "Order on WhatsApp" buttons that pre-fill the product name
- Customer reviews with star ratings and profile photos
- Masonry gallery with lazy-loaded images
- Contact form with server-side validation (Spring Bean Validation)
- Floating WhatsApp button, scroll-to-top button, page loader
- **Dark / Light mode** toggle (remembers your choice)
- Smooth scroll-reveal animations, hover effects, mobile-first responsive layout
- SEO meta tags and Open Graph tags

## Tech Stack

| Layer      | Technology                          |
|------------|-------------------------------------|
| Backend    | Java 17, Spring Boot 3.3            |
| Templating | Thymeleaf                           |
| Frontend   | HTML5, CSS3, Bootstrap 5, Vanilla JS |
| Build      | Maven                               |

## Project Structure

```
unique-masale/
├── pom.xml
└── src/main/
    ├── java/com/uniquemasale/
    │   ├── UniqueMasaleApplication.java   # entry point
    │   ├── controller/HomeController.java # routes + contact form
    │   ├── model/                         # Product, Review, ContactMessage
    │   └── service/                       # ProductService, ReviewService
    └── resources/
        ├── application.properties
        ├── templates/
        │   ├── index.html                 # single-page site
        │   └── fragments/                 # head, navbar, footer (reusable)
        └── static/
            ├── css/style.css
            ├── js/main.js
            └── images/                     # product & gallery images
```

## Running Locally

You need **JDK 17+** and **Maven** installed.

```bash
# from the project root
mvn spring-boot:run
```

Then open <http://localhost:8080> in your browser.

To build a runnable JAR:

```bash
mvn clean package
java -jar target/unique-masale-1.0.0.jar
```

## Contact

**Unique Masale &amp; Food Products** &mdash; +91 8830911730
