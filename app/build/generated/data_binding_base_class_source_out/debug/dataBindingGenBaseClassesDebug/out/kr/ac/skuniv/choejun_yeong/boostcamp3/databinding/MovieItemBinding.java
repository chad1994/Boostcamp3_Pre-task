package kr.ac.skuniv.choejun_yeong.boostcamp3.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import kr.ac.skuniv.choejun_yeong.boostcamp3.model.Movie;
import kr.ac.skuniv.choejun_yeong.boostcamp3.ui.main.MainEventListener;

public abstract class MovieItemBinding extends ViewDataBinding {
  @NonNull
  public final TextView movieItemActor;

  @NonNull
  public final TextView movieItemDirector;

  @NonNull
  public final ImageView movieItemImage;

  @NonNull
  public final TextView movieItemPubdate;

  @NonNull
  public final TextView movieItemTitle;

  @NonNull
  public final RatingBar movieItemUserRating;

  @Bindable
  protected Movie mMovie;

  @Bindable
  protected MainEventListener mMainListener;

  protected MovieItemBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView movieItemActor, TextView movieItemDirector,
      ImageView movieItemImage, TextView movieItemPubdate, TextView movieItemTitle,
      RatingBar movieItemUserRating) {
    super(_bindingComponent, _root, _localFieldCount);
    this.movieItemActor = movieItemActor;
    this.movieItemDirector = movieItemDirector;
    this.movieItemImage = movieItemImage;
    this.movieItemPubdate = movieItemPubdate;
    this.movieItemTitle = movieItemTitle;
    this.movieItemUserRating = movieItemUserRating;
  }

  public abstract void setMovie(@Nullable Movie movie);

  @Nullable
  public Movie getMovie() {
    return mMovie;
  }

  public abstract void setMainListener(@Nullable MainEventListener mainListener);

  @Nullable
  public MainEventListener getMainListener() {
    return mMainListener;
  }

  @NonNull
  public static MovieItemBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static MovieItemBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<MovieItemBinding>inflate(inflater, kr.ac.skuniv.choejun_yeong.boostcamp3.R.layout.movie_item, root, attachToRoot, component);
  }

  @NonNull
  public static MovieItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static MovieItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<MovieItemBinding>inflate(inflater, kr.ac.skuniv.choejun_yeong.boostcamp3.R.layout.movie_item, null, false, component);
  }

  public static MovieItemBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static MovieItemBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (MovieItemBinding)bind(component, view, kr.ac.skuniv.choejun_yeong.boostcamp3.R.layout.movie_item);
  }
}
