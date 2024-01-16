package lst.tpjava.controllers;

import lst.tpjava.tpPart1.Main;
import lst.tpjava.models.Enseignant;
import lst.tpjava.services.DB;
import lst.tpjava.services.EnseignantServices;

public class EnseignantsController {

    public static void showMenu() {
        System.out.println("----------[ Teacher Management ]----------");

        System.out.println("\nChoose an operation:");
        System.out.println("1. Add a New Teacher");
        System.out.println("2. View Teacher List");
        System.out.println("3. Update or Delete a Teacher");
        System.out.println("4. Delete a Teacher");
        System.out.println("0. Return to Main Menu");

        int option = Main.getIntInput("Select an option: ");
        switch (option) {
            case 1:
                createEnseignant();
                break;
            case 2:
                showEnseignants();
                break;
            case 3:
                editEnseignant();
                break;
            case 4:
                destroyEnseignant();
                break;
            case 0:
                Main.showPrincipalMenu();
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
                showMenu();
        }
    }

    public static void showEnseignants() {
        System.out.println("----- Viewing Teacher List -----");
        for (Enseignant enseignant : DB.enseignants) {
            System.out.print("Id: " + enseignant.getId());
            System.out.print(" | Name: " + enseignant.getNom() + " " + enseignant.getPrenom());
            System.out.print(" | Email: " + enseignant.getEmail());
            System.out.print(" | Grade: " + enseignant.getGrade());
            if (!Main.isNull(enseignant.getDept())) {
                System.out.print(" | Department: " + enseignant.getDept().getIntitule());
            }
            System.out.println("");
        }

        System.out.println("End of Teacher List");

    }

    public static void createEnseignant() {
        System.out.println("----- Creating a New Teacher -----");
        String nom = Main.getStringInput("Enter the teacher's last name:");
        String prenom = Main.getStringInput("Enter the teacher's first name:");
        String email = Main.getStringInput("Enter the teacher's email:");
        String grade = Main.getStringInput("Enter the teacher's grade:");
        DepartementsController.showDepartements();
        int idDept = Main.getIntInput("Select a department by id:");
        EnseignantServices.addEns(nom, prenom, email, grade, DB.departements.get(idDept));
        showEnseignants();
        System.out.println("Teacher created successfully!");
        showMenu();
    }

    public static void editEnseignant() {
        System.out.println("----- Updating or Deleting a Teacher -----");
        showEnseignants();
        int id = Main.getIntInput("Select a teacher by id:");
        String nom = Main.getStringInput("Enter the new last name:");
        String prenom = Main.getStringInput("Enter the new first name:");
        String email = Main.getStringInput("Enter the new email:");
        String grade = Main.getStringInput("Enter the new grade:");
        DepartementsController.showDepartements();
        int idDept = Main.getIntInput("Select a department by id:");

        EnseignantServices.updateEns(id, nom, prenom, email, grade, DB.departements.get(idDept));

        System.out.println("Teacher updated successfully!");
        showEnseignants();
    }

    public static void destroyEnseignant() {
        System.out.println("----- Deleting a Teacher -----");
        showEnseignants();
        int id = Main.getIntInput("Select a teacher by id:");
        EnseignantServices.deleteEnsById(id);
        System.out.println("Teacher deleted successfully!");
        showEnseignants();
    }
}
