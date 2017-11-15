package app.mvp.com.presenterinstance.mvvm.repository;

import app.mvp.com.presenterinstance.mvvm.services.pokemon.model.PokemonResponse;
import io.reactivex.Observable;

/**
 * Created by andreas on 15/11/17.
 */

public interface PokemonRepository {

    Observable<PokemonResponse> searchPokemon(String pokemonName);

}
