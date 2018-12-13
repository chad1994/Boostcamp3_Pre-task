package kr.ac.skuniv.choejun_yeong.boostcamp3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import kr.ac.skuniv.choejun_yeong.boostcamp3.databinding.ActivityMainBinding;
import kr.ac.skuniv.choejun_yeong.boostcamp3.model.Movie;
import kr.ac.skuniv.choejun_yeong.boostcamp3.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private final int MAX_DISPLAY = 100;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupBindings(savedInstanceState);
    }

    private void setupBindings(Bundle savedInstanceState) {
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        if (savedInstanceState == null) {
            viewModel.init();
        }
        activityMainBinding.setVm(viewModel);
//        setupSearchClick();
        setupList();
    }


//    private void setupSearchClick() {
//        viewModel.getSeachMovieName().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(String movieName) {
//                setupList();
//            }
//        });
//    }

    //    private void setupList(String movieName, int display) {
    private void setupList() {
//        viewModel.fetchList(movieName, display);
//        viewModel.getMovies().observe(this, new Observer<List<Movie>>() {
//            @Override
//            public void onChanged(@Nullable List<Movie> movies) {
//                if (movies.size() == 0 || movies == null) {
//                    viewModel.emptyVisibility.set(View.VISIBLE);
//                    viewModel.setMovieInAdapter(movies);
//
//                } else {
//                    viewModel.emptyVisibility.set(View.GONE);
//                    viewModel.setMovieInAdapter(movies);
//                }
//            }
//        });
        viewModel.getMovies().observe(this, new Observer<PagedList<Movie>>() {
            @Override
            public void onChanged(PagedList<Movie> movies) {
                Log.d("@@@","IN@@");
                if (movies.size() == 0 || movies == null) {
                    viewModel.emptyVisibility.set(View.VISIBLE);
                    viewModel.setMovieInAdapter(movies);
                    viewModel.getAdapter().submitList(movies);
                } else {
                    viewModel.emptyVisibility.set(View.GONE);
                    viewModel.setMovieInAdapter(movies);
                    viewModel.getAdapter().submitList(movies);
                }
            }
        });
        setupListClick();
    }

    private void setupListClick() {
        viewModel.getSelected().observe(this, new Observer<Movie>() {
            @Override
            public void onChanged(@Nullable Movie movie) {
                if (movie != null) {
                    //TODO 화면전환.
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    Uri uri = Uri.parse(movie.getLink());
                    intent.setData(uri);
                    startActivity(intent);
                }
            }
        });
    }



    @Override
    protected void onPause() {
        viewModel.unBind();
        super.onPause();
    }
}
