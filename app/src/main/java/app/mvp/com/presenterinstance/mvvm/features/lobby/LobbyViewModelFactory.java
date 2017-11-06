package app.mvp.com.presenterinstance.mvvm.features.lobby;

/**
 * Created by andreas on 28/10/17.
 */

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import app.mvp.com.presenterinstance.mvvm.services.LoadCommonGreetingUseCase;
import app.mvp.com.presenterinstance.mvvm.services.LoadLobbyGreetingUseCase;
import app.mvp.com.presenterinstance.mvvm.services.SchedulersFacade;


public class LobbyViewModelFactory implements ViewModelProvider.Factory {

    private final LoadCommonGreetingUseCase loadCommonGreetingUseCase;

    private final LoadLobbyGreetingUseCase loadLobbyGreetingUseCase;

    private final SchedulersFacade schedulersFacade;

    LobbyViewModelFactory(LoadCommonGreetingUseCase loadCommonGreetingUseCase,
                          LoadLobbyGreetingUseCase loadLobbyGreetingUseCase,
                          SchedulersFacade schedulersFacade) {
        this.loadCommonGreetingUseCase = loadCommonGreetingUseCase;
        this.loadLobbyGreetingUseCase = loadLobbyGreetingUseCase;
        this.schedulersFacade = schedulersFacade;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(LobbyViewModel.class)) {
            return (T) new LobbyViewModel(loadCommonGreetingUseCase, loadLobbyGreetingUseCase, schedulersFacade);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}