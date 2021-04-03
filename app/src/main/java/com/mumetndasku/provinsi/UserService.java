package com.mumetndasku.provinsi;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface UserService {

    @GET("/users")
    Call<ArrayList<UserItem>> getUsers();
}
