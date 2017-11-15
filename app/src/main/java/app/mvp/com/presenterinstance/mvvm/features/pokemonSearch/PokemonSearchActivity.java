package app.mvp.com.presenterinstance.mvvm.features.pokemonSearch;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

import app.mvp.com.presenterinstance.R;
import app.mvp.com.presenterinstance.mvvm.services.pokemon.model.PokemonResponse;
import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

/**
 * Created by andreas on 15/11/17.
 */

public class PokemonSearchActivity extends DaggerAppCompatActivity {

    @Inject
    PokemonSearchViewModelFactory viewModelFactory;

    @BindView(R.id.pokemonSearchSearchView)
    SearchView pokemonSearchSearchView;
    @BindView(R.id.pokemonSearchProgressBar)
    ProgressBar pokemonSearchProgressBar;
    @BindView(R.id.pokemonSearchImageView)
    ImageView pokemonSearchImageView;
    @BindView(R.id.pokemonSearchName)
    TextView pokemonSearchName;

    private PokemonSearchViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pokemon_activity);
        ButterKnife.bind(this);

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PokemonSearchViewModel.class);

        pokemonSearchSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                viewModel.searchPokemon(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        viewModel.searchResult()
                .observe(this, pokemonResponse -> setPokemonData(pokemonResponse));
        viewModel.searchError()
                .observe(this, throwable -> Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show());
        viewModel.isLoading()
                .observe(this, isLoading -> pokemonSearchProgressBar.setVisibility(isLoading ? VISIBLE : INVISIBLE));
    }

    private void setPokemonData(PokemonResponse pokemonResponse) {
        pokemonSearchName.setText(pokemonResponse.name());
        Glide.with(this)
                .load(pokemonResponse.sprites().frontDefault())
                .into(pokemonSearchImageView);
    }

}
