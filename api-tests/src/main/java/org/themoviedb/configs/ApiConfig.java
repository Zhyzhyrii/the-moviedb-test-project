package org.themoviedb.configs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "api")
@Getter
@Setter
public class ApiConfig {
    private String accountId;
    private String token;
}
