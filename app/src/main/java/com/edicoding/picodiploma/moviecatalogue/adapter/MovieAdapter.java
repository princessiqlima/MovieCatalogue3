package com.edicoding.picodiploma.moviecatalogue.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.edicoding.picodiploma.moviecatalogue.DetailMovie;
import com.edicoding.picodiploma.moviecatalogue.R;
import com.edicoding.picodiploma.moviecatalogue.model.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.CardViewHolder> {
    private Context context;
    private ArrayList<Movie> listMovie;
    private OnItemClickListener mListener;

    public MovieAdapter(ArrayList<Movie> list){
        this.listMovie = list;
        this.context = context;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_movie, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        holder.bind(listMovie.get(position));
    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvTitle, tvDate, tvSynopsis;
        View detail;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            tvDate = itemView.findViewById(R.id.tv_item_date);
            detail = itemView.findViewById(R.id.card_view);
        }

        public void bind(final Movie movie) {
            Glide.with(itemView.getContext())
                    .load(movie.getPhoto())
                    .apply(new RequestOptions().override(350,550))
                    .into(imgPhoto);

            tvTitle.setText(movie.getTitle());
            tvDate.setText(movie.getDate());

            detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(itemView.getContext(), DetailMovie.class);
                    intent.putExtra(DetailMovie.EXTRA_MOVIE, movie);
                    itemView.getContext().startActivity(intent);

                }
            });

        }
    }
}
