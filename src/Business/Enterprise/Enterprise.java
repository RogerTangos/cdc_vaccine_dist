package Business.Enterprise;

import Business.Organization.Organization;
import Business.Organization.Payable;
import Business.Organization.Receivable;
import Business.Organization.Warehouse;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Albert Carter
 */
public abstract class Enterprise extends Organization {

    private ArrayList<Organization> organizationList;
    private PersonDirectory personDirectory;
    private UserAccountDirectory userAccountDirectory;
    private String type;

    public Enterprise() {
        super();
        organizationList = new ArrayList<Organization>();
        personDirectory = new PersonDirectory();
        userAccountDirectory = new UserAccountDirectory();
        
        //all enterprises have Teasury & Payable, and Receivable
        Payable payable = new Payable();
        payable.setOrgName("Payable and Treasury");
        organizationList.add(payable);
        
        Receivable receivable = new Receivable();
        receivable.setOrgName("Receivable");
        organizationList.add(receivable); 
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(ArrayList<Organization> organizationList) {
        this.organizationList = organizationList;
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(PersonDirectory personDirectory) {
        this.personDirectory = personDirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public Organization newOrganization(){
        Organization o = new Organization();
        organizationList.add(o);
        return o;
    }
    
    public Warehouse newWarehouse(){
        Warehouse w = new Warehouse();
        organizationList.add(w);
        return w;
    }

}
