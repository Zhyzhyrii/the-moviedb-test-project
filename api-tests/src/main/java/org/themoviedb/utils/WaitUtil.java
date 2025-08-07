package org.themoviedb.utils;

import lombok.experimental.UtilityClass;
import org.awaitility.Awaitility;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

@UtilityClass
public class WaitUtil {

    public static <T> T waitUntil(final Callable<T> supplier,
                                  final Predicate<? super T> predicate,
                                  final long timeOutMilliSeconds,
                                  final long pollIntervalMilliSeconds) {
        return Awaitility.await().
                pollInSameThread().
                atMost(timeOutMilliSeconds, TimeUnit.MILLISECONDS).
                with().
                pollInterval(pollIntervalMilliSeconds, TimeUnit.MILLISECONDS).
                until(supplier, predicate);
    }
}
