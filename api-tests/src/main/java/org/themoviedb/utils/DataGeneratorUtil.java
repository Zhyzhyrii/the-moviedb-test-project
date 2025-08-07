package org.themoviedb.utils;

import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.IntStream;

@UtilityClass
public class DataGeneratorUtil {

    public static List<BigDecimal> generateMovieRatingRange() {
        return generateRange(0.5, 10, 0.5).stream()
                .map(BigDecimal::valueOf)
                .toList();
    }

    private static List<Double> generateRange(final double start, final double end, final double step) {
        var steps = (int) ((end - start) / step);
        return IntStream.rangeClosed(0, steps)
                .mapToObj(i -> start + i * step)
                .toList();
    }
}
