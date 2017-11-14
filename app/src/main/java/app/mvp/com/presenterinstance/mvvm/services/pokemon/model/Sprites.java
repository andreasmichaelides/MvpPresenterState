package app.mvp.com.presenterinstance.mvvm.services.pokemon.model;

import com.google.auto.value.AutoValue;
import com.google.gson.TypeAdapter;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;

@AutoValue
public abstract class Sprites{

	@SerializedName("back_shiny_female")
	public abstract Object backShinyFemale();

	@SerializedName("back_female")
	public abstract Object backFemale();

	@SerializedName("back_default")
	public abstract String backDefault();

	@SerializedName("front_shiny_female")
	public abstract Object frontShinyFemale();

	@SerializedName("front_default")
	public abstract String frontDefault();

	@SerializedName("front_female")
	public abstract Object frontFemale();

	@SerializedName("back_shiny")
	public abstract String backShiny();

	@SerializedName("front_shiny")
	public abstract String frontShiny();

	public static TypeAdapter<Sprites> typeAdapter(Gson gson) {
		return new AutoValue_Sprites.GsonTypeAdapter(gson);
	}
}