package Business.Organization;

import Business.IndyPackage.Person;
import Business.IndyPackage.UserAccount;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Albert Carter
 */
public class StaffDirectory {
    
    private ArrayList<UserAccount> staffList;
    
    public StaffDirectory(){
        staffList = new ArrayList<UserAccount>();
    }

    public ArrayList<UserAccount> getStaffList() {
        return staffList;
    }

    public void setStaffList(ArrayList<UserAccount> staffList) {
        this.staffList = staffList;
    }
    
    public UserAccount newStaff(UserAccount ua, Organization o){
        staffList.add(ua);
        ua.setOrganization(o);
        return ua;
    }
    
}
