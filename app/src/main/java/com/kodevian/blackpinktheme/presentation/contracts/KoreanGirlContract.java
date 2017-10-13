package com.kodevian.blackpinktheme.presentation.contracts;

import com.kodevian.blackpinktheme.base.BasePresenter;
import com.kodevian.blackpinktheme.base.BaseView;
import com.kodevian.blackpinktheme.data.entities.KoreanGirlEntity;

import java.util.List;

/**
 * Created by junior on 13/10/17.
 */

public interface KoreanGirlContract {

    interface View extends BaseView<Presenter> {

        void getKoreanGirls(List<KoreanGirlEntity> list);

        void getKoreanGirlDetail(KoreanGirlEntity koreanGirlEntity);

        boolean isActive();

        void showNoKoreanGirls();


    }

    interface Presenter extends BasePresenter {

        void loadKoreanGirls(boolean forceUpdate);

        
        void openKoreanGirlDetail(KoreanGirlEntity koreanGirlEntity);
    }
}
