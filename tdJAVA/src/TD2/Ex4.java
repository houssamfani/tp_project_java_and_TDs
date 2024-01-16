package TD2;

public class Ex4 {
    public static void main(String[] args) {
        Temps temps1 = new Temps();
        Temps temps2 = new Temps(12);
        Temps temps3 = new Temps(8, 30);
        Temps temps4 = new Temps(14, 45, 30);

        Temps temps5 = new Temps(temps4);

        temps1.ajouterHeures(3);
        temps2.ajouterMinutes(45);
        temps3.ajouterSecondes(120);

        System.out.println("Temps 1 : " + temps1);
        System.out.println("Temps 2 : " + temps2);
        System.out.println("Temps 3 : " + temps3);
        System.out.println("Temps 4 : " + temps4);
        System.out.println("Temps 5 (copie de Temps 4) : " + temps5);
    }
}

class Temps {
    private int heures;
    private int minutes;
    private int secondes;

    public Temps() {
        this.heures = 0;
        this.minutes = 0;
        this.secondes = 0;
    }

    public Temps(int heures) {
        this.heures = heures;
        this.minutes = 0;
        this.secondes = 0;
    }

    public Temps(int heures, int minutes) {
        this.heures = heures;
        this.minutes = minutes;
        this.secondes = 0;
    }

    public Temps(int heures, int minutes, int secondes) {
        this.heures = heures;
        this.minutes = minutes;
        this.secondes = secondes;
    }

     public Temps(Temps autreTemps) {
        this.heures = autreTemps.heures;
        this.minutes = autreTemps.minutes;
        this.secondes = autreTemps.secondes;
    }

     public void ajouterHeures(int heures) {
        this.heures += heures;
        this.heures %= 24;
    }

    public void ajouterMinutes(int minutes) {
        this.minutes += minutes;
        ajouterHeures(this.minutes / 60);
        this.minutes %= 60;
    }

    public void ajouterSecondes(int secondes) {
        this.secondes += secondes;
        ajouterMinutes(this.secondes / 60);
        this.secondes %= 60;
    }

     @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", heures, minutes, secondes);
    }
}
