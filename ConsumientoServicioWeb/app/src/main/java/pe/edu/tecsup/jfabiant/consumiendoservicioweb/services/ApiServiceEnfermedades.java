package pe.edu.tecsup.jfabiant.consumiendoservicioweb.services;

import java.util.List;

import pe.edu.tecsup.jfabiant.consumiendoservicioweb.models.Enfermedad;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServiceEnfermedades {

    String API_BASE_URL = "http://medibot-api-jfabiantimoteotorres.c9users.io";
    @GET("/api/enfermedades/")

    public Call<List<Enfermedad>> getEnfermedades();


}
