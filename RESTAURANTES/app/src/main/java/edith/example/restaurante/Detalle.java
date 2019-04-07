package edith.example.restaurante;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import edith.example.principal.R;

public class Detalle extends AppCompatActivity {
    RatingBar rbEval;
    private ImageView imgVwRes;
    private TextView txtVwNom, txtVwDesc, txtVwDirTel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        //Se vinculan los elementos de la actividad
        imgVwRes = findViewById(R.id.imgVwRes);
        txtVwNom = findViewById(R.id.txtVwNom);
        txtVwDesc = findViewById(R.id.txtVwDesc);
        txtVwDirTel = findViewById(R.id.txtVwDirTel);
        rbEval = findViewById(R.id.rbEval);
        //Se obtienen los atributos del intento y se colocan en los elementos de la actividad
        Intent inDatos = getIntent();
        Bundle bDatos = inDatos.getExtras();
        if (bDatos != null) {
            imgVwRes.setImageResource(bDatos.getInt("IMG_REST"));
            txtVwNom.setText(bDatos.getString("NOM_REST"));
            txtVwDesc.setText(bDatos.getString("DESC_REST"));
            txtVwDirTel.setText(bDatos.getString("DIRTEL_REST"));
            rbEval.setProgress(bDatos.getInt("CALIF_REST"));
        }
    }

    public void guardar(View v) {
        Toast.makeText(this, "guardar", Toast.LENGTH_LONG).show();
    }
}
