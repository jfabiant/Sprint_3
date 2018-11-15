package pe.edu.tecsup.jfabiant.medibotapp.services;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import pe.edu.tecsup.jfabiant.medibotapp.models.HistorialMedico;
import pe.edu.tecsup.jfabiant.medibotapp.models.Hospital;
import pe.edu.tecsup.jfabiant.medibotapp.models.Login;
import pe.edu.tecsup.jfabiant.medibotapp.models.User;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {

    String API_BASE_URL = "https://medibot-api-jfabiantimoteotorres.c9users.io";

    @FormUrlEncoded
    @POST("/rest-auth/login/")
    Call<Login> login (@Field("username") String username,
                       @Field("password") String password);


    @GET("/api/hospitales/")
    Call<List<Hospital>> getHospitales();

    @GET("/api/h_medicos/")
    Call<List<HistorialMedico>> getHistoriales();

    @GET("/rest-auth/user/")
    Call<List<User>> getUsers();
}
