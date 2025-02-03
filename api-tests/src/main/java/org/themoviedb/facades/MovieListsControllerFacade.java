package org.themoviedb.facades;

import org.themoviedb.controllers.MovieListsController;
import org.themoviedb.models.MovieDto;

import java.util.List;

public class MovieListsControllerFacade {

    private final MovieListsController movieListsController = new MovieListsController();

    //   TODO make random
    public MovieDto getRandomTopRatedMovie() {
        return getTopRatedMovies().getFirst();
    }

    private List<MovieDto> getTopRatedMovies() {
        return movieListsController.getTopRatedMovies()
                .getResults();
    }
}
