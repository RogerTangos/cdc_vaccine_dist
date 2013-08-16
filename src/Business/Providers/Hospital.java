/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Providers;

import java.util.ArrayList;

/**
 *
 * @author Albert Carter
 */
public class Hospital extends Provider{
    private ArrayList<Clinic> clinicList;
    private static String type = "Hospital";
    
    public Hospital(){
        super();
        clinicList = new ArrayList<Clinic>();
    }

    public ArrayList<Clinic> getClinicList() {
        return clinicList;
    }

    public void setClinicList(ArrayList<Clinic> clinicList) {
        this.clinicList = clinicList;
    }
    
    public Clinic newClinic(){
        Clinic c = new Clinic();
        clinicList.add(c);
        return c;
    }
}
