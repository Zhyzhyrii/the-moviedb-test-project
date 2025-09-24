package org.themoviedb.models.wrappers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.List;

@Value
public class PaginatedResponse<T> {
    int page;
    List<T> results;

    @JsonProperty("total_pages")
    int totalPages;

    @JsonProperty("total_results")
    int totalResults;
}
