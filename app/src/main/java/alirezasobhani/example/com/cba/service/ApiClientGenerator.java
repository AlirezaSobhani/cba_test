package alirezasobhani.example.com.cba.service;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClientGenerator {

    public <T> T createService(OkHttpClient okHttpClient, Gson gson, Class<T> clientClass) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.dropbox.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();

        return retrofit.create(clientClass);
    }
}
