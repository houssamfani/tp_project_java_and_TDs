package lst.tpjava.tpPart2.DataAccess;

import lst.tpjava.models.Departement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DepartementDAO {
    private Connection connection;

    public DepartementDAO(Connection connection) {
        this.connection = connection;
    }

    public void addDepartement(Departement departement) {
        try {
            String query = "INSERT INTO departements (intitule, chef_id) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, departement.getIntitule());
            if (departement.getChef() != null) {
                preparedStatement.setInt(2, departement.getChef().getId());
            } else {
                preparedStatement.setNull(2, java.sql.Types.INTEGER);
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Departement getDepartementById(int id) {
        try {
            String query = "SELECT * FROM departements WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Departement departement = new Departement();
                departement.setId(resultSet.getInt("id"));
                departement.setIntitule(resultSet.getString("intitule"));
                // Set other properties...
                return departement;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Departement> getAllDepartements() {
        ArrayList<Departement> departements = new ArrayList<>();
        try {
            String query = "SELECT * FROM departements";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Departement departement = new Departement();
                departement.setId(resultSet.getInt("id"));
                departement.setIntitule(resultSet.getString("intitule"));
                // Set other properties...
                departements.add(departement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departements;
    }

    public void updateDepartement(Departement departement) {
        try {
            String query = "UPDATE departements SET intitule = ?, chef_id = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, departement.getIntitule());
            if (departement.getChef() != null) {
                preparedStatement.setInt(2, departement.getChef().getId());
            } else {
                preparedStatement.setNull(2, java.sql.Types.INTEGER);
            }
            preparedStatement.setInt(3, departement.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDepartementById(int id) {
        try {
            String query = "DELETE FROM departements WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
