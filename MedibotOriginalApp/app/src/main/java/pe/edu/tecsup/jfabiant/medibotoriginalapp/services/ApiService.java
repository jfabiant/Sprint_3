package pe.edu.tecsup.jfabiant.medibotoriginalapp.services;

import pe.edu.tecsup.jfabiant.medibotoriginalapp.models.Login;
import pe.edu.tecsup.jfabiant.medibotoriginalapp.models.User;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    String API_BASE_URL = "https://medibot-api-jfabiantimoteotorres.c9users.io";

    @FormUrlEncoded
    @POST("/rest-auth/login/")
    Call<Login> login(@Field("username") String username,
                      @Field("password") String password);

    @GET("/rest-auth/user/")
    Call <User> getUser();

    @FormUrlEncoded
    @POST("/rest-auth/logout/")
    Call<Login> logout(@Field("username") String username,
                       @Field("password") String password);




}