package com.kodevian.blackpinktheme.data.source;

import android.support.annotation.NonNull;

import com.kodevian.blackpinktheme.data.entities.KoreanGirlEntity;

import java.util.List;

/**
 * Created by junior on 13/10/17.
 */

public interface KoreanGirlDataSource {



    interface LoadKoreanGirlsCallback {

        void onKoreanGirlsLoaded(List<KoreanGirlEntity> koreanGirlEntities);

        void onDataNotAvailable();
    }

    interface GetKoreanGirlsCallback {

        void onKoreanGirlsLoaded(KoreanGirlEntity koreanGirlEntity);

        void onDataNotAvailable();
    }



    void getKoreanGirls(@NonNull LoadKoreanGirlsCallback callback);

    void saveKoreanGirl(@NonNull KoreanGirlEntity koreanGirlEntity);

    void refreshKoreanGirls();

    void deleteAllKoreanGirls();

}
