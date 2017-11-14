package app.mvp.com.presenterinstance.mvvm.services.pokemon.model;

import com.google.auto.value.AutoValue;
import com.google.gson.TypeAdapter;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;

@AutoValue
public abstract class FormsItem{

	@SerializedName("name")
	public abstract String name();

	@SerializedName("url")
	public abstract String url();

	public static TypeAdapter<FormsItem> typeAdapter(Gson gson) {
		return new AutoValue_FormsItem.GsonTypeAdapter(gson);
	}
}