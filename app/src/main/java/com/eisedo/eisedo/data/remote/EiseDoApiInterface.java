package com.eisedo.eisedo.data.remote;

import com.eisedo.eisedo.data.remote.Dao.PostSample;
import com.eisedo.eisedo.data.remote.Dao.Sample;

import org.json.JSONObject;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface EiseDoApiInterface {

    @POST("users/register")
    @FormUrlEncoded
    Call<Sample> getUserRegistration(@Field("name") String name, @Field("password") String password, @Field("email") String email);

    @POST("users/register")
    Call<JSONObject> callRawdata(@Body Map<String,Object> data);

    @POST("users/register")
    Call<JSONObject> callRawdata(@Body PostSample data);


}
