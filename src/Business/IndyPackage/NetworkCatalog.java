/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.IndyPackage;

import Business.Enterprise.Network;
import java.util.ArrayList;

/**
 *
 * @author Albert Carter
 */
public class NetworkCatalog {
    ArrayList<Network> networkList;

    public NetworkCatalog(){
        networkList = new ArrayList<Network>();
    }
    
    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    
    public Network newNetwork(){
        Network n = new Network();
        networkList.add(n);
        return n;
    }
}
