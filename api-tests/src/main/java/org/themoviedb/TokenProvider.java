package org.themoviedb;

import org.springframework.stereotype.Service;
import org.themoviedb.configs.ApiConfig;

@Service
public class TokenProvider {

    @SuppressWarnings("PMD.AvoidUsingVolatile")
    private volatile String authToken;
    private final Object tokenLock = new Object();

    @SuppressWarnings("PMD.AvoidSynchronizedStatement")
    public String getAccessToken(final ApiConfig config) {
        var local = authToken;
        if (local == null) {
            synchronized (tokenLock) {
                if (authToken == null) {
                    authToken = generateAccessToken(config);
                }
                local = authToken;
            }
        }
        return local;
    }

    private String generateAccessToken(final ApiConfig config) {
        /*
        Here is a method for token generation: when we have a login, password and call auth endpoint to receive the token.
        It can be helpful when we do not have a static (long-term) token, and it can be expired.
        TMDB provides a long-term token for api.
         */
        authToken = config.getToken();
        return authToken;
    }
}
