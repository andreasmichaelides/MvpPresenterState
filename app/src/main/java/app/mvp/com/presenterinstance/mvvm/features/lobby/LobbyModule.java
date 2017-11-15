package app.mvp.com.presenterinstance.mvvm.features.lobby;


import app.mvp.com.presenterinstance.mvvm.core.dagger.ActivityScope;
import app.mvp.com.presenterinstance.mvvm.services.CommonGreetingRepository;
import app.mvp.com.presenterinstance.mvvm.services.LoadCommonGreetingUseCase;
import app.mvp.com.presenterinstance.mvvm.services.LoadLobbyGreetingUseCase;
import app.mvp.com.presenterinstance.mvvm.services.LobbyGreetingRepository;
import app.mvp.com.presenterinstance.mvvm.services.SchedulersFacade;
import app.mvp.com.presenterinstance.mvvm.services.pokemon.PokemonApi;
import app.mvp.com.presenterinstance.mvvm.services.pokemon.PokemonModule;
import dagger.Module;
import dagger.Provides;

/**
 * Created by andreas on 28/10/17.
 */

@Module(includes = PokemonModule.class)
public class LobbyModule {

    @Provides
    @ActivityScope
    static CommonGreetingRepository provideCommonGreetingRepository() {
        return new CommonGreetingRepository();
    }

    @Provides
    @ActivityScope
    static LobbyGreetingRepository provideLobbyGreetingRepository() {
        return new LobbyGreetingRepository();
    }

    @Provides
    @ActivityScope
    static LoadCommonGreetingUseCase provideLoadCommonGreetingUseCase(CommonGreetingRepository commonGreetingRepository) {
        return new LoadCommonGreetingUseCase(commonGreetingRepository);
    }

    @Provides
    @ActivityScope
    static LoadLobbyGreetingUseCase provideLoadLobbyGreetingUseCase(LobbyGreetingRepository lobbyGreetingRepository) {
        return new LoadLobbyGreetingUseCase(lobbyGreetingRepository);
    }

    @Provides
    @ActivityScope
    static SchedulersFacade provideSchedulersFacade() {
        return new SchedulersFacade();
    }

    @Provides
    @ActivityScope
    static LobbyViewModelFactory provideLobbyViewModelFactory(LoadCommonGreetingUseCase loadCommonGreetingUseCase,
                                                              LoadLobbyGreetingUseCase loadLobbyGreetingUseCase,
                                                              SchedulersFacade schedulersFacade,
                                                              PokemonApi pokemonApi) {
        return new LobbyViewModelFactory(loadCommonGreetingUseCase, loadLobbyGreetingUseCase, schedulersFacade, pokemonApi);
    }
}
