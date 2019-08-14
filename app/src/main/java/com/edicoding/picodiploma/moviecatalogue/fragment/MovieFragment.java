package com.edicoding.picodiploma.moviecatalogue.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.edicoding.picodiploma.moviecatalogue.R;
import com.edicoding.picodiploma.moviecatalogue.adapter.MovieAdapter;
import com.edicoding.picodiploma.moviecatalogue.adapter.MovieAdapter.CardViewHolder;
import com.edicoding.picodiploma.moviecatalogue.model.Movie;
import com.edicoding.picodiploma.moviecatalogue.model.MovieData;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment implements MovieAdapter.OnItemClickListener {
    private ArrayList<Movie> list = new ArrayList<>();
    private RecyclerView rvCategory;
    private View view;
    private String language;

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_movie, container, false);
        rvCategory = view.findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list.addAll(MovieData.getListData());
        showRecyclerCardView();

        return view;
    }

    private void showRecyclerCardView() {
        MovieAdapter adapter = new MovieAdapter(list);
        rvCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvCategory.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position) {

    }
}
