package org.themoviedb.models.movie;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor(force = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RatedMovieDto extends MovieDto {
    private final BigDecimal rating;

    public RatedMovieDto(final long id,
                         final String title,
                         final String originalTitle,
                         final Double popularity,
                         final BigDecimal rating) {
        super(id, title, originalTitle, popularity);
        this.rating = rating;
    }
}
