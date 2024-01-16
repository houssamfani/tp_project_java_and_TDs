package lst.tpjava.controllers;

import lst.tpjava.tpPart1.Main;
import lst.tpjava.models.Filiere;
import lst.tpjava.services.DB;
import lst.tpjava.services.DepartementServices;
import lst.tpjava.services.EnseignantServices;
import lst.tpjava.services.FiliereServices;

public class FilliersController {

    public static void showMenu() {
        System.out.println("-------------------------[ Major Management ]---------------------------");

        System.out.println("\nChoose an operation:");
        System.out.println("1. Add a New Major");
        System.out.println("2. View Major List");
        System.out.println("3. Update or Delete a Major");
        System.out.println("4. Delete a Major");
        System.out.println("0. Return to Main Menu");

        int option = Main.getIntInput("Select an option: ");
        switch (option) {
            case 1:
                createFiliere();
                break;
            case 2:
                showFilieres();
                break;
            case 3:
                editFiliere();
                break;
            case 4:
                destroyFiliere();
                break;
            case 0:
                Main.showPrincipalMenu();
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
                showMenu();
        }
    }

    public static void showFilieres() {
        System.out.println("----- Viewing Major List -----");
        for (Filiere filiere : DB.filieres) {
            System.out.print("Id: " + filiere.getId());
            System.out.print(" | Major: " + filiere.getIntitule());
            if (!Main.isNull(filiere.getChef())) {
                System.out.print(" | Head of Major: " + filiere.getChef().getNom() + " " + filiere.getChef().getPrenom());
            }
            if (!Main.isNull(filiere.getDept())) {
                System.out.print(" | Department: " + filiere.getDept().getIntitule());
            }
            System.out.println("");
        }

        System.out.println("End of Major List");

    }

    public static void createFiliere() {
        System.out.println("----- Creating a New Major -----");
        String intitule = Main.getStringInput("Enter the major name:");
        EnseignantsController.showEnseignants();
        int idChef = Main.getIntInput("Select the head of major by id:");
        DepartementsController.showDepartements();
        int idDept = Main.getIntInput("Select a department by id:");
        FiliereServices.addFiliere(intitule, EnseignantServices.getEnsById(idChef), DepartementServices.getDeptById(idDept));
        showFilieres();
        System.out.println("Major created successfully!");
        showMenu();
    }

    public static void editFiliere() {
        System.out.println("----- Updating or Deleting a Major -----");
        showFilieres();
        int id = Main.getIntInput("Select a major by id:");
        String intitule = Main.getStringInput("Enter the new major name:");
        EnseignantsController.showEnseignants();
        int idChef = Main.getIntInput("Select the new head of major by id:");
        DepartementsController.showDepartements();
        int idDept = Main.getIntInput("Select a new department by id:");

        FiliereServices.updateFiliere(id, intitule, EnseignantServices.getEnsById(idChef), DepartementServices.getDeptById(idDept));

        System.out.println("Major updated successfully!");
        showFilieres();
    }

    public static void destroyFiliere() {
        System.out.println("----- Deleting a Major -----");
        showFilieres();
        int id = Main.getIntInput("Select a major by id:");
        FiliereServices.deleteFiliereById(id);
        System.out.println("Major deleted successfully!");
        showFilieres();
    }
}
