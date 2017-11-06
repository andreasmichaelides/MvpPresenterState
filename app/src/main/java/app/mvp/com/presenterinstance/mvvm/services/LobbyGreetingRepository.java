package app.mvp.com.presenterinstance.mvvm.services;

import io.reactivex.Single;

/**
 * Created by andreas on 28/10/17.
 */

public class LobbyGreetingRepository {
    Single<String> getGreeting() {
        return Single.just("Hello from LobbyGreetingRepository");
    }
}
