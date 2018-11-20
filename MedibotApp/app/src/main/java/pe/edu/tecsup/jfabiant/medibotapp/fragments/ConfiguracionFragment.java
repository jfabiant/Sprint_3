package pe.edu.tecsup.jfabiant.medibotapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pe.edu.tecsup.jfabiant.medibotapp.R;

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

        userList.setAdapter(new UsuarioAdapter());

    }
}
