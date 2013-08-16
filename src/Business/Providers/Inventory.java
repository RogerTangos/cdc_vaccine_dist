/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Providers;

import Business.Enterprise.Manufacturer;
import Business.IndyPackage.Vaccine;
import Business.Organization.Organization;
import java.util.Date;


/**
 *
 * @author Albert Carter
 */
public class Inventory {
        
    private Vaccine vaccine;
    private int count;
    private int serialNo;
    private static int index=100;
    private double price;
    private Date dateCreated;
    private Date dateExpired;
    private Manufacturer manufacturer;
    private Organization warehouse; //we want to know where each vaccine was stored.
    private int numberAdministered;

    public Inventory(){
    serialNo=index++;
    dateCreated = new Date();
    numberAdministered = 0;
//            Calendar.getInstance();//automatically populates the date created
    //The manufacturer will have to change dateExpired using
    //the getInstance() and setDateExpired() methods.
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
        Inventory.index = index;
    }

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Organization getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Organization warehouse) {
        this.warehouse = warehouse;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateExpired() {
        return dateExpired;
    }

    public void setDateExpired(Date dateExpired) {
        this.dateExpired = dateExpired;
    }

    public int getNumberAdministered() {
        return numberAdministered;
    }

    public void setNumberAdministered(int numberAdministered) {
        this.numberAdministered = numberAdministered;
    }
    
    public void setExpiration(){
        long date = dateCreated.getTime() + (vaccine.getLifespan()*24*60*60*1000);
        dateExpired = new Date(date);
        System.out.println(dateExpired);
    }
    

   @Override
   public String toString(){
       return getVaccine().getName();
   }
}
