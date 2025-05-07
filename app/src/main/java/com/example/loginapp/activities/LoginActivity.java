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
import com.example.loginapp.crypt.Crypt;
import com.example.loginapp.dao.UsuarioDao;
import com.example.loginapp.model.Usuario;

public class LoginActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        this.email = findViewById(R.id.editTextEmailLogin);
        this.password = findViewById(R.id.editTextPasswordLogin);
        email.setText("");
        password.setText("");
    }

    public void onLogin(View v) {
        if (validateFields()) {
            callMenu();
        }
    }

    private boolean validateFields() {
        if (this.email.getText().toString().isEmpty() || this.email.getText().toString() == null) {
            Toast.makeText(this, "Ingrese un email", Toast.LENGTH_LONG).show();
            return false;
        }
        if (this.password.getText().toString().isEmpty() || this.password.getText().toString() == null) {
            Toast.makeText(this, "Ingrese la contraseña", Toast.LENGTH_LONG).show();
            return false;
        }
        if (!validateEmailPassword()) {
            Toast.makeText(this, "Usuario y/o contraseña incorrectos", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    public void onCleanForm(View v) {
        this.email.setText("");
        this.password.setText("");
    }

    public boolean validateEmailPassword() {
        UsuarioDao dao = new UsuarioDao(this);
        if (dao.exist(this.email.getText().toString())) {
            Usuario u = dao.findBy(this.email.getText().toString());
            String emailSp = u.getEmail();
            String passwordSp = u.getPassword();
            System.out.println("email = " + email);
            System.out.println("uusario = " + u);
            if (!this.email.getText().toString().equals(emailSp.toString())) return false;
            if (!new Crypt().toEncrypt(password.getText().toString()).equals(passwordSp))
                return false;
            Toast.makeText(this, "Bienvenido " + u.getNombreCompleto(), Toast.LENGTH_LONG).show();
            return true;
        } else {
            return false;
        }
    }

    public void callMenu() {
        Intent intentMenu = new Intent(this, MenuActivity.class);
        startActivity(intentMenu);
    }
}