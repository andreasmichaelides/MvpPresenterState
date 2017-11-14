package app.mvp.com.presenterinstance.mvvm.services.pokemon.model;

import com.google.auto.value.AutoValue;
import com.google.gson.TypeAdapter;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;

@AutoValue
public abstract class GameIndicesItem{

	@SerializedName("game_index")
	public abstract int gameIndex();

	@SerializedName("version")
	public abstract Version version();

	public static TypeAdapter<GameIndicesItem> typeAdapter(Gson gson) {
		return new AutoValue_GameIndicesItem.GsonTypeAdapter(gson);
	}
}