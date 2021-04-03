package com.mumetndasku.provinsi;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.list_user)
    RecyclerView listUser;

    private ArrayList<UserItem> dataArrayList = new ArrayList<>();
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        listUser.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MainAdapter(getApplicationContext(), dataArrayList);
        listUser.setAdapter(adapter);
        listUser.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        RestClient.getProvinsiService().getUsers().enqueue(new Callback<ArrayList<UserItem>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<UserItem>> call, @NonNull Response<ArrayList<UserItem>> response) {
                if(response.body() != null){
                    adapter.listUser.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onFailure(@NonNull Call<ArrayList<UserItem>> call, @NonNull Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
