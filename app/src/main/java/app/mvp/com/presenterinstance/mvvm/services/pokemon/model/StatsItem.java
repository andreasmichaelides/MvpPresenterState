package app.mvp.com.presenterinstance.mvvm.services.pokemon.model;

import com.google.auto.value.AutoValue;
import com.google.gson.TypeAdapter;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;

@AutoValue
public abstract class StatsItem{

	@SerializedName("stat")
	public abstract Stat stat();

	@SerializedName("base_stat")
	public abstract int baseStat();

	@SerializedName("effort")
	public abstract int effort();

	public static TypeAdapter<StatsItem> typeAdapter(Gson gson) {
		return new AutoValue_StatsItem.GsonTypeAdapter(gson);
	}
}