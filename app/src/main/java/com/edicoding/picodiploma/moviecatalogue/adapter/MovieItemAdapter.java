package com.edicoding.picodiploma.moviecatalogue.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.edicoding.picodiploma.moviecatalogue.MainActivity;
import com.edicoding.picodiploma.moviecatalogue.R;
import com.edicoding.picodiploma.moviecatalogue.model.MovieItem;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieItemAdapter extends RecyclerView.Adapter<MovieItemAdapter.CustomViewHolder>  {
    private List<MovieItem> dataList;
    private Context context;

    public MovieItemAdapter(Context context,List<MovieItem> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public final View mView;

        TextView txtTitle, txtDate;
        private ImageView coverImage;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;

            txtTitle = mView.findViewById(R.id.tv_item_title);
            txtDate = mView.findViewById(R.id.tv_item_date);
            coverImage = mView.findViewById(R.id.img_item_photo);
        }
    }

    @NonNull
    @Override
    public MovieItemAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_cardview_movie, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieItemAdapter.CustomViewHolder holder, int position) {
        holder.txtTitle.setText(dataList.get(position).getTitle());
        holder.txtDate.setText(dataList.get(position).getThumbnailUrl());

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(dataList.get(position).getUrl())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.coverImage);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
