package org.themoviedb.facades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.themoviedb.controllers.MovieListsController;
import org.themoviedb.models.MovieDto;

@Component
public class MovieListsControllerFacade {

    private final MovieListsController movieListsController;

    @Autowired
    public MovieListsControllerFacade(final MovieListsController movieListsController) {
        this.movieListsController = movieListsController;
    }

    //   TODO make random
    public MovieDto getRandomTopRatedMovie() {
        return movieListsController
                .getTopRatedMovies()
                .getResults()
                .getFirst();
    }
}
