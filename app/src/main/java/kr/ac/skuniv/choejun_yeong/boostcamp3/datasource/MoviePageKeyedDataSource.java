package kr.ac.skuniv.choejun_yeong.boostcamp3.datasource;

import android.util.Log;

import javax.net.ssl.HttpsURLConnection;

import androidx.annotation.LongDef;
import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import kr.ac.skuniv.choejun_yeong.boostcamp3.model.Movie;
import kr.ac.skuniv.choejun_yeong.boostcamp3.service.MovieService;

public class MoviePageKeyedDataSource extends PageKeyedDataSource<Integer,Movie> {

    private String query;
    private CompositeDisposable compositeDisposable;
    private int limit =0;
    public static final int PAGE_SIZE = 10;

    MoviePageKeyedDataSource(String query, CompositeDisposable compositeDisposable) {
        this.query = query;
        this.compositeDisposable = compositeDisposable;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Movie> callback) {
            compositeDisposable.add(MovieService.getInstance().getMovieListbyPage(query,params.requestedLoadSize,1)
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnNext(res ->{
                        if (res.code() == HttpsURLConnection.HTTP_OK) {
                           limit = res.body().getTotal();
                           callback.onResult(res.body().getItems(),res.body().getDisplay(),res.body().getStart()+res.body().getDisplay());
                            Log.d("@@@","on success");
                        } else {
                            Log.d("HttpConnectFail", "//Error");
                        }
                    })
                    .subscribe());
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Movie> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Movie> callback) {
            if(params.key<limit){
                compositeDisposable.add(MovieService.getInstance().getMovieListbyPage(query,params.requestedLoadSize,params.key)
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnNext(res ->{
                            if (res.code() == HttpsURLConnection.HTTP_OK) {
                                limit = res.body().getTotal();
                                callback.onResult(res.body().getItems(),params.key+res.body().getDisplay());
                            } else {
                                Log.d("HttpConnectFail", "//Error");
                            }
                        })
                        .subscribe());
            }
    }
}
