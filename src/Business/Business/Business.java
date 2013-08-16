/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Business;

import Business.IndyPackage.VaccineCatalog;
import Business.IndyPackage.DiseaseCatalog;
import Business.Enterprise.ProgramSystem;
import Business.Enterprise.UserAccountDirectory;
import Business.IndyPackage.Sandbox;

/**
 *
 * @author Albert Carter
 */
public class Business {

    private String name;
    private DiseaseCatalog diseaseCatalog;
    private VaccineCatalog vaccineCatalog;
    private UserAccountDirectory userAccountDirectory;
    private ProgramSystem system;
    private Sandbox sandbox;

    public Business(String n) {
        name = n;
        diseaseCatalog = new DiseaseCatalog();
        vaccineCatalog = new VaccineCatalog();
        userAccountDirectory = new UserAccountDirectory();
        sandbox = new Sandbox();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DiseaseCatalog getDiseaseCatalog() {
        return diseaseCatalog;
    }

    public void setDiseaseCatalog(DiseaseCatalog diseaseCatalog) {
        this.diseaseCatalog = diseaseCatalog;
    }

    public VaccineCatalog getVaccineCatalog() {
        return vaccineCatalog;
    }

    public void setVaccineCatalog(VaccineCatalog vaccineCatalog) {
        this.vaccineCatalog = vaccineCatalog;
    }

    public ProgramSystem getSystem() {
        return system;
    }

    public void setSystem(ProgramSystem system) {
        this.system = system;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    public Sandbox getSandbox() {
        return sandbox;
    }

    public void setSandbox(Sandbox sandbox) {
        this.sandbox = sandbox;
    }
    

}
