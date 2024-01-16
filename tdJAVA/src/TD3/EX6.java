package TD3;

public class EX6 {
    public static void main(String[] args){
        Rectangle rectangle=new Rectangle(4,2,"rectangle A");
        rectangle.getNom();
        rectangle.getPerimetre();
        rectangle.getAire();
        System.out.println(rectangle.toString());
        Disque disque=new Disque(2,4,"disque A");
        disque.getNom();
        disque.getPerimetre();
        disque.getAire();
        System.out.println(disque.toString());

    }
}
abstract class Figure{
    private String nom;
    Figure(){};
    Figure(String nom){
        this.nom=nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public abstract double getPerimetre();
    public abstract double getAire();
    public abstract String toString();
}
class Disque extends Figure{
    private double rayon;
    private double centre;
    Disque(){};
    Disque (double centre,double rayon){
        this.centre=centre;
        this.rayon=rayon;
    }
    Disque(double centre,double rayon,String nom){
        super(nom);
        this.centre=centre;
        this.rayon=rayon;
    }

    public double getRayon() {
        return rayon;
    }

    public void setRayon(double rayon) {
        this.rayon = rayon;
    }

    public double getCentre() {
        return centre;
    }

    public void setCentre(double centre) {
        this.centre = centre;
    }

    @Override
    public double getPerimetre() {
        return 2*Math.PI*rayon;
    }
    public double getAire(){
        return rayon*rayon*Math.PI;
    }
    public String toString(){
        return "Disque{ nom: "+getNom()+
                "centre :"+centre+
                "rayon :"+rayon+
                "nom:"+getNom()+
                "perimetre="+getPerimetre()+
                "aire="+getAire()+
                "}";
    }
}
class Rectangle extends Figure{
    private double longueur;
    private double largeur;
    Rectangle(){};
    Rectangle(double longueur,double largeur){
        this.longueur=longueur;
        this.largeur=largeur;
    }
    Rectangle(double longueur,double largeur,String Nom){
        super(Nom);
        this.longueur=longueur;
        this.largeur=largeur;
    }

    public double getLongueur() {
        return longueur;
    }

    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    @Override
    public double getPerimetre() {
        return 2*(longueur+largeur);
    }

    @Override
    public double getAire() {
        return longueur*largeur;
    }

    @Override
    public String toString() {
        return "Rectangle{ longueur="+longueur+
                "largeur="+largeur+
                "nom:"+getNom()+
                "perimetre="+getPerimetre()+
                "aire="+getAire()+
                "}";
    }
}
