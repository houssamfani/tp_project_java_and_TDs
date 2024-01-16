package TD3;

public class EX7 {
    public static void main(String[] args){
        Patron patron=new Patron("boukiri","ayoub",4333);
        System.out.println(patron.toString());
        TravailleurComission travailleurComission=new TravailleurComission("ahmed","omar",4055,400,2);
       travailleurComission.gain();
        System.out.println(travailleurComission.toString());
        TravailleurHoraire travailleurHoraire=new TravailleurHoraire("amina","ahlam",300,3);
        travailleurHoraire.gain();
        System.out.println(travailleurHoraire.toString());
    }
}
abstract class Employe{
    private String nom;
    private String prenom;
    Employe(){};
    Employe(String nom,String prenom){
        this.nom=nom;
        this.prenom=prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
   public abstract double gain();
}
class Patron extends Employe{
    private double salaire;
    Patron(){ super();};
    Patron(String nom,String prenom,double salaire)
    {
        super(nom,prenom);
        this.salaire=salaire;
    }

    public double getSalaire() {
        return salaire;
    }

    @Override
    public String toString() {
        return "Patron{" +
                "salaire= " + salaire +
                "nom= "+getNom()+
                "prenom= "+getPrenom()+
                '}';
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    @Override
    public double gain() {
        return this.salaire;
    }
}
class TravailleurComission extends Employe{
    private double salaire;
    private double comission;
    private int quantite;
    TravailleurComission(){super();};
    TravailleurComission(String nom,String prenom,double salaire,double comission,int quantite){
        super(nom,prenom);
        this.salaire=salaire;
        this.comission=comission;
        this.quantite=quantite;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public double getComission() {
        return comission;
    }

    public void setComission(double comission) {
        this.comission = comission;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "TravailleurComission{" +
                "nom= "+getNom()+
                "prenom= "+getPrenom()+
                "salaire= " + salaire +
                ", comission= " + comission +
                ", quantite= " + quantite +
                ",gain= "+gain()+
                '}';
    }

    @Override
    public double gain() {
        return salaire+(comission*quantite);
    }
}
class TravailleurHoraire extends Employe{
    private double retribution;
    private int heure;
    TravailleurHoraire(){super();};
    TravailleurHoraire(String nom,String prenom,double retribution,int heure){
        super(nom,prenom);
        this.retribution=retribution;
        this.heure=heure;
    }

    public double getRetribution() {
        return retribution;
    }

    public void setRetribution(double retribution) {
        this.retribution = retribution;
    }

    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }

    @Override
    public double gain() {
        return retribution*heure;
    }

    @Override
    public String toString() {
        return "TravailleurHoraire{" +
                "nom= "+getNom()+
                "prenom= "+getPrenom()+
                "retribution= " + retribution +
                ", heure= " + heure +
                "gain= "+gain()+
                '}';
    }
}
