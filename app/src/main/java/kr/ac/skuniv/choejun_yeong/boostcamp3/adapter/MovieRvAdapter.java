package kr.ac.skuniv.choejun_yeong.boostcamp3.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import kr.ac.skuniv.choejun_yeong.boostcamp3.viewmodel.MainViewModel;
import kr.ac.skuniv.choejun_yeong.boostcamp3.model.Movie;

public class MovieRvAdapter extends RecyclerView.Adapter<MovieViewHolder>  {

    private int layoutId;
    private List<Movie> list;
    private MainViewModel viewModel;


    public MovieRvAdapter(@LayoutRes int layoutId, MainViewModel viewModel){
        this.layoutId = layoutId;
        this.viewModel = viewModel;
    }

    private int getLayoutIdForPosition(int position) {
        return layoutId;
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutIdForPosition(position);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, i, viewGroup,false);

        return new MovieViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int i) {
        movieViewHolder.bind(viewModel,i);
    }

    public void setMovies(List<Movie> movies){
        this.list = movies;
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }


}
