package com.example.garage21;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Veiculo {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "placa")
    private String placa;
    @ColumnInfo(name = "numero_vaga")
    private String numero_vaga;
    @ColumnInfo(name = "preco_total")
    private float preco_total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNumero_vaga() {
        return numero_vaga;
    }

    public void setNumero_vaga(String numero_vaga) {
        this.numero_vaga = numero_vaga;
    }

    public float getPreco_total() {
        return preco_total;
    }

    public void setPreco_total(float preco_total) {
        this.preco_total = preco_total;
    }
}
