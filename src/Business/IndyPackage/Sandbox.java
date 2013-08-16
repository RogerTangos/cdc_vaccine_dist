/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.IndyPackage;

import Business.Business.Business;
import Business.Enterprise.UserAccountDirectory;

/**
 *
 * @author Albert Carter
 */
public class Sandbox {
    private UserAccountDirectory userAccountDirectory;
    private String userName;
    private String pass;
    private Business business;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    public Sandbox getBusinessSandbox() {
        return business.getSandbox();
    }
    
    public UserAccount isValid(String userName, String pass){
        return userAccountDirectory.isValid(userName, pass);
    }
    
    public UserAccount addUserAccount(UserAccount ua){
        getBusinessSandbox().addUserAccount(ua);
                return ua;
    }
    
}
