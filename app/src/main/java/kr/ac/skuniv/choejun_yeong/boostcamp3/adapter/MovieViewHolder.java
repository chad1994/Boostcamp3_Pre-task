package kr.ac.skuniv.choejun_yeong.boostcamp3.adapter;

import android.view.View;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import kr.ac.skuniv.choejun_yeong.boostcamp3.BR;
import kr.ac.skuniv.choejun_yeong.boostcamp3.MainViewModel;

public class MovieViewHolder extends RecyclerView.ViewHolder {
    private ViewDataBinding binding;


    public MovieViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    void bind(MainViewModel viewModel,Integer position){
        binding.setVariable(BR.position,position);
        binding.setVariable(BR.vm,viewModel);
        binding.executePendingBindings();
    }
}
