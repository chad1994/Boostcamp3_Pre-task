package kr.ac.skuniv.choejun_yeong.boostcamp3.viewmodel;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import androidx.databinding.ObservableInt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import io.reactivex.disposables.CompositeDisposable;
import kr.ac.skuniv.choejun_yeong.boostcamp3.R;
import kr.ac.skuniv.choejun_yeong.boostcamp3.adapter.MoviePagedAdapter;
import kr.ac.skuniv.choejun_yeong.boostcamp3.datasource.MovieDataSourceFactory;
import kr.ac.skuniv.choejun_yeong.boostcamp3.datasource.MoviePageKeyedDataSource;
import kr.ac.skuniv.choejun_yeong.boostcamp3.model.Movie;

public class MainViewModel extends ViewModel {

//    private Movies movies;
    private MoviePagedAdapter adapter;
    private String editableMovieName;
    public MutableLiveData<Movie> selected;
    public MutableLiveData<String> movieName;
    public ObservableInt emptyVisibility;
    //
    private CompositeDisposable compositeDisposable;
    private LiveData<PagedList<Movie>> moviePagedList;
    private LiveData<MoviePageKeyedDataSource> liveDatasource;
//    private PagedList.Config config =
//            new PagedList.Config.Builder()
//                    .setEnablePlaceholders(true)
//                    .setPageSize(MoviePageKeyedDataSource.PAGE_SIZE)
//                    .setPrefetchDistance(MoviePageKeyedDataSource.PAGE_SIZE)
//                    .setInitialLoadSizeHint(MoviePageKeyedDataSource.PAGE_SIZE)
//                    .build();

    public void init() {
        compositeDisposable = new CompositeDisposable();

//        movies = new Movies();
        adapter = new MoviePagedAdapter(R.layout.movie_item, this);
        selected = new MutableLiveData<>();
        movieName = new MutableLiveData<>();
        editableMovieName = "";
        emptyVisibility = new ObservableInt(View.GONE);
        moviePagedList = new LiveData<PagedList<Movie>>() {
        };
    }

    public void search(){
        MovieDataSourceFactory movieDataSourceFactory = new MovieDataSourceFactory(movieName.getValue(), compositeDisposable);
        liveDatasource = movieDataSourceFactory.getMovieLiveDataSource();
        PagedList.Config config =
                new PagedList.Config.Builder()
                        .setEnablePlaceholders(true)
                        .setPageSize(MoviePageKeyedDataSource.PAGE_SIZE)
                        .setPrefetchDistance(MoviePageKeyedDataSource.PAGE_SIZE)
                        .setInitialLoadSizeHint(MoviePageKeyedDataSource.PAGE_SIZE)
                        .build();
        moviePagedList = new LivePagedListBuilder<>(movieDataSourceFactory,config).build();
    }

    public void onSearchClick() {
//        movieName.setValue(editableName);
        Log.d("@@@","movie:"+movieName.getValue());
        search();
    }

//    public void fetchList(String movieName, int display) {
////        movies.fetchList(movieName, display);
//
//    }

    public LiveData<PagedList<Movie>> getMovies() {
        return moviePagedList;
    }

    public void setMovieInAdapter(PagedList<Movie> movies) {
        adapter.setMovies(movies);
        adapter.notifyDataSetChanged();
    }


    public MoviePagedAdapter getAdapter() {
        return adapter;
    }


    public MutableLiveData<Movie> getSelected() {
        return selected;
    }

//    public MutableLiveData<String> getSeachMovieName() {
//        return movieName;
//    }

    public void onItemClick(Integer i) {
        Movie movie = getMovieAt(i);
        selected.setValue(movie);
    }



    public Movie getMovieAt(Integer i) {
//        if (movies.getMovies().getValue() != null && i != null && movies.getMovies().getValue().size() > i) {
//            return movies.getMovies().getValue().get(i);
//        }
        if(moviePagedList.getValue()!=null && i != null && moviePagedList.getValue().size() > i){
            return moviePagedList.getValue().get(i);
        }
        return null;
    }

    public TextWatcher textWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               movieName.setValue(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
    }

    public void unBind() {
        compositeDisposable.clear();
    }

}
