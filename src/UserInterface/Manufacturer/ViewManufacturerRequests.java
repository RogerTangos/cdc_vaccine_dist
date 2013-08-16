/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddPerson.java
 *
 * Created on Nov 15, 2011, 6:42:05 PM
 */
package UserInterface.Manufacturer;

import Business.Enterprise.CDC;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Manufacturer;
import Business.IndyPackage.Invoice;
import Business.IndyPackage.WorkRequest;
import Business.IndyPackage.UserAccount;
import Business.Providers.Inventory;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Albert Carter
 */
public class ViewManufacturerRequests extends javax.swing.JPanel {

    UserAccount ua;
    Enterprise enterprise;
    JPanel userProcessContainer;

    /** Creates new form AddPerson */
    public ViewManufacturerRequests(javax.swing.JPanel jp, Enterprise enterprise, UserAccount ua) {
        initComponents();
        this.enterprise = enterprise;
        userProcessContainer = jp;
        this.ua = ua;

        jLabel1.setText(enterprise.getOrgName() + " " + enterprise.getClass().getSimpleName() + " | Manage Requests");
        refresh();
        refreshRequested();
    }

    void refresh() {
        int rowcount = receivedjTable.getRowCount();
        int i;
        for (i = rowcount - 1; i >= 0; i--) {
            ((DefaultTableModel) receivedjTable.getModel()).removeRow(i);
        }

        Map map = (Map) enterprise.getWorkRequestList(); //cast the HashMap to map
        Set set = map.entrySet(); //and get the entry set
        Iterator iter = set.iterator(); //get the number of entries

        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            ArrayList<WorkRequest> entryRequests = (ArrayList<WorkRequest>) entry.getValue();
            for (WorkRequest c : entryRequests) {
                if (c.getEditorEnterprise() != enterprise && c.getInvoice() == null) {
                    Object[] col = new Object[5];
                    col[0] = c;
                    col[1] = c.getInventory().getVaccine();
                    col[2] = c.getInventory().getCount();
                    col[3] = c.getOriginator();
                    col[4] = c.getOriginator().getClass().getSimpleName();

                    ((DefaultTableModel) receivedjTable.getModel()).addRow(col);
                }
            }
        }
    }

    void refreshRequested() {
        int rowcount = madejTable1.getRowCount();
        int i;
        for (i = rowcount - 1; i >= 0; i--) {
            ((DefaultTableModel) madejTable1.getModel()).removeRow(i);
        }

        Map map = (Map) enterprise.getWorkRequestList(); //cast the HashMap to map
        Set set = map.entrySet(); //and get the entry set
        Iterator iter = set.iterator(); //get the number of entries

        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            ArrayList<WorkRequest> entryRequests = (ArrayList<WorkRequest>) entry.getValue();
            for (WorkRequest c : entryRequests) {
                if (c.getEditorEnterprise() == enterprise && c.getInvoice() != null) {
                    Object[] col = new Object[4];
                    col[0] = c;
                    col[1] = c.getInventory().getVaccine();
                    col[2] = c.getInventory().getCount();
                    col[3] = c.getInvoice().getPayment();

                    ((DefaultTableModel) madejTable1.getModel()).addRow(col);
                }
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
        jSeparator1 = new javax.swing.JSeparator();
        refreshjButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        receivedjTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        madejTable1 = new javax.swing.JTable();
        manufacturejButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setText("jLabel1");

        backjButton.setText("<<Back");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });

        refreshjButton.setText("Refresh");
        refreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjButtonActionPerformed(evt);
            }
        });

        receivedjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Request Title", "Vaccine Name", "Count", "Originator Enterprise", "Originator Type"
            }
        ));
        receivedjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                receivedjTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(receivedjTable);

        madejTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Request Title", "Vaccine Name", "Count", "Paid?"
            }
        ));
        madejTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                madejTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(madejTable1);

        manufacturejButton.setText("Manufacture Vaccine");
        manufacturejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manufacturejButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Vaccines Manufactured (that CDC will pay)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backjButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(refreshjButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 219, Short.MAX_VALUE)
                                .addComponent(manufacturejButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshjButton)
                    .addComponent(manufacturejButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(backjButton)
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
// TODO add your handling code here:
    userProcessContainer.remove(this);
    CardLayout c3 = (CardLayout) userProcessContainer.getLayout();
    c3.previous(userProcessContainer);
}//GEN-LAST:event_backjButtonActionPerformed

