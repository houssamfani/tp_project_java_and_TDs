package TD3;
public class Ex3 {
    public static void main(String[] args) {
        Cercle c1 = new Cercle( 3, 5,"a",45);

        c1.affiche();

        c1.affNom();


    }
}

class _Point {
    public _Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void affCoord() {
        System.out.println("Coordonnees : " + x + " " + y);
    }
    public void affiche() {
        System.out.println("Coordonnees : " + x + " " + y);
    }
    private int x, y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
class Centre extends _Point {
    private String nom;

    public String getNom() {
        return nom;
    }

    public Centre(String nom, int x, int y) {
        super(x, y);
        this.nom=nom;
    }


    public void affNom() {
        System.out.println("nom:"+this.nom);
    }

    public void affiche() {
        System.out.println("Point " + nom + " - Coordonnées : (" + getX() + ", " + getY() + ")");
    }
}
class Cercle extends Centre{
    private int rayon;
    public Cercle(int x,int y,String nom,int rayon){
        super(nom,x,y);
        this.rayon=rayon;
    }


    public void affiche() {

        System.out.println("rayon: "+rayon+" Point: " + getNom() + "  Coordonnées : (" + getX() + ", " + getY() + ")");
    }

}