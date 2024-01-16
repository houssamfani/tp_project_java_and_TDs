package TD3;

public class Ex4 {
    public static void main (String[] args){
        Batiment B=new Batiment("203 rue elfath");
        System.out.println(B.toString());
        Maison M=new Maison("447 rue elghdir",5);
        System.out.println(M.toString());
        Immeuble I=new Immeuble("103 Rue zaraba",12);
        System.out.println(I.toString());
    }
}
class Batiment{
    private String adresse;
    Batiment(){};
    Batiment(String adresse){
        this.adresse=adresse;
    }
    public String getAdresse(){
        return adresse;
    }
    public void setAdresse(String adresse){
        this.adresse=adresse;
    }

    @Override
    public String toString() {
        return "Batiment{" +
                "adresse='" + adresse + '\'' +
                '}';
    }
}
class Maison extends Batiment{
    private int nbChambres;
    Maison(){};
    Maison(String adresse,int nbChambres){
        super(adresse);
        this.nbChambres=nbChambres;
    }
    public int getNbChambres() {
        return nbChambres;
    }

    public void setNbChambres(int nbChambres) {
        this.nbChambres = nbChambres;
    }

    @Override
    public String toString() {
        return "Maison{" +
                "nbChambres=" + nbChambres +
                " adresse="+getAdresse()+ '}';
    }
}
class Immeuble extends Batiment{
    private int nbAppart;
    Immeuble(){};
    Immeuble(String adresse,int nbAppart){
        super(adresse);
        this.nbAppart=nbAppart;
    }

    public int getNbAppart() {
        return nbAppart;
    }

    public void setNbAppart(int nbAppart) {
        this.nbAppart = nbAppart;
    }

    @Override
    public String toString() {
        return "Immeuble{" +
                "nbAppart=" + nbAppart +
                "adresse="+getAdresse()+'}';
    }
}