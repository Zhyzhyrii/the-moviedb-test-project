package org.themoviedb.facades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.themoviedb.controllers.MovieListsController;
import org.themoviedb.models.movie.MovieDto;
import org.themoviedb.utils.RandomUtil;

import java.util.List;

import static org.themoviedb.Constants.MAX_PAGE_COUNT;

@Component
public class MovieListsControllerFacade {

    private final MovieListsController movieListsController;

    @Autowired
    public MovieListsControllerFacade(final MovieListsController movieListsController) {
        this.movieListsController = movieListsController;
    }

    public MovieDto getRandomTopRatedMovie() {
        var results = getTopRatedMoviesResultsOnRandomPage();
        return RandomUtil.getRandomElement(results);
    }

    public MovieDto getRandomTopRatedMovieExcluding(final List<MovieDto> exceptMovies) {
        var results = getTopRatedMoviesResultsOnRandomPage();
        results.removeAll(exceptMovies);
        return RandomUtil.getRandomElement(results);
    }

    private List<MovieDto> getTopRatedMoviesResultsOnRandomPage() {
        var randomPage = getRandomPage();
        return movieListsController
                .getTopRatedMovies(randomPage)
                .getResults();
    }

    private int getRandomPage() {
        var totalPages = Math.min(MAX_PAGE_COUNT, movieListsController.getTopRatedMovies().getTotalPages());
        return RandomUtil.getRandomInt(1, totalPages + 1);
    }
}
