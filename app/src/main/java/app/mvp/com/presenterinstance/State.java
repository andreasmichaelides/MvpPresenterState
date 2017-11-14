package app.mvp.com.presenterinstance;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

/**
 * Created by westplay on 13/08/17.
 */

@AutoValue
public abstract class State implements Parcelable {

    public abstract String message();

    public abstract int counter();

    static State create(String message, int counter) {
        return builder()
                .message(message)
                .counter(counter)
                .build();
    }

    private static Builder builder() {
        return new AutoValue_State.Builder();
    }

    @AutoValue.Builder
    abstract static class Builder {
        public abstract Builder message(String message);

        public abstract Builder counter(int counter);

        public abstract State build();
    }

    public static TypeAdapter<State> typeAdapter(Gson gson) {
        return new AutoValue_State.GsonTypeAdapter(gson);
    }

}
