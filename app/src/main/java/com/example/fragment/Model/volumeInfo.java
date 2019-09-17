package com.example.fragment.Model;

import com.google.gson.annotations.SerializedName;

public class volumeInfo
{
    @SerializedName("authors")
    String authors;
    @SerializedName("categories")
    String categories;
    @SerializedName("imageLinks")
    imageLinks imageLinks;

    public volumeInfo()
    {

    }

    public volumeInfo(String authors, String categories, com.example.fragment.Model.imageLinks imageLinks)
    {
        this.authors = authors;
        this.categories = categories;
        this.imageLinks = imageLinks;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public com.example.fragment.Model.imageLinks getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(com.example.fragment.Model.imageLinks imageLinks) {
        this.imageLinks = imageLinks;
    }
}
