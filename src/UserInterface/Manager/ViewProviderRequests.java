/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddPerson.java
 *
 * Created on Nov 15, 2011, 6:42:05 PM
 */
package UserInterface.Manager;

import Business.IndyPackage.WorkRequest;
import Business.IndyPackage.UserAccount;
import Business.Providers.Provider;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Albert Carter
 */
public class ViewProviderRequests extends javax.swing.JPanel {

    UserAccount ua;
    Provider p;
    WorkRequest wr;
    JPanel userProcessContainer;

    /** Creates new form AddPerson */
    public ViewProviderRequests(javax.swing.JPanel jp, Provider p, UserAccount ua) {
        initComponents();
        this.p = p;
        userProcessContainer = jp;
        this.ua=ua;
        
        jLabel1.setText(p.getOrgName() + " " + p.getClass().getSimpleName()+" | Existing Requests");
        refresh();
    }
    
    
    void refresh() {
        int rowcount = managejTable.getRowCount();
        int i;
        for (i = rowcount - 1; i >= 0; i--) {
            ((DefaultTableModel) managejTable.getModel()).removeRow(i);
        }

        
        Map map = (Map) p.getWorkRequestList(); //cast the HashMap to map
        Set set = map.entrySet(); //and get the entry set
        
        Iterator iter = set.iterator(); //get the number of entries
        
        while(iter.hasNext()){
        Map.Entry entry = (Map.Entry) iter.next();
        ArrayList<WorkRequest> entryRequests = (ArrayList<WorkRequest>) entry.getValue();
        for(WorkRequest c : entryRequests){
            if(c.getInvoice() == null){//shouldn't have an invoice (as in is not fulfilled)
        
            Object[] col = new Object[6];
            col[0] = c;
            col[1] = c.getInventory().getVaccine().getName();
            col[2] = c.getInventory().getCount();
            col[3] = c.getCreator();
            col[4] = c.getInventory().getVaccine().getDisease();

            ((DefaultTableModel) managejTable.getModel()).addRow(col);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        managejTable = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        refreshjButton = new javax.swing.JButton();
        updatejButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        messagejTextArea = new javax.swing.JTextArea();
        addjButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        duplicatejButton = new javax.swing.JButton();

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
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Request Title", "Vaccine Name", "Count", "Creator", "Disease"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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

        updatejButton.setText("Update");
        updatejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatejButtonActionPerformed(evt);
            }
        });

        messagejTextArea.setColumns(20);
        messagejTextArea.setRows(5);
        jScrollPane2.setViewportView(messagejTextArea);

        addjButton.setText("Add Request");
        addjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addjButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Previous Requests:");

        duplicatejButton.setText("Reorder Selected Order");
        duplicatejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duplicatejButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(backjButton)
                                    .addComponent(refreshjButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 289, Short.MAX_VALUE)
                                .addComponent(duplicatejButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(addjButton)
                                    .addComponent(updatejButton)))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE))
                    .addComponent(jLabel2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshjButton)
                    .addComponent(addjButton)
                    .addComponent(duplicatejButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backjButton)
                    .addComponent(updatejButton))
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
    int selectedRow = managejTable.getSelectedRow();
    if (selectedRow < 0 || selectedRow > managejTable.getRowCount()) {
        return;
    }

    wr = (WorkRequest) managejTable.getValueAt(selectedRow, 0);

    messagejTextArea.setText(wr.getMessage());
    
    
}//GEN-LAST:event_managejTableMouseClicked

private void updatejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatejButtonActionPerformed
// TODO add your handling code here:
    if(wr!=null){
    wr.setMessage(messagejTextArea.getText());
    refresh();
    }
}//GEN-LAST:event_updatejButtonActionPerformed

private void addjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addjButtonActionPerformed
// TODO add your handling code here:
    AddProviderVaccineRequest awa = new AddProviderVaccineRequest(userProcessContainer, p, ua);
    userProcessContainer.add("AdminWorkAreaJPanel", awa);
    CardLayout c1 = (CardLayout) userProcessContainer.getLayout();
    c1.next(userProcessContainer);
}//GEN-LAST:event_addjButtonActionPerformed

private void duplicatejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duplicatejButtonActionPerformed
// TODO add your handling code here:
    WorkRequest countRequest = new WorkRequest();
    WorkRequest newWorkRequest = wr.cloneWorkRequest(wr);
    newWorkRequest.setCreator(ua);
    newWorkRequest.setEditorEnterprise(p);
    newWorkRequest.setCount(countRequest.getCount());
    
    p.newWorkRequest(newWorkRequest);
    p.getPhd().newWorkRequest(newWorkRequest);
    refresh();
    JOptionPane.showMessageDialog(null, "Vaccine request duplicated");
}//GEN-LAST:event_duplicatejButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addjButton;
    private javax.swing.JButton backjButton;
    private javax.swing.JButton duplicatejButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable managejTable;
    private javax.swing.JTextArea messagejTextArea;
    private javax.swing.JButton refreshjButton;
    private javax.swing.JButton updatejButton;
    // End of variables declaration//GEN-END:variables
}