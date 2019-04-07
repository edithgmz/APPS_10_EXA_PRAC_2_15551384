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

    public RestauranteAdapter(@NonNull Context context, int resource, @NonNull Restaurante[] objects) {
        super(context, resource, objects);
        cApp = context;
        iLayoutRest = resource;
        arDatos = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        ImageView imgVwRes2;
        TextView txtVwNom2, txtVwDesc2;
        RatingBar rbEval2;

        View vwLayRest = convertView;

        if (vwLayRest == null) {
            LayoutInflater liCrearLayout = ((Activity) cApp).getLayoutInflater();
            vwLayRest = liCrearLayout.inflate(iLayoutRest, parent, false);
        }

        imgVwRes2 = vwLayRest.findViewById(R.id.imgVwRes2);
        txtVwNom2 = vwLayRest.findViewById(R.id.txtVwNom2);
        txtVwDesc2 = vwLayRest.findViewById(R.id.txtVwDesc2);
        rbEval2 = vwLayRest.findViewById(R.id.rbEval2);

        Restaurante rRestaurante = arDatos[position];

        imgVwRes2.setImageResource(rRestaurante.getImg());
        txtVwNom2.setText(rRestaurante.getNom());
        txtVwDesc2.setText(rRestaurante.getDesc());
        rbEval2.setProgress(rRestaurante.getCalif());

        return vwLayRest;
    }
}
