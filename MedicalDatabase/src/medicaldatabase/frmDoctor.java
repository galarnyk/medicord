/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package medicaldatabase;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Seth
 */
public class frmDoctor extends javax.swing.JFrame {

    Login loginForm = null;
    frmDoctorApptInfo doctorApptForm = null;
    
    ArrayList <String> appDates;
    ArrayList<String> patientNames;
    
    
    public frmDoctor(Login frm){
        initComponents();
        this.loginForm = frm;
        String userId = loginForm.getUserId();
        populate(userId);
    }

    public frmDoctor(String userId)
    {
        initComponents();
        populate(userId);
    }
    
    private void populate(String userId)
    {
        //setting the basic information tab
        doctorId.setText(userId);
        try
        {
            ResultSet rsK = Importdb.getUserInfo(userId);
            if (rsK==null)
            {
                throw new Exception("null result set");
            }
            while (rsK.next())
            {
                if (rsK.getString("name") != null && rsK.getString("name").isEmpty()==false)
                {
                    nameTextField.setText(rsK.getString("name"));
                }
                String gender;
                if (rsK.getString("gender") != null && rsK.getString("gender").isEmpty()==false)
                {
                    gender = rsK.getString("gender");
                    if (gender.toUpperCase().contains("M"))
                    {
                        maleRadioBtn.setSelected(true);
                    }
                    else
                    {
                        femaleRadioBtn.setSelected(true);
                    }
                }
                if (rsK.getString("SPECIALIZATION") != null && rsK.getString("SPECIALIZATION").isEmpty()==false)
                {
                    specialtiesTextField.setText(rsK.getString("SPECIALIZATION"));
                }
                if (rsK.getString("HOSPITAL") != null && rsK.getString("HOSPITAL").isEmpty()==false)
                {
                    hospitalTextField.setText(rsK.getString("HOSPITAL"));
                }                
            }
            
            //set the appointment tab
            rsK = Importdb.viewAppointments(userId);
            int rowNum=1;
            //DefaultTableModel model = new DefaultTableModel();  
            if (rsK!=null)
            {
                DefaultTableModel model = (DefaultTableModel) tblAppointments.getModel();
                while(rsK.next())
                {
                    String patientId = rsK.getString("pid");
                    String patientName = Importdb.getName(patientId);
                    String appDate = rsK.getString("dates");                    
                    model.addRow(new Object[]{rowNum ,patientName ,appDate});
                    rowNum++;
                }
            }
            //tblAppointments.setModel(model);
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        welcomeLabel = new javax.swing.JLabel();
        logoutLabel = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        basicInfoPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        specialtiesLabel = new javax.swing.JLabel();
        specialtiesTextField = new javax.swing.JTextField();
        companyLabel = new javax.swing.JLabel();
        hospitalTextField = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        phoneTextField = new javax.swing.JTextField();
        saveInfoButton = new javax.swing.JButton();
        doctorId = new javax.swing.JLabel();
        doctorIdLabel = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        maleRadioBtn = new javax.swing.JRadioButton();
        femaleRadioBtn = new javax.swing.JRadioButton();
        patientListPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAppointments = new javax.swing.JTable();

        buttonGroup1.add(maleRadioBtn);
        buttonGroup1.add(femaleRadioBtn);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        welcomeLabel.setText("Welcome username!");

        logoutLabel.setText("Logout");
        logoutLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutLabelMouseClicked(evt);
            }
        });

        nameLabel.setText("Name");

        specialtiesLabel.setText("Specialties");

        companyLabel.setText("Hospital");

        phoneLabel.setText("Phone");

        saveInfoButton.setText("Save");
        saveInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveInfoButtonActionPerformed(evt);
            }
        });

        doctorId.setText("value");

        doctorIdLabel.setText("Doctor ID");

        genderLabel.setText("Gender");

        maleRadioBtn.setSelected(true);
        maleRadioBtn.setText("Male");

        femaleRadioBtn.setText("Female");

        javax.swing.GroupLayout basicInfoPanelLayout = new javax.swing.GroupLayout(basicInfoPanel);
        basicInfoPanel.setLayout(basicInfoPanelLayout);
        basicInfoPanelLayout.setHorizontalGroup(
            basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basicInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(basicInfoPanelLayout.createSequentialGroup()
                        .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel)
                            .addComponent(doctorIdLabel)
                            .addComponent(genderLabel))
                        .addGap(99, 99, 99)
                        .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(doctorId)
                            .addGroup(basicInfoPanelLayout.createSequentialGroup()
                                .addComponent(maleRadioBtn)
                                .addGap(18, 18, 18)
                                .addComponent(femaleRadioBtn))))
                    .addGroup(basicInfoPanelLayout.createSequentialGroup()
                        .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phoneLabel)
                            .addComponent(companyLabel)
                            .addComponent(specialtiesLabel))
                        .addGap(89, 89, 89)
                        .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hospitalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(specialtiesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(saveInfoButton)
                                .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        basicInfoPanelLayout.setVerticalGroup(
            basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basicInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(doctorId)
                    .addComponent(doctorIdLabel))
                .addGap(18, 18, 18)
                .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(femaleRadioBtn)
                    .addComponent(maleRadioBtn)
                    .addComponent(genderLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(specialtiesLabel)
                    .addComponent(specialtiesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(companyLabel)
                    .addComponent(hospitalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(basicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneLabel)
                    .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(saveInfoButton)
                .addGap(165, 165, 165))
        );

        jTabbedPane1.addTab("Basic Information", basicInfoPanel);

        tblAppointments.setRowSelectionAllowed(true);
        tblAppointments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Patient Name", "Date of appointment"
            }){
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }

            }

        );
        tblAppointments.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(tblAppointments);

        javax.swing.GroupLayout patientListPanelLayout = new javax.swing.GroupLayout(patientListPanel);
        patientListPanel.setLayout(patientListPanelLayout);
        patientListPanelLayout.setHorizontalGroup(
            patientListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 392, Short.MAX_VALUE)
            .addGroup(patientListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, patientListPanelLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        patientListPanelLayout.setVerticalGroup(
            patientListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 283, Short.MAX_VALUE)
            .addGroup(patientListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, patientListPanelLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("Patient List", patientListPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(welcomeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logoutLabel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(welcomeLabel)
                    .addComponent(logoutLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutLabelMouseClicked
        // TODO add your handling code here:        
        loginForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutLabelMouseClicked

    private void saveInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveInfoButtonActionPerformed
        // TODO add your handling code here:
        if (maleRadioBtn.isSelected())
        {
            Importdb.setDoctorProfile(doctorId.getText(), nameTextField.getText(), hospitalTextField.getText(), specialtiesTextField.getText(), "M");
        }
        else
        {
            Importdb.setDoctorProfile(doctorId.getText(), nameTextField.getText(), hospitalTextField.getText(), specialtiesTextField.getText(), "F");
        }
        JOptionPane.showMessageDialog(null, "Information has been saved!");
    }//GEN-LAST:event_saveInfoButtonActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /*
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDoctor("d2").setVisible(true);
            }
        });
        * */
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel basicInfoPanel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel companyLabel;
    private javax.swing.JLabel doctorId;
    private javax.swing.JLabel doctorIdLabel;
    private javax.swing.JRadioButton femaleRadioBtn;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JTextField hospitalTextField;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel logoutLabel;
    private javax.swing.JRadioButton maleRadioBtn;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JPanel patientListPanel;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JButton saveInfoButton;
    private javax.swing.JLabel specialtiesLabel;
    private javax.swing.JTextField specialtiesTextField;
    private javax.swing.JTable tblAppointments;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
