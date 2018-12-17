package kr.ac.skuniv.choejun_yeong.boostcamp3.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import kr.ac.skuniv.choejun_yeong.boostcamp3.ui.main.MainViewModel;

public abstract class ActivityMainBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView mainRv;

  @NonNull
  public final Button mainSearchBtn;

  @NonNull
  public final EditText mainSearchEdittext;

  @Bindable
  protected MainViewModel mVm;

  protected ActivityMainBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RecyclerView mainRv, Button mainSearchBtn,
      EditText mainSearchEdittext) {
    super(_bindingComponent, _root, _localFieldCount);
    this.mainRv = mainRv;
    this.mainSearchBtn = mainSearchBtn;
    this.mainSearchEdittext = mainSearchEdittext;
  }

  public abstract void setVm(@Nullable MainViewModel vm);

  @Nullable
  public MainViewModel getVm() {
    return mVm;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityMainBinding>inflate(inflater, kr.ac.skuniv.choejun_yeong.boostcamp3.R.layout.activity_main, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityMainBinding>inflate(inflater, kr.ac.skuniv.choejun_yeong.boostcamp3.R.layout.activity_main, null, false, component);
  }

  public static ActivityMainBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityMainBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityMainBinding)bind(component, view, kr.ac.skuniv.choejun_yeong.boostcamp3.R.layout.activity_main);
  }
}
