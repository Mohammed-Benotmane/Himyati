package com.example.mohamed.himyati;

public class Item {
    private int image;
    private String description;
    private String user;

    public Item(int image, String description) {
        this.image = image;
        this.description = description;
    }

    public Item() {
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

