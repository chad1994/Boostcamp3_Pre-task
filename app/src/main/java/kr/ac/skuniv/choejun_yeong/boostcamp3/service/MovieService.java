package kr.ac.skuniv.choejun_yeong.boostcamp3.service;

import javax.net.ssl.HttpsURLConnection;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import kr.ac.skuniv.choejun_yeong.boostcamp3.BuildConfig;
import kr.ac.skuniv.choejun_yeong.boostcamp3.model.ReponseMovie;
import kr.ac.skuniv.choejun_yeong.boostcamp3.network.MovieAPIService;
import kr.ac.skuniv.choejun_yeong.boostcamp3.network.NetworkUtil;
import retrofit2.Response;

public class MovieService {
    private static final MovieService ourInstance = new MovieService();
    private MovieAPIService mService;

    public static MovieService getInstance() {
        return ourInstance;
    }

    private MovieService() { }

    public void setService(String Id, String Secret) {
        mService = NetworkUtil.getMovieService(Id,Secret);
    }

    public Observable<Response<ReponseMovie>> getMovieList(String movieName,int display){
        setService(BuildConfig.NaverClientID,BuildConfig.NaverClientSecret);
        return mService.getMovieList(movieName,display).subscribeOn(Schedulers.io())
                .doOnNext(res -> {
                    if(res.code() == HttpsURLConnection.HTTP_OK){
                        res.body();
                    }
                });
    }

    public Observable<Response<ReponseMovie>> getMovieListbyPage(String movieName,int display,int start){
        setService(BuildConfig.NaverClientID,BuildConfig.NaverClientSecret);
        return mService.getMovieListbyPage(movieName,display,start).subscribeOn(Schedulers.io())
                .doOnNext(res -> {
                    if(res.code() == HttpsURLConnection.HTTP_OK){
                        res.body();
                    }
                });
    }
}
