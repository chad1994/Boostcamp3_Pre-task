package kr.ac.skuniv.choejun_yeong.boostcamp3.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    public static Retrofit getClientwithHeader(String url, String Id, String Secret) {
        Retrofit retrofit =null;
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync());

        HeaderInterceptor interceptor = new HeaderInterceptor(Id,Secret);

        httpClient.addInterceptor(interceptor);
        builder.client(httpClient.build());
        retrofit = builder.build();


        return retrofit;
    }


}
