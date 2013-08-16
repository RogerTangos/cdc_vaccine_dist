/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author Albert Carter
 */
public class Network extends Enterprise{
    private String name;
    private static String type = "Network";
    private ArrayList<Enterprise> enterpriseList;
    private ProgramSystem system;
    
    public Network(){
        super();
        enterpriseList = new ArrayList<Enterprise>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }

    public ProgramSystem getSystem() {
        return system;
    }

    public void setSystem(ProgramSystem system) {
        this.system = system;
    }
    
    public Enterprise newEnterprise(Enterprise enterprise){
        enterpriseList.add(enterprise);
        return enterprise;
    }
    
    
}
