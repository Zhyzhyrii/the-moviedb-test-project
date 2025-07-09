package org.themoviedb.models.listdetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemDto {
    long id;
    String title;
    Double popularity;//todo BigDecimal
}
