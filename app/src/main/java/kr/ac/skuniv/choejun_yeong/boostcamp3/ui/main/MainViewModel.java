package kr.ac.skuniv.choejun_yeong.boostcamp3.ui.main;

import android.util.Log;
import android.view.View;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import io.reactivex.disposables.CompositeDisposable;
import kr.ac.skuniv.choejun_yeong.boostcamp3.datasource.MovieDataSourceFactory;
import kr.ac.skuniv.choejun_yeong.boostcamp3.datasource.MoviePageKeyedDataSource;
import kr.ac.skuniv.choejun_yeong.boostcamp3.model.Movie;

public class MainViewModel extends ViewModel implements MainEventListener {

    public ObservableInt emptyVisibility;
    private MutableLiveData<String> selected;
    private MutableLiveData<String> movieName;
    private CompositeDisposable compositeDisposable;
    private MovieDataSourceFactory movieDataSourceFactory;
    private LiveData<PagedList<Movie>> moviePagedList ;
    private MutableLiveData<Boolean> hasSearched;

    private PagedList.Config config = new PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setPageSize(MoviePageKeyedDataSource.PAGE_SIZE)
            .setInitialLoadSizeHint(MoviePageKeyedDataSource.PAGE_SIZE)
            .setPrefetchDistance(MoviePageKeyedDataSource.PAGE_SIZE)
            .build();

    public void init() {
        compositeDisposable = new CompositeDisposable();
        selected = new MutableLiveData<>();
        movieName = new MutableLiveData<>();
        hasSearched = new MutableLiveData<>();
        hasSearched.postValue(false);
        emptyVisibility = new ObservableInt(View.GONE);
 }

    public void search() {
        movieDataSourceFactory = new MovieDataSourceFactory(movieName.getValue(), compositeDisposable);
        moviePagedList = (new LivePagedListBuilder(movieDataSourceFactory, config)).build(); // -> liveData observe 하는 순간 create 호출...(?)
        hasSearched.postValue(true); //observe 타이밍을 맞추기 위한...(?)
    }

    public LiveData<PagedList<Movie>> getMovies() {
        return moviePagedList;
    }

    public MutableLiveData<Boolean> getHasSearched(){
        return hasSearched;
    }

    public MutableLiveData<String> getSelected() {
        return selected;
    }

    public void unBind() {
        compositeDisposable.clear();
    }

    @Override
    public void textWatcher(String text) {
        movieName.setValue(text);
    }

    @Override
    public void onItemClick(String item) {
        selected.setValue(item);
    }
}

