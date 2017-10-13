package com.kodevian.blackpinktheme.data.source.remote;

import android.content.Context;
import android.support.annotation.NonNull;

import com.kodevian.blackpinktheme.data.entities.BaseListResponse;
import com.kodevian.blackpinktheme.data.entities.KoreanGirlEntity;
import com.kodevian.blackpinktheme.data.source.KoreanGirlDataSource;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by junior on 13/10/17.
 */

public class KoreanGirlsRemoteDataSource  implements KoreanGirlDataSource{


    private static KoreanGirlsRemoteDataSource INSTANCE;
    private Context mContext;



    public static KoreanGirlsRemoteDataSource getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new KoreanGirlsRemoteDataSource(context);
        }
        return INSTANCE;
    }

    // Prevent direct instantiation.
    private KoreanGirlsRemoteDataSource(Context context) {
        this.mContext = context;

    }


    // Prevent direct instantiation.
    private KoreanGirlsRemoteDataSource() {}



    @Override
    public void getKoreanGirls(@NonNull final LoadKoreanGirlsCallback callback) {
        KoreanGirlsRequest babiesRequest = ServiceGenerator.createService(KoreanGirlsRequest.class);
        Call<BaseListResponse<KoreanGirlEntity>> call = babiesRequest.getBabies();
        call.enqueue(new Callback<BaseListResponse<KoreanGirlEntity>>() {
            @Override
            public void onResponse(Call<BaseListResponse<KoreanGirlEntity>> call, Response<BaseListResponse<KoreanGirlEntity>> response) {

                if (response.isSuccessful()) {
                    callback.onKoreanGirlsLoaded(response.body().getData());
                } else {
                    callback.onDataNotAvailable();
                }
            }

            @Override
            public void onFailure(Call<BaseListResponse<KoreanGirlEntity>> call, Throwable t) {

                callback.onDataNotAvailable();
            }
        });
    }

    @Override
    public void saveKoreanGirl(@NonNull KoreanGirlEntity koreanGirlEntity) {

    }

    @Override
    public void refreshKoreanGirls() {

    }

    @Override
    public void deleteAllKoreanGirls() {

    }
}
