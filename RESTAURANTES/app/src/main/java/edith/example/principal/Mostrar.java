package edith.example.principal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import edith.example.datos.BaseDatos;
import edith.example.restaurante.Detalle;
import edith.example.restaurante.Restaurante;
import edith.example.restaurante.RestauranteAdapter;

public class Mostrar extends AppCompatActivity implements ListView.OnItemClickListener {
    private ListView lstVwRest;
    private Intent inDetalle;
    //Lista de restaurantes y restaurante actual
    private ArrayList<Restaurante> alRestaurante;
    //Controlador de base de datos
    private BaseDatos bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        //Iniciar controlador de la base de datos
        bd = new BaseDatos(this);
        //Inicia la lista de restaurantes
        alRestaurante = bd.datosRestaurante();
        //Se vincula la lista, agrega el adaptador y el listener
        lstVwRest = findViewById(R.id.lstVwRest);
        lstVwRest.setAdapter(new RestauranteAdapter(this, R.layout.layout_restaurante, alRestaurante));
        lstVwRest.setOnItemClickListener(this);
        //Intento para la actividad Detalle
        inDetalle = new Intent(this, Detalle.class);
    }

    //Al seleccionar un elemento de la lista se envían sus atributos en un bundle a la actividad Detalle
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        Bundle bDatos = new Bundle();
        bDatos.putInt("IMG_REST", alRestaurante.get(i).getImg());
        bDatos.putString("NOM_REST", alRestaurante.get(i).getNom());
        bDatos.putString("DESC_REST", alRestaurante.get(i).getDesc());
        bDatos.putString("DIRTEL_REST", alRestaurante.get(i).getDirtel());
        bDatos.putInt("CALIF_REST", alRestaurante.get(i).getCalif());
        inDetalle.putExtras(bDatos);
        startActivity(inDetalle);
    }
}
