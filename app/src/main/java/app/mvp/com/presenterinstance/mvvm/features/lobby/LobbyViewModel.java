package app.mvp.com.presenterinstance.mvvm.features.lobby;

/**
 * Created by andreas on 28/10/17.
 */

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import app.mvp.com.presenterinstance.mvvm.model.Response;
import app.mvp.com.presenterinstance.mvvm.services.LoadCommonGreetingUseCase;
import app.mvp.com.presenterinstance.mvvm.services.LoadLobbyGreetingUseCase;
import app.mvp.com.presenterinstance.mvvm.services.SchedulersFacade;
import app.mvp.com.presenterinstance.mvvm.services.pokemon.PokemonApi;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

public class LobbyViewModel extends ViewModel {

    private final MutableLiveData<Response<String>> response = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loadingStatus = new MutableLiveData<>();

    private final Subject<Object> greetingClick = PublishSubject.create();
    private final Subject<Object> commonClick = PublishSubject.create();
    private final Subject<ButtonSelection> buttonSelection = PublishSubject.create();
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final PokemonApi pokemonApi;

    LobbyViewModel(LoadCommonGreetingUseCase loadCommonGreetingUseCase,
                   LoadLobbyGreetingUseCase loadLobbyGreetingUseCase,
                   SchedulersFacade schedulersFacade, PokemonApi pokemonApi) {
        this.pokemonApi = pokemonApi;

        Observable<ButtonSelection> stateRestored = buttonSelection.flatMap(selection -> Observable.just(response.getValue() == null)
                .filter(isNull -> isNull)
                .map(ignored -> selection));

        disposables.addAll(
                // Services change live data and then live data emit on view
                commonClick.flatMapSingle(ignored -> loadCommonGreetingUseCase.execute()
                        .subscribeOn(schedulersFacade.io())
                        .observeOn(schedulersFacade.ui())
                        .doOnSubscribe(s -> loadingStatus.setValue(true))
                        .doAfterTerminate(() -> loadingStatus.setValue(false)))
                        .subscribe(
                                greeting -> response.setValue(Response.success(greeting)),
                                throwable -> response.setValue(Response.error(throwable))
                        ),

                greetingClick.flatMap(ignored -> loadLobbyGreetingUseCase.execute()
                        .flatMapObservable(someText -> pokemonApi.getPokemon("bulbasaur"))
                        .subscribeOn(schedulersFacade.io())
                        .observeOn(schedulersFacade.ui())
                        .doOnError(throwable -> {
                            response.setValue(Response.error(throwable));
                            throwable.printStackTrace();
                        })
                        .onErrorResumeNext(Observable.empty())
                        .map(pokemonResponse -> pokemonResponse.name())
                        .doOnSubscribe(s -> loadingStatus.setValue(true))
                        .doAfterTerminate(() -> loadingStatus.setValue(false)))
                        .subscribe(
                                greeting -> response.setValue(Response.success(greeting)),
                                throwable -> {
                                    response.setValue(Response.error(throwable));
                                    throwable.printStackTrace();
                                }
                        ),
                stateRestored
                        .filter(selection ->  selection == ButtonSelection.COMMON)
                        .doOnNext(buttonSelection1 -> Log.d("Restored", buttonSelection1.toString()))
                        .subscribe(restoredSelection -> commonClick.onNext(true)),
                stateRestored
                        .filter(selection ->  selection == ButtonSelection.GREETING)
                        .doOnNext(buttonSelection1 -> Log.d("Restored", buttonSelection1.toString()))
                        .subscribe(restoredSelection -> greetingClick.onNext(true))
        );
    }


    // OnViewDetached
    @Override
    protected void onCleared() {
        disposables.clear();
    }

    // Presenter methods that the view calls
    void loadCommonGreeting() {
        commonClick.onNext(new Object());
    }

    void loadLobbyGreeting() {
        greetingClick.onNext(new Object());
    }

    void restoreState(@NonNull ButtonSelection buttonSelection) {
        this.buttonSelection.onNext(buttonSelection);
    }

    // View observes for live data changes
    MutableLiveData<Response<String>> getResponse() {
        return response;
    }

    MutableLiveData<Boolean> getLoadingStatus() {
        return loadingStatus;
    }
}