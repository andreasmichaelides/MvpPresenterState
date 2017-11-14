package app.mvp.com.presenterinstance.mvvm.services.pokemon.model;

import com.google.auto.value.AutoValue;
import com.google.gson.TypeAdapter;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;

@AutoValue
public abstract class VersionGroupDetailsItem{

	@SerializedName("level_learned_at")
	public abstract int levelLearnedAt();

	@SerializedName("version_group")
	public abstract VersionGroup versionGroup();

	@SerializedName("move_learn_method")
	public abstract MoveLearnMethod moveLearnMethod();

	public static TypeAdapter<VersionGroupDetailsItem> typeAdapter(Gson gson) {
		return new AutoValue_VersionGroupDetailsItem.GsonTypeAdapter(gson);
	}
}