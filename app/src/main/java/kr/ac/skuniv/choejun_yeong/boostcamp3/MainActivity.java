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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kr.ac.skuniv.choejun_yeong.boostcamp3.adapter.MoviePagedAdapter;
import kr.ac.skuniv.choejun_yeong.boostcamp3.databinding.ActivityMainBinding;
import kr.ac.skuniv.choejun_yeong.boostcamp3.model.Movie;
import kr.ac.skuniv.choejun_yeong.boostcamp3.ui.main.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;
    private ActivityMainBinding activityMainBinding;
    private MoviePagedAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupBindings(savedInstanceState);
    }

    private void setupBindings(Bundle savedInstanceState) {
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        if (savedInstanceState == null) {
            viewModel.init();
        }
        activityMainBinding.setVm(viewModel);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        activityMainBinding.mainRv.setLayoutManager(layoutManager);
        adapter = new MoviePagedAdapter(viewModel);
        activityMainBinding.mainRv.setAdapter(adapter);
        setupList();
        setupListClick();
    }


    private void setupList() {
        viewModel.getHasSearched().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean==true) {
                    viewModel.getMovies().observe(MainActivity.this, new Observer<PagedList<Movie>>() {
                        @Override
                        public void onChanged(@Nullable PagedList<Movie> movies) {
                            if (movies != null) {
                                viewModel.emptyVisibility.set(View.GONE);
                                adapter.submitList(movies);
                                Log.d("@@@movie",""+movies.getLoadedCount()+"/"+movies.getLastKey()+"/"+movies.getPositionOffset()+"/"+movies.size()+"/"+movies.isEmpty());
                                viewModel.getHasSearched().postValue(false);
                            }
                        }
                    });
                }
            }
        });
    }

    private void setupListClick() {
        viewModel.getSelected().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String movieUrl) {
                if (movieUrl != null) {
                    //TODO 화면전환.
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    Uri uri = Uri.parse(movieUrl);
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
