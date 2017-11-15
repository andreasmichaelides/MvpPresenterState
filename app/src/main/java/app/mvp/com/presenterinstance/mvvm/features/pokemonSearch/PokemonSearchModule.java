package app.mvp.com.presenterinstance.mvvm.features.pokemonSearch;

import app.mvp.com.presenterinstance.mvvm.core.dagger.ActivityScope;
import app.mvp.com.presenterinstance.mvvm.features.pokemonSearch.usecase.SearchPokemon;
import app.mvp.com.presenterinstance.mvvm.repository.PokemonRepository;
import app.mvp.com.presenterinstance.mvvm.repository.PokemonRepositoryImpl;
import app.mvp.com.presenterinstance.mvvm.services.SchedulersFacade;
import app.mvp.com.presenterinstance.mvvm.services.pokemon.PokemonApi;
import app.mvp.com.presenterinstance.mvvm.services.pokemon.PokemonModule;
import dagger.Module;
import dagger.Provides;

/**
 * Created by andreas on 15/11/17.
 */

@Module(includes = PokemonModule.class)
public class PokemonSearchModule {

    @Provides
    @ActivityScope
    static PokemonSearchViewModelFactory providePokemonSearchViewModelFactory(SearchPokemon searchPokemon) {
        return new PokemonSearchViewModelFactory(searchPokemon);
    }

    @Provides
    @ActivityScope
    static SchedulersFacade provideSchedulersFacade() {
        return new SchedulersFacade();
    }

    @Provides
    @ActivityScope
    static PokemonRepository providePokemonRepository(PokemonApi pokemonApi, SchedulersFacade schedulersFacade) {
        return new PokemonRepositoryImpl(pokemonApi, schedulersFacade);
    }

    @Provides
    @ActivityScope
    static SearchPokemon provideSearchPokemon(PokemonRepository pokemonRepository) {
        return new SearchPokemon(pokemonRepository);
    }
}
