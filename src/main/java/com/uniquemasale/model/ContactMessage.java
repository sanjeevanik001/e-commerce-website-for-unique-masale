package com.uniquemasale.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * Backing bean for the contact form. Uses Jakarta Bean Validation so the
 * controller can reject invalid submissions and return helpful messages.
 */
public class ContactMessage {

    @NotBlank(message = "Please enter your name")
    @Size(max = 80, message = "Name is too long")
    private String name;

    @NotBlank(message = "Please enter your phone number")
    @Pattern(regexp = "^[0-9+\\-\\s]{7,15}$", message = "Please enter a valid phone number")
    private String phone;

    @NotBlank(message = "Please enter a message")
    @Size(max = 1000, message = "Message is too long")
    private String message;

    public ContactMessage() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
