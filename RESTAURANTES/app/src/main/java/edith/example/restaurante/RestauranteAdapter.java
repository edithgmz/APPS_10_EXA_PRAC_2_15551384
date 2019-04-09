package edith.example.restaurante;
/*
 * Created by Edith on 07-Apr-19.
 */

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import edith.example.principal.R;

public class RestauranteAdapter extends ArrayAdapter<Restaurante> {
    private Context cApp;
    private int iLayoutRest;
    //Lista de restaurantes
    private ArrayList<Restaurante> alDatos;

    //Constructor para el adaptador de restaurante
    public RestauranteAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Restaurante> objects) {
        super(context, resource, objects);
        cApp = context;
        iLayoutRest = resource;
        alDatos = objects;
    }

    @NonNull
    @Override
    public View getView(int i, @Nullable View convertView, @Nullable ViewGroup parent) {
        ImageView imgVwRes2;
        TextView txtVwNom2, txtVwDesc2, txtVwDirTel2;
        RatingBar rbEval2;
        View vwLayRest = convertView;
        //Si el layout no existe lo crea
        if (vwLayRest == null) {
            LayoutInflater liCrearLayout = ((Activity) cApp).getLayoutInflater();
            vwLayRest = liCrearLayout.inflate(iLayoutRest, parent, false);
        }
        //Se vinculan los elementos de la actividad
        imgVwRes2 = vwLayRest.findViewById(R.id.imgVwRes2);
        txtVwNom2 = vwLayRest.findViewById(R.id.txtVwNom2);
        txtVwDesc2 = vwLayRest.findViewById(R.id.txtVwDesc2);
        txtVwDirTel2 = vwLayRest.findViewById(R.id.txtVwDirTel2);
        rbEval2 = vwLayRest.findViewById(R.id.rbEval2);
        //Crea una lista de restaurantes con la lista obtenida del constructor
        ArrayList<Restaurante> alRestaurante = alDatos;
        if (alRestaurante != null) {
            //Se colocan los datos de la lista en los elementos de la actividad
            imgVwRes2.setImageResource(alRestaurante.get(i).getImg());
            txtVwNom2.setText(alRestaurante.get(i).getNom());
            txtVwDesc2.setText(alRestaurante.get(i).getDesc());
            txtVwDirTel2.setText(alRestaurante.get(i).getDirtel());
            rbEval2.setProgress(alRestaurante.get(i).getCalif());
        }
        //Devuelve el layout creado
        return vwLayRest;
    }
}
