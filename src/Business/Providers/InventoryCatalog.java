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
public class InventoryCatalog {
    private ArrayList<Inventory> inventoryList;
    
    
    public InventoryCatalog(){
        inventoryList = new ArrayList<Inventory>();
    }

    public ArrayList<Inventory> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(ArrayList<Inventory> inventoryList) {
        this.inventoryList = inventoryList;
    }

    
    public Inventory newInventory(){
        Inventory i = new Inventory();
        inventoryList.add(i);
        return i;
    }
    
    
}
