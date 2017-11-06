package app.mvp.com.presenterinstance.mvvm.core.dagger;


import app.mvp.com.presenterinstance.mvvm.features.lobby.LobbyActivity;
import app.mvp.com.presenterinstance.mvvm.features.lobby.LobbyModule;
import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by andreas on 28/10/17.
 */

@Module(includes = AndroidInjectionModule.class)
abstract class ApplicationModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = LobbyModule.class)
    abstract LobbyActivity lobbyActivityInjector();

}
