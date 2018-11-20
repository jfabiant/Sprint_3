package pe.edu.tecsup.jfabiant.medibotapp.services;

import java.util.List;

import pe.edu.tecsup.jfabiant.medibotapp.models.HistorialMedico;
import pe.edu.tecsup.jfabiant.medibotapp.models.Hospital;
import pe.edu.tecsup.jfabiant.medibotapp.models.Login;
import pe.edu.tecsup.jfabiant.medibotapp.models.User;
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

    @GET("/api/hospitales/")
    Call<List<Hospital>> getHospitales();

    @GET("/api/h_medicos/")
    Call<List<HistorialMedico>> getHistoriales();


}
