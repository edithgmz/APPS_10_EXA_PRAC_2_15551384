package edith.example.imagen;
/*
 * Created by Edith on 07-Apr-19.
 */

public class Imagen {
    private int img;
    public static int current;

    //Constructor para añadir imagen
    public Imagen(int img) {
        this.img = img;
    }

    //Método para obtener la imagen
    public int getImg() {
        return img;
    }

    //Método para colocar la imagen
    public void setImg(int img) {
        this.img = img;
    }
}
