package app.mvp.com.presenterinstance;

import android.os.Bundle;

import io.reactivex.Observable;

/**
 * Created by westplay on 13/08/17.
 */

interface PeristanceService {

    void saveState(DataProvider dataProvider);

    void restoreState();

    Observable<Bundle> subscribeGetData();
}
