package com.opticsolutions.moviecatalogservice.Models;

import org.springframework.stereotype.Component;

public class CatalogItem {
    private String name;
    private String descriptions;
    private int rating;

    public CatalogItem(String name, String descriptions, int rating) {
        this.name = name;
        this.descriptions = descriptions;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
