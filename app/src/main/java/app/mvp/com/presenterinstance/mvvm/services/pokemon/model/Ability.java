package app.mvp.com.presenterinstance.mvvm.services.pokemon.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Ability{

	@SerializedName("name")
	public abstract String name();

	@SerializedName("url")
	public abstract String url();

	public static TypeAdapter<Ability> typeAdapter(Gson gson) {
		return new AutoValue_Ability.GsonTypeAdapter(gson);
	}
}