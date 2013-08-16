package Business.Enterprise;

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
public class UserAccountDirectory {
    ArrayList<UserAccount> userAccountList;
    
    public UserAccountDirectory(){
        userAccountList = new ArrayList<UserAccount>();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }

    public void setUserAccountList(ArrayList<UserAccount> userAccountList) {
        this.userAccountList = userAccountList;
    }
    
    public UserAccount newUserAccount(){
        UserAccount u = new UserAccount();
        userAccountList.add(u);
        return u;
    }
    
    public UserAccount addUserAccount(UserAccount ua){
        userAccountList.add(ua);
        return ua;
    }
    
        public UserAccount isValid(String userName, String pass){
        UserAccount ua = null;
        
        for(UserAccount u : userAccountList){    
            if (u.getUserName().equalsIgnoreCase(userName) && u.getPassword().equals(pass) && u.getStatus().equalsIgnoreCase("Active")){
                ua = u;
            }
        }
        return ua; //will return null if userAccount =! u
    }
        
}
