package lst.tpjava.controllers;

import lst.tpjava.tpPart1.Main;
import lst.tpjava.models.Departement;
import lst.tpjava.services.DB;
import lst.tpjava.services.DepartementServices;
import lst.tpjava.services.EnseignantServices;

public class DepartementsController {


    public static void showMenu(){
        System.out.println("-------------------------[ Département Management ]---------------------------");

        System.out.println("\nChoose an operation:");
        System.out.println("1. Add a New Department");
        System.out.println("2. Show Department List");
        System.out.println("3. Update or Delete a Department");
        System.out.println("4. Delete a Department");
        System.out.println("0. Exit to Main Menu");

        int option = Main.getIntInput("Select an option: ");
        switch(option) {
            case 1:
                createDepartement();
                break;
            case 2:
                showDepartements();
                break;
            case 3:
                editDepartement();
                break;
            case 4:
                destroyDepartement();
                break;
            default:
            System.out.println("Invalid option. Please choose a valid option.");
            showMenu();}
}
    public static void createDepartement() {
        System.out.println("----- Creating a New Department -----");
        String intitule = Main.getStringInput("Enter the department name:");
        EnseignantsController.showEnseignants();
        int id = Main.getIntInput("Select an instructor by id:");
        DepartementServices.addDept(intitule, EnseignantServices.getEnsById(id));
        showDepartements();
        System.out.println("Department created successfully!");
        showMenu();
    }

    public static void showDepartements() {
        System.out.println("----- Viewing Department List -----");
        for (Departement departement : DB.departements) {
            System.out.print("Id: " + departement.getId());
            System.out.print(" | Name: " + departement.getIntitule());
            if (!Main.isNull(departement.getChef())) {
                System.out.print(" | Head: " + departement.getChef().getNom() + " " + departement.getChef().getPrenom());
            }
            System.out.println("");
        }

        System.out.println("End of Department List");

    }

    public static void editDepartement() {
        System.out.println("----- Updating or Deleting a Department -----");
        showDepartements();
        int id = Main.getIntInput("Select a department by id:");
        String intitule = Main.getStringInput("Enter the new department name:");
        EnseignantsController.showEnseignants();
        int idEns = Main.getIntInput("Select an instructor by id:");

        DepartementServices.updateDept(id, intitule, EnseignantServices.getEnsById(idEns));

        System.out.println("Department updated successfully!");
        showDepartements();
    }

    public static void destroyDepartement() {
        System.out.println("----- Deleting a Department -----");
        showDepartements();
        int id = Main.getIntInput("Select a department by id:");
        DepartementServices.deleteDeptById(id);
        System.out.println("Department deleted successfully!");
        showDepartements();
    }
}