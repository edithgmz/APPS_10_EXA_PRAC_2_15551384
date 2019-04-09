package edith.example.imagen;
/*
 * Created by Edith on 07-Apr-19.
 */

public class Imagen {
    private int img;
    public int id;

    //Constructor para añadir imagen y id
    Imagen(int img, int id) {
        this.img = img;
        this.id = id;
    }

    //Métodos para obtener la imagen y un id
    int getImg() {
        return img;
    }

    public int getId() {
        return id;
    }

    //Método para colocar un id
    public void setId(int id) {
        this.id = id;
    }
}
