/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.IndyPackage.Invoice;
import Business.IndyPackage.WorkRequest;
import Business.Providers.Provider;
import java.util.ArrayList;

/**
 *
 * @author Albert Carter
 */
public class Manufacturer extends Provider {

    private Distributor distributor;
    private ArrayList<WorkRequest> requestsManufacturedList;
    private ArrayList<Invoice> receivableList;
    private CDC cdc;

    public Manufacturer() {
        super();
        requestsManufacturedList = new ArrayList<WorkRequest>();
        receivableList = new ArrayList<Invoice>();
    }

    public Distributor getDistributor() {
        return distributor;
    }

    public void setDistributor(Distributor distributor) {
        this.distributor = distributor;
    }

    public ArrayList<WorkRequest> getRequestsManufacturedList() {
        return requestsManufacturedList;
    }

    public void setRequestsManufacturedList(ArrayList<WorkRequest> requestsManufacturedList) {
        this.requestsManufacturedList = requestsManufacturedList;
    }

    public WorkRequest newRequestManufactured(WorkRequest wr) {
        requestsManufacturedList.add(wr);
        return wr;
    }

    public ArrayList<Invoice> getReceivableList() {
        return receivableList;
    }

    public void setReceivableList(ArrayList<Invoice> receivableList) {
        this.receivableList = receivableList;
    }

    public CDC getCdc() {
        return cdc;
    }

    public void setCdc(CDC cdc) {
        this.cdc = cdc;
    }

    public Invoice addReceivable(Invoice i) { //this is for invoices the Distributor generates
        //that must be paid to the CDC by Providers/PHD's
        receivableList.add(i);
        return i;
    }

    }
