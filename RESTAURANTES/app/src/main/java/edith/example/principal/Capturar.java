package edith.example.principal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import edith.example.datos.BaseDatos;
import edith.example.imagen.SelecImagen;

public class Capturar extends AppCompatActivity {
    private Intent inSelecImagen;
    private ImageView imgVwSeImg;
    private EditText edtTxtNom, edtTxtDesc, edtTxtDirTel;
    private int idImg = 0;
    //Controlador de base de datos
    private BaseDatos bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capturar);
        //Vincular los elementos de la actividad
        imgVwSeImg = findViewById(R.id.imgVwSeImg);
        edtTxtNom = findViewById(R.id.edtTxtNom);
        edtTxtDesc = findViewById(R.id.edtTxtDesc);
        edtTxtDirTel = findViewById(R.id.edtTxtDirTel);
        //Intento para la actividad SelecImagen
        inSelecImagen = new Intent(this, SelecImagen.class);
        //Si el intento tiene el extra IMAGEN se cambia el contenido del ImageView
        Intent inImg = getIntent();
        if (inImg.hasExtra("IMAGEN")) {
            imgVwSeImg.setImageResource(inImg.getIntExtra("IMAGEN", 0));
            idImg = inImg.getIntExtra("ID", 0);
        }
        //Iniciar controlador de la base de datos
        bd = new BaseDatos(this);
    }

    //Inicia la actividad para seleccionar imagen al presionar el ImageView
    public void selecImagen(View v) {
        startActivity(inSelecImagen);
    }

    public void guardar(View v) {
        String nom = edtTxtNom.getText().toString();
        String desc = edtTxtDesc.getText().toString();
        String dirtel = edtTxtDirTel.getText().toString();
        //Insertar registro en la base de datos
        bd.insertar(idImg, nom, desc, dirtel, 1);
        //Pone en blanco los EditText
        edtTxtNom.setText("");
        edtTxtDesc.setText("");
        edtTxtDirTel.setText("");
        Toast.makeText(this, "Registrado", Toast.LENGTH_SHORT).show();
    }
}
