/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddPerson.java
 *
 * Created on Nov 15, 2011, 6:42:05 PM
 */
package UserInterface.Distributor;

import Business.Enterprise.Distributor;
import Business.Enterprise.Enterprise;
import Business.IndyPackage.WorkRequest;
import Business.IndyPackage.UserAccount;
import Business.IndyPackage.Vaccine;
import Business.Organization.Organization;
import Business.Organization.Warehouse;
import Business.Providers.Inventory;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Albert Carter
 */
public class ArrangeShipment extends javax.swing.JPanel {

    UserAccount ua;
    Enterprise enterprise;
    JPanel userProcessContainer;
    WorkRequest wr;
    Warehouse w;
    Vaccine vaccine;

    /** Creates new form AddPerson */
    public ArrangeShipment(javax.swing.JPanel jp, Enterprise enterprise, UserAccount ua, WorkRequest wr) {
        initComponents();
        this.enterprise = enterprise;
        userProcessContainer = jp;
        this.ua = ua;
        this.wr = wr;

        jLabel1.setText(enterprise.getOrgName() + " " + enterprise.getClass().getSimpleName() + " | Order Warehouse(s) to Ship");

        vaccine = wr.getInventory().getVaccine(); //i need this because we use this global variable later, once WR is deleted.

        nametypejLabel.setText(wr.getOriginator().getOrgName() + " " + wr.getOriginator().getClass().getSimpleName());
        address1jLabel.setText(wr.getOriginator().getLocation().getAddress1());
        address2jLabel.setText(wr.getOriginator().getLocation().getAddress2());
        citystatecountryjLabel.setText(wr.getOriginator().getLocation().getCity() + ", " + wr.getOriginator().getLocation().getState() + " " + wr.getOriginator().getLocation().getCountry());

        vaccinejLabel.setText(wr.getInventory().getVaccine().getName());
        diseasejLabel.setText(wr.getInventory().getVaccine().getDisease().getName());
        dosesjLabel.setText(Integer.toString(wr.getInventory().getCount()));
//        
//        Distributor testDistributor = (Distributor) enterprise;
//        for(Organization testWarehouse : enterprise.getOrganizationList()){
//            testWarehouse.getOrgName();
//            
//            for(Inventory testInventory: testDistributor.getInventoryList()){
//                if(testInventory.getWarehouse().equals(testWarehouse)){
//                    System.out.println(testInventory.getSerialNo());
//                }
//            } 
//        }
//        
//        

        refresh();
    }

    void refresh() {
        int rowcount = warehousejTable.getRowCount();
        int i;
        for (i = rowcount - 1; i >= 0; i--) {
            ((DefaultTableModel) warehousejTable.getModel()).removeRow(i);
        }

        //you need to make this show all of the inventory catalogs and their inventory
        //so make it show the inventory catalog and count up the inventory items
        //then make a button to view the inventoryCatalog in detail

        Distributor d = (Distributor) enterprise;

        //creating a list of warehouses that have the item.
        ArrayList<Organization> clist = new ArrayList<Organization>();


        for (Inventory inv : d.getInventoryList()) { //cycle through all of the distributor's inventory
            //if the inventory vaccine is the same as the warehouse, add that warehouse to the list


            if (inv.getVaccine() == wr.getInventory().getVaccine() && inv.getWarehouse() != null) {
                // if the warehouse has the vaccine

                boolean notOnList = true; // check to see if the warehouse is already on the list
                for (Organization warehouse : clist) {
                    System.out.println(inv.getSerialNo() + " || " + inv.getWarehouse());
                    if (inv.getWarehouse().equals(warehouse)) {
                        notOnList = false;
                    }
                }

                if (notOnList) { //if the warehouse isn't on the list, add it.
                    clist.add(inv.getWarehouse());
                }
            }
        }


        for (Organization o : clist) {
            Object[] col = new Object[5];
            col[0] = o;
            col[1] = o.getLocation().getAddress1();
            col[2] = o.getLocation().getCity();
            col[3] = o.getLocation().getState();
            col[4] = o.getLocation().getCountry();

            ((DefaultTableModel) warehousejTable.getModel()).addRow(col);
        }
    }

