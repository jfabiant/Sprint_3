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
import pe.edu.tecsup.jfabiant.consumiendoservicioweb.adapters.EnfermedadAdapter;
import pe.edu.tecsup.jfabiant.consumiendoservicioweb.models.Enfermedad;
import pe.edu.tecsup.jfabiant.consumiendoservicioweb.services.ApiServiceEnfermedades;
import pe.edu.tecsup.jfabiant.consumiendoservicioweb.services.ApiServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondActivity extends AppCompatActivity {

    private final static String TAG = SecondActivity.class.getSimpleName();
    public RecyclerView listEnfermedades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        listEnfermedades = findViewById(R.id.list_enfermedades);
        listEnfermedades.setLayoutManager(new LinearLayoutManager(this));
        listEnfermedades.setAdapter(new EnfermedadAdapter());
        initialize();

    }

    private void initialize () {

        ApiServiceEnfermedades service = ApiServiceGenerator.createService(ApiServiceEnfermedades.class);

        Call<List<Enfermedad>> call = service.getEnfermedades();

        call.enqueue(new Callback<List<Enfermedad>>() {
            @Override
            public void onResponse(Call<List<Enfermedad>> call, Response<List<Enfermedad>> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        List<Enfermedad> enfermedades = response.body();
                        Log.d(TAG, "Enfermedades: " + enfermedades);

                        EnfermedadAdapter adapter = (EnfermedadAdapter) listEnfermedades.getAdapter();
                        adapter.setEnfermedades(enfermedades);
                        adapter.notifyDataSetChanged();

                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(SecondActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }

            @Override
            public void onFailure(Call<List<Enfermedad>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(SecondActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    public void back (View view) {

        startActivity(new Intent(this, MainActivity.class));
        //finish();
    }

}
