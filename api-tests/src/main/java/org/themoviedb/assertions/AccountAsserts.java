package org.themoviedb.assertions;

import lombok.Setter;
import org.assertj.core.api.Assertions;
import org.themoviedb.models.MovieDto;
import org.themoviedb.models.PostResponseDto;

@Setter
public class AccountAsserts {

    private PostResponseDto postResponseDto;
    private MovieDto movieDto;

    public void movieIsAddedCorrectly() {
        var expected = PostResponseDto.builder()
                .success(true)
                .statusCode(1)
                .statusMessage("Success.")
                .build();
        Assertions.assertThat(postResponseDto)
                .overridingErrorMessage("Movie was not added to watchlist")
                .isEqualTo(expected);
    }

    public void watchListContainsExpectedMovie(final MovieDto expectedMovie) {
        Assertions.assertThat(movieDto)
                .overridingErrorMessage("Wrong movie was added to watchlist")
                .isEqualTo(expectedMovie);
    }
}