private void refreshjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshjButtonActionPerformed
// TODO add your handling code here:
    refresh();
}//GEN-LAST:event_refreshjButtonActionPerformed

private void receivedjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receivedjTableMouseClicked
// TODO add your handling code here:
}//GEN-LAST:event_receivedjTableMouseClicked

private void madejTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_madejTable1MouseClicked
// TODO add your handling code here:
}//GEN-LAST:event_madejTable1MouseClicked

private void manufacturejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manufacturejButtonActionPerformed
// TODO add your handling code here:
    int selectedRow = receivedjTable.getSelectedRow();
    if (selectedRow < 0 || selectedRow > receivedjTable.getRowCount()) {
        return;
    }

    WorkRequest wr = (WorkRequest) receivedjTable.getValueAt(selectedRow, 0);
    wr.setEditorEnterprise(enterprise);
    
    
    Manufacturer m = (Manufacturer) enterprise;
    wr.getInventory().setManufacturer(m);

    Double pricePerVaccine = wr.getInventory().getVaccine().getPrice();
    int numberOfVaccines = wr.getInventory().getCount();


//    WorkRequest mwr = m.newWorkRequest(wr); //moves the request to the Manufacturer completed list
    m.newRequestManufactured(wr); //this is kind of obselete, but harmless.
    
//    m.newWorkRequest(wr);//remove the wr from the original list.


    Inventory inventory = m.getDistributor().newInventory();
    inventory.setCount(wr.getInventory().getCount());
    inventory.setManufacturer(m);
    inventory.setVaccine(wr.getInventory().getVaccine());
    inventory.setExpiration(); //sets the expiration date after the vaccine manufacture
    
//    add the new Inventory to the workd request
//    wr.setInventory(inventory);
    
    //here, I'm making the CDC foot the bill.
    
    WorkRequest cwr = wr.cloneWorkRequest(wr);
    CDC cdc = (CDC) m.getCdc();
    cdc.newWorkRequest(cwr); //put this in, because something funky is happening when WR gets copied to the list.
    
    Invoice cInvoice = new Invoice();
    cwr.setInvoice(cInvoice);
    
    cInvoice.setOwedTo(enterprise);
    cInvoice.setAmount(pricePerVaccine * numberOfVaccines);
    cInvoice.setPayment("unpaid");
    cInvoice.setStatus("payable");
    
    //make manufacturer remember that CDC owes it money
    Invoice mInvoice = new Invoice();
    wr.setInvoice(mInvoice);
    mInvoice.setAmount(pricePerVaccine * numberOfVaccines);
    mInvoice.setOwedTo(cdc);
    mInvoice.setPayment("unpaid"); 
    mInvoice.setStatus("receivable");

    
//    //here, I'm making the CDC foot the bill.
//    Invoice cInvoice = new Invoice(); //creates a new invoice
//    WorkRequest cwr = m.getCdc().newWorkRequest(wr);
//    cwr.setInvoice(cInvoice);
//
//    cInvoice.setOwedTo(enterprise);
//    cInvoice.setAmount(pricePerVaccine * numberOfVaccines);
//    cInvoice.setPayment("unpaid");
//    cInvoice.setStatus("payable");

//    inventory.setDateExpired(inventory.getDateCreated());
    //don't know how to set expirtation date yet.



//    
//    //first we make a new package
//    VaccinePackage p = m.getDistributor().newPackage();
//    p.setVaccine(wr.getInventory().getVaccine());
//    p.setManufacturer(m);
//    
//    //then we make a new inventory item in the package
//    Inventory inventory = p.getInventoryCatalog().newInventory();
//    inventory.setCount(wr.getInventory().getCount());
//    inventory.setManufacturer(m);
//    
//    p.getInventoryCatalog().getInventoryList().add(wr.getInventory());
//    
//    
//    //Inventory v = p.getInventoryCatalog().newInventory();
//    //v = wr.getInventory(); //populates the inventory item with the work request inventory            

    refreshRequested();//the bottom table, with requests made to the CDC
    refresh();


}//GEN-LAST:event_manufacturejButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable madejTable1;
    private javax.swing.JButton manufacturejButton;
    private javax.swing.JTable receivedjTable;
    private javax.swing.JButton refreshjButton;
    // End of variables declaration//GEN-END:variables
}