package org.themoviedb.assertions;

import lombok.Setter;
import org.assertj.core.api.Assertions;
import org.themoviedb.models.MovieDto;
import org.themoviedb.models.PostResponseDto;

import java.util.List;

@Setter
public class AccountAsserts {

    private PostResponseDto postResponseDto;
    private List<MovieDto> watchListMovies;

    public void addMovieResponseIsSuccessful() {
//        TODO: to ResponseTemplate
        var expected = PostResponseDto.builder()
                .success(true)
                .statusCode(1)
                .statusMessage("Success.")
                .build();
        Assertions.assertThat(postResponseDto)
                .overridingErrorMessage("Movie was not added to watchlist")
                .isEqualTo(expected);
    }

    public void addMovieResponseIsUnsuccessful(final int statusCode, final String statusMessage) {
//        TODO: to ResponseTemplate
        var expected = PostResponseDto.builder()
                .success(false)
                .statusCode(statusCode)
                .statusMessage(statusMessage)
                .build();
        Assertions.assertThat(postResponseDto)
                .overridingErrorMessage("Expected failure response for invalid movie addition, but the response did not match.")
                .isEqualTo(expected);
    }

    public void watchListContainsExpectedMovie(final MovieDto expectedMovie) {
        Assertions.assertThat(watchListMovies)
                .overridingErrorMessage("Expected the watchlist to contain the movie %s, but it was not found.", expectedMovie)
                .contains(expectedMovie);
    }

    public void watchListIsEmpty() {
        Assertions.assertThat(watchListMovies)
                .overridingErrorMessage("Watchlist is not empty")
                .isEmpty();
    }
}
