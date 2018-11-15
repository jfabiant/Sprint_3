package pe.edu.tecsup.jfabiant.medibotapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import pe.edu.tecsup.jfabiant.medibotapp.R;
import pe.edu.tecsup.jfabiant.medibotapp.adapters.HospitalAdapter;
import pe.edu.tecsup.jfabiant.medibotapp.models.Hospital;
import pe.edu.tecsup.jfabiant.medibotapp.services.ApiService;
import pe.edu.tecsup.jfabiant.medibotapp.services.ApiServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistorialFragment extends Fragment {

    private static final String TAG = HistorialFragment.class.getSimpleName();
    private RecyclerView hospitalList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_historial, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        hospitalList = getView().findViewById(R.id.recyclerview);
        hospitalList.setLayoutManager(new LinearLayoutManager(getContext()));

        hospitalList.setAdapter(new HospitalAdapter());

        initialize();

    }

    private void initialize () {

        ApiService service = ApiServiceGenerator.createService(ApiService.class);
        Call<List<Hospital>> call = service.getHospitales();

        call.enqueue(new Callback<List<Hospital>>() {
            @Override
            public void onResponse(Call<List<Hospital>> call, Response<List<Hospital>> response) {
                try {

                    if (response.isSuccessful()) {

                        List<Hospital> hospitales = response.body();
                        Log.d(TAG, "Hospitales: " + hospitales);

                        HospitalAdapter adapter = (HospitalAdapter) hospitalList.getAdapter();
                        adapter.setHospitales(hospitales);
                        adapter.notifyDataSetChanged();

                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}

                }

            }

            @Override
            public void onFailure(Call<List<Hospital>> call, Throwable t) {
                Toast.makeText(getActivity(), "Error: ", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