    void refreshWarehouseInventory() {
        int rowcount = inventoryjTable.getRowCount();
        int i;
        for (i = rowcount - 1; i >= 0; i--) {
            ((DefaultTableModel) inventoryjTable.getModel()).removeRow(i);
        }

        Distributor d = (Distributor) enterprise;

        ArrayList<Inventory> clist = d.getInventoryList();
        for (Inventory ii : clist) {
            System.out.println("THe inventoryu is " + ii.getSerialNo());
        }

        for (Inventory in : clist) {
            in.getVaccine().getName();

            if (in.getWarehouse() != null && in.getWarehouse().equals(w) && in.getVaccine().equals(vaccine)) { //we only want results from this warehouse
                System.out.println("successful inventory:" + in.hashCode());
                Object[] col = new Object[3];
                col[0] = in;
                col[1] = in.getManufacturer();
                col[2] = in.getCount();

                ((DefaultTableModel) inventoryjTable.getModel()).addRow(col);
            }


        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        backjButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        diseasejLabel = new javax.swing.JLabel();
        dosesjLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        address1jLabel = new javax.swing.JLabel();
        address2jLabel = new javax.swing.JLabel();
        citystatecountryjLabel = new javax.swing.JLabel();
        nametypejLabel = new javax.swing.JLabel();
        vaccinejLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        warehousejTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        inventoryjTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        shipjButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setText("jLabel1");

        backjButton.setText("<<Back");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Vaccine Information:");

        diseasejLabel.setText("Associate Disease:");

        dosesjLabel.setText("Number of Doses:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Requester Information:");

        address1jLabel.setText("Address 1:");

        address2jLabel.setText("Address 2:");

        citystatecountryjLabel.setText("City");

        nametypejLabel.setText("Name");

        vaccinejLabel.setText("Vaccine");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        warehousejTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Warehouse", "Address 1", "City", "State", "Country"
            }
        ));
        warehousejTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                warehousejTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(warehousejTable);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Warehouses with Vaccine in Stock (select one)");

        inventoryjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Vaccines", "Manufacturer", "Number in Stock"
            }
        ));
        jScrollPane2.setViewportView(inventoryjTable);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Selected Warehouse's Inventory of Selected Vaccine:");

        shipjButton.setText("Tell Warehouse to Ship");
        shipjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shipjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(backjButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(shipjButton))
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(nametypejLabel)
                                .addComponent(address1jLabel)
                                .addComponent(address2jLabel)
                                .addComponent(citystatecountryjLabel))
                            .addGap(74, 74, 74)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(dosesjLabel)
                                .addComponent(diseasejLabel)
                                .addComponent(vaccinejLabel)
                                .addComponent(jLabel2)))
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nametypejLabel)
                            .addComponent(vaccinejLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(address1jLabel)
                            .addComponent(diseasejLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(address2jLabel)
                            .addComponent(dosesjLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(citystatecountryjLabel)))
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backjButton)
                    .addComponent(shipjButton))
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
// TODO add your handling code here:
    userProcessContainer.remove(this);
    CardLayout c3 = (CardLayout) userProcessContainer.getLayout();
    c3.previous(userProcessContainer);
}//GEN-LAST:event_backjButtonActionPerformed

private void warehousejTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_warehousejTableMouseClicked
// TODO add your handling code here:

    int selectedRow = warehousejTable.getSelectedRow();
    if (selectedRow < 0 || selectedRow > warehousejTable.getRowCount()) {
        return;
    }

    w = (Warehouse) warehousejTable.getValueAt(selectedRow, 0);

    refreshWarehouseInventory();


}//GEN-LAST:event_warehousejTableMouseClicked

private void shipjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shipjButtonActionPerformed
// TODO add your handling code here:

    //get the warehouse we're talking about
    int selectedRow = warehousejTable.getSelectedRow();
    if (selectedRow < 0 || selectedRow > warehousejTable.getRowCount()) {
        return;
    }
    w = (Warehouse) warehousejTable.getValueAt(selectedRow, 0);

    //get the inventory item we're talking about
    int selectedinvRow = inventoryjTable.getSelectedRow();
    if (selectedinvRow < 0 || selectedinvRow > inventoryjTable.getRowCount()) {
        return;
    }
    Inventory inv = (Inventory) inventoryjTable.getValueAt(selectedinvRow, 0);

    //declare some ints for convenience
    int quantityRemaining = inv.getCount() - wr.getInventory().getCount();

    //go ahead and cast. you'll need it.
    Distributor distributor = (Distributor) enterprise;

    System.out.println("quantity remaining" + quantityRemaining);

