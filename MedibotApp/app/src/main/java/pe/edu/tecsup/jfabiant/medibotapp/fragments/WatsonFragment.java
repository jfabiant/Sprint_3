package pe.edu.tecsup.jfabiant.medibotapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pe.edu.tecsup.jfabiant.medibotapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WatsonFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_watson, container, false);
    }

}
