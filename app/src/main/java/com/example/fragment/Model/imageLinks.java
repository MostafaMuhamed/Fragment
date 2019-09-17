package com.example.fragment.Model;

import com.google.gson.annotations.SerializedName;

public class imageLinks
{
    @SerializedName("smallThumbnail")
    int smallThumbnail;

    public imageLinks()
    {

    }

    public imageLinks(int smallThumbnail)
    {
        this.smallThumbnail = smallThumbnail;
    }

    public int getSmallThumbnail() {
        return smallThumbnail;
    }

    public void setSmallThumbnail(int smallThumbnail) {
        this.smallThumbnail = smallThumbnail;
    }
}
