package com.b2w.lodjinha.home.view.adapter.banner;

import android.view.ViewGroup;

import com.b2w.lodjinha.base.adapter.BasePageAdapter;
import com.b2w.lodjinha.rest.model.Banner;

import org.androidannotations.annotations.EBean;

@EBean
public class SlidingImageAdapter extends BasePageAdapter<Banner> {

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        PageItem pageItem = PageItem_.build(mContext);

        pageItem.bind(items.get(position));

        view.addView(pageItem);

        return pageItem;
    }

}
