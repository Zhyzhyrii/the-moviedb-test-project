package org.themoviedb.models.listdetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemDto {
    long id;
    String title;
    BigDecimal popularity;
}
