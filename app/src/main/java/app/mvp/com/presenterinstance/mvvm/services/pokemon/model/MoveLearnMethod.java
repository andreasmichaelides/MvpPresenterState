package app.mvp.com.presenterinstance.mvvm.services.pokemon.model;

import com.google.auto.value.AutoValue;
import com.google.gson.TypeAdapter;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;

@AutoValue
public abstract class MoveLearnMethod{

	@SerializedName("name")
	public abstract String name();

	@SerializedName("url")
	public abstract String url();

	public static TypeAdapter<MoveLearnMethod> typeAdapter(Gson gson) {
		return new AutoValue_MoveLearnMethod.GsonTypeAdapter(gson);
	}
}