package com.example.ernesto.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SegundoActivity extends AppCompatActivity {

    EditText nombre_usuario;
    EditText email;
    EditText contrasena;
    EditText confContrasena;
    EditText telefono;
    Button confirmar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        nombre_usuario = findViewById(R.id.nombre_usuario);
        email = findViewById(R.id.email);
        contrasena = findViewById(R.id.contrasena);
        confContrasena = findViewById(R.id.confContrasena);
        telefono = findViewById(R.id.telefono);
        confirmar = findViewById(R.id.confirmar);

        
        confirmar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                checkDataEntered();
           }

        });

    }

    //Método para el botón Anterior
    public void Anterior(View view) {
        Intent anterior = new Intent(this, MainActivity.class);
        startActivity(anterior);
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void checkDataEntered() {
        if (isEmpty(nombre_usuario)) {
            Toast t = Toast.makeText(this, "¡Debe ingresar el nombre para registrarse!", Toast.LENGTH_SHORT);
            t.show();
        }

        if (isEmpty(contrasena)) {
            contrasena.setError("¡Ingrese un una contraseña válida!");
        }

        if (isEmpty(confContrasena)) {
            confContrasena.setError("¡Ingrese un una contraseña válida!");
        }


        if (!isEmail(email)) {
            email.setError("¡Ingrese un email valido!");
       }

        if (!isEmpty(telefono)) {
            telefono.setError("¡Ingrese un número valido!");
        }
    }
    
}
