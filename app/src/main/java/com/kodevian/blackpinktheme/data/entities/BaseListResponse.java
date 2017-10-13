package com.kodevian.blackpinktheme.data.entities;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

/**
 * Created by junior on 13/10/17.
 */

public class BaseListResponse<T> {

    @Nullable
    private String next_page_url;
    @Nullable
    private String prev_page_url;
    @NonNull
    private List<T> data;


    @Nullable
    public String getNext_page_url() {
        return next_page_url;
    }


    @Nullable
    public String getPrev_page_url() {
        return prev_page_url;
    }


    @NonNull
    public List<T> getData() {
        return data;
    }

}
