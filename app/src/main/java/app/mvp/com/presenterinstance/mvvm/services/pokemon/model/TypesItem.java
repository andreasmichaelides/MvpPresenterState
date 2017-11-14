package app.mvp.com.presenterinstance.mvvm.services.pokemon.model;

import com.google.auto.value.AutoValue;
import com.google.gson.TypeAdapter;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;

@AutoValue
public abstract class TypesItem{

	@SerializedName("slot")
	public abstract int slot();

	@SerializedName("type")
	public abstract Type type();

	public static TypeAdapter<TypesItem> typeAdapter(Gson gson) {
		return new AutoValue_TypesItem.GsonTypeAdapter(gson);
	}
}