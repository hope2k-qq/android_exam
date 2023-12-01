package com.example.android_exam;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static NetworkService networkService;
    private Retrofit retrofit;
    private Api api;
    private UserDB userDB;

    private NetworkService(Context context){
        userDB = Room.databaseBuilder(context, UserDB.class, "user_db")
                .allowMainThreadQueries()
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);
    }

    public static NetworkService getInstance(Context context) {
        if(networkService == null){
            networkService = new NetworkService(context);
        }
        return networkService;
    }

    public void renewalUsers() {
        Call<List<User>> call = api.getAll();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<User> users = response.body();

                    userDB.userDAO().insertAll(users);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
            }
        });
    }

    public Api getApi() {
        return api;
    }

    public UserDB getUserDB() {
        return userDB;
    }

    public UserDAO getUserDAO() {
        return userDB.userDAO();
    }
}
