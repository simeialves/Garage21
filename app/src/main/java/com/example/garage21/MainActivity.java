package com.example.garage21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText login, senha;
    Button logar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.edtLogin);
        senha = findViewById(R.id.edtSenha);
        logar = findViewById(R.id.btnLogar);

        gravarDados();
    }

    public void gravarDados()
    {
        logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String l = login.getText().toString().trim();
                String s = senha.getText().toString().trim();

                if (l.equals("Simei") && s.equals("123"))
                {
                    Intent principalForm = new Intent(getApplicationContext(), Principal.class);
                    startActivity(principalForm);
                    login.setText("");
                    senha.setText("");
                }
                else {
                    Toast.makeText(getApplicationContext(), "Dados Incorretos!", Toast.LENGTH_LONG).show();
                    login.setText("");
                    senha.setText("");
                    login.requestFocus();
                }

            }
        });
    }
}