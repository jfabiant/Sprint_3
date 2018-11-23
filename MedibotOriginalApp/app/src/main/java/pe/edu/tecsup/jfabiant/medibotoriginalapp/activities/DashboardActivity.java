package pe.edu.tecsup.jfabiant.medibotoriginalapp.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import pe.edu.tecsup.jfabiant.medibotoriginalapp.R;
import pe.edu.tecsup.jfabiant.medibotoriginalapp.fragments.ConfiguracionFragment;
import pe.edu.tecsup.jfabiant.medibotoriginalapp.fragments.HistorialFragment;
import pe.edu.tecsup.jfabiant.medibotoriginalapp.fragments.InformacionFragment;
import pe.edu.tecsup.jfabiant.medibotoriginalapp.fragments.WatsonFragment;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setItemIconTintList(null);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HistorialFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectFragment = null;

                    switch (item.getItemId()){
                        case R.id.nav_historial:
                            selectFragment = new HistorialFragment();
                            break;
                        case R.id.nav_watson:
                            selectFragment = new WatsonFragment();
                            break;
                        case R.id.nav_informacion:
                            selectFragment = new InformacionFragment();
                            break;
                        case R.id.nav_configuracion:
                            selectFragment = new ConfiguracionFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectFragment).commit();
                    return true;
                }
            };
}
