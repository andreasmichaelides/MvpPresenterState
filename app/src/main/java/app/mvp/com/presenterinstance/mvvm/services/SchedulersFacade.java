package app.mvp.com.presenterinstance.mvvm.services;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by andreas on 28/10/17.
 */

public class SchedulersFacade {


    public Scheduler io() {
        return Schedulers.io();
    }

    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}
