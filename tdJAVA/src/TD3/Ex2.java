package TD3;

public class Ex2 {
    public static void main(String[] args) {
        PointNom pointNom = new PointNom("A", 3, 5);

        pointNom.affCoordNom();

        pointNom.setPointNom("F", 6,2);
        pointNom.affCoordNom();
        pointNom.setNom("L");

        pointNom.affCoordNom();

    }
}

class Point_ {
    private int x, y;

    public Point_(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void deplace(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public void affCoord() {
        System.out.println("Coordonnees : " + x + " " + y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}

class PointNom extends Point_ {
    private String nom;

    public PointNom(String nom, int x, int y) {
        super(x, y);
        this.nom = nom;
    }
    public void setPointNom(String nom, int x, int y) {
        this.nom = nom;
        setX(x);
        setY(y);
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public void affCoordNom() {
        System.out.println("Point " + nom + " - Coordonnées : (" + getX() + ", " + getY() + ")");
    }
}

