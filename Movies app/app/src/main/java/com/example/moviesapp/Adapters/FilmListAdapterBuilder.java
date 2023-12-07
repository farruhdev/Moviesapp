package com.example.moviesapp.Adapters;
import com.example.moviesapp.Domain.ListFilm;

public class FilmListAdapterBuilder {
    private ListFilm items;

    public FilmListAdapterBuilder setItems(ListFilm items) {
        this.items = items;
        return this;
    }

    public FilmListAdapter createFilmListAdapter() {
        return new FilmListAdapter(items);
    }
}


