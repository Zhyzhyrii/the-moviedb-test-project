package org.themoviedb.data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MediaType {

    MOVIE("movie");

    private final String name;
}
