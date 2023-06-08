package com.test.newapicallingrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public  static String url = "https://jsonplaceholder.typicode.com";
    List<models> userList;

    RecyclerView recyclerView;

    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RetrofitInstance.getInstance().apiInterface.getData()
                .enqueue(new Callback<List<models>>() {
                    @Override
                    public void onResponse(Call<List<models>> call, Response<List<models>> response) {
                        userList =response.body();
                        recyclerView.setAdapter(new MyAdapter(MainActivity.this,userList));




                        for(int i=0;i<userList.size(); i++){
                            Log.e("api",""+userList.get(i).getTitle());
                        }
//                        Log.e("api",""+response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<List<models>> call, Throwable t) {
                        Log.e("api",""+t.getMessage().toString());


                    }
                });
    }
}