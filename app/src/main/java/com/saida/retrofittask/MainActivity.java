package com.saida.retrofittask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    UserPojo userPojo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userPojo = new UserPojo();


        ApiInit apiInit = new ApiInit();
        apiInit.initRetrofit();

        APIInterfaces apiInterfaces = apiInit.getClient();

        apiInterfaces.getListPostPOJO()
                .enqueue(new Callback<List<PostPOJO>>() {
                    @Override
                    public void onResponse(Call<List<PostPOJO>> call, Response<List<PostPOJO>> response) {
                        List<PostPOJO> postPOJOS = response.body();
                        Log.e("ListPostPojo", "result");
                        Log.e("ListPostPojo", postPOJOS.toString());
                    }

                    @Override
                    public void onFailure(Call<List<PostPOJO>> call, Throwable t) {
                        t.printStackTrace();
                    }
                });


        //  https://jsonplaceholder.typicode.com/comments?postId=3
        // postId 3 olanlari getirir
        apiInterfaces.getListPostPOJOByPostId("3")
                .enqueue(new Callback<List<PostPOJO>>() {
                    @Override
                    public void onResponse(Call<List<PostPOJO>> call, Response<List<PostPOJO>> response) {
                        List<PostPOJO> postPOJOSByPostId = response.body();
                        Log.e("ListPostPojoByPostId", "result");
                        Log.e("ListPostPojoByPostId", postPOJOSByPostId.toString());
                    }

                    @Override
                    public void onFailure(Call<List<PostPOJO>> call, Throwable t) {

                    }
                });


        //  https://jsonplaceholder.typicode.com/posts?userId=2
        // userId 2 olanlari getirir
        apiInterfaces.getListUserPOJObyUserId("2")
                .enqueue(new Callback<List<UserPojo>>() {
                    @Override
                    public void onResponse(Call<List<UserPojo>> call, Response<List<UserPojo>> response) {
                        List<UserPojo> userPOJOSByUserId = response.body();
                        Log.e("ListUserPojoByUserId", "result");
                        Log.e("ListUserPojoByUserId", userPOJOSByUserId.toString());
                    }

                    @Override
                    public void onFailure(Call<List<UserPojo>> call, Throwable t) {

                    }
                });


        // post ile request
        apiInterfaces.getUserPojo(userPojo)
                .enqueue(new Callback<List<UserPojo>>() {
                    @Override
                    public void onResponse(Call<List<UserPojo>> call, Response<List<UserPojo>> response) {
                        List<UserPojo> userPojoList = response.body();
                        Log.e("userPojoList", userPojoList.toString());

                    }

                    @Override
                    public void onFailure(Call<List<UserPojo>> call, Throwable t) {

                    }
                });


        apiInterfaces.getPhotoList()
                .enqueue(new Callback<List<Photos>>() {
                    @Override
                    public void onResponse(Call<List<Photos>> call, Response<List<Photos>> response) {
                        List<Photos> photosList = response.body();
                        Log.e("userPhotoList", photosList.toString());

                    }

                    @Override
                    public void onFailure(Call<List<Photos>> call, Throwable t) {
                        t.printStackTrace();

                    }
                });


        apiInterfaces.getUserList()
                .enqueue(new Callback<List<Users>>() {
                    @Override
                    public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                        List<Users> usersList = response.body();
                        Log.e("usersList", usersList.toString());
                    }

                    @Override
                    public void onFailure(Call<List<Users>> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }
}
