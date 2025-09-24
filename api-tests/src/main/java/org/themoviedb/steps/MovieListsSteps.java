package org.themoviedb.steps;

import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.themoviedb.facades.MovieListsControllerFacade;
import org.themoviedb.models.movie.MovieDto;

import java.util.List;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Component
@Scope(SCOPE_PROTOTYPE)
public class MovieListsSteps {

    private final MovieListsControllerFacade movieListsControllerFacade;

    @Autowired
    public MovieListsSteps(final MovieListsControllerFacade movieListsControllerFacade) {
        this.movieListsControllerFacade = movieListsControllerFacade;
    }

    @Step("Get random top rated movie")
    public MovieDto getRandomTopRatedMovie() {
        return movieListsControllerFacade.getRandomTopRatedMovie();
    }

    @Step("Get random top rated movie excluding '{exceptMovies}' movies")
    public MovieDto getRandomTopRatedMovie(final List<MovieDto> exceptMovies) {
        return movieListsControllerFacade.getRandomTopRatedMovieExcluding(exceptMovies);
    }
}
