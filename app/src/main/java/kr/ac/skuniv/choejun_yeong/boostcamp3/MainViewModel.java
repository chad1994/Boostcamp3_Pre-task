package kr.ac.skuniv.choejun_yeong.boostcamp3;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;
import kr.ac.skuniv.choejun_yeong.boostcamp3.adapter.MovieRvAdapter;
import kr.ac.skuniv.choejun_yeong.boostcamp3.model.Movie;
import kr.ac.skuniv.choejun_yeong.boostcamp3.model.Movies;

public class MainViewModel extends ViewModel {
    @NonNull
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private Movies movies;
    private MovieRvAdapter adapter;
    private String editalbeName;
    public MutableLiveData<Movie> selected;
    public MutableLiveData<String> movieName;


    public MainViewModel(){
    }

    public void init(){
        movies = new Movies();
        adapter = new MovieRvAdapter(R.layout.movie_item,this);
        selected = new MutableLiveData<>();
        movieName = new MutableLiveData<>();
        editalbeName = "";
    }

    public void fetchList(String movieName){
        movies.fetchList(movieName);
    }

    public MutableLiveData<List<Movie>> getMovies(){
        return movies.getMovies();
    }

    public void setMovieInAdapter(List<Movie> movies){
        this.adapter.setMovies(movies);
        this.adapter.notifyDataSetChanged();
    }


    public MovieRvAdapter getAdapter(){ return adapter;}


    public MutableLiveData<Movie> getSelected(){
        return selected;
    }

    public MutableLiveData<String> getSeachMovieName(){
        return movieName;
    }
    public void onItemClick(Integer i){
        Movie movie = getMovieAt(i);
        selected.setValue(movie);
        Log.d("@@@","item clicked");
    }

    public void onSearchClick(){
        movieName.setValue(editalbeName);
    }
    public Movie getMovieAt(Integer i){
        if(movies.getMovies().getValue()!=null && i != null && movies.getMovies().getValue().size() > i){
            return movies.getMovies().getValue().get(i);
        }
        return null;
    }

    public TextWatcher textWatcher(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editalbeName=s.toString();
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        };
    }

}
