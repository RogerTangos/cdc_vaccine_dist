/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.IndyPackage;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Providers.Inventory;


/**
 *
 * @author Albert Carter
 */
public class WorkRequest {
    private Enterprise originator; //original enterprise
    private Organization editorEnterprise; //enterprise that most recently edited the request
    private UserAccount creator; //individual
    private UserAccount assignedTo;
    private String title;
    private String message;
    private Inventory inventory;
    private Invoice invoice;
    private static int index;
    private int count;
    
    public WorkRequest(){
        inventory = new Inventory();
        count = index++;
    }

    public UserAccount getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(UserAccount assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Organization getEditorEnterprise() {
        return editorEnterprise;
    }

    public void setEditorEnterprise(Organization editorEnterprise) {
        this.editorEnterprise = editorEnterprise;
    }

    public UserAccount getCreator() {
        return creator;
    }

    public void setCreator(UserAccount creator) {
        this.creator = creator;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Enterprise getOriginator() {
        return originator;
    }

    public void setOriginator(Enterprise originator) {
        this.originator = originator;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static int getIndex() {
        return index;
    }

    public static void setIndex(int index) {
        WorkRequest.index = index;
    }

    
//    private Invoice newInvoice(){ //don't actually need this, b/c a wr can only have one invoice.
//    }
    
    @Override
    public String toString() {
        return title;
    }
    
    public WorkRequest cloneWorkRequest(WorkRequest wr){
        WorkRequest nWR = new WorkRequest();
        nWR.setAssignedTo(wr.getAssignedTo());
        nWR.setCount(wr.getCount());
        nWR.setCreator(wr.getCreator());
        nWR.setEditorEnterprise(wr.getEditorEnterprise());
        nWR.setOriginator(wr.getOriginator());
        nWR.setTitle(wr.getTitle());
        
        if(wr.getMessage()!=null){
            nWR.setMessage(wr.getMessage());
        }
        
        if(wr.getInventory()!=null){
            Inventory ninventory = new Inventory();
            ninventory.setCount(wr.getInventory().getCount());
            ninventory.setDateCreated(wr.getInventory().getDateCreated());
            ninventory.setDateExpired(wr.getInventory().getDateExpired());
            if(wr.getInventory().getManufacturer()!=null){
            ninventory.setManufacturer(wr.getInventory().getManufacturer());
            }
            ninventory.setPrice(wr.getInventory().getPrice());
            ninventory.setSerialNo(wr.getInventory().getSerialNo());
            ninventory.setVaccine(wr.getInventory().getVaccine());
            if(ninventory.getDateCreated()!=null){
                ninventory.setExpiration();
            }
            if(wr.getInventory().getWarehouse()!=null){
            ninventory.setWarehouse(wr.getInventory().getWarehouse());
            }
            
            nWR.setInventory(ninventory);
        }
        if(wr.getInvoice()!=null){
            Invoice ninvoice = new Invoice();
            ninvoice.setAmount(wr.getInvoice().getAmount());
            ninvoice.setCount(wr.getInvoice().getCount());
//            invoice.setCreationDate(wr.getInvoice().getCreationDate()); Creation date should be created along with the clone method, i think.
            if(wr.getInvoice().getOwedTo()!=null){
            ninvoice.setOwedTo(wr.getInvoice().getOwedTo());
            }
            ninvoice.setPayment(wr.getInvoice().getPayment());
            ninvoice.setStatus(wr.getInvoice().getStatus());
            nWR.setInvoice(ninvoice);    
        }
        
        return nWR;
    }
    
    
    
}
