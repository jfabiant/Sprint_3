package pe.edu.tecsup.jfabiant.medibotapp.services;

import java.util.List;

import pe.edu.tecsup.jfabiant.medibotapp.models.HistorialMedico;
import pe.edu.tecsup.jfabiant.medibotapp.models.Hospital;
import pe.edu.tecsup.jfabiant.medibotapp.models.Usuario;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

public interface ApiService {

    String API_BASE_URL = "https://medibot-api-jfabiantimoteotorres.c9users.io";


    @GET("/api/usuarios/")
    Call<Usuario> getUsuarios();

    @GET("/api/hospitales/")
    Call<List<Hospital>> getHospitales();

    @GET("/api/h_medicos/")
    Call<List<HistorialMedico>> getHistoriales();

}
