package org.themoviedb.utils;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@UtilityClass
public class RandomUtil {

    public static <T> T getRandomElement(final List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List should not be empty");
        }
        return list.get(ThreadLocalRandom.current().nextInt(list.size()));
    }
}
