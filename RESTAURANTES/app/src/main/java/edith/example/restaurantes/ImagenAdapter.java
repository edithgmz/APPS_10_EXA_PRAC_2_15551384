package edith.example.restaurantes;
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

public class ImagenAdapter extends ArrayAdapter<Imagen> {
    private Context cApp;
    private int iLayImg;
    private Imagen[] aiDatos;

    public ImagenAdapter(Context context, int resource, Imagen[] objects) {
        super(context, resource, objects);
        cApp = context;
        iLayImg = resource;
        aiDatos = objects;
    }

    @NonNull
    @Override
    public View getView(int i, @Nullable View convertView, @NonNull ViewGroup parent) {
        ImageView imgVwSeImg2;
        View vwLayImg = convertView;
        //Si el layout no existe lo crea
        if (vwLayImg == null) {
            LayoutInflater liCreaLayout = ((Activity) cApp).getLayoutInflater();
            vwLayImg = liCreaLayout.inflate(iLayImg, parent, false);
        }
        //Se vincula el ImageView, se obtiene la imagen del arreglo y se coloca en el ImageView
        imgVwSeImg2 = vwLayImg.findViewById(R.id.imgVwSeImg2);
        Imagen imImagen = aiDatos[i];
        imgVwSeImg2.setImageResource(imImagen.getImg());
        //Devuelve el layout creado
        return vwLayImg;
    }
}
