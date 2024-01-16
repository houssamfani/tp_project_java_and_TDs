package TD1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


 //TD1_conditions

        //EX1
/*        System.out.println("Entrer 3 entiers :");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        System.out.println("le max est: " + Math.max(a,b));  */



     /*   int max = 0 , pos =1 ;
        for (int i=1;i<=5;i++) {

          int n = scanner.nextInt();

          if (n >= max) { max = n; pos=i; }

        }

        System.out.println("max = "+ max + "    posmax = "+pos );   */



 /*       int a =scanner.nextInt();
        int b =scanner.nextInt();
        int pgcd=1;

        for (int i=1;i<= Math.min(a,b);i++)
            {  if (a%i==0 && b%i==0) pgcd=i; }


        System.out.println("pgcd ="+ pgcd);                */



 /*       int n = scanner.nextInt();
        int u0 = 1, u1 = 1, un=0;

        if (n == 0 || n == 1) System.out.println("u0=u1= 1");

        else
            System.out.print("1 1 ");
            for (int i = 2; i <= n+1; i++) {
            un = u1 + u0;
            u0 = u1;
            u1 = un;

            System.out.print(un +" "); }             */



      /*    for (int i=1;i<=9;i++)
              for (int j=1;j<=9;j++)
                  for (int k=1;k<=9;k++)
                  {   if (i+j+k==15) System.out.println(i+" "+j+" "+k); }   */



/*          int n=scanner.nextInt();

           for (int i=1;i<=n;i++)
           {  for (int j=1;j<=i;j++)
                  { System.out.print("*"); }

               System.out.println();  }

        for (int i=n-1;i>=1;i--)
        {  for (int j=1;j<=i;j++)
               { System.out.print("*"); }

            System.out.println();  }              */



/*       int n=scanner.nextInt() , k=0 ;

        System.out.print(n%10 +" ");

        do {
             k=k+ n%10;

             n=n/10;

             System.out.print(n%10 +" ");

        } while (n!=0);

        System.out.print(" = "+ k);                 */



 /*       for (int i=1;i<=9;i++)
            for (int j=0;j<=9;j++)
                for (int k=0;k<=9;k++)
                {
                    if (Math.pow(i,3)+Math.pow(j,3)+Math.pow(k,3)==(i*100)+(j*10)+k)

                        System.out.println(i+" "+j+" "+k); }
                                                                                            */


/*        int t[] = new int[5];
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            t[i] = r.nextInt(100);
            System.out.println("t["+i+"] : "+ t[i]); }

        int max=t[0];
        int min=t[0];
        for (int i = 0; i < 5; i++) {
            if (t[i]<= min) min=t[i];
            if (t[i]>= max) max=t[i]; }

        System.out.println("max= "+max +"   min= "+min );        */



    /*    int t[] = new int[10];
        Random r = new Random();
        for (int i = 0; i < t.length; i++) {
            t[i] = r.nextInt(20);
            System.out.println("t["+i+"] : "+ t[i]); }

            int c=0;
            for (int i = 0; i < t.length; i++) { if(t[i]>=10) c++;  }
            System.out.println();
            System.out.println(c +" qui ont validé");             */



    /*        int n=scanner.nextInt();
            int t[] = new int[30];
            int c=0;
            for(int i = 0; i < t.length; i++) {

                t[i]= n%2;

                n=n/2;

                if (n==0) break; c++; }

            for(int i = c; i >= 0; i--) { System.out.print(t[i] +" ");  }         */


/*        int n=scanner.nextInt();
        int t[][] = new int[n][n];
        int v[][] = new int[n][n];
        Random r = new Random();
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t.length; j++) {
                 t[i][j] = r.nextInt(10);
                 v[i][j] = r.nextInt(10);

            System.out.print(t[i][j]+"  ");  }

            System.out.println();   }

        System.out.println();

            for (int i = 0; i < t.length; i++) {
                for (int j = 0; j < t.length; j++) {

                    System.out.print(v[i][j]+"  ");  }

                    System.out.println();   }


        System.out.println("la matrice somme");
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t.length; j++) {

                System.out.print(v[i][j]+t[i][j]+"  ");  }

            System.out.println();   }                                */


/*        int n=scanner.nextInt();
        String t[] = new String[8];
        Random r = new Random();
        for(int i = 0; i < t.length; i++) {

            t[i]= scanner.next();
            System.out.print(t[i]+" ");

            t[0]=t[n-1];
            t[i]=t[i+1];

            System.out.print(t[i]+" ");   }                 */




    }
}