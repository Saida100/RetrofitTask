package com.saida.retrofittask;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterfaces {

    @GET("posts/1/comments")
    Call<List<PostPOJO>> getListPostPOJO();


    @GET("comments")
    Call<List<PostPOJO>> getListPostPOJOByPostId(@Query("postId")  String postId);


    @GET("posts")
    Call<List<UserPojo>> getListUserPOJObyUserId(@Query("userId")  String userId);

    @GET("/photos")
    Call<List<Photos>> getPhotoList();

    @GET("/users")
    Call<List<Users>>  getUserList();


    @POST("/posts")
    Call<List<UserPojo>>getUserPojo(@Body UserPojo userPojo  );


}
