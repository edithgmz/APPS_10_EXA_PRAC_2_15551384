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
            new Imagen(R.drawable.barrafina, 10),
            new Imagen(R.drawable.bourkestreetbakery, 11),
            new Imagen(R.drawable.cafedeadend, 12),
            new Imagen(R.drawable.cafeloisl, 13),
            new Imagen(R.drawable.cafelore, 14),
            new Imagen(R.drawable.confessional, 15),
            new Imagen(R.drawable.donostia, 16),
            new Imagen(R.drawable.fiveleaves, 17),
            new Imagen(R.drawable.forkeerestaurant, 18),
            new Imagen(R.drawable.grahamavenuemeats, 19),
            new Imagen(R.drawable.haighschocolate, 20),
            new Imagen(R.drawable.homei, 21),
            new Imagen(R.drawable.palominoespresso, 22),
            new Imagen(R.drawable.petiteoyster, 23),
            new Imagen(R.drawable.posatelier, 24),
            new Imagen(R.drawable.royaloak, 25),
            new Imagen(R.drawable.teakha, 26),
            new Imagen(R.drawable.thaicafe, 27),
            new Imagen(R.drawable.traif, 28),
            new Imagen(R.drawable.upstate, 29),
            new Imagen(R.drawable.wafflewolf, 30)
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

    //Al seleccionar una imagen se coloca en un Extra junto con su id y se envía a la actividad Capturar
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        inCapturar.putExtra("IMAGEN", aimImagenes[i].getImg());
        inCapturar.putExtra("ID", aimImagenes[i].getId());
        startActivity(inCapturar);
    }
}
