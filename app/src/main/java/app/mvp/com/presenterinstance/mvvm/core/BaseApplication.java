package app.mvp.com.presenterinstance.mvvm.core;


import app.mvp.com.presenterinstance.mvvm.core.dagger.DaggerApplicationComponent;
import dagger.android.AndroidInjector;

/**
 * Created by andreas on 28/10/17.
 */

public class BaseApplication extends dagger.android.support.DaggerApplication {

    @Override
    protected AndroidInjector<? extends dagger.android.support.DaggerApplication> applicationInjector() {
        return DaggerApplicationComponent.builder()
                .application(this).build();
    }
}
