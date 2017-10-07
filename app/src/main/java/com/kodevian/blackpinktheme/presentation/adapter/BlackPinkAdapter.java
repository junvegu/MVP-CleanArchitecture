package com.kodevian.blackpinktheme.presentation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kodevian.blackpinktheme.R;
import com.kodevian.blackpinktheme.data.BlackPinkMemberEntity;
import com.kodevian.blackpinktheme.presentation.utils.ImageLoaderHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Junior Quevedo on 06/10/17.
 */
public class BlackPinkAdapter extends RecyclerView.Adapter<BlackPinkAdapter.ViewHolder> {



    private List<BlackPinkMemberEntity> member;
    private ImageLoaderHelper imageLoaderHelper;

    /**
     *
     * @param blackpinkMembers
     */
    public BlackPinkAdapter(List<BlackPinkMemberEntity> blackpinkMembers) {
        this.member = blackpinkMembers;
        imageLoaderHelper= new ImageLoaderHelper(ImageLoaderHelper.GLIDE);

    }

    public void setItems(ArrayList<BlackPinkMemberEntity> items) {
        this.member = items;
        notifyDataSetChanged();
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        BlackPinkMemberEntity blackPinkMemberEntity =  member.get(position);

        holder.textView.setText(blackPinkMemberEntity.getFullName());
        imageLoaderHelper.getLoader().load(blackPinkMemberEntity.getPhoto(),holder.imageView);



    }

    @Override
    public int getItemCount() {
        return member.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {


        public ImageView imageView;
        public TextView textView;

        public ViewHolder(View v) {
            super(v);

            imageView =  v.findViewById(R.id.iv_image);
            textView = v.findViewById(R.id.tv_name);
        }
    }



}
