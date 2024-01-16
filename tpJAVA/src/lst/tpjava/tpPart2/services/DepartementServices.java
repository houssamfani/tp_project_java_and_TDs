package lst.tpjava.tpPart2.services;

import lst.tpjava.tpPart2.DataAccess.DepartementDAO;
import lst.tpjava.models.Departement;
import lst.tpjava.models.Enseignant;

import java.util.ArrayList;

public class DepartementServices {
    private DepartementDAO departementDAO;

    public DepartementServices(DepartementDAO departementDAO) {
        this.departementDAO = departementDAO;
    }



    public Departement addDept(String intitule, Enseignant chef) {
        Departement departement = new Departement(intitule, chef);
        departementDAO.addDepartement(departement);
        return departement;
    }

    public Departement updateDept(int id, String intitule, Enseignant chef) {
        Departement departement = departementDAO.getDepartementById(id);
        if (departement != null) {
            departement.setIntitule(intitule);
            departement.setChef(chef);
            departementDAO.updateDepartement(departement);
        }
        return departement;
    }

    public void deleteDeptById(int id) {
        departementDAO.deleteDepartementById(id);
    }

    public Departement getDeptById(int id) {
        return departementDAO.getDepartementById(id);
    }

    public ArrayList<Departement> getAllDept() {
        return departementDAO.getAllDepartements();
    }
}
