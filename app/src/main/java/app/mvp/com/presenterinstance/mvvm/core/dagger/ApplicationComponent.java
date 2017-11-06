package app.mvp.com.presenterinstance.mvvm.core.dagger;

import android.app.Application;

import javax.inject.Singleton;

import app.mvp.com.presenterinstance.mvvm.core.BaseApplication;
import dagger.BindsInstance;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by andreas on 28/10/17.
 */

@Singleton
@dagger.Component(modules = {AndroidSupportInjectionModule.class,
        ApplicationModule.class})
public interface ApplicationComponent extends AndroidInjector<BaseApplication>, Component<BaseApplication> {

    @dagger.Component.Builder
    abstract class Builder {
        @BindsInstance
        public abstract Builder application(Application application);

        public abstract ApplicationComponent build();
    }



}
