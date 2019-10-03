package com.edicoding.picodiploma.moviecatalogue;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.edicoding.picodiploma.moviecatalogue.adapter.MovieAdapter;
import com.edicoding.picodiploma.moviecatalogue.adapter.MovieItemAdapter;
import com.edicoding.picodiploma.moviecatalogue.model.Movie;
import com.edicoding.picodiploma.moviecatalogue.model.MovieData;
import com.edicoding.picodiploma.moviecatalogue.model.MovieItem;
import com.edicoding.picodiploma.moviecatalogue.network.GetDataService;
import com.edicoding.picodiploma.moviecatalogue.network.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
//    private ArrayList<Movie> list = new ArrayList<>();
    private MovieItemAdapter adapter;
    private RecyclerView rvCategory;
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ProgressDialog progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        /*Create handle for the RetrofitInstance interface*/
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<MovieItem>> call = service.getAllPhotos();

        call.enqueue(new Callback<List<MovieItem>>() {

            @Override
            public void onResponse(Call<List<MovieItem>> call, Response<List<MovieItem>> response) {
                progressDoalog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<MovieItem>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }


    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<MovieItem> movieItemList) {
        rvCategory = findViewById(R.id.rv_category);
        adapter = new MovieItemAdapter(this, movieItemList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        rvCategory.setLayoutManager(layoutManager);
        rvCategory.setAdapter(adapter);
    }
}
