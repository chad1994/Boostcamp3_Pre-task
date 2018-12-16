package kr.ac.skuniv.choejun_yeong.boostcamp3.adapter;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import androidx.databinding.BindingAdapter;
import kr.ac.skuniv.choejun_yeong.boostcamp3.ui.main.MainViewModel;

public class CustomBindings {

    @BindingAdapter("textChangedListener")
    public static void bindTextWatcher(EditText editText,MainViewModel listener) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                listener.textWatcher(s.toString());
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    @BindingAdapter("setImage")
    public static void bindImageUrl(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }

    /*@BindingAdapter("searchItem")
    public static void bindRecyclerViewAdapter(RecyclerView recyclerView, PagedList<Movie> moviePagedList) {
//        recyclerView.setHasFixedSize(true);
//
//        if (recyclerView.getAdapter() == null) {
//            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
//            recyclerView.setHasFixedSize(true);
//            recyclerView.setAdapter(adapter);
//            Log.d("1","@@@");
//        } else {
//            Log.d("3","@@@@");
        Log.d("1","@@@@");
            if (moviePagedList != null) {
                MoviePagedAdapter moviePagedAdapter = (MoviePagedAdapter) recyclerView.getAdapter();
                moviePagedAdapter.submitList(moviePagedList);
                Log.d("2","@@@@");
            }
//        }
    }*/

}
