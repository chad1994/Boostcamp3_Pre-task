package kr.ac.skuniv.choejun_yeong.boostcamp3.datasource;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import io.reactivex.disposables.CompositeDisposable;
import kr.ac.skuniv.choejun_yeong.boostcamp3.model.Movie;

public class MovieDataSourceFactory extends DataSource.Factory<Integer,Movie> {

    private String query;
    private CompositeDisposable compositeDisposable;
    private MutableLiveData<MoviePageKeyedDataSource> movieLiveDataSource = new MutableLiveData<MoviePageKeyedDataSource>();

    public MovieDataSourceFactory(String query, CompositeDisposable compositeDisposable) {
        this.query = query;
        this.compositeDisposable = compositeDisposable;
    }

    @NonNull
    @Override
    public DataSource<Integer, Movie> create() {
        MoviePageKeyedDataSource source = new MoviePageKeyedDataSource(query,compositeDisposable);
        movieLiveDataSource.postValue(source);
        return source;
    }


    public MutableLiveData<MoviePageKeyedDataSource> getMovieLiveDataSource() {
        return movieLiveDataSource;
    }
}
