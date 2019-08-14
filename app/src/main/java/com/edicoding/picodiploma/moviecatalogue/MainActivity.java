package com.edicoding.picodiploma.moviecatalogue;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;
import android.widget.TextView;

import com.edicoding.picodiploma.moviecatalogue.adapter.MovieAdapter;
import com.edicoding.picodiploma.moviecatalogue.model.Movie;
import com.edicoding.picodiploma.moviecatalogue.model.MovieData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Movie> list = new ArrayList<>();
    private RecyclerView rvCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list.addAll(MovieData.getListData());
        showRecyclerCardView();
    }

    private void showRecyclerCardView() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        MovieAdapter cardViewStudentAdapter = new MovieAdapter(list);
        rvCategory.setAdapter(cardViewStudentAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_change_settings){
            Intent mIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(mIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}
