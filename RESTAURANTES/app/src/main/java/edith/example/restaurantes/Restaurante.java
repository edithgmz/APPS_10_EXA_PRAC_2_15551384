package edith.example.restaurantes;

import android.widget.ImageView;

public class Restaurante {
    private ImageView img;
    private String nombre;
    private String descripción;
    private byte calificación;//maximo 5, minimo 1


    public Restaurante(ImageView img, String nombre, String descripción, byte calificación){
        this.img = img;
        this.nombre = nombre;
        this.descripción = descripción;
        this.calificación = calificación;
    }

    public ImageView getImageView(){
        return img;
    }

    public String getNombre(){
        return nombre;
    }

    public String getDescripción(){
        return descripción;
    }

    public byte getCalificación() {
        return calificación;
    }
}
