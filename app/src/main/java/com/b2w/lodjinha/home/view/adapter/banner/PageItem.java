package com.b2w.lodjinha.home.view.adapter.banner;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.b2w.lodjinha.R;
import com.b2w.lodjinha.rest.model.Banner;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.slidingimages_layout)
public class PageItem extends FrameLayout {

    @ViewById(R.id.imgBanner)
    protected ImageView imgBanner;

    @ViewById(R.id.progressBar)
    protected ProgressBar pbLoading;

    public PageItem(@NonNull Context context) {
        super(context);
    }

    public PageItem(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PageItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public PageItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void bind(Banner banner) {
        pbLoading.setVisibility(View.VISIBLE);
        imgBanner.setVisibility(View.GONE);

        Picasso.get()
                .load(banner.getUrlImagem())
                .into(imgBanner, new Callback() {
                    @Override
                    public void onSuccess() {
                        pbLoading.setVisibility(View.GONE);
                        imgBanner.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onError(Exception e) {
                        e.printStackTrace();
                    }
                });
    }
}
