package lst.tpjava.tpPart1;

import lst.tpjava.controllers.*;
import lst.tpjava.models.Enseignant;
import lst.tpjava.services.DB;

import java.util.Scanner;

public class Main {

    public static boolean isNull(Object ob) {
        return ob == null ;
    }
    public static int getIntInput(String... msg) {
        Scanner scan = new Scanner(System.in);
        String message = "Entrez un nombre entier : ";
        if (msg.length > 0 )
            message = msg[0] ;
        System.out.print(message);


        // This method reads the number provided using keyboard
        int num = scan.nextInt();

        // Closing Scanner after the use
      //  scan.close();
        return num;
    }

    public static String getStringInput(String... msg) {
        Scanner scan = new Scanner(System.in);
        String message = "Entrez un texte : ";
        if (msg.length > 0 )
            message = msg[0] ;
        System.out.print(message);

        // This method reads the number provided using keyboard
        String str = scan.nextLine();

        // Closing Scanner after the use
      //  scan.close();
        return str;
    }

    public static void showPrincipalMenu(){
        System.out.println("-------------------------[ Welcome ]---------------------------");


        System.out.println("1: to manage the 'Departements'");
        System.out.println("2: to manage the 'filières'");
        System.out.println("3: to manage the 'enseignants'");
        System.out.println("4: to manage the 'modules'");
        System.out.println("5: to manage the 'étudiants'");
        System.out.println("0: to exit");

        //"Veuillez sélectionner une option : ")
        int option = getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                DepartementsController.showMenu();
                break;
            case 2:
                FilliersController.showMenu();
                break;
            case 3:
                EnseignantsController.showMenu();
                break;
            case 4:
                ModulesController.showMenu();
                break;
            case 5:
                EtudiantsController.showMenu();
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
                showPrincipalMenu();
        }


    }
    public static void main(String[] args) {

        Enseignant enseignant = new Enseignant();
        enseignant.setNom("Amine");
        enseignant.setPrenom("Ben Charif");
        enseignant.setEmail("test@gmail.com");
        enseignant.setGrade("PES");
        enseignant.setId(DB.getEnsId());
        DB.enseignants.add(enseignant);
        showPrincipalMenu();
    }
}
