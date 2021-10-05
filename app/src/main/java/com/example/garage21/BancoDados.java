package com.example.garage21;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Veiculo.class}, version = 1)
public abstract class BancoDados  extends RoomDatabase {
    public abstract VeiculoDAO getDAO();

    private static BancoDados INSTANCIA;

    public static BancoDados getBancoDados(Context context) {
        if (INSTANCIA == null) {
            synchronized (BancoDados.class) {
                if (INSTANCIA == null) {
                    INSTANCIA = Room.databaseBuilder(context.getApplicationContext(),
                            BancoDados.class, "DBGaragem").allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCIA;
    }
}