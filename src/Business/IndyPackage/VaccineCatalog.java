/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.IndyPackage;

import java.util.ArrayList;

/**
 *
 * @author Albert Carter
 */
public class VaccineCatalog {

    private ArrayList<Vaccine> vaccineList;

    public VaccineCatalog() {
        vaccineList = new ArrayList<Vaccine>();
    }

    public ArrayList<Vaccine> getVaccineList() {
        return vaccineList;
    }

    public void setVaccineList(ArrayList<Vaccine> vaccineList) {
        this.vaccineList = vaccineList;
    }
    
    

    public Vaccine newVaccine() {
        Vaccine d = new Vaccine();
        vaccineList.add(d);
        return d;
    }
}
