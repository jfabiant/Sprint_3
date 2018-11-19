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

        usernameText = findViewById(R.id.username_text);
        emailText = findViewById(R.id.email_text);
        logoutButton = findViewById(R.id.logout_button);

        ApiService service = ApiServiceGenerator.createService(ApiService.class);

        Call<User> call = null;
        call = service.getUser();

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                try{
                    if (response.isSuccessful()) {
                        Toast.makeText(DashboardActivity.this,"Username: "+response.body().getUsername(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DashboardActivity.this,"La respuesta no fue exitosa", Toast.LENGTH_SHORT).show();
                    }
                }catch (Throwable t){

                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
            }
        });

    }



}
