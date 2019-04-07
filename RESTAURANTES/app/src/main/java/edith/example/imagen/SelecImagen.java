package edith.example.imagen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import edith.example.principal.Capturar;
import edith.example.principal.R;

public class SelecImagen extends AppCompatActivity implements ListView.OnItemClickListener {
    private ListView lstVwImgs;
    private Intent inCapturar;
    //Arreglo con las imagenes seleccionables
    private Imagen[] aimImagenes = {
            new Imagen(R.drawable.barrafina),
            new Imagen(R.drawable.bourkestreetbakery),
            new Imagen(R.drawable.cafedeadend),
            new Imagen(R.drawable.cafeloisl),
            new Imagen(R.drawable.cafelore),
            new Imagen(R.drawable.confessional),
            new Imagen(R.drawable.donostia),
            new Imagen(R.drawable.fiveleaves),
            new Imagen(R.drawable.forkeerestaurant),
            new Imagen(R.drawable.grahamavenuemeats),
            new Imagen(R.drawable.haighschocolate),
            new Imagen(R.drawable.homei),
            new Imagen(R.drawable.palominoespresso),
            new Imagen(R.drawable.petiteoyster),
            new Imagen(R.drawable.posatelier),
            new Imagen(R.drawable.royaloak),
            new Imagen(R.drawable.teakha),
            new Imagen(R.drawable.thaicafe),
            new Imagen(R.drawable.traif),
            new Imagen(R.drawable.upstate),
            new Imagen(R.drawable.wafflewolf)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selec_imagen);
        //Se vincula la lista, agrega el adaptador y el listener
        lstVwImgs = findViewById(R.id.lstVwImgs);
        lstVwImgs.setAdapter(new ImagenAdapter(this, R.layout.layout_imagenes, aimImagenes));
        lstVwImgs.setOnItemClickListener(this);
        //Intento para la actividad Capturar
        inCapturar = new Intent(this, Capturar.class);
    }

    //Al seleccionar una imagen se coloca en un Extra y se envía a la actividad Capturar
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        inCapturar.putExtra("IMAGEN", aimImagenes[i].getImg());
        startActivity(inCapturar);
    }
}
