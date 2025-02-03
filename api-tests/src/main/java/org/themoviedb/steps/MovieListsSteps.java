package org.themoviedb.steps;

import org.themoviedb.facades.MovieListsControllerFacade;
import org.themoviedb.models.MovieDto;

public class MovieListsSteps {

    private final MovieListsControllerFacade movieListsControllerFacade = new MovieListsControllerFacade();

    public MovieDto getRandomTopRatedMovie() {
        return movieListsControllerFacade.getRandomTopRatedMovie();
    }
}
