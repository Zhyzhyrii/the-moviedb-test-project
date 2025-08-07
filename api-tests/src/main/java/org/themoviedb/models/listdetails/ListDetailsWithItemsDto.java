package org.themoviedb.models.listdetails;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ListDetailsWithItemsDto extends ListDetailsDto {
    private final List<ItemDto> items;
}

