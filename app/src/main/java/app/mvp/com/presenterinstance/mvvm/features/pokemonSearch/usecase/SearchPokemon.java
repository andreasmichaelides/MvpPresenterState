package app.mvp.com.presenterinstance.mvvm.features.pokemonSearch.usecase;

import app.mvp.com.presenterinstance.mvvm.repository.PokemonRepository;
import app.mvp.com.presenterinstance.mvvm.services.pokemon.model.PokemonResponse;
import io.reactivex.Observable;

/**
 * Created by andreas on 15/11/17.
 */

public class SearchPokemon {

    private final PokemonRepository pokemonRepository;
    private final HasSearchResults hasSearchResults;

    public SearchPokemon(PokemonRepository pokemonRepository, HasSearchResults hasSearchResults) {
        this.pokemonRepository = pokemonRepository;
        this.hasSearchResults = hasSearchResults;
    }

    public Observable<PokemonResponse> search(String pokemonName) {
        return hasSearchResults.setSearchResultsAsDownloaded()
                .andThen(pokemonRepository.searchPokemon(pokemonName));
    }
}
