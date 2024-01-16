package TD2;

public class Ex3 {



    public static void main(String[] args) {
        Livre L1=new Livre("ice&fire","abdo",150,2004);
        System.out.println(L1);

    }

}
class Livre {
    private String titre;
    private String auteur;
    private double prix;
    private int annee;
    public Livre(){}
    public Livre(String titre){
        this.titre=titre;
    }
    public Livre(String titre,String auteur){
        this.titre=titre;
        this.auteur=auteur;
    }
    public Livre(String titre,String auteur,double prix){
        this.titre=titre;
        this.auteur=auteur;
        this.prix=prix;
    }
    public Livre(String titre,String auteur,double prix,int annee){
        this.titre=titre;
        this.auteur=auteur;
        this.prix=prix;
        this.annee=annee;
    }
    public String getTitre(){
        return titre;
    }
    public void setTitre(String titre){
        this.titre=titre;
    }
    public String getAuteur(){
        return auteur;
    }
    public void setAuteur(String auteur){
        this.auteur=auteur;

    } public double getPrix(){
        return prix;
    }
    public void setPrix(double  prix){
        this.prix=prix;
    } public int getAnnee(){
        return annee;
    }
    public void setAnnee(int annee){
        this.annee=annee;
    }
    @Override
    public String toString() {
        return "Livre{" +
                "titre=" + getTitre() +
                ", auteur=" + getAuteur() +
                ", prix=" + getPrix() +
                ", annee=" + getAnnee() + '}';
    }
}