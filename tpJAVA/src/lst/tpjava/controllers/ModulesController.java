package lst.tpjava.controllers;

import lst.tpjava.tpPart1.Main;
import lst.tpjava.models.Module;
import lst.tpjava.services.DB;
import lst.tpjava.services.EnseignantServices;
import lst.tpjava.services.ModuleServices;

public class ModulesController {

    public static void showMenu() {
        System.out.println("-------------------------[ Module Management ]---------------------------");

        System.out.println("\nChoose an operation:");
        System.out.println("1. Add a New Module");
        System.out.println("2. View Module List");
        System.out.println("3. Update or Delete a Module");
        System.out.println("4. Delete a Module");
        System.out.println("0. Return to Main Menu");

        int option = Main.getIntInput("Select an option: ");
        switch (option) {
            case 1:
                createModule();
                break;
            case 2:
                showModules();
                break;
            case 3:
                editModule();
                break;
            case 4:
                destroyModule();
                break;
            case 0:
                Main.showPrincipalMenu();
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
                showMenu();
        }
    }

    public static void showModules() {
        System.out.println("----- Viewing Module List -----");
        for (Module module : DB.modules) {
            System.out.print("Id: " + module.getId());
            System.out.print(" | Module: " + module.getIntitule());
            if (!Main.isNull(module.getChef())) {
                System.out.print(" | Instructor: " + module.getChef().getNom() + " " + module.getChef().getPrenom());
            }
            if (!Main.isNull(module.getFiliere())) {
                System.out.print(" | Major: " + module.getFiliere().getIntitule());
            }
            System.out.println("");
        }

        System.out.println("End of Module List");

    }

    public static void createModule() {
        System.out.println("----- Creating a New Module -----");
        String intitule = Main.getStringInput("Enter the module's name:");
        EnseignantsController.showEnseignants();
        int idEns = Main.getIntInput("Select an instructor by id:");
        FilliersController.showFilieres();
        int idFiliere = Main.getIntInput("Select a major by id:");

        ModuleServices.addFiliere(intitule, EnseignantServices.getEnsById(idEns), DB.filieres.get(idFiliere));
        showModules();
        System.out.println("Module created successfully!");
        showMenu();
    }

    public static void editModule() {
        System.out.println("----- Updating or Deleting a Module -----");
        showModules();
        int id = Main.getIntInput("Select a module by id:");
        String intitule = Main.getStringInput("Enter the new module name:");
        EnseignantsController.showEnseignants();
        int idEns = Main.getIntInput("Select a new instructor by id:");
        FilliersController.showFilieres();
        int idFiliere = Main.getIntInput("Select a new major by id:");

        ModuleServices.updateFiliere(id, intitule, EnseignantServices.getEnsById(idEns), DB.filieres.get(idFiliere));

        System.out.println("Module updated successfully!");
        showModules();
    }

    public static void destroyModule() {
        System.out.println("----- Deleting a Module -----");
        showModules();
        int id = Main.getIntInput("Select a module by id:");
        ModuleServices.deleteModuleById(id);
        System.out.println("Module deleted successfully!");
        showModules();
    }
}
