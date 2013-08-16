package Business.Organization;

import Business.IndyPackage.WorkRequest;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Albert Carter
 */
public class Organization {
    private StaffDirectory staffDirectory;
    private String orgName;
    private Location location;
    private HashMap<Integer, ArrayList<WorkRequest>> workRequestList;
        
    public Organization(){
        staffDirectory = new StaffDirectory();
        location = new Location();
        workRequestList = new HashMap<Integer, ArrayList<WorkRequest>>();
    }

    public StaffDirectory getStaffDirectory() {
        return staffDirectory;
    }

    public void setStaffDirectory(StaffDirectory staffDirectory) {
        this.staffDirectory = staffDirectory;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Location getLocation() {
        return location;
    }
    
    public void setLocation(Location location) {
        this.location = location;
    }

    public HashMap<Integer, ArrayList<WorkRequest>> getWorkRequestList() {
        return workRequestList;
    }

    public void setWorkRequestList(HashMap<Integer, ArrayList<WorkRequest>> workRequestList) {
        this.workRequestList = workRequestList;
    }
    
    public WorkRequest newWorkRequest(WorkRequest wr){
        
        //if the workrequest is actually new
        if(getWorkRequestList().get(wr.getCount())==null){
            ArrayList<WorkRequest> wrList = new ArrayList<WorkRequest>(); //make a new workrequestlist
            wrList.add(wr);//and add the new wr
            getWorkRequestList().put(wr.getCount(), wrList);//and make a new entry
            
        }else{
            getWorkRequestList().get(wr.getCount()).add(wr); //get the existing arrayList and add wr.
        }
        return wr;
    }
    
    
    
    @Override
    public String toString(){
        return orgName;
    }
    
}
