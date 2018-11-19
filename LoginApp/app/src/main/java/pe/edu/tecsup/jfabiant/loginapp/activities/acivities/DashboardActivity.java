package pe.edu.tecsup.jfabiant.loginapp.activities.acivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import pe.edu.tecsup.jfabiant.loginapp.R;
import pe.edu.tecsup.jfabiant.loginapp.activities.models.Login;
import pe.edu.tecsup.jfabiant.loginapp.activities.models.User;
import pe.edu.tecsup.jfabiant.loginapp.activities.services.ApiService;
import pe.edu.tecsup.jfabiant.loginapp.activities.services.ApiServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity {

    private TextView usernameText;
    private TextView emailText;
    private Button logoutButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


    }



}
