package com.mumetndasku.provinsi;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    private static UserService service;

    public static UserService getProvinsiService(){
        if(service == null){
            String API_BASE_URL = "https://jsonplaceholder.typicode.com";
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            Retrofit.Builder builder = new Retrofit.Builder().baseUrl(API_BASE_URL).addConverterFactory(GsonConverterFactory.create());
            Retrofit retrofit = builder.client(httpClient.build()).build();

            service = retrofit.create(UserService.class);
        }
        return service;
    }
}
