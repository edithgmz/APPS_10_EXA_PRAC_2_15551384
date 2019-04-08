package edith.example.principal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public abstract class BaseDatos extends SQLiteOpenHelper {
    //la tabla necesita el script de creación con todos los campos que va a tener
    String tabla=" Create Table MostrarRes()";

    public BaseDatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {//se ejecuta la creación de la tabla
        db.execSQL(tabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {//ignorar
    }
}