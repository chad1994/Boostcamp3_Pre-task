package kr.ac.skuniv.choejun_yeong.boostcamp3;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import io.reactivex.annotations.NonNull;
import kr.ac.skuniv.choejun_yeong.boostcamp3.databinding.ActivityMainBinding;
import kr.ac.skuniv.choejun_yeong.boostcamp3.model.Movie;

public class MainActivity extends AppCompatActivity {

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

        setupSearchClick();
    }

    private void setupList(String movieName) {
        viewModel.fetchList(movieName);
        viewModel.getMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(@Nullable List<Movie> movies) {
                if (movies.size() == 0) {
                    //빈 화면 보여줌.
                } else {
                    viewModel.setMovieInAdapter(movies);
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
                    //눌렸을때 화면전환.
                    Toast.makeText(MainActivity.this, ""+movie.getTitle(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setupSearchClick(){
        viewModel.getSeachMovieName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(MainActivity.this, ""+s, Toast.LENGTH_SHORT).show();
                setupList(s);
            }
        });
    }

}
