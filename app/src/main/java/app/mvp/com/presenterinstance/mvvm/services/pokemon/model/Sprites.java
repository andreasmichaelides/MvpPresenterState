package app.mvp.com.presenterinstance.mvvm.services.pokemon.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Nullable;

@AutoValue
public abstract class Sprites{

    @Nullable
	@SerializedName("back_shiny_female")
	public abstract Object backShinyFemale();

    @Nullable
	@SerializedName("back_female")
	public abstract Object backFemale();

    @Nullable
	@SerializedName("back_default")
	public abstract String backDefault();

    @Nullable
	@SerializedName("front_shiny_female")
	public abstract Object frontShinyFemale();

    @Nullable
	@SerializedName("front_default")
	public abstract String frontDefault();

    @Nullable
	@SerializedName("front_female")
	public abstract Object frontFemale();

    @Nullable
	@SerializedName("back_shiny")
	public abstract String backShiny();

    @Nullable
	@SerializedName("front_shiny")
	public abstract String frontShiny();

	public static TypeAdapter<Sprites> typeAdapter(Gson gson) {
		return new AutoValue_Sprites.GsonTypeAdapter(gson);
	}
}