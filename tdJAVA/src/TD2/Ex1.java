package TD2;

public class Ex1 {

    public static void main(String[] args) {

        point ptA = new point('A',7.0);


        // Affichage des caractéristiques initiales
        System.out.println("Caractéristiques initiales du point :");
        ptA.Affiche();

        // Translation du point
        double translationValue = 2.5;
        ptA.Translation(translationValue);

        // Affichage des caractéristiques après la translation
        System.out.println("Caractéristiques après translation de " + translationValue + " unités :");
        ptA.Affiche();

    }


    class point {

        public char name;
        public double absc;

        public point(char name, double absc) {
            this.name = name;
            this.absc = absc;
        }

        public void Affiche() {
            System.out.println("le point: " + name + " d'abscisse: " + absc);
        }

        public void Translation(double dx) {
            absc += dx;
        }

    }


}
