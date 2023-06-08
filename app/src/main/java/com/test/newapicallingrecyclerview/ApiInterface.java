package com.test.newapicallingrecyclerview;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/photos")
    Call<List<models>>  getData();



}
