package com.test.newapicallingrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    Context context;
    List<models> modelsList;

    public MyAdapter(Context context, List<models> modelsList) {
        this.context = context;
        this.modelsList = modelsList;
    }


    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {

        holder.title.setText(modelsList.get(position).getTitle());
        holder.url.setText(modelsList.get(position).getUrl());
        holder.thumbnailUrl.setText(modelsList.get(position).getThumbnailUrl());
    }

    @Override
    public int getItemCount() {
        return modelsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title,url,thumbnailUrl;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            url= itemView.findViewById(R.id.url);
            thumbnailUrl=itemView.findViewById(R.id.thumbnailUrl);

        }
    }
}
