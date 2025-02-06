package org.themoviedb.facades;

import org.themoviedb.controllers.MovieListsController;
import org.themoviedb.models.MovieDto;

public class MovieListsControllerFacade {

    private final MovieListsController movieListsController = new MovieListsController();

    //   TODO make random
    public MovieDto getRandomTopRatedMovie() {
        return movieListsController
                .getTopRatedMovies()
                .getResults()
                .getFirst();
    }
}
