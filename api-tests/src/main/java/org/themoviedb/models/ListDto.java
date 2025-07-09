package org.themoviedb.models;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class ListDto {
    private final String name;
    private final String description;
    private final String language;
}
