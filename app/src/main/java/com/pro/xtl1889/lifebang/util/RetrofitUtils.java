package com.pro.xtl1889.lifebang.util;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xtl1889 on 16-8-3.
 */
public class RetrofitUtils {



    public static OkHttpClient getClient(){
        CommonIntercetor commonIntercetor=new RetrofitUtils().new CommonIntercetor("Teemo");

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(commonIntercetor)
                .build();
        return client;

    }
    public static <T> T getRestAPI(String baseUrl, final Class<T> service) {


        Interceptor interceptor=new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request request;
//                String method = originalRequest.method();
//                Headers headers = originalRequest.headers();
                HttpUrl modifiedUrl = originalRequest.url().newBuilder()
                        // Provide your custom parameter here
                        .addQueryParameter("platform", "android")
                        .addQueryParameter("version", "1.0.0")
                        .build();
                request = originalRequest.newBuilder().url(modifiedUrl).build();
                return chain.proceed(request);
            }
        };

//        OkHttpClient.Builder builder=new OkHttpClient.Builder();
//        builder.addInterceptor(interceptor);
//        OkHttpClient client=builder.build();
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(service);
    }


    class CommonIntercetor implements Interceptor{

        private String apiKery;

        public CommonIntercetor(String apiKery) {
            this.apiKery = apiKery;
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request oldRequest=chain.request();

//            HttpUrl modifiedUrl = oldRequest.url().newBuilder()
//                    // Provide your custom parameter here
//                    .addQueryParameter("platform", "android")
//                    .addQueryParameter("version", apiKery)
//                    .build();
//
//            Request  newRequest=oldRequest.newBuilder().url(modifiedUrl).build();


            // 添加新的参数
            HttpUrl.Builder authorizedUrlBuilder = oldRequest.url()
                    .newBuilder()
                    .scheme(oldRequest.url().scheme())
                    .host(oldRequest.url().host())
                    .addQueryParameter("key", apiKery);

            LogUtils.LOGD("----cs----retrofitUtil----"+apiKery);

            // 新的请求
            Request newRequest = oldRequest.newBuilder()
                    .method(oldRequest.method(), oldRequest.body())
                    .url(authorizedUrlBuilder.build())
                    .build();
            return chain.proceed(newRequest);
        }
    }
}
