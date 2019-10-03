package com.edicoding.picodiploma.moviecatalogue.network;

import com.edicoding.picodiploma.moviecatalogue.model.MovieItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/photos")
    Call<List<MovieItem>> getAllPhotos();
}
