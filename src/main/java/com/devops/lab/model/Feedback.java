package com.devops.lab.model;

public class Feedback {
    private String name;
    private String email;
    private String category;
    private int rating;
    private String comments;

    public Feedback() {}

    public Feedback(String name, String email, String category, int rating, String comments) {
        this.name = name;
        this.email = email;
        this.category = category;
        this.rating = rating;
        this.comments = comments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
