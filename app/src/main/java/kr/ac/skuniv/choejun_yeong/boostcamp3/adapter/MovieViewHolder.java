package kr.ac.skuniv.choejun_yeong.boostcamp3.adapter;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import kr.ac.skuniv.choejun_yeong.boostcamp3.databinding.MovieItemBinding;
import kr.ac.skuniv.choejun_yeong.boostcamp3.model.Movie;
import kr.ac.skuniv.choejun_yeong.boostcamp3.ui.main.MainEventListener;

public class MovieViewHolder extends RecyclerView.ViewHolder {
    private MovieItemBinding binding;
    private MainEventListener listener;


    public MovieViewHolder(MovieItemBinding binding,MainEventListener listener) {
        super(binding.getRoot());
        this.binding = binding;
        this.listener = listener;
    }

    void bind(Movie movie){
        binding.setMovie(movie);
        binding.setMainListener(listener);
        binding.executePendingBindings();
    }
}
