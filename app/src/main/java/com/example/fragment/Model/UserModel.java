package com.example.fragment.Model;

import com.google.gson.annotations.SerializedName;

public class UserModel
{
    @SerializedName("items")
    items items;

    public UserModel()
    {

    }

    public UserModel(com.example.fragment.Model.items items)
    {
        this.items = items;
    }

    public com.example.fragment.Model.items getItems()
    {
        return items;
    }

    public void setItems(com.example.fragment.Model.items items)
    {
        this.items = items;
    }
}
