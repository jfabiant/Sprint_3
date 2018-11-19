package pe.edu.tecsup.jfabiant.loginapp.activities.services;

import java.net.CookieManager;
import java.net.CookiePolicy;

import okhttp3.OkHttpClient;
import pe.edu.tecsup.jfabiant.loginapp.activities.models.Login;
import pe.edu.tecsup.jfabiant.loginapp.activities.models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiService {

    String API_BASE_URL = "https://medibot-api-jfabiantimoteotorres.c9users.io";

    @FormUrlEncoded
    @POST("/rest-auth/login/")
    Call<Login> login(@Field("username") String username,
                      @Field("password") String password);
    @GET("/rest-auth/user/")
    Call <User> getUser();


}
