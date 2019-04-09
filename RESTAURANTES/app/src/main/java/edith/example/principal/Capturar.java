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
    //Variables para seleccionar imagen según id obtenido
    private int idImg;
    private int img;
    private int imagen;
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
        //Se obtienen los atributos del intento y se colocan en los elementos de la actividad
        Intent inImg = getIntent();
        if (inImg.hasExtra("IMAGEN") && inImg.hasExtra("ID")) {
            imgVwSeImg.setImageResource(inImg.getIntExtra("IMAGEN", 0));
            idImg = inImg.getIntExtra("ID", 0);
        }
        imagen = inImagen(idImg);
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
        bd.insertar(imagen, nom, desc, dirtel, 1);
        //Pone en blanco los EditText
        edtTxtNom.setText("");
        edtTxtDesc.setText("");
        edtTxtDirTel.setText("");
        Toast.makeText(this, "Registrado", Toast.LENGTH_SHORT).show();
    }

    //Método para seleccionar la imagen según el id obtenido del intento
    public int inImagen(int id) {
        switch (id) {
            case 10:
                img = R.drawable.barrafina;
                break;
            case 11:
                img = R.drawable.bourkestreetbakery;
                break;
            case 12:
                img = R.drawable.cafedeadend;
                break;
            case 13:
                img = R.drawable.cafeloisl;
                break;
            case 14:
                img = R.drawable.cafelore;
                break;
            case 15:
                img = R.drawable.confessional;
                break;
            case 16:
                img = R.drawable.donostia;
                break;
            case 17:
                img = R.drawable.fiveleaves;
                break;
            case 18:
                img = R.drawable.forkeerestaurant;
                break;
            case 19:
                img = R.drawable.grahamavenuemeats;
                break;
            case 20:
                img = R.drawable.haighschocolate;
                break;
            case 21:
                img = R.drawable.homei;
                break;
            case 22:
                img = R.drawable.palominoespresso;
                break;
            case 23:
                img = R.drawable.petiteoyster;
                break;
            case 24:
                img = R.drawable.posatelier;
                break;
            case 25:
                img = R.drawable.royaloak;
                break;
            case 26:
                img = R.drawable.teakha;
                break;
            case 27:
                img = R.drawable.thaicafe;
                break;
            case 28:
                img = R.drawable.traif;
                break;
            case 29:
                img = R.drawable.upstate;
                break;
            case 30:
                img = R.drawable.wafflewolf;
                break;
        }
        return img;
    }
}
