package com.kodevian.blackpinktheme.presentation.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.IdlingResource;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kodevian.blackpinktheme.Injection;
import com.kodevian.blackpinktheme.R;
import com.kodevian.blackpinktheme.base.BaseActivity;
import com.kodevian.blackpinktheme.base.ScrollChildSwipeRefreshLayout;
import com.kodevian.blackpinktheme.data.entities.KoreanGirlEntity;
import com.kodevian.blackpinktheme.presentation.adapter.KoreanGirlAdapter;
import com.kodevian.blackpinktheme.presentation.adapter.KoreanGirlItemListener;
import com.kodevian.blackpinktheme.presentation.contracts.KoreanGirlContract;
import com.kodevian.blackpinktheme.presentation.presenter.KoreanGirlsPresenter;
import com.kodevian.blackpinktheme.presentation.utils.EspressoIdlingResource;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Junior Quevedo on 06/10/17.
 */
public class KoreanGirlsActivity extends BaseActivity implements KoreanGirlContract.View {

    private static final int NUM_COLUM = 3;


    @Bind(R.id.rv_list)
    RecyclerView mRecycleViewKoreanGirls;
    @Bind(R.id.refresh_layout)
    ScrollChildSwipeRefreshLayout mRefreshLayout;


    private KoreanGirlAdapter mKoreanGirlsAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private GridLayoutManager gridLayoutManager;
    private KoreanGirlContract.Presenter mPresenter;

    private KoreanGirlItemListener mKoreanGirlItemListener = new KoreanGirlItemListener() {
        @Override
        public void onKoreanGirlsClick(KoreanGirlEntity koreanGirlEntity) {
            mPresenter.openKoreanGirlDetail(koreanGirlEntity);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_koreans);
        ButterKnife.bind(this);

        mPresenter = new KoreanGirlsPresenter(this,
                Injection.provideKoreanGirlRepostoryRepository(getApplicationContext()));

        //Initialized List UI
        ui();
    }

    //Lifecycle : Call after before execute onCreate
    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.start();

    }

    private void ui() {
        mKoreanGirlsAdapter = new KoreanGirlAdapter(new ArrayList<KoreanGirlEntity>(), mKoreanGirlItemListener);
        mLinearLayoutManager = new LinearLayoutManager(this);
        gridLayoutManager = new GridLayoutManager(this, NUM_COLUM);
        mRecycleViewKoreanGirls.setAdapter(mKoreanGirlsAdapter);
        mRecycleViewKoreanGirls.setLayoutManager(mLinearLayoutManager);
        mRefreshLayout.setScrollUpChild(mRecycleViewKoreanGirls);

        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.loadKoreanGirls(true);
            }
        });

    }

    @Override
    public void getKoreanGirls(List<KoreanGirlEntity> list) {
        mKoreanGirlsAdapter.setItems((ArrayList<KoreanGirlEntity>) list);
    }

    @Override
    public void getKoreanGirlDetail(KoreanGirlEntity koreanGirlEntity) {
        //showMessage("Clicked " + koreanGirlEntity.getFullName());
        Intent intent = new Intent(this,KoreanDetailActivity.class);
        intent.putExtra(KoreanDetailActivity.EXTRA_KOREAN,koreanGirlEntity);
        startActivity(intent);
    }


    @Override
    public void showNoKoreanGirls() {

    }


    @Override
    public void setPresenter(KoreanGirlContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void setLoadingIndicator(final boolean active) {

        mRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mRefreshLayout.setRefreshing(active);
            }
        });
    }

    @Override
    public void showMessage(String message) {
        showSuccessMessage(message);
    }

    @Override
    public void showErrorMessage(String message) {
        showErrorMessages(message);
    }

    @NonNull
    @Override
    public Context getContext() {
        return this;
    }


    @VisibleForTesting
    public IdlingResource getCountingIdlingResource() {
        return EspressoIdlingResource.getIdlingResource();
    }


    @Override
    public boolean isActive() {
        return true;
    }

}
