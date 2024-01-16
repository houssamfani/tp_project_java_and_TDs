package lst.tpjava.tpPart2.controllers;

import lst.tpjava.tpPart2.Main;
import lst.tpjava.tpPart2.services.DepartementServices;
import lst.tpjava.controllers.EnseignantsController;
import lst.tpjava.models.Departement;
import lst.tpjava.services.EnseignantServices;

import java.util.ArrayList;

public class DepartementsController {

    private DepartementServices departementServices;

    public DepartementsController(DepartementServices departementServices) {
        this.departementServices = departementServices;
    }

    public void showMenu() {
        while (true) {
            System.out.println("-------------------------[ Departement ]---------------------------");
            System.out.println("1. Add");
            System.out.println("2. Show List");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("0. Exit");

            int option = Main.getIntInput("Select an option: ");
            switch (option) {
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
                case 0:
                    showMenu();
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public void showDepartements() {
        ArrayList<Departement> departements = departementServices.getAllDept();
        for (Departement departement : departements) {
            System.out.print("Id: " + departement.getId());
            System.out.print(" | Intitulé: " + departement.getIntitule());
            if (!Main.isNull(departement.getChef())) {
                System.out.print(" | Chef: " + departement.getChef().getNom() + " " + departement.getChef().getPrenom());
            }
            System.out.println("");
        }
    }

    public void createDepartement() {
        String intitule = Main.getStringInput("Enter an intitule :");
        EnseignantsController.showEnseignants();
        int id = Main.getIntInput("select a 'enseignant' with id :");
        departementServices.addDept(intitule, EnseignantServices.getEnsById(id));

        showDepartements();
        showMenu();
    }

    public void editDepartement() {
        showDepartements();
        int id = Main.getIntInput("select a 'departement' with id :");
        String intitule = Main.getStringInput("Enter an intitule :");
        EnseignantsController.showEnseignants();
        int idEns = Main.getIntInput("select a 'enseignant' with id :");

        departementServices.updateDept(id, intitule, EnseignantServices.getEnsById(idEns));

        showDepartements();
        showMenu();
    }

    public void destroyDepartement() {
        showDepartements();
        int id = Main.getIntInput("select a 'departement' with id :");
        departementServices.deleteDeptById(id);
        showDepartements();
    }
}
