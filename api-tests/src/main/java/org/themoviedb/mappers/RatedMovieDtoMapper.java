package org.themoviedb.mappers;

import org.springframework.stereotype.Component;
import org.themoviedb.models.movie.MovieDto;
import org.themoviedb.models.movie.RatedMovieDto;

import java.math.BigDecimal;

@Component
public class RatedMovieDtoMapper {

    public RatedMovieDto movieDtoToRatedMovieDto(final MovieDto movieDto, final BigDecimal rating) {
        return new RatedMovieDto(movieDto.getId(), movieDto.getTitle(), movieDto.getOriginalTitle(), movieDto.getPopularity(), rating);
    }
}
