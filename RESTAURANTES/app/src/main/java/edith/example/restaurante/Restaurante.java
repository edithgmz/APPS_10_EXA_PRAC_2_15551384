package edith.example.restaurante;

public class Restaurante {
    private int img;
    private String nom;
    private String desc;
    private String dirtel;
    private int calif; //máximo 3, mínimo 1


    public Restaurante(int img, String nom, String desc, String dirtel, int calif) {
        this.img = img;
        this.nom = nom;
        this.desc = desc;
        this.calif = calif;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDirtel() {
        return desc;
    }

    public void setDirtel(String desc) {
        this.desc = desc;
    }

    public int getCalif() {
        return calif;
    }

    public void setCalif(int calif) {
        this.calif = calif;
    }
}
