package org.themoviedb;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//TODO move to common module
@SpringBootApplication
@NoArgsConstructor(access = AccessLevel.PRIVATE)//TODO figure out how to remove this
public class Application {

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
