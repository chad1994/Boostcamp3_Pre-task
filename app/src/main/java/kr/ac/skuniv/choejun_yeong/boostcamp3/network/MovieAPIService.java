package kr.ac.skuniv.choejun_yeong.boostcamp3.network;

import io.reactivex.Observable;
import kr.ac.skuniv.choejun_yeong.boostcamp3.model.ReponseMovie;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieAPIService {
    @GET("movie.json")
    Observable<Response<ReponseMovie>> getMovieList(@Query("query") String movieName,@Query("display")int display);

    @GET("movie.json")
    Observable<Response<ReponseMovie>> getMovieListbyPage(@Query("query") String movieName,@Query("display")int display,@Query("start")int start);
}
