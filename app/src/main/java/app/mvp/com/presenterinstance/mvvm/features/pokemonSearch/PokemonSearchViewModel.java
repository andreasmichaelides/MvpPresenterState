package app.mvp.com.presenterinstance.mvvm.features.pokemonSearch;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import app.mvp.com.presenterinstance.mvvm.features.pokemonSearch.usecase.SearchPokemon;
import app.mvp.com.presenterinstance.mvvm.services.pokemon.model.PokemonResponse;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * Created by andreas on 15/11/17.
 */

class PokemonSearchViewModel extends ViewModel {

    private final MutableLiveData<PokemonResponse> pokemonSearchResult = new MutableLiveData<>();
    private final MutableLiveData<Throwable> pokemonSearchError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private final Subject<String> searchForPokemon = PublishSubject.create();
    private final CompositeDisposable disposables = new CompositeDisposable();

    PokemonSearchViewModel(SearchPokemon searchPokemon) {

        disposables.addAll(
                searchForPokemon.switchMap(pokemonQuery -> searchPokemon.search(pokemonQuery)
                        .doOnSubscribe(disposable -> loading.setValue(true))
                        .doOnError(throwable -> pokemonSearchError.setValue(throwable))
                        .doOnError(throwable -> loading.setValue(false))
                        .onErrorResumeNext(Observable.empty()))
                        .subscribe(pokemonResponse -> {
                            pokemonSearchResult.setValue(pokemonResponse);
                            loading.setValue(false);
                        })
        );
    }

    void searchPokemon(String pokemonName) {
        searchForPokemon.onNext(pokemonName);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.clear();
    }

    MutableLiveData<PokemonResponse> searchResult() {
        return pokemonSearchResult;
    }

    MutableLiveData<Throwable> searchError() {
        return pokemonSearchError;
    }

    MutableLiveData<Boolean> isLoading() {
        return loading;
    }
}
