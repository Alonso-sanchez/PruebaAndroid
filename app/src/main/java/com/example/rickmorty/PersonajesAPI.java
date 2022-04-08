package com.example.rickmorty;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PersonajesAPI {

    @GET("character/{id}")
    public Call<Results> getPersonaje(@Path("id") int id);
}
