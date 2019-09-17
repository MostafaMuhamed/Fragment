package com.example.fragment;

import com.example.fragment.Model.UserModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Helper
{
    @GET("books/v1/volumes?q=cars")
    Call<ArrayList<UserModel>> carHelper();
    @GET("books/v1/volumes?q=football")
    Call<ArrayList<UserModel>> footballHelper();
    @GET("books/v1/volumes?q=food")
    Call<ArrayList<UserModel>> foodHelper();
}
