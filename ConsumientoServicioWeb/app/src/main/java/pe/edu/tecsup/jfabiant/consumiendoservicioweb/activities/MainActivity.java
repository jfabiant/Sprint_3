package pe.edu.tecsup.jfabiant.consumiendoservicioweb.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import pe.edu.tecsup.jfabiant.consumiendoservicioweb.R;
import pe.edu.tecsup.jfabiant.consumiendoservicioweb.adapters.HospitalAdapter;
import pe.edu.tecsup.jfabiant.consumiendoservicioweb.models.Hospital;
import pe.edu.tecsup.jfabiant.consumiendoservicioweb.services.ApiServiceGenerator;
import pe.edu.tecsup.jfabiant.consumiendoservicioweb.services.ApiServiceHospitales;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();
    public RecyclerView listHospitales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listHospitales = findViewById(R.id.list_hospitales);
        listHospitales.setLayoutManager(new LinearLayoutManager(this));
        listHospitales.setAdapter(new HospitalAdapter());
        initialize();

    }

    private void initialize() {

        ApiServiceHospitales service = ApiServiceGenerator.createService(ApiServiceHospitales.class);

        Call<List<Hospital>> call = service.getHospitales();

        call.enqueue(new Callback<List<Hospital>>() {
            @Override
            public void onResponse(Call<List<Hospital>> call, Response<List<Hospital>> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        List<Hospital> hospitales = response.body();
                        Log.d(TAG, "Hopitales: " + hospitales);

                        HospitalAdapter adapter = (HospitalAdapter) listHospitales.getAdapter();
                        adapter.setHospitales(hospitales);
                        adapter.notifyDataSetChanged();

                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }

            @Override
            public void onFailure(Call<List<Hospital>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void next (View view) {

        startActivity(new Intent(this, SecondActivity.class));
        //finish();
    }
}
