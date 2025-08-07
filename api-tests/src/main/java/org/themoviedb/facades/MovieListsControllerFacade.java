package org.themoviedb.facades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.themoviedb.controllers.MovieListsController;
import org.themoviedb.models.movie.MovieDto;
import org.themoviedb.utils.RandomUtil;

import java.util.List;

@Component
public class MovieListsControllerFacade {

    private final MovieListsController movieListsController;

    @Autowired
    public MovieListsControllerFacade(final MovieListsController movieListsController) {
        this.movieListsController = movieListsController;
    }

    public MovieDto getRandomTopRatedMovie() {
        return RandomUtil.getRandomElement(getTopRatedMoviesResults());
    }

    public MovieDto getRandomTopRatedMovie(final List<MovieDto> exceptMovies) {
        var results = getTopRatedMoviesResults();
        results.removeAll(exceptMovies);
        return RandomUtil.getRandomElement(results);
    }

    private List<MovieDto> getTopRatedMoviesResults() {
        return movieListsController
                .getTopRatedMovies()
                .getResults();
    }
}