//    If the count of the inventory selected is the same as the request's.
    if (wr.getInventory().getCount() == inv.getCount()) {
//        enterprise.getWorkRequestList().remove(wr); //this wr is no longer in the enterprise list
        
        wr.setEditorEnterprise(enterprise);//first, i need to set the enterprise, so that it won't show up in the list anymore.

        WorkRequest dadWR = w.newWorkRequest(wr); //then I create a new WorkRequest, and add the inventory to it.
        
        dadWR.setInventory(inv);//yep. At long last, the work request is joined with the warehouse inventory!
        //the inventory also happens to contain the warehouse
        
        distributor.getInventoryList().remove(inv);
        
        dosesjLabel.setText("complete!");
        quantityRemaining = inv.getCount() - wr.getInventory().getCount();

        System.out.println("part 1");
        JOptionPane.showMessageDialog(null, "Inventory will be shipped from " + w.getOrgName());
        return;

    }

//    If there's less in inventory than the request asked for
    if (wr.getInventory().getCount() > inv.getCount()) {
        
        dosesjLabel.setText(Integer.toString(wr.getInventory().getCount()-inv.getCount()));
        quantityRemaining = -(inv.getCount() - wr.getInventory().getCount());
        
        //duplicate the work request
        WorkRequest warehouseRequest = new WorkRequest();
        warehouseRequest.setAssignedTo(wr.getAssignedTo());
        warehouseRequest.setCount(wr.getCount());
        warehouseRequest.setCreator(wr.getCreator());
        warehouseRequest.setEditorEnterprise(enterprise);
        warehouseRequest.setInventory(wr.getInventory());
        warehouseRequest.setInvoice(wr.getInvoice());
        warehouseRequest.setMessage(wr.getMessage());
        warehouseRequest.setOriginator(wr.getOriginator());
        warehouseRequest.setTitle(wr.getTitle());
        
        
        Inventory newInv = new Inventory();
        //copying each and every attribute of inv to tempInventory... because just setting tempInventory = inv creates a reference; doesn't copy the whole thing
        newInv.setCount(inv.getCount());
        newInv.setDateCreated(inv.getDateCreated());
        newInv.setDateExpired(inv.getDateExpired());
        newInv.setManufacturer(inv.getManufacturer());
        newInv.setPrice(inv.getPrice());
        newInv.setSerialNo(inv.getSerialNo());
        newInv.setVaccine(inv.getVaccine());
        newInv.setWarehouse(inv.getWarehouse());
        
        
        
        warehouseRequest.setInventory(newInv);
        w.newWorkRequest(warehouseRequest);
        
        //change the D work request
        wr.getInventory().setCount(quantityRemaining);
        
        //remove the inventory
        distributor.getInventoryList().remove(inv);
          
        //you are making sure that the correct amount goes to the warhouse and that the correct amount remains
        //in the distributor work request.

        System.out.println("part 2");
        JOptionPane.showMessageDialog(null, "Inventory will be shipped from " + w.getOrgName());
        return;
    }

//  If the count of the inventory selected is more than the request's.
    if (wr.getInventory().getCount() < inv.getCount()) {

        //make the work request be the quantity sent and then copy it to the warehouse

        w.newWorkRequest(wr);
        Inventory tempInventory = new Inventory();
        
        //copying each and every attribute of inv to tempInventory... because just setting tempInventory = inv creates a reference; doesn't copy the whole thing
        tempInventory.setCount(inv.getCount());
        tempInventory.setDateCreated(inv.getDateCreated());
        tempInventory.setDateExpired(inv.getDateExpired());
        tempInventory.setManufacturer(inv.getManufacturer());
        tempInventory.setPrice(inv.getPrice());
        tempInventory.setSerialNo(inv.getSerialNo());
        tempInventory.setVaccine(inv.getVaccine());
        tempInventory.setWarehouse(inv.getWarehouse());
        
        
        tempInventory.setCount(wr.getInventory().getCount());
        wr.setInventory(tempInventory);
        
        //reset the inventory appropriately
        inv.setCount(quantityRemaining); //change the inventory count
        
        
        //remove the work request, because it's done!
        wr.setEditorEnterprise(enterprise);
        quantityRemaining = inv.getCount() - wr.getInventory().getCount();
        dosesjLabel.setText("0: Request Complete!");
        System.out.println("part 3");
        JOptionPane.showMessageDialog(null, "Inventory will be shipped from " + w.getOrgName());
        return;

    }
}//GEN-LAST:event_shipjButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address1jLabel;
    private javax.swing.JLabel address2jLabel;
    private javax.swing.JButton backjButton;
    private javax.swing.JLabel citystatecountryjLabel;
    private javax.swing.JLabel diseasejLabel;
    private javax.swing.JLabel dosesjLabel;
    private javax.swing.JTable inventoryjTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel nametypejLabel;
    private javax.swing.JButton shipjButton;
    private javax.swing.JLabel vaccinejLabel;
    private javax.swing.JTable warehousejTable;
    // End of variables declaration//GEN-END:variables
}
