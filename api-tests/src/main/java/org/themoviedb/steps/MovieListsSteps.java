package org.themoviedb.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.themoviedb.facades.MovieListsControllerFacade;
import org.themoviedb.models.MovieDto;

@Component
public class MovieListsSteps {

    private final MovieListsControllerFacade movieListsControllerFacade;

    @Autowired
    public MovieListsSteps(final MovieListsControllerFacade movieListsControllerFacade) {
        this.movieListsControllerFacade = movieListsControllerFacade;
    }

    public MovieDto getRandomTopRatedMovie() {
        return movieListsControllerFacade.getRandomTopRatedMovie();
    }
}
