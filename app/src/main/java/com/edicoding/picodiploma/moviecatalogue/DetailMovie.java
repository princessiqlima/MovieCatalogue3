package com.edicoding.picodiploma.moviecatalogue;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.edicoding.picodiploma.moviecatalogue.model.Movie;

public class DetailMovie extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    TextView title, date, synopsis;
    ImageView photo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        title = findViewById(R.id.tv_item_title);
        date = findViewById(R.id.tv_item_date);
        synopsis = findViewById(R.id.tv_item_synopsis);
        photo    = findViewById(R.id.img_item_photo);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        title.setText(movie.getTitle());
        date.setText(movie.getDate());
        synopsis.setText(movie.getSynopsis());

        Glide.with(this)
                .load(movie.getPhoto())
                .apply(new RequestOptions().override(350,550))
                .into(photo);
    }
}
