package kr.ac.skuniv.choejun_yeong.boostcamp3.network;

import java.util.List;

import io.reactivex.Observable;
import kr.ac.skuniv.choejun_yeong.boostcamp3.model.Movie;
import kr.ac.skuniv.choejun_yeong.boostcamp3.model.ReponseMovie;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieAPIService {
    @GET("movie.json")
    Observable<Response<ReponseMovie>> getMovieList(@Query("query") String movieName);
}
