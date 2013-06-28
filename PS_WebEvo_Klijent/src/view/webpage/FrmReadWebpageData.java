/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.webpage;

import java.io.IOException;
import javax.swing.JOptionPane;
import view.controller.webpage.ControllerReadWebpageData;

/**
 *
 * @author Djordje Gligorijevic
 */
public class FrmReadWebpageData extends javax.swing.JFrame {

    private ControllerReadWebpageData controllerReadWebpageData;

    /**
     * Creates new form FrmReadWebpageData
     */
    public FrmReadWebpageData() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFWebpageUrl = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAWebpage = new javax.swing.JTextArea();
        btnLoad = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnCopyData = new javax.swing.JButton();
        lblCopyDataResult = new javax.swing.JLabel();
        btnSaveData = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Read webpage"));

        jLabel1.setText("Webpage url: ");

        txtFWebpageUrl.setText("http://www.example.com");

        txtAWebpage.setEditable(false);
        txtAWebpage.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        txtAWebpage.setColumns(20);
        txtAWebpage.setRows(5);
        jScrollPane1.setViewportView(txtAWebpage);

        btnLoad.setText("Load");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Copy data"));

        btnCopyData.setText("Copy data");
        btnCopyData.setToolTipText("Copies data broj JSoup structure to WebEvo virtual structure.");
        btnCopyData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopyDataActionPerformed(evt);
            }
        });

        btnSaveData.setText("Save webpage");
        btnSaveData.setToolTipText("Saves webpage loaded in virtual memory.");
        btnSaveData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnSaveData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCopyData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addComponent(lblCopyDataResult, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(lblCopyDataResult)
                .addGap(43, 43, 43))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCopyData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSaveData))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtFWebpageUrl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLoad))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFWebpageUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        try {
            controllerReadWebpageData.parseWebpageFromUrl();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnLoadActionPerformed
    
    private void btnCopyDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopyDataActionPerformed
        controllerReadWebpageData.copyHtmlPageStructure();
    }//GEN-LAST:event_btnCopyDataActionPerformed
    
    private void btnSaveDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveDataActionPerformed
//        try {
//            controllerReadWebpageData.saveCopiedHtmlPage();
//        } catch (Exception ex) {
//            lblCopyDataResult.setText("Error: " + ex.getMessage());
//        }
        FrmDefineWebsite frmDefineWebsite = new FrmDefineWebsite(this, true);
        frmDefineWebsite.setControllerReadWebpageData(controllerReadWebpageData);
        controllerReadWebpageData.setFrmDefineWebsite(frmDefineWebsite);
        controllerReadWebpageData.fillCbOnFrmDefineWebsite();
        frmDefineWebsite.setVisible(true);
    }//GEN-LAST:event_btnSaveDataActionPerformed

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
            java.util.logging.Logger.getLogger(FrmReadWebpageData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmReadWebpageData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmReadWebpageData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmReadWebpageData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmReadWebpageData().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCopyData;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnSaveData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCopyDataResult;
    private javax.swing.JTextArea txtAWebpage;
    private javax.swing.JTextField txtFWebpageUrl;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the controllerReadWebpageData
     */
    public ControllerReadWebpageData getControllerReadWebpageData() {
        return controllerReadWebpageData;
    }

    /**
     * @param controllerReadWebpageData the controllerReadWebpageData to set
     */
    public void setControllerReadWebpageData(ControllerReadWebpageData controllerReadWebpageData) {
        this.controllerReadWebpageData = controllerReadWebpageData;
    }

    /**
     * @return the btnCopyData
     */
    public javax.swing.JButton getBtnCopyData() {
        return btnCopyData;
    }

    /**
     * @param btnCopyData the btnCopyData to set
     */
    public void setBtnCopyData(javax.swing.JButton btnCopyData) {
        this.btnCopyData = btnCopyData;
    }

    /**
     * @return the btnLoad
     */
    public javax.swing.JButton getBtnLoad() {
        return btnLoad;
    }

    /**
     * @param btnLoad the btnLoad to set
     */
    public void setBtnLoad(javax.swing.JButton btnLoad) {
        this.btnLoad = btnLoad;
    }

    /**
     * @return the jLabel1
     */
    public javax.swing.JLabel getjLabel1() {
        return jLabel1;
    }

    /**
     * @param jLabel1 the jLabel1 to set
     */
    public void setjLabel1(javax.swing.JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    /**
     * @return the jPanel1
     */
    public javax.swing.JPanel getjPanel1() {
        return jPanel1;
    }

    /**
     * @param jPanel1 the jPanel1 to set
     */
    public void setjPanel1(javax.swing.JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    /**
     * @return the jPanel2
     */
    public javax.swing.JPanel getjPanel2() {
        return jPanel2;
    }

    /**
     * @param jPanel2 the jPanel2 to set
     */
    public void setjPanel2(javax.swing.JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    /**
     * @return the jScrollPane1
     */
    public javax.swing.JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    /**
     * @param jScrollPane1 the jScrollPane1 to set
     */
    public void setjScrollPane1(javax.swing.JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    /**
     * @return the lblCopyDataResult
     */
    public javax.swing.JLabel getLblCopyDataResult() {
        return lblCopyDataResult;
    }

    /**
     * @param lblCopyDataResult the lblCopyDataResult to set
     */
    public void setLblCopyDataResult(javax.swing.JLabel lblCopyDataResult) {
        this.lblCopyDataResult = lblCopyDataResult;
    }

    /**
     * @return the txtAWebpage
     */
    public javax.swing.JTextArea getTxtAWebpage() {
        return txtAWebpage;
    }

    /**
     * @param txtAWebpage the txtAWebpage to set
     */
    public void setTxtAWebpage(javax.swing.JTextArea txtAWebpage) {
        this.txtAWebpage = txtAWebpage;
    }

    /**
     * @return the txtFWebpageUrl
     */
    public javax.swing.JTextField getTxtFWebpageUrl() {
        return txtFWebpageUrl;
    }

    /**
     * @param txtFWebpageUrl the txtFWebpageUrl to set
     */
    public void setTxtFWebpageUrl(javax.swing.JTextField txtFWebpageUrl) {
        this.txtFWebpageUrl = txtFWebpageUrl;
    }
}
