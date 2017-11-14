package app.mvp.com.presenterinstance.mvvm.services.pokemon.model;

import java.util.List;
import com.google.auto.value.AutoValue;
import com.google.gson.TypeAdapter;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;

@AutoValue
public abstract class MovesItem{

	@SerializedName("version_group_details")
	public abstract List<VersionGroupDetailsItem> versionGroupDetails();

	@SerializedName("move")
	public abstract Move move();

	public static TypeAdapter<MovesItem> typeAdapter(Gson gson) {
		return new AutoValue_MovesItem.GsonTypeAdapter(gson);
	}
}