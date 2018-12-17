package kr.ac.skuniv.choejun_yeong.boostcamp3.databinding;
import kr.ac.skuniv.choejun_yeong.boostcamp3.R;
import kr.ac.skuniv.choejun_yeong.boostcamp3.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class MovieItemBindingImpl extends MovieItemBinding implements kr.ac.skuniv.choejun_yeong.boostcamp3.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public MovieItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private MovieItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[5]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[2]
            , (android.widget.RatingBar) bindings[3]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.movieItemActor.setTag(null);
        this.movieItemDirector.setTag(null);
        this.movieItemImage.setTag(null);
        this.movieItemPubdate.setTag(null);
        this.movieItemTitle.setTag(null);
        this.movieItemUserRating.setTag(null);
        setRootTag(root);
        // listeners
        mCallback2 = new kr.ac.skuniv.choejun_yeong.boostcamp3.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.mainListener == variableId) {
            setMainListener((kr.ac.skuniv.choejun_yeong.boostcamp3.ui.main.MainEventListener) variable);
        }
        else if (BR.movie == variableId) {
            setMovie((kr.ac.skuniv.choejun_yeong.boostcamp3.model.Movie) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setMainListener(@Nullable kr.ac.skuniv.choejun_yeong.boostcamp3.ui.main.MainEventListener MainListener) {
        this.mMainListener = MainListener;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.mainListener);
        super.requestRebind();
    }
    public void setMovie(@Nullable kr.ac.skuniv.choejun_yeong.boostcamp3.model.Movie Movie) {
        this.mMovie = Movie;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.movie);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String movieDirector = null;
        float floatParseFloatMovieUserRatingFloat20f = 0f;
        kr.ac.skuniv.choejun_yeong.boostcamp3.ui.main.MainEventListener mainListener = mMainListener;
        float floatParseFloatMovieUserRating = 0f;
        kr.ac.skuniv.choejun_yeong.boostcamp3.model.Movie movie = mMovie;
        java.lang.String movieImage = null;
        java.lang.String movieTitle = null;
        java.lang.String moviePubDate = null;
        java.lang.String movieUserRating = null;
        java.lang.String movieActor = null;

        if ((dirtyFlags & 0x6L) != 0) {



                if (movie != null) {
                    // read movie.director
                    movieDirector = movie.getDirector();
                    // read movie.image
                    movieImage = movie.getImage();
                    // read movie.title
                    movieTitle = movie.getTitle();
                    // read movie.pubDate
                    moviePubDate = movie.getPubDate();
                    // read movie.userRating
                    movieUserRating = movie.getUserRating();
                    // read movie.actor
                    movieActor = movie.getActor();
                }


                // read Float.parseFloat(movie.userRating)
                floatParseFloatMovieUserRating = java.lang.Float.parseFloat(movieUserRating);


                // read (Float.parseFloat(movie.userRating)) / (2.0f)
                floatParseFloatMovieUserRatingFloat20f = (floatParseFloatMovieUserRating) / (2.0f);
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.mboundView0.setOnClickListener(mCallback2);
        }
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.movieItemActor, movieActor);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.movieItemDirector, movieDirector);
            kr.ac.skuniv.choejun_yeong.boostcamp3.adapter.CustomBindings.bindImageUrl(this.movieItemImage, movieImage);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.movieItemPubdate, moviePubDate);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.movieItemTitle, movieTitle);
            androidx.databinding.adapters.RatingBarBindingAdapter.setRating(this.movieItemUserRating, floatParseFloatMovieUserRatingFloat20f);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // movie
        kr.ac.skuniv.choejun_yeong.boostcamp3.model.Movie movie = mMovie;
        // movie.link
        java.lang.String movieLink = null;
        // mainListener
        kr.ac.skuniv.choejun_yeong.boostcamp3.ui.main.MainEventListener mainListener = mMainListener;
        // mainListener != null
        boolean mainListenerJavaLangObjectNull = false;
        // movie != null
        boolean movieJavaLangObjectNull = false;



        mainListenerJavaLangObjectNull = (mainListener) != (null);
        if (mainListenerJavaLangObjectNull) {



            movieJavaLangObjectNull = (movie) != (null);
            if (movieJavaLangObjectNull) {


                movieLink = movie.getLink();

                mainListener.onItemClick(movieLink);
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): mainListener
        flag 1 (0x2L): movie
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}