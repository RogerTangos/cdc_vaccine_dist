/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddPerson.java
 *
 * Created on Nov 15, 2011, 6:42:05 PM
 */
package UserInterface.CDC;

import Business.Enterprise.CDC;
import Business.Enterprise.Enterprise;
import Business.IndyPackage.Disease;
import Business.IndyPackage.UserAccount;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Albert Carter
 */
public class ManageCDCDiseases extends javax.swing.JPanel {
    Disease D;
    UserAccount ua;
    Enterprise e;
    JPanel userProcessContainer;
    /** Creates new form AddPerson */
    public ManageCDCDiseases(javax.swing.JPanel jp, Enterprise e, UserAccount ua) {
        initComponents();
        this.e = e;
        userProcessContainer = jp;
        this.ua=ua;
        
        jLabel1.setText(e.getOrgName() + " " + e.getClass().getSimpleName()+ " | Add Diseases to Catalog");
        refresh();
    }
    
    void refresh() {
        int rowcount = managejTable.getRowCount();
        int i;
        for (i = rowcount - 1; i >= 0; i--) {
            ((DefaultTableModel) managejTable.getModel()).removeRow(i);
        }
        CDC cdc = (CDC) e;
        ArrayList<Disease> clist = cdc.getSystem().getDiseaseCatalog().getDiseaseList();
        for (Disease c : clist) {
            Object[] col = new Object[3];
            col[0] = c;

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
        addDiseasejButton = new javax.swing.JButton();
        namejTextField = new javax.swing.JTextField();
        titlejLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        managejTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        savejButton = new javax.swing.JButton();
        refreshjButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setText("jLabel1");

        backjButton.setText("<<Back");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });

        addDiseasejButton.setText("Add New Disease");
        addDiseasejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDiseasejButtonActionPerformed(evt);
            }
        });

        titlejLabel.setText("Disease Name:");

        managejTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Disease"
            }
        ));
        managejTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                managejTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(managejTable);

        jLabel4.setText("Current Diseases Cataloged:");

        savejButton.setText("Save Disease Changes");
        savejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savejButtonActionPerformed(evt);
            }
        });

        refreshjButton.setText("Refresh");
        refreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backjButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                        .addComponent(savejButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(titlejLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(namejTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(refreshjButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
                        .addComponent(addDiseasejButton))
                    .addComponent(jLabel4))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addDiseasejButton)
                    .addComponent(refreshjButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titlejLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backjButton)
                    .addComponent(savejButton))
                .addGap(34, 34, 34))
        );
    }// </editor-fold>//GEN-END:initComponents

private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
// TODO add your handling code here:
    userProcessContainer.remove(this);
    CardLayout c3 = (CardLayout)userProcessContainer.getLayout();
    c3.previous(userProcessContainer);
}//GEN-LAST:event_backjButtonActionPerformed

private void addDiseasejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDiseasejButtonActionPerformed
// TODO add your handling code here:
    AddCDCDisease awa = new AddCDCDisease(userProcessContainer, e, ua);
    userProcessContainer.add("Add New Disease", awa);
    CardLayout c1 = (CardLayout) userProcessContainer.getLayout();
    c1.next(userProcessContainer);
}//GEN-LAST:event_addDiseasejButtonActionPerformed

private void managejTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_managejTableMouseClicked
// TODO add your handling code here:
    int selectedRow = managejTable.getSelectedRow();
    if (selectedRow < 0 || selectedRow > managejTable.getRowCount()) {
        return;
    }

    D = (Disease) managejTable.getValueAt(selectedRow, 0);
    namejTextField.setText(D.getName());
}//GEN-LAST:event_managejTableMouseClicked

private void savejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savejButtonActionPerformed
// TODO add your handling code here:
    D.setName(namejTextField.getText());
    refresh();
    JOptionPane.showMessageDialog(null, "Disease Updated");
}//GEN-LAST:event_savejButtonActionPerformed

private void refreshjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshjButtonActionPerformed
// TODO add your handling code here:
refresh();
}//GEN-LAST:event_refreshjButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDiseasejButton;
    private javax.swing.JButton backjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable managejTable;
    private javax.swing.JTextField namejTextField;
    private javax.swing.JButton refreshjButton;
    private javax.swing.JButton savejButton;
    private javax.swing.JLabel titlejLabel;
    // End of variables declaration//GEN-END:variables
}