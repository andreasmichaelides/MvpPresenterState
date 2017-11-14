package app.mvp.com.presenterinstance.mvvm.services.pokemon.model;

import com.google.auto.value.AutoValue;
import com.google.gson.TypeAdapter;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;

@AutoValue
public abstract class AbilitiesItem{

	@SerializedName("is_hidden")
	public abstract boolean isHidden();

	@SerializedName("slot")
	public abstract int slot();

	@SerializedName("ability")
	public abstract Ability ability();

	public static TypeAdapter<AbilitiesItem> typeAdapter(Gson gson) {
		return new AutoValue_AbilitiesItem.GsonTypeAdapter(gson);
	}
}