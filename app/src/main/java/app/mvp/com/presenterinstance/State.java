package app.mvp.com.presenterinstance;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

/**
 * Created by westplay on 13/08/17.
 */

@AutoValue
abstract class State implements Parcelable {

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
}
