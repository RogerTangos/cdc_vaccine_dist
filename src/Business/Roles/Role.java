/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Roles;

/**
 *
 * @author Albert Carter
 */
public abstract class Role {
    private String roleName;
    
    public Role(String roleName){
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    @Override
    public String toString(){
    return roleName;
}
    
}


