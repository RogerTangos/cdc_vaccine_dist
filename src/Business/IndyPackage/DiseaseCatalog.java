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
public class DiseaseCatalog {
    private ArrayList<Disease> diseaseList;
    
    public DiseaseCatalog(){
        diseaseList = new ArrayList<Disease>();
    }

    public ArrayList<Disease> getDiseaseList() {
        return diseaseList;
    }

    public void setDiseaseList(ArrayList<Disease> diseaseList) {
        this.diseaseList = diseaseList;
    }
    
    public Disease newDisease(){
        Disease d = new Disease();
        diseaseList.add(d);
        return d;
    }
    
}
