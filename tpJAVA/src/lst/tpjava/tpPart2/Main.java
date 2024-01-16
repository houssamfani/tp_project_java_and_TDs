package lst.tpjava.tpPart2;


import lst.tpjava.tpPart2.DataAccess.DepartementDAO;
import lst.tpjava.tpPart2.controllers.DepartementsController;
import lst.tpjava.tpPart2.services.DepartementServices;
import lst.tpjava.models.Enseignant;
import lst.tpjava.services.DB;

import java.sql.*;
import java.util.Scanner;


public class Main {

    public static boolean isNull(Object ob) {
        return ob == null;
    }

    public static int getIntInput(String... msg) {
        Scanner scanner = new Scanner(System.in);

        String message = "Enter an integer: ";
        if (msg.length > 0) {
            message = msg[0];
        }

        System.out.print(message);
        return scanner.nextInt();
    }

    public static String getStringInput(String... msg) {
        Scanner scanner = new Scanner(System.in);

        String message = "Enter a text: ";
        if (msg.length > 0) {
            message = msg[0];
        }

        System.out.print(message);
        return scanner.nextLine();
    }

    public static void showDepartementMenu(DepartementsController departementsController) {
        boolean run=true;
        while (run) {
            System.out.println("---------[ Departement Management ]-------");
            System.out.println("1. Add Departement");
            System.out.println("2. Show Departements");
            System.out.println("3. Update Departement");
            System.out.println("4. Delete Departement");
            System.out.println("0. Exit");

            int option = getIntInput("Select an option: ");
            switch (option) {
                case 1:
                    departementsController.createDepartement();
                    break;
                case 2:
                    departementsController.showDepartements();
                    break;
                case 3:
                    departementsController.editDepartement();
                    break;
                case 4:
                    departementsController.destroyDepartement();
                    break;
                case 0:
                    System.out.println("Departement closed");
                    run=false;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        Enseignant enseignant = new Enseignant();
        Enseignant enseignant2 = new Enseignant();

        try {
//            System.out.println('h');
            // Establish a connection to your MySQL database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");
//
            String createEnseignantTable = "CREATE TABLE IF NOT EXISTS enseignants (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "nom VARCHAR(255) NOT NULL," +
                    "prenom VARCHAR(255) NOT NULL," +
                    "email VARCHAR(255) NOT NULL," +
                    "grade VARCHAR(50) NOT NULL)";

            String createDepartementTable = "CREATE TABLE IF NOT EXISTS departements (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "intitule VARCHAR(255) NOT NULL," +
                    "chef_id INT DEFAULT NULL," +
                    "FOREIGN KEY (chef_id) REFERENCES enseignants(id))";
            connection.prepareStatement(createEnseignantTable).execute();
            connection.prepareStatement(createDepartementTable).execute();
            enseignant.setNom("Amine");
            enseignant.setPrenom("Ben Charif");
            enseignant.setEmail("test@gmail.com");
            enseignant.setGrade("PES");
            enseignant.setId(DB.getEnsId());
            DB.enseignants.add(enseignant);

            enseignant2.setNom("louzar");
            enseignant2.setPrenom("med");
            enseignant2.setEmail("med.louzar@gmail.com");
            enseignant2.setGrade("DOC_MA");
            enseignant2.setId(DB.getEnsId());
            DB.enseignants.add(enseignant2);

            // Check if enseignant1 already exists in the "enseignants" table
            String checkEnseignant1 = "SELECT * FROM enseignants WHERE nom = ? AND prenom = ? AND email = ? AND grade = ?";
            try (PreparedStatement checkStatement = connection.prepareStatement(checkEnseignant1)) {
                checkStatement.setString(1, enseignant.getNom());
                checkStatement.setString(2, enseignant.getPrenom());
                checkStatement.setString(3, enseignant.getEmail());
                checkStatement.setString(4, enseignant.getGrade());

                try (ResultSet resultSet = checkStatement.executeQuery()) {
                    if (!resultSet.next()) {
                        // Insert enseignant1 if it doesn't already exist
                        String insertEnseignant1 = "INSERT INTO enseignants (nom, prenom, email, grade) VALUES (?, ?, ?, ?)";
                        try (PreparedStatement preparedStatement = connection.prepareStatement(insertEnseignant1)) {
                            preparedStatement.setString(1, enseignant.getNom());
                            preparedStatement.setString(2, enseignant.getPrenom());
                            preparedStatement.setString(3, enseignant.getEmail());
                            preparedStatement.setString(4, enseignant.getGrade());
                            preparedStatement.executeUpdate();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

// Repeat the same process for enseignant2
            String checkEnseignant2 = "SELECT * FROM enseignants WHERE nom = ? AND prenom = ? AND email = ? AND grade = ?";
            try (PreparedStatement checkStatement = connection.prepareStatement(checkEnseignant2)) {
                checkStatement.setString(1, enseignant2.getNom());
                checkStatement.setString(2, enseignant2.getPrenom());
                checkStatement.setString(3, enseignant2.getEmail());
                checkStatement.setString(4, enseignant2.getGrade());

                try (ResultSet resultSet = checkStatement.executeQuery()) {
                    if (!resultSet.next()) {
                        // Insert enseignant2 if it doesn't already exist
                        String insertEnseignant2 = "INSERT INTO enseignants (nom, prenom, email, grade) VALUES (?, ?, ?, ?)";
                        try (PreparedStatement preparedStatement = connection.prepareStatement(insertEnseignant2)) {
                            preparedStatement.setString(1, enseignant2.getNom());
                            preparedStatement.setString(2, enseignant2.getPrenom());
                            preparedStatement.setString(3, enseignant2.getEmail());
                            preparedStatement.setString(4, enseignant2.getGrade());
                            preparedStatement.executeUpdate();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


            // Initialize DAOs, Services, and Controllers
            DepartementDAO departementDAO = new DepartementDAO(connection);
            DepartementServices departementServices = new DepartementServices(departementDAO);
            DepartementsController departementsController = new DepartementsController(departementServices);

            // Show the Departement menu



            showDepartementMenu(departementsController);

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//

    }

}