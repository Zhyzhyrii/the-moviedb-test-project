package org.themoviedb;

@SuppressWarnings("PMD.MissingStaticMethodInNonInstantiatableClass")
public final class ApiPaths {

    private ApiPaths() {
    }

    @SuppressWarnings("PMD.DataClass")
    public static final class PARAM {

        public static final String LIST_ID = "list_id";
        public static final String ACCOUNT_ID = "account_id";
        public static final String MOVIE_ID = "movie_id";
        public static final String PAGE = "page";

        private PARAM() {
        }
    }

    @SuppressWarnings("PMD.DataClass")
    public static final class Lists {

        public static final String ROOT = "/list";
        public static final String BY_ID = String.format("%s/{%s}", ROOT, PARAM.LIST_ID);
        public static final String ADD_ITEM = BY_ID + "/add_item";
        public static final String REMOVE_ITEM = BY_ID + "/remove_item";

        private Lists() {
        }
    }

    @SuppressWarnings("PMD.DataClass")
    public static final class Account {

        public static final String ROOT = "/account";
        public static final String BY_ID = String.format("%s/{%s}", ROOT, PARAM.ACCOUNT_ID);
        public static final String WATCH_LIST = BY_ID + "/watchlist";
        public static final String WATCH_LIST_MOVIES = WATCH_LIST + "/movies";
        public static final String LISTS_MOVIES = BY_ID + "/lists";
        public static final String RATED_MOVIES = BY_ID + "/rated/movies";

        private Account() {
        }
    }

    public static final class MovieLists {

        public static final String ROOT = "/movie";
        public static final String TOP_RATED = ROOT + "/top_rated";

        private MovieLists() {
        }
    }

    public static final class Movies {

        public static final String ROOT = "/movie";
        public static final String BY_ID = String.format("%s/{%s}", ROOT, PARAM.MOVIE_ID);
        public static final String RATING = BY_ID + "/rating";

        private Movies() {
        }
    }
}
