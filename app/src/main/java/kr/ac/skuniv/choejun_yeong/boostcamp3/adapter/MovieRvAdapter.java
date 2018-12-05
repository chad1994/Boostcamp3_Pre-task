package kr.ac.skuniv.choejun_yeong.boostcamp3.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import kr.ac.skuniv.choejun_yeong.boostcamp3.R;
import kr.ac.skuniv.choejun_yeong.boostcamp3.model.Movie;

public class MovieRvAdapter extends RecyclerView.Adapter<MovieViewHolder> implements OnListItemClickListener {

    List<Movie> list;


    public MovieRvAdapter(List<Movie> list) {
        this.list = list;
    }


    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_item, viewGroup, false);
        MovieViewHolder holder = new MovieViewHolder(v);
        holder.setOnListItemClickListener(this);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int i) {
//        movieViewHolder.binding.movieItemImage
        movieViewHolder.binding.movieItemTitle.setText(list.get(i).getTitle());
        movieViewHolder.binding.movieItemUserRating.setRating(Float.parseFloat(list.get(i).getUserRating()));
        movieViewHolder.binding.movieItemPubdate.setText(list.get(i).getPubDate());
        movieViewHolder.binding.movieItemDirector.setText(list.get(i).getDirector());
        movieViewHolder.binding.movieItemActor.setText(list.get(i).getActor());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onListItemClick(int position) {

    }
}
