package com.kodevian.blackpinktheme.data.source;

import android.support.annotation.NonNull;

import com.kodevian.blackpinktheme.data.entities.KoreanGirlEntity;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by junior on 13/10/17.
 */

public class KoreanGirlsRepository implements KoreanGirlDataSource {

    private static KoreanGirlsRepository INSTANCE = null;

    private final KoreanGirlDataSource mKoreanGirlsRemoteDataSource;

    private final KoreanGirlDataSource mKoreanGirlsLocalDataSource;

    /**
     * This variable has package local visibility so it can be accessed from tests.
     */
    Map<String, KoreanGirlEntity> mCachedKoreanGirls;

    /**
     * Marks the cache as invalid, to force an update the next time data is requested. This variable
     * has package local visibility so it can be accessed from tests.
     */
    boolean mCacheIsDirty = false;

    // Prevent direct instantiation.
    private KoreanGirlsRepository(@NonNull KoreanGirlDataSource koreanGirlsRemoteDataSource,
                            @NonNull KoreanGirlDataSource koreanGirlsLocalDataSource) {
        mKoreanGirlsRemoteDataSource = checkNotNull(koreanGirlsRemoteDataSource);
        mKoreanGirlsLocalDataSource = checkNotNull(koreanGirlsLocalDataSource);
    }

    /**
     * Returns the single instance of this class, creating it if necessary.
     *
     * @param koreanGirlsRemoteDataSource the backend data source
     * @param koreanGirlsLocalDataSource  the device storage data source
     * @return the {@link KoreanGirlsRepository} instance
     */
    public static KoreanGirlsRepository getInstance(KoreanGirlDataSource koreanGirlsRemoteDataSource,
                                                    KoreanGirlDataSource koreanGirlsLocalDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new KoreanGirlsRepository(koreanGirlsRemoteDataSource, koreanGirlsLocalDataSource);
        }
        return INSTANCE;
    }

    /**
     * Used to force  to create a new instance
     * next time it's called.
     */
    public static void destroyInstance() {
        INSTANCE = null;
    }

    /**
     * Gets tasks from cache, local data source (SQLite) or remote data source, whichever is
     * available first.
     * <p>
     * Note: {@link LoadKoreanGirlsCallback#onDataNotAvailable()} is fired if all data sources fail to
     * get the data.
     */

    @Override
    public void getKoreanGirls(@NonNull final LoadKoreanGirlsCallback callback) {
        checkNotNull(callback);

        // Respond immediately with cache if available and not dirty
        if (mCachedKoreanGirls != null && !mCacheIsDirty) {
            callback.onKoreanGirlsLoaded(new ArrayList<>(mCachedKoreanGirls.values()));
            //return;
        }

        if (mCacheIsDirty) {
            // If the cache is dirty we need to fetch new data from the network.
            getTasksFromRemoteDataSource(callback);
        } else {
            // Query the local storage if available. If not, query the network.
            mKoreanGirlsLocalDataSource.getKoreanGirls(new LoadKoreanGirlsCallback() {

                @Override
                public void onKoreanGirlsLoaded(List<KoreanGirlEntity> koreanGirlEntities) {

                    refreshCache(koreanGirlEntities);
                    callback.onKoreanGirlsLoaded(new ArrayList<>(mCachedKoreanGirls.values()));
                }

                @Override
                public void onDataNotAvailable() {
                    getTasksFromRemoteDataSource(callback);
                }
            });
        }
    }
    private void getTasksFromRemoteDataSource(@NonNull final LoadKoreanGirlsCallback callback) {
        mKoreanGirlsRemoteDataSource.getKoreanGirls(new LoadKoreanGirlsCallback() {

            @Override
            public void onKoreanGirlsLoaded(List<KoreanGirlEntity> koreanGirlEntities) {

                refreshCache(koreanGirlEntities);
                refreshLocalDataSource(koreanGirlEntities);
                callback.onKoreanGirlsLoaded(new ArrayList<>(mCachedKoreanGirls.values()));
            }

            @Override
            public void onDataNotAvailable() {
                callback.onDataNotAvailable();
            }
        });
    }
    private void refreshCache(List<KoreanGirlEntity> koreanGirlEntities) {
        if (mCachedKoreanGirls == null) {
            mCachedKoreanGirls = new LinkedHashMap<>();
        }
        mCachedKoreanGirls.clear();
        for (KoreanGirlEntity koreanGirlEntity : koreanGirlEntities) {
            mCachedKoreanGirls.put(koreanGirlEntity.getId(), koreanGirlEntity);
        }
        mCacheIsDirty = false;
    }

    private void refreshLocalDataSource(List<KoreanGirlEntity> koreanGirlEntities) {
        mKoreanGirlsLocalDataSource.deleteAllKoreanGirls();
        for (KoreanGirlEntity koreanGirlEntity : koreanGirlEntities) {
            mKoreanGirlsLocalDataSource.saveKoreanGirl(koreanGirlEntity);
        }
    }

    @Override
    public void saveKoreanGirl(@NonNull KoreanGirlEntity koreanGirlEntity) {

    }

    @Override
    public void refreshKoreanGirls() {
        mCacheIsDirty = true;
    }

    @Override
    public void deleteAllKoreanGirls() {
        mKoreanGirlsRemoteDataSource.deleteAllKoreanGirls();
        mKoreanGirlsLocalDataSource.deleteAllKoreanGirls();

        if (mCachedKoreanGirls == null) {
            mCachedKoreanGirls = new LinkedHashMap<>();
        }
        mCachedKoreanGirls.clear();
    }
}
