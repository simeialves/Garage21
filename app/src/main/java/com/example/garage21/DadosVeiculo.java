package com.example.garage21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DadosVeiculo extends AppCompatActivity {

    TextView placa, numero_vaga, preco_total;
    Button cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_veiculo);

        placa = findViewById(R.id.txtPlaca);
        numero_vaga = findViewById(R.id.txtNumeroVaga);
        preco_total = findViewById(R.id.txtPrecoTotal);
        cadastrar = findViewById(R.id.btnCadastrar);


        Intent exibirDados = getIntent();

        placa.setText(exibirDados.getStringExtra("Placa"));
        numero_vaga.setText(exibirDados.getStringExtra("Numero_Vaga"));
        preco_total.setText(exibirDados.getStringExtra("Preco_Total"));

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastrarVeiculo();
            }


        });
    }

    public void cadastrarVeiculo()
    {
        Veiculo v = new Veiculo();

        v.setPlaca(placa.getText().toString().trim());
        v.setNumero_vaga(numero_vaga.getText().toString().trim());
        v.setPreco_total(Float.parseFloat(preco_total.getText().toString().trim()));

        BancoDados.getBancoDados(this).getDAO().insereVeiculo(v);

        Toast.makeText(getApplicationContext(), "Cadastrado com Sucesso!", Toast.LENGTH_LONG).show();
    }
}