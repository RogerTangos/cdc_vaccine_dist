/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.IndyPackage;

/**
 *
 * @author Albert Carter
 */
public class Disease {
    private String name;
    //i guess vaccines appropriate for the disease go here, too

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString(){
        return name;
    }
    
}
