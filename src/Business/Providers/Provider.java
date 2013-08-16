/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Providers;

import Business.Enterprise.Enterprise;
import Business.Enterprise.PHD;

/**
 *
 * @author Albert Carter
 */
public abstract class Provider extends Enterprise{
    private InventoryCatalog inventoryCatalog;
    private PHD phd;
    
    public Provider(){
        super();
        inventoryCatalog = new InventoryCatalog();
    }

    public InventoryCatalog getInventoryCatalog() {
        return inventoryCatalog;
    }

    public void setInventoryCatalog(InventoryCatalog inventoryCatalog) {
        this.inventoryCatalog = inventoryCatalog;
    }

    public PHD getPhd() {
        return phd;
    }

    public void setPhd(PHD phd) {
        this.phd = phd;
    }
    
    
    
    
}
