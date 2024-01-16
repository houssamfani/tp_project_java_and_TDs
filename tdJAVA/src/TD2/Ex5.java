package TD2;

public class Ex5 {
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle();
        Rectangle rectangle2 = new Rectangle(5.0, 7.0);
        Rectangle rectangle3 = new Rectangle(rectangle2);

         rectangle1.setLongueur(8.0);
        rectangle1.setLargeur(8.0);

         afficherCaracteristiques(rectangle1);
        afficherCaracteristiques(rectangle2);
        afficherCaracteristiques(rectangle3);
    }

    public static void afficherCaracteristiques(Rectangle rectangle) {
        System.out.println("Rectangle : " + rectangle);
        System.out.println("Périmètre : " + rectangle.perimetre());
        System.out.println("Aire : " + rectangle.aire());
        System.out.println("Est un carré : " + rectangle.isCarre());
        System.out.println();
    }
}

class Rectangle {
    private double longueur;
    private double largeur;

     public Rectangle() {
        this.longueur = 0.0;
        this.largeur = 0.0;
    }

     public Rectangle(double longueur, double largeur) {
        setLongueur(longueur);
        setLargeur(largeur);
    }

     public Rectangle(Rectangle autreRectangle) {
        this.longueur = autreRectangle.longueur;
        this.largeur = autreRectangle.largeur;
    }

     public double getLongueur() {
        return longueur;
    }

    public void setLongueur(double longueur) {
        if (longueur > 0) {
            this.longueur = longueur;
        } else {
            System.out.println("Erreur : La longueur doit être positive.");
        }
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        if (largeur > 0) {
            this.largeur = largeur;
        } else {
            System.out.println("Erreur : La largeur doit être positive.");
        }
    }

     public double perimetre() {
        return 2 * (longueur + largeur);
    }

    public double aire() {
        return longueur * largeur;
    }

    public boolean isCarre() {
        return longueur == largeur;
    }

     @Override
    public String toString() {
        return "Rectangle [longueur=" + longueur + ", largeur=" + largeur + "]";
    }
}
