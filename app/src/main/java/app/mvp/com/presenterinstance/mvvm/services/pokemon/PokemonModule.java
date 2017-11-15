package app.mvp.com.presenterinstance.mvvm.services.pokemon;

import app.mvp.com.presenterinstance.mvvm.core.dagger.ActivityScope;
import dagger.Module;
import dagger.Provides;

/**
 * Created by andreas on 15/11/17.
 */

@Module
public class PokemonModule {

    @Provides
    @ActivityScope
    static PokemonService providePokemonService() {
        return new PokemonService();
    }

    @Provides
    @ActivityScope
    static PokemonApi providePokemonApi(PokemonService pokemonService) {
        return pokemonService.createService(PokemonApi.class);
    }
}
