/*
package kr.ac.skuniv.choejun_yeong.boostcamp3.model;


import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import androidx.databinding.BaseObservable;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import kr.ac.skuniv.choejun_yeong.boostcamp3.service.MovieService;

public class Movies extends BaseObservable {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private List<Movie> movieList = new ArrayList<>();
    private MutableLiveData<List<Movie>> movies = new MutableLiveData<>();
    public MutableLiveData<List<Movie>> getMovies() {
        return movies;
    }

    public void addMovie(Movie movie) {
        movieList.add(movie);
    }

    public void fetchList(String movieName, int display) {
        //TODO : 리스트 업데이트 (통신)
        compositeDisposable.add(MovieService.getInstance().getMovieList(movieName, display)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(res -> {
                    if (res.code() == HttpsURLConnection.HTTP_OK) {
                        movieList = res.body().getItems();
                        movies.setValue(movieList);
                    } else {
                        Log.d("HttpConnectFail", "//Error");
                    }
                })
                .doOnError(e -> Log.d("OnError:", "" + e.getMessage()))
                .subscribe());
    }

    public void unBind(){
        compositeDisposable.clear();
    }

}
*/
