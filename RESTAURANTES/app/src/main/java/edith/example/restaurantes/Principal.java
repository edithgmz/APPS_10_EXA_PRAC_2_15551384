package edith.example.restaurantes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Principal extends AppCompatActivity {
    private Intent inCapturar;
    private Intent inMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //Intento para la actividad Capturar
        inCapturar = new Intent(this, Capturar.class);
        //Intento para la actividad Mostrar
        inMostrar = new Intent(this, Mostrar.class);
    }

    public void menu(View view) {
        //Dependiendo del botón presionado se lanza una actividad o se cierra la aplicación
        switch (view.getId()){
            case R.id.btnCap:
                startActivity(inCapturar);
                break;
            case R.id.btnMos:
                startActivity(inMostrar);
                break;
            case R.id.btnSal:
                finish();
                break;
        }
    }
}
