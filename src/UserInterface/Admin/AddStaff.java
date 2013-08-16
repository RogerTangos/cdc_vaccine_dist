/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddPerson.java
 *
 * Created on Nov 15, 2011, 6:42:05 PM
 */
package UserInterface.Admin;

import Business.Enterprise.Enterprise;
import Business.IndyPackage.Person;
import Business.IndyPackage.UserAccount;
import Business.Organization.Organization;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Albert Carter
 */
public class AddStaff extends javax.swing.JPanel {
    UserAccount UA;
    Organization o;
    Enterprise enterprise;
    JPanel userProcessContainer;
    /** Creates new form AddPerson */
    public AddStaff(javax.swing.JPanel jp, Enterprise enterprise, Organization o) {
        initComponents();
        this.enterprise = enterprise;
        userProcessContainer = jp;
        this.o=o;
        
        jLabel1.setText(enterprise.getOrgName() + " " + o.getOrgName() + " | Add Staff");
        refresh();
    }
    
    void refresh() {
        int rowcount = managejTable.getRowCount();
        int i;
        for (i = rowcount - 1; i >= 0; i--) {
            ((DefaultTableModel) managejTable.getModel()).removeRow(i);
        }
        ArrayList<UserAccount> plist = enterprise.getUserAccountDirectory().getUserAccountList();
        for (UserAccount ua : plist) {
            Object[] col = new Object[4];
            col[0] = ua;
            col[1] = ua.getPerson().getFirstName();
            col[2] = ua.getPerson().getLastName();
            col[3] = ua.getPerson().getDob();

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
        addUserAccountjButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        managejTable = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setText("jLabel1");

        backjButton.setText("<<Back");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });

        addUserAccountjButton.setText("Add to Staff");
        addUserAccountjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserAccountjButtonActionPerformed(evt);
            }
        });

        managejTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Username", "First Name", "Last Name", "DOB"
            }
        ));
        managejTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                managejTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(managejTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(backjButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(addUserAccountjButton))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addUserAccountjButton)
                    .addComponent(backjButton))
                .addContainerGap(112, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
// TODO add your handling code here:
    userProcessContainer.remove(this);
    CardLayout c3 = (CardLayout)userProcessContainer.getLayout();
    c3.previous(userProcessContainer);
}//GEN-LAST:event_backjButtonActionPerformed

private void addUserAccountjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserAccountjButtonActionPerformed
// TODO add your handling code here:
        
    o.getStaffDirectory().newStaff(UA, o);
    

    JOptionPane.showMessageDialog(null, UA.getUserName() + " - " + UA.getPerson() + " " + UA.getPerson().getLastName() + " Added to staff");
        
}//GEN-LAST:event_addUserAccountjButtonActionPerformed

private void managejTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_managejTableMouseClicked
// TODO add your handling code here:
    //make sure o is empty, or it will give a null pointer.

    int selectedRow = managejTable.getSelectedRow();
    if (selectedRow < 0 || selectedRow > managejTable.getRowCount()) {
        return;
    }

    UA = (UserAccount) managejTable.getValueAt(selectedRow, 0);


}//GEN-LAST:event_managejTableMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addUserAccountjButton;
    private javax.swing.JButton backjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable managejTable;
    // End of variables declaration//GEN-END:variables
}
