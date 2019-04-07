package edith.example.restaurantes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void botonazo(View view) {
        switch (view.getId()){
            case R.id.btnCap:
                Toast.makeText(this,"captura",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnMos:
                Toast.makeText(this, "mostrar",Toast.LENGTH_LONG).show();
                break;
            case R.id.btnSal:
                Toast.makeText(this,"salir",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
