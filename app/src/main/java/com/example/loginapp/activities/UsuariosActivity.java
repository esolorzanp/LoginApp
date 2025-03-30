package com.example.loginapp.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.loginapp.R;

public class UsuariosActivity extends AppCompatActivity {

    private EditText email;
    private EditText nombreCompleto;
    private EditText password;
    private EditText confPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_usuarios);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        this.email = findViewById(R.id.editTextEmailUsuario);
        this.nombreCompleto = findViewById(R.id.editTextNombreCompletoUsuario);
        this.password = findViewById(R.id.editTextPasswordUsuario);
        this.confPassword = findViewById(R.id.editTextPasswordConfirmacionUsuario);
    }

    public void onCallMenuPrincipal(View v) {
        Intent intMain = new Intent(this, MenuActivity.class);
        startActivity(intMain);
    }

    public void onGuardar(View v) {
        if (validateFields()) {
            SharedPreferences sp = getSharedPreferences("AppLoginApp", Context.MODE_PRIVATE);
            SharedPreferences.Editor edt = sp.edit();
            edt.putString("Email", this.email.getText().toString());
            edt.putString("Nombre_compleo", this.nombreCompleto.getText().toString());
            edt.putString("Password", email.getText().toString());
            edt.commit();
            Toast.makeText(this, "Usuario guardado exitosamente", Toast.LENGTH_LONG).show();
        }
    }

    private boolean validateFields() {
        boolean b = true;
        if (email.getText().toString().isEmpty() || email.getText() == null) {
            Toast.makeText(this, "Campo Email no puede estar vacío", Toast.LENGTH_LONG).show();
            return false;
        }
        if (nombreCompleto.getText().toString().isEmpty() || nombreCompleto.getText() == null) {
            Toast.makeText(this, "Campo Nombre completo no puede estar vacío", Toast.LENGTH_LONG).show();
            return false;
        }
        if (password.getText().toString().isEmpty() || password.getText() == null) {
            Toast.makeText(this, "Campo Contrasela no puede estar vacío", Toast.LENGTH_LONG).show();
            return false;
        }
        if (confPassword.getText().toString().isEmpty() || confPassword.getText() == null) {
            Toast.makeText(this, "Campo Confirme la contraseña no puede estar vacío", Toast.LENGTH_LONG).show();
            return false;
        }
        if (!password.getText().toString().equals(confPassword.getText().toString())) {
            Toast.makeText(this, "La constraseña y la confirmación no son las mismas, ingreselas de nuevo", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    public void onConsultar(View v) {
        SharedPreferences sp = getSharedPreferences("AppLoginApp", Context.MODE_PRIVATE);
        email.setText(sp.getString("Email", ""));
        nombreCompleto.setText(sp.getString("Nombre_compleo", ""));
        //password.setText(sp.getString("Password",""));
    }
}