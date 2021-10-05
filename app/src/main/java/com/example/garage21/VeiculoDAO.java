package com.example.garage21;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public abstract class VeiculoDAO {
    @Insert
    public abstract long insereVeiculo(Veiculo v);
}
