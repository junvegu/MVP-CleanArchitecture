package com.kodevian.blackpinktheme.presentation.presenter;

import android.content.Context;

import com.kodevian.blackpinktheme.data.BlackPinkMemberEntity;
import com.kodevian.blackpinktheme.presentation.view.BlackPinkPresenter;
import com.kodevian.blackpinktheme.presentation.view.BlackPinkView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Junior Quevedo on 06/10/17.
 */

public class BlackPinkMemberPresenter  implements BlackPinkPresenter {

    private Context mContext;
    private BlackPinkView blackPinkView;


    /**
     *
     * @param mContext
     * @param blackPinkView
     */
    public BlackPinkMemberPresenter(Context mContext, BlackPinkView blackPinkView) {
        this.mContext = mContext;
        this.blackPinkView = blackPinkView;
    }

    @Override
    public void loadData() {

        List<BlackPinkMemberEntity> blackPinkMemberEntities =  BlackPinkMemberEntity.getMockData();



        blackPinkView.showMembers((ArrayList<BlackPinkMemberEntity>) blackPinkMemberEntities);
    }
}
