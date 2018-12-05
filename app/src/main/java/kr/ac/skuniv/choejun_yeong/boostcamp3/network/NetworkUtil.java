package kr.ac.skuniv.choejun_yeong.boostcamp3.network;

public class NetworkUtil {

    private NetworkUtil() {
    }

    private static final String BASE_URL = "https://openapi.naver.com/v1/";
    public static final String Search_URL = BASE_URL + "search/";

    public static MovieAPIService getMovieService(String Id, String Secret){
        return RetrofitClient.getClientwithHeader(Search_URL, Id, Secret).create(MovieAPIService.class);
    }
}
