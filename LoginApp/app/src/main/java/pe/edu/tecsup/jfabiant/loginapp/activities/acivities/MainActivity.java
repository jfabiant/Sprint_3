package pe.edu.tecsup.jfabiant.loginapp.activities.acivities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pe.edu.tecsup.jfabiant.loginapp.R;
import pe.edu.tecsup.jfabiant.loginapp.activities.models.Login;
import pe.edu.tecsup.jfabiant.loginapp.activities.models.User;
import pe.edu.tecsup.jfabiant.loginapp.activities.services.ApiService;
import pe.edu.tecsup.jfabiant.loginapp.activities.services.ApiServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText usernameInput;
    private EditText passwordInput;
    private Button loginButton;
    private Button showUserButton;

    private Retrofit retrofit;
    private ApiService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameInput = findViewById(R.id.username_input);
        passwordInput = findViewById(R.id.password_input);
        loginButton = findViewById(R.id.login_button);
        showUserButton = findViewById(R.id.showUser_button);

        retrofit = new Retrofit.Builder().baseUrl("https://medibot-api-jfabiantimoteotorres.c9users.io")
                .addConverterFactory(GsonConverterFactory.create()).build();

        service = retrofit.create(ApiService.class);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();

                Call<Login> call = null;
                call = service.login(username, password);

                call.enqueue(new Callback<Login>() {
                    @Override
                    public void onResponse(Call<Login> call, Response<Login> response) {
                        try{
                            if(response.isSuccessful()){
                                Toast.makeText(MainActivity.this,"Usuario existe con token: "+response.body().getKey(), Toast.LENGTH_SHORT).show();

                                SharedPreferences preferences = getSharedPreferences("myPrefs", MODE_PRIVATE);
                                preferences.edit().putString("token", response.body().getKey()).commit();

                                //startActivity(new Intent(MainActivity.this, DashboardActivity.class));
                                //finish();

                            }else{
                                Toast.makeText
                                        (MainActivity.this, "Usuario no existe", Toast.LENGTH_SHORT).show();
                            }
                        }catch (Throwable t){
                        }
                    }

                    @Override
                    public void onFailure(Call<Login> call, Throwable t) {
                        Toast.makeText
                                (MainActivity.this,
                                        "Error al conectarse",
                                        Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        showUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Call<User> call = null;
                call = service.getUser();

                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        try{
                            if(response.isSuccessful()){
                                Toast.makeText
                                        (MainActivity.this,
                                                "Username: "+response.body().getUsername(),
                                                Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText
                                        (MainActivity.this, "No se detecto el usuario", Toast.LENGTH_SHORT).show();
                            }
                        }catch (Throwable t){
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText
                                (MainActivity.this,
                                        "Error al conectarse",
                                        Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

    }

}
