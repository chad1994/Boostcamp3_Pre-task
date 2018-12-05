package kr.ac.skuniv.choejun_yeong.boostcamp3.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptor implements Interceptor {

    private String Id;
    private String Secret;

    public HeaderInterceptor(String id, String secret) {
        Id = id;
        Secret = secret;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request.Builder builder = chain.request().newBuilder();
        builder.addHeader("X-Naver-Client-Id", Id);
        builder.addHeader("X-Naver-Client-Secret",Secret);

        Request request = builder.build();

        return chain.proceed(request);
    }
}
