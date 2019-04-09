package edith.example.datos;
/*
 * Created by Edith on 07-Apr-19.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import edith.example.restaurante.Restaurante;

public class BaseDatos extends SQLiteOpenHelper {
    private static final String CREAR_TABLA = "CREATE TABLE restaurante(_id INTEGER PRIMARY KEY AUTOINCREMENT, img INTEGER, nom TEXT, descr TEXT, dirtel TEXT, calif INTEGER)";
    private static final String LEER_TABLA = "SELECT _id, img, nom, descr, dirtel, calif FROM restaurante";
    private static final String NOMBRE_BD = "restaurantes.sqlite";
    private static final int VERSION_BD = 1;
    private SQLiteDatabase bd;

    //Constructor de la base de datos
    public BaseDatos(Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
        bd = this.getWritableDatabase(); //Es un método interno
    }

    //Ejecuta el query cuando se crea la base de datos
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAR_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    //Insertar un registro de restaurante
    public void insertar(int img, String nom, String descr, String dirtel, int calif) {
        ContentValues cv = new ContentValues();
        cv.put("img", img);
        cv.put("nom", nom);
        cv.put("descr", descr);
        cv.put("dirtel", dirtel);
        cv.put("calif", calif);
        bd.insert("restaurante", null, cv);
    }

    //Obtener la lista de restaurantes
    public ArrayList<Restaurante> datosRestaurante() {
        ArrayList<Restaurante> alRestaurantes = new ArrayList<>();
        //Se crea el cursor ejecutando el query para leer los datos de la tabla
        Cursor c = bd.rawQuery(LEER_TABLA, null);
        if (c != null && c.getCount() > 0) {
            c.moveToFirst();
            do {
                //Asignar valor de las variables para crear objeto Restaurante
                int img = c.getInt(c.getColumnIndex("img"));
                String nom = c.getString(c.getColumnIndex("nom"));
                String descr = c.getString(c.getColumnIndex("descr"));
                String dirtel = c.getString(c.getColumnIndex("dirtel"));
                int calif = c.getInt(c.getColumnIndex("calif"));
                //Se añaden los atributos al objeto
                alRestaurantes.add(new Restaurante(img, nom, descr, dirtel, calif));
            } while (c.moveToNext());
        }
        //Cerrar cursor
        if (c != null) {
            c.close();
        }
        return alRestaurantes;
    }

    //Actualizar registro de restaurante
    public void actualizar(String nom, String desc, String dirtel, int calif) {
        String[] args = new String[]{nom, desc, dirtel};
        ContentValues cv = new ContentValues();
        cv.put("calif", calif);
        bd.update("restaurante", cv, "nom=? AND descr=? AND dirtel=?", args);
    }
}
