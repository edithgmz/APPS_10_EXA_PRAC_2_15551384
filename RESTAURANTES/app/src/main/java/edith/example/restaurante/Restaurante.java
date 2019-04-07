package edith.example.restaurante;

public class Restaurante {
    private int img;
    private String nom;
    private String desc;
    private String dirtel;
    private int calif; //máximo 3, mínimo 1

    //Constructor para añadir restaurante
    public Restaurante(int img, String nom, String desc, String dirtel, int calif) {
        this.img = img;
        this.nom = nom;
        this.desc = desc;
        this.dirtel = dirtel;
        this.calif = calif;
    }

    //Métodos para obtener los atributos del restaurante
    public int getImg() {
        return img;
    }
    public String getNom() {
        return nom;
    }
    public String getDesc() {
        return desc;
    }

    public void setImg(int img) {
        this.img = img;
    }
    public int getCalif() {
        return calif;
    }

    public String getDirtel() {
        return dirtel;
    }

    public void setDirtel(String dirtel) {
        this.dirtel = dirtel;
    }

    //Métodos para colocar los atributos del restaurante
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    public void setCalif(int calif) {
        this.calif = calif;
    }
}
