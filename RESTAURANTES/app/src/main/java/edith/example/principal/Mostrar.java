package edith.example.principal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import edith.example.restaurante.Detalle;
import edith.example.restaurante.Restaurante;
import edith.example.restaurante.RestauranteAdapter;

public class Mostrar extends AppCompatActivity implements ListView.OnItemClickListener {
    ListView lstVwRest;
    Intent inDetalle;
    Restaurante[] arRestaurantes = {
            new Restaurante(R.drawable.barrafina,
                    "Barra Fina",
                    "Restaurante Gourmet",
                    "Periférico de la Juventud #312 Distrito 1 Tel: 472-8500",
                    2),
            new Restaurante(R.drawable.bourkestreetbakery,
                    "Bourke Street Bakery",
                    "Pastelería y café",
                    "Barangaroo Avenue #4/23 Tel: 831-9468",
                    3),
            new Restaurante(R.drawable.cafedeadend,
                    "Cafe Deadend",
                    "Café",
                    "Po Hing Fong #72 Tel: 671-7005",
                    1)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        lstVwRest = findViewById(R.id.lstVwRest);
        lstVwRest.setAdapter(new RestauranteAdapter(this, R.layout.layout_restaurante, arRestaurantes));
        lstVwRest.setOnItemClickListener(this);

        inDetalle = new Intent(this, Detalle.class);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        Bundle bDatos = new Bundle();
        bDatos.putInt("IMG_REST", arRestaurantes[i].getImg());
        bDatos.putString("NOM_REST", arRestaurantes[i].getNom());
        bDatos.putString("DESC_REST", arRestaurantes[i].getDesc());
        bDatos.putString("DIRTEL_REST", arRestaurantes[i].getDirtel());
        bDatos.putInt("CALIF_REST", arRestaurantes[i].getCalif());
        inDetalle.putExtras(bDatos);
        startActivity(inDetalle);
    }
}
