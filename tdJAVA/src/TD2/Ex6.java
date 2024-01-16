package TD2;

public class Ex6 {



    public static void main(String[] args) {
        Banque compte1=new Banque(1,5000.75f,"AB 1200");
        System.out.println(compte1.avoirInf());
        System.out.println(compte1.avoirSolde());
        compte1.deposer(500);
        System.out.println(compte1.avoirInf());
        System.out.println(compte1.avoirSolde());
        compte1.retirer(200);
        System.out.println(compte1.avoirInf());
        System.out.println(compte1.avoirSolde());



    }

}
class Banque {
    private int NCompte;
    private float solde;
    private String CIN;


    public Banque(int NCompte,float solde,String CIN){

        this.NCompte=NCompte;
        this.solde=solde;
        this.CIN=CIN;
    }

    public int getNCompte() {
        return NCompte;
    }

    public float getSolde() {
        return solde;
    }

    public String getCIN() {
        return CIN;
    }

    public void setNCompte(int NCompte) {
        this.NCompte = NCompte;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }



    public void deposer(float Somme){
        setSolde(getSolde()+Somme);
    }
    public void retirer(float Somme){
        setSolde(getSolde()-Somme);
    }
    public float avoirSolde(){
        return getSolde();
    }
    public String avoirInf(){
        String inf ="NCompte="+getNCompte()+" CIN="+getCIN();
        return inf;
    }




}