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
import Business.IndyPackage.UserAccount;
import Business.IndyPackage.VaccinePackage;
import Business.Providers.Inventory;
import UserInterface.Distributor.ManageWarehouses;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Albert Carter
 */
public class SeeDistributorInventory extends javax.swing.JPanel {

    UserAccount ua;
    Enterprise e;
    JPanel userProcessContainer;

    /** Creates new form AddPerson */
    public SeeDistributorInventory(javax.swing.JPanel jp, Enterprise e, UserAccount ua) {
        initComponents();
        this.e = e;
        userProcessContainer = jp;
        this.ua=ua;

        jLabel1.setText(e.getOrgName() + " " + e.getClass().getSimpleName()+" | Manage Inventory");
        refresh();
    }

    void refresh() {
        int rowcount = managejTable.getRowCount();
        int i;
        for (i = rowcount - 1; i >= 0; i--) {
            ((DefaultTableModel) managejTable.getModel()).removeRow(i);
        }
        
        //you need to make this show all of the inventory catalogs and their inventory
        //so make it show the inventory catalog and count up the inventory items
        //then make a button to view the inventoryCatalog in detail
        
        Distributor d = (Distributor) e;
        
        ArrayList<Inventory> clist = d.getInventoryList();
        for (Inventory c : clist) {
            Object[] col = new Object[3];
            col[0] = c;
            col[1] = c.getCount();
            col[2] = c.getWarehouse();
            
            ((DefaultTableModel) managejTable.getModel()).addRow(col);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        managejTable = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        refreshjButton = new javax.swing.JButton();
        editjButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setText("jLabel1");

        backjButton.setText("<<Back");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });

        managejTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Vaccine Name", "Count", "Warehouse"
            }
        ));
        managejTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                managejTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(managejTable);

        refreshjButton.setText("Refresh");
        refreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjButtonActionPerformed(evt);
            }
        });

        editjButton.setText("Edit Packages");
        editjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backjButton))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jSeparator1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(refreshjButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(editjButton))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshjButton)
                    .addComponent(editjButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 252, Short.MAX_VALUE)
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

private void managejTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_managejTableMouseClicked
// TODO add your handling code here:
    //make sure ua is empty, or it will give a null pointer.
}//GEN-LAST:event_managejTableMouseClicked

private void editjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editjButtonActionPerformed
// TODO add your handling code here:
    int selectedRow = managejTable.getSelectedRow();
    if (selectedRow < 0 || selectedRow > managejTable.getRowCount()) {
        return;
    }

    Inventory p = (Inventory) managejTable.getValueAt(selectedRow, 0);
    
    ManageWarehouses awa = new ManageWarehouses(userProcessContainer, e, ua, p);
    userProcessContainer.add("Manage Distributor Packages", awa);
    CardLayout c1 = (CardLayout) userProcessContainer.getLayout();
    c1.next(userProcessContainer);
    
}//GEN-LAST:event_editjButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton;
    private javax.swing.JButton editjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable managejTable;
    private javax.swing.JButton refreshjButton;
    // End of variables declaration//GEN-END:variables
}