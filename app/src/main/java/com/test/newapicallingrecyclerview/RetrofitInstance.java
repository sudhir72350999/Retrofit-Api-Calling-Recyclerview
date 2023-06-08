package com.test.newapicallingrecyclerview;

import static com.test.newapicallingrecyclerview.MainActivity.url;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {


    public static RetrofitInstance instance;
    ApiInterface apiInterface;
    RetrofitInstance(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // build the retrofit class object
//        apiInterface variable me store kre
        apiInterface= retrofit.create(ApiInterface.class);


    }
    public static RetrofitInstance getInstance() {
        if (instance == null) {
            instance = new RetrofitInstance();
        }
        return instance;

    }
}
