package com.kodevian.blackpinktheme.presentation.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.kodevian.blackpinktheme.R;
import com.kodevian.blackpinktheme.base.BaseActivity;
import com.kodevian.blackpinktheme.data.entities.KoreanGirlEntity;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by junior on 7/03/17.
 */

public class KoreanDetailActivity extends BaseActivity {

    public static final String EXTRA_KOREAN = "KOREAN";
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.iv_image)
    ImageView ivImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_koreans_detail);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDefaultDisplayHomeAsUpEnabled(true);
        ab.setDisplayHomeAsUpEnabled(true);

        KoreanGirlEntity koreanGirlEntity = (KoreanGirlEntity) getIntent().getSerializableExtra(EXTRA_KOREAN);
        ab.setTitle(koreanGirlEntity.getFullName());

        Glide.with(this).load(koreanGirlEntity.getImage()).into(ivImage);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
