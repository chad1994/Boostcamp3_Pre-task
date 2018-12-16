package kr.ac.skuniv.choejun_yeong.boostcamp3.datasource;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;
import io.reactivex.disposables.CompositeDisposable;
import kr.ac.skuniv.choejun_yeong.boostcamp3.model.Movie;

public class MovieDataSourceFactory extends DataSource.Factory {


    private String query;
    private CompositeDisposable compositeDisposable;
    private MutableLiveData<PageKeyedDataSource<Integer,Movie>> movieLiveDataSource;

    public MovieDataSourceFactory(String query, CompositeDisposable compositeDisposable) {
        this.query = query;
        this.compositeDisposable = compositeDisposable;
        movieLiveDataSource = new MutableLiveData<>();
    }

    @NonNull
    @Override
    public DataSource create() {
        MoviePageKeyedDataSource source = new MoviePageKeyedDataSource(query,compositeDisposable);
        movieLiveDataSource.postValue(source);
        return source;
    }

    public MutableLiveData<PageKeyedDataSource<Integer,Movie>> getMovieLiveDataSource() {
        return movieLiveDataSource;
    }
}
