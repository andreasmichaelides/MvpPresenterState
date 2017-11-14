package app.mvp.com.presenterinstance.mvvm.services.pokemon.model;

import java.util.List;
import com.google.auto.value.AutoValue;
import com.google.gson.TypeAdapter;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;

@AutoValue
public abstract class PokemonResponse{

	@SerializedName("location_area_encounters")
	public abstract String locationAreaEncounters();

	@SerializedName("types")
	public abstract List<TypesItem> types();

	@SerializedName("base_experience")
	public abstract int baseExperience();

	@SerializedName("held_items")
	public abstract List<Object> heldItems();

	@SerializedName("weight")
	public abstract int weight();

	@SerializedName("is_default")
	public abstract boolean isDefault();

	@SerializedName("sprites")
	public abstract Sprites sprites();

	@SerializedName("abilities")
	public abstract List<AbilitiesItem> abilities();

	@SerializedName("game_indices")
	public abstract List<GameIndicesItem> gameIndices();

	@SerializedName("stats")
	public abstract List<StatsItem> stats();

	@SerializedName("species")
	public abstract Species species();

	@SerializedName("moves")
	public abstract List<MovesItem> moves();

	@SerializedName("name")
	public abstract String name();

	@SerializedName("id")
	public abstract int id();

	@SerializedName("forms")
	public abstract List<FormsItem> forms();

	@SerializedName("height")
	public abstract int height();

	@SerializedName("order")
	public abstract int order();

	public static TypeAdapter<PokemonResponse> typeAdapter(Gson gson) {
		return new AutoValue_PokemonResponse.GsonTypeAdapter(gson);
	}
}