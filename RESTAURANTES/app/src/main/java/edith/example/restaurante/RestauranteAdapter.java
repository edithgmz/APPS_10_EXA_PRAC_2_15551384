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

import edith.example.principal.R;

public class RestauranteAdapter extends ArrayAdapter<Restaurante> {
    private Context cApp;
    private int iLayoutRest;
    private Restaurante[] arDatos;

    //Constructor para el adaptador de restaurante
    public RestauranteAdapter(@NonNull Context context, int resource, @NonNull Restaurante[] objects) {
        super(context, resource, objects);
        cApp = context;
        iLayoutRest = resource;
        arDatos = objects;
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
        //Se crea un arreglo que contendrá los datos obtenidos del constructor
        Restaurante rRestaurante = arDatos[i];
        //Se colocan los datos del arreglo en los elementos de la actividad
        imgVwRes2.setImageResource(rRestaurante.getImg());
        txtVwNom2.setText(rRestaurante.getNom());
        txtVwDesc2.setText(rRestaurante.getDesc());
        txtVwDirTel2.setText(rRestaurante.getDirtel());
        rbEval2.setProgress(rRestaurante.getCalif());
        //Devuelve el layout creado
        return vwLayRest;
    }
}
