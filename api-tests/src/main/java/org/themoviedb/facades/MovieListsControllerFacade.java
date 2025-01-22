package org.themoviedb.facades;

import org.themoviedb.controllers.MovieListsController;
import org.themoviedb.models.Movie;

import java.util.List;

public class MovieListsControllerFacade {

    private final MovieListsController movieListsController = new MovieListsController();

    //   TODO make random
    public Movie getRandomTopRatedMovie() {
        return getTopRatedMovies().getFirst();
    }

    private List<Movie> getTopRatedMovies() {
        return movieListsController.getTopRatedMovies()
                .getResults();
    }
}
