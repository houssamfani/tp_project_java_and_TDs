package TD3;

public class Ex1 {



    public static void main(String[] args) {
        PointA p1 = new PointA(3,5);
        p1.affiche();
    }


}
class Point {
    public  Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void deplace(int dx, int dy) {
        x += dx;
        y += dy;
    }
    public int getX() {

        return x;
    }
    public int getY() {
        return y;
    }
    private int x, y;
}
class PointA extends Point_ {
    public PointA(int x , int y ){

        super(x,y);
    }


    public void affiche(){
        System.out.println("Point:("+getX()+","+getY()+")");
    }
}