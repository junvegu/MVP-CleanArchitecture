package com.kodevian.blackpinktheme.presentation.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.kodevian.blackpinktheme.R;
import com.kodevian.blackpinktheme.data.entities.KoreanGirlEntity;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Junior Quevedo on 06/10/17.
 */
public class KoreanGirlAdapter extends RecyclerView.Adapter<KoreanGirlAdapter.ViewHolder> {



    private List<KoreanGirlEntity> member;
    private KoreanGirlItemListener mKoreanGirlItemListener;


    /**
     *
     * @param blackpinkMembers
     * @param koreanGirlItemListener
     */
    public KoreanGirlAdapter(List<KoreanGirlEntity> blackpinkMembers,KoreanGirlItemListener koreanGirlItemListener ) {
        this.member = blackpinkMembers;
        mKoreanGirlItemListener = koreanGirlItemListener;

    }

    public void setItems(ArrayList<KoreanGirlEntity> items) {
        this.member = checkNotNull(items);
        notifyDataSetChanged();
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final KoreanGirlEntity koreanGirlEntity =  member.get(position);

        holder.textView.setText(koreanGirlEntity.getFullName());

        holder.ageTextView.setText(koreanGirlEntity.getAge());

        Glide.with(holder.imageView.getContext())
                .load(koreanGirlEntity.getImage())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.imageView);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mKoreanGirlItemListener.onKoreanGirlsClick(koreanGirlEntity);
            }
        });


    }

    @Override
    public int getItemCount() {
        return member.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {


        public ImageView imageView;
        public TextView textView;
        public TextView ageTextView;

        public ViewHolder(@NonNull View v) {
            super(v);


            imageView =  v.findViewById(R.id.iv_image);
            textView = v.findViewById(R.id.tv_name);
            ageTextView = v.findViewById(R.id.tv_age);
        }
    }



}
