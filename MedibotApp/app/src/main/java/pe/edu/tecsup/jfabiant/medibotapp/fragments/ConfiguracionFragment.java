package pe.edu.tecsup.jfabiant.medibotapp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import pe.edu.tecsup.jfabiant.medibotapp.R;
import pe.edu.tecsup.jfabiant.medibotapp.adapters.UserAdapter;
import pe.edu.tecsup.jfabiant.medibotapp.models.User;
import pe.edu.tecsup.jfabiant.medibotapp.services.ApiService;
import pe.edu.tecsup.jfabiant.medibotapp.services.ApiServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfiguracionFragment extends Fragment {

    private static final String TAG = ConfiguracionFragment.class.getSimpleName();
    private RecyclerView userList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_configuracion, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        userList = getView().findViewById(R.id.recyclerview);
        userList.setLayoutManager(new LinearLayoutManager(getContext()));

        userList.setAdapter(new UserAdapter());

        initialize();

    }

    private void initialize () {

        ApiService service = ApiServiceGenerator.createService(ApiService.class);
        Call<List<User>> call = service.getUsers();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                try {

                    if (response.isSuccessful()) {

                        List<User> users = response.body();
                        Log.d(TAG, "Usuario: " + users);

                        UserAdapter adapter = (UserAdapter) userList.getAdapter();
                        adapter.setUsers(users);
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
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(getActivity(), "Error: ", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
