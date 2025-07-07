package org.themoviedb.data.requests;

import org.themoviedb.models.ListDto;

import static org.themoviedb.data.enums.Language.ENGLISH;
import static org.themoviedb.utils.RandomUtil.getRandomizedAlphaNumericValue;

public class CreateListRequestTemplate {

    public ListDto createListRequest() {
        return ListDto.builder()
                .name(String.format("Created list: %s", getRandomizedAlphaNumericValue(5)))
                .description(String.format("Description: %s", getRandomizedAlphaNumericValue(8)))
                .language(ENGLISH.getValue())
                .build();
    }
}
