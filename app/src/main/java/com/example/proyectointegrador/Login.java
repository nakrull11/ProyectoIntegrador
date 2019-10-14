package com.example.proyectointegrador;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectointegrador.R;

public class Login extends AppCompatActivity {
    EditText usuario, clave;
    Button botonLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Login();
    }

    void Login(){
        usuario = findViewById(R.id.usuario);
        clave = findViewById(R.id.clave);
        botonLogin = findViewById(R.id.botonLogin);

        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (usuario.getText().toString().equals("Gustavo") && clave.getText().toString().equals("12345")){
                    Toast.makeText(getApplicationContext(),"ingreso con exito!",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent("com.example.proyectointegrador.MainActivity");
                    startActivity(intent);
                }else Toast.makeText(getApplicationContext(),"Usuario y/o contraseña incorrectos",Toast.LENGTH_LONG).show();
            }
        });
    }
}
