/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.IndyPackage.DiseaseCatalog;
import Business.IndyPackage.NetworkCatalog;
import Business.IndyPackage.VaccineCatalog;

/**
 *
 * @author Albert Carter
 */
public class ProgramSystem extends Enterprise{
    private NetworkCatalog networkCatalog;
    private DiseaseCatalog diseaseCatalog;
    private VaccineCatalog vaccineCatalog;
    
    public ProgramSystem() {
    super();
    networkCatalog = new NetworkCatalog();
    diseaseCatalog = new DiseaseCatalog();
    vaccineCatalog = new VaccineCatalog();
    }

    public NetworkCatalog getNetwork() {
        return networkCatalog;
    }

    public void setNetwork(NetworkCatalog networkCatalog) {
        this.networkCatalog = networkCatalog;
    }
     
        public DiseaseCatalog getDiseaseCatalog() {
        return diseaseCatalog;
    }

    public void setDiseaseCatalog(DiseaseCatalog diseaseCatalog) {
        this.diseaseCatalog = diseaseCatalog;
    }

    public NetworkCatalog getNetworkCatalog() {
        return networkCatalog;
    }

    public void setNetworkCatalog(NetworkCatalog networkCatalog) {
        this.networkCatalog = networkCatalog;
    }

    public VaccineCatalog getVaccineCatalog() {
        return vaccineCatalog;
    }

    public void setVaccineCatalog(VaccineCatalog vaccineCatalog) {
        this.vaccineCatalog = vaccineCatalog;
    }
        
}
