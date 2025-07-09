package org.themoviedb.models.listdetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.util.List;

@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListDetailsDto {
    long id;
    String name;
    String description;
    List<ItemDto> items;
}
