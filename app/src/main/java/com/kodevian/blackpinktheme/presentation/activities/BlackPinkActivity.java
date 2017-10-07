package com.kodevian.blackpinktheme.presentation.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.kodevian.blackpinktheme.R;
import com.kodevian.blackpinktheme.data.BlackPinkMemberEntity;
import com.kodevian.blackpinktheme.presentation.adapter.BlackPinkAdapter;
import com.kodevian.blackpinktheme.presentation.presenter.BlackPinkMemberPresenter;
import com.kodevian.blackpinktheme.presentation.view.BlackPinkPresenter;
import com.kodevian.blackpinktheme.presentation.view.BlackPinkView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
/**
 * Created by Junior Quevedo on 06/10/17.
 */
public class BlackPinkActivity extends AppCompatActivity implements BlackPinkView {

    private static final int NUM_COLUM = 3;


    @Bind(R.id.rv_list)
    RecyclerView rvList;



    private BlackPinkAdapter mBlackPinkAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private GridLayoutManager gridLayoutManager;
    private BlackPinkPresenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        //Initialized List UI
        mBlackPinkAdapter = new BlackPinkAdapter(new ArrayList<BlackPinkMemberEntity>());
        mLinearLayoutManager = new LinearLayoutManager(this);
        gridLayoutManager = new GridLayoutManager(this, NUM_COLUM);
        rvList.setAdapter(mBlackPinkAdapter);
        rvList.setLayoutManager(mLinearLayoutManager);


        // Create new instance of Presenter
        mPresenter = new BlackPinkMemberPresenter(getApplicationContext(), this);


    }




    //Lifecycle : Call after before execute onCreate
    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.loadData();

    }

    @Override
    public void showMembers(ArrayList<BlackPinkMemberEntity> blackPinkMemberEntities) {
        mBlackPinkAdapter.setItems(blackPinkMemberEntities);
    }

    @OnClick({R.id.bt_vertical, R.id.bt_horizontal})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_vertical:
                rvList.setLayoutManager(mLinearLayoutManager);
                break;
            case R.id.bt_horizontal:
                rvList.setLayoutManager(gridLayoutManager);
                break;
        }
    }
}
