package com.example.garage21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    EditText placa, numero_vaga, preco_total;
    Button visualizarDados, recuperarDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        placa = findViewById(R.id.edtPlaca);
        numero_vaga = findViewById(R.id.edtNumeroVaga);
        preco_total = findViewById(R.id.edtPrecoTotal);

        visualizarDados = findViewById(R.id.btnVisualizarDados);
        recuperarDados = findViewById(R.id.btnRecuperarDados);

        Visualizar();
        recuperarDados();
    }

    public void Visualizar()
    {
        visualizarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (placa.getText().toString().equals("") ||
                        numero_vaga.getText().equals("") ||
                        preco_total.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Digite todos os dados do veículo!", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Intent veiculoForm = new Intent(getApplicationContext(), DadosVeiculo.class);

                    veiculoForm.putExtra("Placa", placa.getText().toString().trim());
                    veiculoForm.putExtra("Numero_Vaga", numero_vaga.getText().toString().trim());
                    veiculoForm.putExtra("Preco_Total", preco_total.getText().toString().trim());

                    startActivity(veiculoForm);

                    SharedPreferences objetoShared = getSharedPreferences("TabelaDadosVeiculo", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editaDados = objetoShared.edit();
                    editaDados.putString("Placa", placa.getText().toString().trim());
                    editaDados.putString("Numero_Vaga", numero_vaga.getText().toString().trim());
                    editaDados.putString("Preco_Total", preco_total.getText().toString().trim());

                    editaDados.apply();

                    placa.setText("");
                    numero_vaga.setText("");
                    preco_total.setText("");
                }
            }
        });
    }

    public void recuperarDados()
    {
        recuperarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences recuperarDados = getSharedPreferences("TabelaDadosVeiculo", Context.MODE_PRIVATE);

                placa.setText(recuperarDados.getString("Placa", "Nulo"));
                numero_vaga.setText(recuperarDados.getString("Numero_Vaga", "Nulo"));
                preco_total.setText(recuperarDados.getString("Preco_Total", "Nulo"));
            }
        });
    }
}