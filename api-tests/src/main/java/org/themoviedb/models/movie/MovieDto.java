package org.themoviedb.models.movie;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@NoArgsConstructor(force = true)
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDto {
    private final long id;

    private final String title;

    @JsonProperty("original_title")
    private final String originalTitle;

    private final Double popularity;//todo BigDecimal

    public MovieDto(final long id,
                    final String title,
                    final String originalTitle,
                    final Double popularity) {
        this.id = id;
        this.title = title;
        this.originalTitle = originalTitle;
        this.popularity = popularity;
    }
}
