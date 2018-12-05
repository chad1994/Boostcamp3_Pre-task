package kr.ac.skuniv.choejun_yeong.boostcamp3.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import kr.ac.skuniv.choejun_yeong.boostcamp3.R;
import kr.ac.skuniv.choejun_yeong.boostcamp3.databinding.MovieItemBinding;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    OnListItemClickListener mListener;
    MovieItemBinding binding;

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);

        binding = DataBindingUtil.bind(itemView);
    }

    public void setOnListItemClickListener(OnListItemClickListener onListItemClickListener){
        mListener=onListItemClickListener;
    }
}
