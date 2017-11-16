package app.mvp.com.presenterinstance.mvvm.features.pokemonSearch.usecase;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;

/**
 * Created by andreas on 15/11/17.
 */

public class HasSearchResults {

    private final Subject<Boolean> resultsPresent = BehaviorSubject.createDefault(false);

    Observable<Boolean> hasSearchResults() {
        return resultsPresent;
    }

    Completable setSearchResultsAsDownloaded() {
        return Completable.fromAction(() -> resultsPresent.onNext(true));
    }

}
