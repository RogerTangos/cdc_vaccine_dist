/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.IndyPackage;

import Business.Enterprise.Manufacturer;
import Business.Organization.Organization;
import Business.Providers.Inventory;
import Business.Providers.InventoryCatalog;

/**
 *
 * @author Albert Carter
 */
public class VaccinePackage {
    private InventoryCatalog inventoryCatalog;
    private Vaccine vaccine; //this is the type of vaccine in the InventoryCatalog.
    private Organization warehouse;
    private Manufacturer manufacturer;
    //This is really only used for the Distributor's inventory items
    
    public VaccinePackage(){
        inventoryCatalog = new InventoryCatalog();
    }
    
    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public Organization getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Organization warehouse) {
        this.warehouse = warehouse;
    }

    public InventoryCatalog getInventoryCatalog() {
        return inventoryCatalog;
    }

    public void setInventoryCatalog(InventoryCatalog inventoryCatalog) {
        this.inventoryCatalog = inventoryCatalog;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
    
    public Integer findVaccineCount(){
        Integer number = 0;
        for(Inventory i: inventoryCatalog.getInventoryList()){
            number = number + i.getCount();
        }
        return number;
    }
    
    @Override
    public String toString(){
        return getVaccine().getName();
    }
    
}