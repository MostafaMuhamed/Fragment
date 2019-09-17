package com.example.fragment.Model;

import com.google.gson.annotations.SerializedName;

public class items
{
    @SerializedName("id")
    String id;
    @SerializedName("volumeInfo")
    volumeInfo volumeInfo;

    public items()
    {

    }

    public items(String id, com.example.fragment.Model.volumeInfo volumeInfo)
    {
        this.id = id;
        this.volumeInfo = volumeInfo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public com.example.fragment.Model.volumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(com.example.fragment.Model.volumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }
}
