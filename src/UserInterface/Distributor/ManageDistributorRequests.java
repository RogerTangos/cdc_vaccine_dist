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

import Business.Enterprise.CDC;
import Business.Enterprise.Enterprise;
import Business.IndyPackage.WorkRequest;
import Business.IndyPackage.UserAccount;
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
public class ManageDistributorRequests extends javax.swing.JPanel {

    UserAccount ua;
    Enterprise enterprise;
    JPanel userProcessContainer;
    WorkRequest wr;

    /** Creates new form AddPerson */
    public ManageDistributorRequests(javax.swing.JPanel jp, Enterprise enterprise, UserAccount ua) {
        initComponents();
        this.enterprise = enterprise;
        userProcessContainer = jp;
        this.ua=ua;

        jLabel1.setText(enterprise.getOrgName() + " " + enterprise.getClass().getSimpleName()+" | Manage Requests");
        refresh();
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
        
        while(iter.hasNext()){
        Map.Entry entry = (Map.Entry) iter.next();
        ArrayList<WorkRequest> entryRequests = (ArrayList<WorkRequest>) entry.getValue();
        for(WorkRequest c : entryRequests){
            if(c.getInvoice()==null && c.getEditorEnterprise() instanceof CDC){
        
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
        shipjButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        enterprisejTextField = new javax.swing.JTextField();
        userjTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        vaccinejTextField = new javax.swing.JTextField();
        diseasejTextField = new javax.swing.JTextField();
        countjTextField = new javax.swing.JTextField();
        titlejTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        messagejTextArea = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        savejButton = new javax.swing.JButton();

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
                "Request Name", "Vaccine", "Count", "Originator Enterprise", "Originator Type"
            }
        ));
        receivedjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                receivedjTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(receivedjTable);

        shipjButton.setText("Arrange Shipment >>");
        shipjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shipjButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Originating Enterprise:");

        jLabel3.setText("Originating User:");

        enterprisejTextField.setEditable(false);

        userjTextField.setEditable(false);

        jLabel4.setText("Vaccines Requested:");

        jLabel5.setText("Vaccine Type:");

        jLabel6.setText("Associate Disease:");

        vaccinejTextField.setEditable(false);

        diseasejTextField.setEditable(false);

        countjTextField.setEditable(false);

        titlejTextField.setEditable(false);

        jLabel7.setText("Request Title:");

        messagejTextArea.setColumns(20);
        messagejTextArea.setRows(5);
        jScrollPane2.setViewportView(messagejTextArea);

        jLabel8.setText("Request Message:");

        savejButton.setText("Save Message");
        savejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savejButtonActionPerformed(evt);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backjButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 432, Short.MAX_VALUE)
                        .addComponent(savejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(refreshjButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 403, Short.MAX_VALUE)
                                .addComponent(shipjButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(countjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(diseasejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(vaccinejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(userjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(enterprisejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(titlejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE))))
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
                    .addComponent(shipjButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titlejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(enterprisejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(userjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(vaccinejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(diseasejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(countjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(backjButton)
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(savejButton)
                        .addContainerGap())))
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
    int selectedRow = receivedjTable.getSelectedRow();
    if (selectedRow < 0 || selectedRow > receivedjTable.getRowCount()) {
        return;
    }

    wr = (WorkRequest) receivedjTable.getValueAt(selectedRow, 0);
    
    titlejTextField.setText(wr.getTitle());
    enterprisejTextField.setText(wr.getOriginator().getOrgName());
    userjTextField.setText(wr.getCreator().getUserName());
    vaccinejTextField.setText(wr.getInventory().getVaccine().getName());
    diseasejTextField.setText(wr.getInventory().getVaccine().getDisease().getName());
    countjTextField.setText(Integer.toString(wr.getInventory().getCount()));
    messagejTextArea.setText(wr.getMessage());
    
}//GEN-LAST:event_receivedjTableMouseClicked

private void shipjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shipjButtonActionPerformed
// TODO add your handling code here:
    int selectedRow = receivedjTable.getSelectedRow();
    if (selectedRow < 0 || selectedRow > receivedjTable.getRowCount()) {
        return;
    }

    wr = (WorkRequest) receivedjTable.getValueAt(selectedRow, 0);
    
    
    ArrangeShipment awa = new ArrangeShipment(userProcessContainer, enterprise, ua, wr);
    userProcessContainer.add("Arrange a new shipment", awa);
    CardLayout c1 = (CardLayout) userProcessContainer.getLayout();
    c1.next(userProcessContainer);
    
}//GEN-LAST:event_shipjButtonActionPerformed

private void savejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savejButtonActionPerformed
// TODO add your handling code here:
    wr.setMessage(messagejTextArea.getText());
}//GEN-LAST:event_savejButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton;
    private javax.swing.JTextField countjTextField;
    private javax.swing.JTextField diseasejTextField;
    private javax.swing.JTextField enterprisejTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea messagejTextArea;
    private javax.swing.JTable receivedjTable;
    private javax.swing.JButton refreshjButton;
    private javax.swing.JButton savejButton;
    private javax.swing.JButton shipjButton;
    private javax.swing.JTextField titlejTextField;
    private javax.swing.JTextField userjTextField;
    private javax.swing.JTextField vaccinejTextField;
    // End of variables declaration//GEN-END:variables
}
