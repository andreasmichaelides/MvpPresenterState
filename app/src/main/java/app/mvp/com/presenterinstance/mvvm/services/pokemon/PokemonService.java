package app.mvp.com.presenterinstance.mvvm.services.pokemon;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by andreas on 14/11/17.
 */

public class PokemonService {

    private static final String BASE_URL = "https://pokeapi.co";
    private final Retrofit retrofit;

    public PokemonService() {
        this.retrofit = createRetrofitInstance();
    }

    private Retrofit createRetrofitInstance() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.NONE);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        final Gson gson = new GsonBuilder().
                registerTypeAdapterFactory(AdapterFactory.create())
                .create();

        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build())
                .baseUrl(BASE_URL)
                .build();
    }

    public <T> T createService(Class<T> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
