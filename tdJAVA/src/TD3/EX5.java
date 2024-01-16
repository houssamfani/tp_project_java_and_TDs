package TD3;

public class EX5 {
    public static void main(String[] args) {
        Vehicule car = new Vehicule(4);
        System.out.println("Nbpassager: " + car.getNbrPassager());

        Moto motorcycle = new Moto(2, 1);
        System.out.println("Nbpassager: " + motorcycle.getNbrPassager() + ", nbRoues " + motorcycle.getNbrRoues());

        Avion airplane = new Avion(150);
        System.out.println("Nbpassager: " + airplane.getNbrPassager() + ", nbMoteur: " + airplane.getNbrMoteur());

        Triporteur trike = new Triporteur(2);
        System.out.println("Nbpassager: " + trike.getNbrPassager() + ", nbRoues: " + trike.getNbrRoues());
    }
}

class Vehicule {
    private int nbrPassager;

    public Vehicule(int n) {
        this.nbrPassager = n;
    }

    public int getNbrPassager() {
        return nbrPassager;
    }
}

class Moto extends Vehicule {
    private int nbrRoues = 2;

    public Moto(int n, int nbrRoues) {
        super(n);
        this.nbrRoues = nbrRoues;
    }

    public Moto(int n) {
        super(n);
    }

    public int getNbrRoues() {
        return nbrRoues;
    }
}

class Avion extends Vehicule {
    private int nbrMoteur;

    public Avion(int nPr) {
        super(nPr);
    }

    public Avion(int nPr, int nbrMoteur) {
        this(nPr);
        this.nbrMoteur = nbrMoteur;
    }

    public int getNbrMoteur() {
        return nbrMoteur;
    }
}

class Triporteur extends Moto {
    public Triporteur(int n) {
        super(n, 3);
    }
}
