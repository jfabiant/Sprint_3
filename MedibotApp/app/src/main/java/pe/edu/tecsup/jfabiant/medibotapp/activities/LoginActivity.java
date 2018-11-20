package pe.edu.tecsup.jfabiant.medibotapp.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import pe.edu.tecsup.jfabiant.medibotapp.R;
import pe.edu.tecsup.jfabiant.medibotapp.models.Login;
import pe.edu.tecsup.jfabiant.medibotapp.services.ApiService;
import pe.edu.tecsup.jfabiant.medibotapp.services.ApiServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();
    private static final int REQUEST_SIGNUP = 0;

    @InjectView(R.id.username_input) EditText usernameInput;
    @InjectView(R.id.password_input) EditText passwordInput;
    @InjectView(R.id.btn_login) Button _loginButton;
    @InjectView(R.id.link_signup) TextView _signupLink;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameInput = findViewById(R.id.username_input);
        passwordInput = findViewById(R.id.password_input);

        ButterKnife.inject(this);

        _loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });

        _signupLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });
    }

    public void login() {

        _loginButton.setEnabled(false);

        Log.d(TAG, "Login");

        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();

        if (username.isEmpty()) {
            usernameInput.setError("Este campo es obligatorio");
            //onLoginFailed();
            return;
        }
        if (password.isEmpty()) {
            passwordInput.setError("Este campo es obligatorio");
            //onLoginFailed();
            return;
        }

        ApiService service = ApiServiceGenerator.createService(getApplicationContext(), ApiService.class);
        Call<Login> call = null;

        call = service.login(username, password);
        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                try{
                    if (response.isSuccessful()){
                        Toast.makeText(LoginActivity.this,"Usuario existe con token: "+response.body().getKey(), Toast.LENGTH_SHORT).show();

                        SharedPreferences preferences = getSharedPreferences("myPrefs", MODE_PRIVATE);
                        preferences.edit().putString("token", response.body().getKey()).commit();

                        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                                R.style.AppTheme_Dark_Dialog);
                        progressDialog.setIndeterminate(true);
                        progressDialog.setMessage("Autenticando ...");
                        progressDialog.show();

                        // TODO: Implement your own authentication logic here.

                        new android.os.Handler().postDelayed(
                                new Runnable() {
                                    public void run() {
                                        // On complete call either onLoginSuccess or onLoginFailed
                                        onLoginSuccess();
                                        // onLoginFailed();
                                        progressDialog.dismiss();
                                    }
                                }, 3000);



                    } else {
                        Toast.makeText(LoginActivity.this,"Usuario no existe", Toast.LENGTH_SHORT).show();
                    }
                }catch (Throwable t){

                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Toast.makeText
                        (LoginActivity.this,
                                "Error al conectarse a la red",
                                Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        _loginButton.setEnabled(true);
        startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
        finish();
    }

    public void onLoginFailed() {
        //Toast.makeText(getBaseContext(), "Error al iniciar sesion", Toast.LENGTH_LONG).show();

        _loginButton.setEnabled(true);
    }
}