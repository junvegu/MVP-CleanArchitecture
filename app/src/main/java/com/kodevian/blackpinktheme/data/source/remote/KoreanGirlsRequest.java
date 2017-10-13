package com.kodevian.blackpinktheme.data.source.remote;

import com.kodevian.blackpinktheme.data.entities.BaseListResponse;
import com.kodevian.blackpinktheme.data.entities.KoreanGirlEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by junior on 13/10/17.
 */

public interface KoreanGirlsRequest {


    @GET(ApiConstants.KOREANS)
    Call<BaseListResponse<KoreanGirlEntity>> getBabies();

}
