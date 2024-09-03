package com.example.sih_project;

public class CropItem {
    private String names;
    private String images;

    public CropItem(String names, String images) {
        this.names = names;
        this.images = images;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}