package edith.example.principal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import edith.example.imagen.SelecImagen;

public class Capturar extends AppCompatActivity {
    private Intent inSelecImagen;
    private ImageView imgVwSeImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capturar);
        imgVwSeImg = findViewById(R.id.imgVwSeImg);
        //Intento para la actividad SelecImagen
        inSelecImagen = new Intent(this, SelecImagen.class);
        //Si el intento tiene el extra IMAGEN se cambia el contenido del ImageView
        Intent inImg = getIntent();
        if (inImg.hasExtra("IMAGEN")) {
            imgVwSeImg.setImageResource(inImg.getIntExtra("IMAGEN", 0));
        }
    }

    //Inicia la actividad para seleccionar imagen al presionar el ImageView
    public void selecImagen(View v) {
        startActivity(inSelecImagen);
    }

    public void guardar(View v) {
        Toast.makeText(this, "guardar", Toast.LENGTH_LONG).show();
    }
}
