package com.edicoding.picodiploma.moviecatalogue.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Toast;

import com.edicoding.picodiploma.moviecatalogue.MainActivity;
import com.edicoding.picodiploma.moviecatalogue.R;
import com.edicoding.picodiploma.moviecatalogue.adapter.MovieAdapter;
import com.edicoding.picodiploma.moviecatalogue.adapter.MovieAdapter.CardViewHolder;
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

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment implements MovieAdapter.OnItemClickListener {
    private ArrayList<MovieItem> list = new ArrayList<>();
    private RecyclerView rvCategory;
    private View view;
    private String language;

    private MovieItemAdapter adapter;
    ProgressDialog progressDoalog;

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final ProgressDialog progressDoalog = new ProgressDialog(getActivity());
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();


        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_movie, container, false);
        rvCategory = view.findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

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
                Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


    @Override
    public void onItemClick(int position) {

    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<MovieItem> movieItemList) {

        adapter = new MovieItemAdapter(getActivity(), movieItemList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvCategory.setLayoutManager(layoutManager);
        rvCategory.setAdapter(adapter);
    }
}
