/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.IndyPackage.WorkRequest;
import Business.Providers.Clinic;
import Business.Providers.Hospital;
import Business.Providers.Pharmacy;
import Business.Providers.Provider;
import java.util.ArrayList;

/**
 *
 * @author Albert Carter
 */
public class PHD extends Enterprise {
    private ArrayList<Provider> providerList;
    private ArrayList<WorkRequest> requestsPlacedList;
    private CDC cdc;

    public PHD() {
        super();
        providerList = new ArrayList<Provider>();
        requestsPlacedList = new ArrayList<WorkRequest>();
    }

    public CDC getCdc() {
        return cdc;
    }

    public void setCdc(CDC cdc) {
        this.cdc = cdc;
    }

    public ArrayList<Provider> getProviderList() {
        return providerList;
    }

    public void setProviderList(ArrayList<Provider> providerList) {
        this.providerList = providerList;
    }

    public ArrayList<WorkRequest> getRequestsPlacedList() {
        return requestsPlacedList;
    }

    public void setRequestsPlacedList(ArrayList<WorkRequest> requestsPlacedList) {
        this.requestsPlacedList = requestsPlacedList;
    }
    
    public WorkRequest newRequestPlaced(WorkRequest wr){
        requestsPlacedList.add(wr);
        return wr;
        //it's the UI's responsibility to delete from the other list.
    }
    
    public Clinic newClinic(){
        Clinic c = new Clinic();
        providerList.add(c);
        return c;
    }
    
    public Hospital newHospital(){
        Hospital h = new Hospital();
        providerList.add(h);
        
        //Add this to the main enterprise list
        for(Network n: getCdc().getSystem().getNetwork().getNetworkList()){
            ArrayList<Enterprise> nEnterpriseList = null;
            for(Enterprise e: n.getEnterpriseList()){
                if(e.equals(this)){
                    nEnterpriseList = n.getEnterpriseList();
                }
            }
            nEnterpriseList.add(h);
        }
        return h;

    }
    
    public Pharmacy newPharmacy(){
        Pharmacy p = new Pharmacy();
        providerList.add(p);
        return p;
    }
    
}
