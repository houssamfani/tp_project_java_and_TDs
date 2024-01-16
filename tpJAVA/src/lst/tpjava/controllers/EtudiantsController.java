package lst.tpjava.controllers;

import lst.tpjava.tpPart1.Main;
import lst.tpjava.models.Etudiant;
import lst.tpjava.services.DB;
import lst.tpjava.services.EtudiantServices;

public class EtudiantsController {

    public static void showMenu() {
        System.out.println("-------------------------[ Student Management ]---------------------------");

        System.out.println("\nChoose an operation:");
        System.out.println("1. Add a New Student");
        System.out.println("2. View Student List");
        System.out.println("3. Update or Delete a Student");
        System.out.println("4. Delete a Student");
        System.out.println("0. Return to Main Menu");

        int option = Main.getIntInput("Select an option: ");
        switch (option) {
            case 1:
                createEtudiant();
                break;
            case 2:
                showEtudiants();
                break;
            case 3:
                editEtudiant();
                break;
            case 4:
                destroyEtudiant();
                break;
            case 0:
                Main.showPrincipalMenu();
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
                showMenu();
        }
    }

    public static void showEtudiants() {
        System.out.println("----- Viewing Student List -----");
        for (Etudiant etudiant : DB.etudiants) {
            System.out.print("Id: " + etudiant.getId());
            System.out.print(" | Name: " + etudiant.getNom() + " " + etudiant.getPrenom());
            System.out.print(" | Email: " + etudiant.getEmail());
            System.out.print(" | Apogee: " + etudiant.getApogee());
            if (!Main.isNull(etudiant.getFiliere())) {
                System.out.print(" | Major: " + etudiant.getFiliere().getIntitule());
            }
            System.out.println("");
        }

        System.out.println("End of Student List");
    }

    public static void createEtudiant() {
        System.out.println("----- Creating a New Student -----");
        String nom = Main.getStringInput("Enter the student's last name:");
        String prenom = Main.getStringInput("Enter the student's first name:");
        String email = Main.getStringInput("Enter the student's email:");
        int apogee = Main.getIntInput("Enter the student's apogee:");
        FilliersController.showFilieres();
        int idFiliere = Main.getIntInput("Select a major by id:");
        EtudiantServices.addEtd(nom, prenom, email, apogee, DB.filieres.get(idFiliere));
        showEtudiants();
        System.out.println("Student created successfully!");
        showMenu();
    }

    public static void editEtudiant() {
        System.out.println("----- Updating or Deleting a Student -----");
        showEtudiants();
        int id = Main.getIntInput("Select a student by id:");
        String nom = Main.getStringInput("Enter the new last name:");
        String prenom = Main.getStringInput("Enter the new first name:");
        String email = Main.getStringInput("Enter the new email:");
        int apogee = Main.getIntInput("Enter the new apogee:");
        FilliersController.showFilieres();
        int idFiliere = Main.getIntInput("Select a major by id:");

        EtudiantServices.updateEtd(id, nom, prenom, email, apogee, DB.filieres.get(idFiliere));

        System.out.println("Student updated successfully!");
        showEtudiants();
    }

    public static void destroyEtudiant() {
        System.out.println("----- Deleting a Student -----");
        showEtudiants();
        int id = Main.getIntInput("Select a student by id:");
        EtudiantServices.deleteEtdById(id);
        System.out.println("Student deleted successfully!");
        showEtudiants();
    }
}
