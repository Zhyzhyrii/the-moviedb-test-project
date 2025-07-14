package org.themoviedb.models.wrappers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.List;

@Value
public class PaginatedResponse<T> {
    long page;
    List<T> results;

    @JsonProperty("total_pages")
    long totalPages;

    @JsonProperty("total_results")
    long totalResults;
}
