package org.themoviedb.mappers;

import org.springframework.stereotype.Component;
import org.themoviedb.models.MovieDto;
import org.themoviedb.models.listdetails.ItemDto;

import java.util.List;

@Component
public class ItemDtoMapper {

    public List<ItemDto> movieDtoListToItemDtoList(final List<MovieDto> movieDtoList) {
        return movieDtoList.stream()
                .map(this::movieDtoToItemDto)
                .toList();
    }

    private ItemDto movieDtoToItemDto(final MovieDto movieDto) {
        return ItemDto.builder()
                .id(movieDto.getId())
                .title(movieDto.getTitle())
                .popularity(movieDto.getPopularity())
                .build();
    }
}
