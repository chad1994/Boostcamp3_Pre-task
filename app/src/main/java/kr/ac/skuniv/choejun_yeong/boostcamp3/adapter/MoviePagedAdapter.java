package kr.ac.skuniv.choejun_yeong.boostcamp3.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import kr.ac.skuniv.choejun_yeong.boostcamp3.viewmodel.MainViewModel;
import kr.ac.skuniv.choejun_yeong.boostcamp3.model.Movie;

public class MoviePagedAdapter extends PagedListAdapter<Movie,MovieViewHolder> {

    private int layoutId;
    private PagedList<Movie> list;
    private MainViewModel viewModel;

    public MoviePagedAdapter(@LayoutRes int layoutId, MainViewModel viewModel) {
        super(DIFF_CALLBACK);
        this.layoutId = layoutId;
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, viewType, parent,false);

        return new MovieViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int position) {
        movieViewHolder.bind(viewModel,position);
    }

    private int getLayoutIdForPosition(int position) {
        return layoutId;
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutIdForPosition(position);
    }

    public void setMovies(PagedList<Movie> movies){
        this.list = movies;
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    private static DiffUtil.ItemCallback<Movie> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Movie>() {
                @Override
                public boolean areItemsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
                    return oldItem.equals(newItem);
                }

                @Override
                public boolean areContentsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
                    return oldItem.equals(newItem);
                }
            };
}
