package org.themoviedb.models;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Builder
@Getter
@ToString
public class RatingDto {
    private final BigDecimal value;
}
