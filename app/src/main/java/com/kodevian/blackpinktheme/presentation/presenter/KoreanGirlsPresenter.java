package com.kodevian.blackpinktheme.presentation.presenter;

import com.kodevian.blackpinktheme.data.entities.KoreanGirlEntity;
import com.kodevian.blackpinktheme.data.source.KoreanGirlDataSource;
import com.kodevian.blackpinktheme.data.source.KoreanGirlsRepository;
import com.kodevian.blackpinktheme.presentation.contracts.KoreanGirlContract;
import com.kodevian.blackpinktheme.presentation.utils.EspressoIdlingResource;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Junior Quevedo on 06/10/17.
 */

public class KoreanGirlsPresenter implements KoreanGirlContract.Presenter{

    private final KoreanGirlContract.View mView;
    private final KoreanGirlsRepository mKoreanGirlsRepository;
    private boolean mFirstLoad = false;


    public KoreanGirlsPresenter(KoreanGirlContract.View koreanGirlsView, KoreanGirlsRepository koreanGirlsRepository) {
        mView = checkNotNull(koreanGirlsView, "koreanGirlsView cannot be null");
        mKoreanGirlsRepository = checkNotNull(koreanGirlsRepository, "koreanGirlsRepository cannot be null!");
        mView.setPresenter(this);
    }

    @Override
    public void start() {
        loadKoreanGirls(false);
    }

    @Override
    public void loadKoreanGirls(boolean forceUpdate) {
        // Simplification for sample: a network reload will be forced on first load.
        loadKoreanGirls(forceUpdate || mFirstLoad, true);
        mFirstLoad = false;
    }

    /**
     * @param forceUpdate   Pass in true to refresh the data in the {@link KoreanGirlDataSource}
     * @param showLoadingUI Pass in true to display a loading icon in the UI
     */
    private void loadKoreanGirls(boolean forceUpdate, final boolean showLoadingUI) {
        if (showLoadingUI) {
            mView.setLoadingIndicator(true);
        }
        if (forceUpdate) {
            mKoreanGirlsRepository.refreshKoreanGirls();
        }

        // The network request might be handled in a different thread so make sure Espresso knows
        // that the app is busy until the response is handled.
        EspressoIdlingResource.increment(); // App is busy until further notice

        mKoreanGirlsRepository.getKoreanGirls(new KoreanGirlDataSource.LoadKoreanGirlsCallback() {


            @Override
            public void onKoreanGirlsLoaded(List<KoreanGirlEntity> koreanGirlEntities) {

                // This callback may be called twice, once for the cache and once for loading
                // the data from the server API, so we check before decrementing, otherwise
                // it throws "Counter has been corrupted!" exception.
                if (!EspressoIdlingResource.getIdlingResource().isIdleNow()) {
                    EspressoIdlingResource.decrement(); // Set app as idle.
                }


                // The view may not be able to handle UI updates anymore
                if (!mView.isActive()) {
                    return;
                }
                if (showLoadingUI) {
                    mView.setLoadingIndicator(false);
                }

                processKoreanGirls(koreanGirlEntities);
            }

            @Override
            public void onDataNotAvailable() {
                // The view may not be able to handle UI updates anymore
                mView.setLoadingIndicator(false);

                if (!mView.isActive()) {
                    return;
                }
                mView.showErrorMessage("Error");
            }
        });
    }

    private void processKoreanGirls(List<KoreanGirlEntity> koreanGirlEntities) {
        if (koreanGirlEntities.isEmpty()) {
            mView.showNoKoreanGirls();
        } else {
            // Show the list of korean girls
            mView.getKoreanGirls(koreanGirlEntities);
        }
    }



    @Override
    public void openKoreanGirlDetail(KoreanGirlEntity koreanGirlEntity) {
        mView.getKoreanGirlDetail(koreanGirlEntity);
    }
}
