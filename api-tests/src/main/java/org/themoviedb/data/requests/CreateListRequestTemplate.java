package org.themoviedb.data.requests;

import org.themoviedb.models.ListDto;

import static org.themoviedb.data.enums.Language.ENGLISH;
import static org.themoviedb.utils.RandomUtil.getRandomizedAlphaNumericValue;

public class CreateListRequestTemplate {

    public ListDto createListRequest() {
        return ListDto.builder()
                .name(String.format("Created new list: %s", getRandomizedAlphaNumericValue(1)))
                .description(String.format("Description: %s", getRandomizedAlphaNumericValue(1)))
                .language(ENGLISH.getValue())
                .build();
    }
}
