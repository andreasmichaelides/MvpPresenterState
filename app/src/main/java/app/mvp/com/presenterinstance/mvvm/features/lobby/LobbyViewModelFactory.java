package app.mvp.com.presenterinstance.mvvm.features.lobby;

/**
 * Created by andreas on 28/10/17.
 */

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import app.mvp.com.presenterinstance.mvvm.services.LoadCommonGreetingUseCase;
import app.mvp.com.presenterinstance.mvvm.services.LoadLobbyGreetingUseCase;
import app.mvp.com.presenterinstance.mvvm.services.SchedulersFacade;
import app.mvp.com.presenterinstance.mvvm.services.pokemon.PokemonApi;


public class LobbyViewModelFactory implements ViewModelProvider.Factory {

    private final LoadCommonGreetingUseCase loadCommonGreetingUseCase;
    private final LoadLobbyGreetingUseCase loadLobbyGreetingUseCase;
    private final SchedulersFacade schedulersFacade;
    private final PokemonApi pokemonApi;

    LobbyViewModelFactory(LoadCommonGreetingUseCase loadCommonGreetingUseCase,
                          LoadLobbyGreetingUseCase loadLobbyGreetingUseCase,
                          SchedulersFacade schedulersFacade,
                          PokemonApi pokemonApi) {
        this.loadCommonGreetingUseCase = loadCommonGreetingUseCase;
        this.loadLobbyGreetingUseCase = loadLobbyGreetingUseCase;
        this.schedulersFacade = schedulersFacade;
        this.pokemonApi = pokemonApi;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(LobbyViewModel.class)) {
            return (T) new LobbyViewModel(loadCommonGreetingUseCase, loadLobbyGreetingUseCase, schedulersFacade, pokemonApi);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}