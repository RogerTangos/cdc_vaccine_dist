/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.IndyPackage.WorkRequest;
import java.util.ArrayList;
import Business.Providers.Inventory;

/**
 *
 * @author Albert Carter
 */
public class Distributor extends Enterprise{
    private ArrayList<WorkRequest> requestsShippedList;
    private ArrayList<Inventory> inventoryList;
        
    public Distributor(){
        super();
        requestsShippedList = new ArrayList<WorkRequest>();
        inventoryList = new ArrayList<Inventory>();
    }
    
     public ArrayList<WorkRequest> getRequestsShippedList() {
        return requestsShippedList;
    }

    public void setRequestsShippedList(ArrayList<WorkRequest> requestsShippedList) {
        this.requestsShippedList = requestsShippedList;
    }

    public ArrayList<Inventory> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(ArrayList<Inventory> inventoryList) {
        this.inventoryList = inventoryList;
    }

     public WorkRequest newRequestShipped(WorkRequest wr){
        requestsShippedList.add(wr);
        return wr;
    }
     
     public Inventory newInventory(){
         Inventory p = new Inventory();
         inventoryList.add(p);
         return p;
     }
     


    
}
