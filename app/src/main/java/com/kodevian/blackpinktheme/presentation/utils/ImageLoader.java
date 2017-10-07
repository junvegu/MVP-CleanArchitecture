package com.kodevian.blackpinktheme.presentation.utils;

import android.widget.ImageView;


/**
 * Created by Junior Quevedo on 06/10/17.
 */
public interface ImageLoader {

    void load(String url, ImageView imageView);
    void loadLocal(String path, ImageView imageView);
}
