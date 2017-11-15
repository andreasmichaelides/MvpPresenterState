package app.mvp.com.presenterinstance.mvvm.features.pokemonSearch.usecase;

import app.mvp.com.presenterinstance.mvvm.repository.PokemonRepository;
import app.mvp.com.presenterinstance.mvvm.services.pokemon.model.PokemonResponse;
import io.reactivex.Observable;

/**
 * Created by andreas on 15/11/17.
 */

public class SearchPokemon {

    private final PokemonRepository pokemonRepository;

    public SearchPokemon(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public Observable<PokemonResponse> search(String pokemonName) {
        return pokemonRepository.searchPokemon(pokemonName);
    }
}
