/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.IndyPackage.Invoice;
import Business.IndyPackage.WorkRequest;
import java.util.ArrayList;

/**
 *
 * @author Albert Carter
 */
public class CDC extends Enterprise {

    private ArrayList<WorkRequest> requestsPlacedList;
    private ProgramSystem system; //this is a cheat, so that it's possible to get to the vaccine/disease/useraccount catalog.
    /// I don't have any idea how we can get these things otherwise. Should ask.
    private static String type = "CDC";
    private ArrayList<PHD> phdList;
    private Distributor distributor;
    private Manufacturer manufacturer;
    private ArrayList<Invoice> receivableList;

    public CDC() {
        super();
        phdList = new ArrayList<PHD>();
        requestsPlacedList = new ArrayList<WorkRequest>();
        receivableList = new ArrayList<Invoice>();
    }

    public ArrayList<PHD> getPhdList() {
        return phdList;
    }

    public void setPhdList(ArrayList<PHD> phdList) {
        this.phdList = phdList;
    }

    public ProgramSystem getSystem() {
        return system;
    }

    public void setSystem(ProgramSystem system) {
        this.system = system;
    }

    public ArrayList<WorkRequest> getRequestsPlacedList() {
        return requestsPlacedList;
    }

    public void setRequestsPlacedList(ArrayList<WorkRequest> requestsPlacedList) {
        this.requestsPlacedList = requestsPlacedList;
    }

    public Distributor getDistributor() {
        return distributor;
    }

    public void setDistributor(Distributor distributor) {
        this.distributor = distributor;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public ArrayList<Invoice> getReceivable() {
        return receivableList;
    }

    public void setReceivable(ArrayList<Invoice> receivable) {
        this.receivableList = receivable;
    }

    public PHD newPHD() {
        PHD p = new PHD();
        phdList.add(p);

        //here, I make sure that the new enterprise goes in the network enterprise list, too.
        for (Network n : getSystem().getNetwork().getNetworkList()) {
            ArrayList<Enterprise> nEnterpriseList = null;
            for (Enterprise e : n.getEnterpriseList()) {
                if (e.equals(this)) {
                    nEnterpriseList = n.getEnterpriseList();
                }
            }

            nEnterpriseList.add(p);
        }

        return p;
    }

    public WorkRequest newRequestPlaced(WorkRequest wr) {
        requestsPlacedList.add(wr);
        return wr;
        //it's the UI's responsibility to delete from the other list.
    }

    public Invoice addReceivable(Invoice i) { //this is for invoices the Distributor generates
        //that must be paid to the CDC by Providers/PHD's
        receivableList.add(i);
        return i;
    }
}
