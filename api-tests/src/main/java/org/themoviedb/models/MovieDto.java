package org.themoviedb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDto {
    Long id;//todo long

    String title;

    @JsonProperty("original_title")
    String originalTitle;

    Double popularity;//todo BigDecimal
}
