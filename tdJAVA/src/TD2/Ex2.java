package TD2;

public class Ex2 {

    public static void main(String[] args) {
        Point p1=new Point();
        p1.setNom('A');
        p1.setX(-46);
        p1.setY(5);

        System.out.println("nom="+p1.getNom()+"  coordonnee=("+p1.getX()+','+p1.getY()+')');
        System.out.println("la norme de "+p1.getNom()+"est "+p1.norme());

    }

}
 class Point {
    private char nom;
    private double x;
    private double y;
    public char getNom(){
        return this.nom;
    }
    public void setNom(char nom){
        this.nom=nom;
    }
    public double getX(){
        return this.x;
    }
    public void setX(double x){
        this.x=x;
    }
    public double getY(){
        return this.y;
    }
    public void setY(double y){
        this.y=y;
    }
    public double norme(){
        double d=x*x+y*y;

        return Math.sqrt(d);
    }


}