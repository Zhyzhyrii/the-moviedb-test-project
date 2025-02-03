package org.themoviedb.steps;

import org.themoviedb.facades.MovieListsControllerFacade;
import org.themoviedb.models.Movie;

public class MovieListsSteps {

    private final MovieListsControllerFacade movieListsControllerFacade = new MovieListsControllerFacade();

    public Movie getRandomTopRatedMovie() {
        return movieListsControllerFacade.getRandomTopRatedMovie();
    }
}
