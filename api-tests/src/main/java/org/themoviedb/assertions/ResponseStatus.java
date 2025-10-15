package org.themoviedb.assertions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
enum ResponseStatus {

    SUCCESS(1, "Success."),
    UPDATED_SUCCESS(12, "The item/record was updated successfully.");

    private final int statusCode;
    private final String statusMessage;
}
