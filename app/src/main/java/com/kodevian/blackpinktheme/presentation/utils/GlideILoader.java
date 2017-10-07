package com.kodevian.blackpinktheme.presentation.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;

/**
 * Created by Junior Quevedo on 06/10/17.
 */
public class GlideILoader implements ImageLoader{

    @Override
    public void load(String url, ImageView imageView)
    {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

    @Override
    public void loadLocal(String path, ImageView imageView) {
        Glide.with(imageView.getContext()).load(new File(path)).into(imageView);
    }
}
