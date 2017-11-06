package app.mvp.com.presenterinstance.mvvm.services;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by andreas on 28/10/17.
 */

public class LoadLobbyGreetingUseCase {
    private final LobbyGreetingRepository greetingRepository;

    @Inject
    public LoadLobbyGreetingUseCase(LobbyGreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public Single<String> execute() {
        return greetingRepository.getGreeting();
    }
}
