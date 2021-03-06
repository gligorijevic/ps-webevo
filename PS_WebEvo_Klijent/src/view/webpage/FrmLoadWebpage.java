package view.webpage;

import java.io.IOException;
import javax.swing.JOptionPane;
import view.controller.webpage.ControllerLoadWebpageFromUrl;

/**
 *
 * @author Djordje Gligorijevic
 */
public class FrmLoadWebpage extends javax.swing.JFrame {

    private ControllerLoadWebpageFromUrl clwfu;

    /**
     * Creates new form FrmLoadWebpage
     */
    public FrmLoadWebpage() {
        initComponents();
//        treeViewNodes.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
//        treeViewNodes.addTreeSelectionListener(new TreeSelectionListener() {
//            @Override
//            public void valueChanged(TreeSelectionEvent e) {
//                DefaultMutableTreeNode node = (DefaultMutableTreeNode) getTreeViewNodes().getLastSelectedPathComponent();
//                /* if nothing is selected */
//                if (node == null) {
//                    return;
//                } else {
//                    try {
//                        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) node.getParent();
//                        if (parent != null) {
//                            DefaultMutableTreeNode grandparent = (DefaultMutableTreeNode) parent.getParent();
//
//                            int place = parent.getIndex(node);
//
//                            kgf.selekcijaElementa(node, parent, grandparent, place);
//                        } else {
//                            kgf.selekcijaElementa(node, parent, null, -1);
//                        }
//                    } catch (Exception ex) {
//                        JOptionPane.showMessageDialog(rootPane, ex.getMessage());
//                    }
//                }
//
//                /* retrieve the node that was selected */
////                Object nodeInfo = node.getUserObject();
//
//                /* React to the node selection. */
//
//            }
//        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtFUrl = new javax.swing.JTextField();
        btnLoadPage = new javax.swing.JButton();
        jSplitPane2 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        treeViewNodes = new javax.swing.JTree();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtAreaHTMLCode = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Load webpage from url");

        jLabel1.setText("Enter URL address here: ");

        txtFUrl.setText("http://www.example.com");

        btnLoadPage.setText("Load webpage from Url");
        btnLoadPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadPageActionPerformed(evt);
            }
        });

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        treeViewNodes.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane1.setViewportView(treeViewNodes);

        jSplitPane2.setLeftComponent(jScrollPane1);

        txtAreaHTMLCode.setColumns(20);
        txtAreaHTMLCode.setRows(5);
        jScrollPane4.setViewportView(txtAreaHTMLCode);

        jSplitPane2.setRightComponent(jScrollPane4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnLoadPage)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFUrl)))
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLoadPage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadPageActionPerformed
        try {
            clwfu.parseWebpageFromUrl();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "There has been an error loading webpage: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnLoadPageActionPerformed

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
            java.util.logging.Logger.getLogger(FrmLoadWebpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLoadWebpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLoadWebpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLoadWebpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmLoadWebpage().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoadPage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTree treeViewNodes;
    private javax.swing.JTextArea txtAreaHTMLCode;
    private javax.swing.JTextField txtFUrl;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the btnLoadPage
     */
    public javax.swing.JButton getBtnLoadPage() {
        return btnLoadPage;
    }

    /**
     * @param btnLoadPage the btnLoadPage to set
     */
    public void setBtnLoadPage(javax.swing.JButton btnLoadPage) {
        this.btnLoadPage = btnLoadPage;
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
     * @return the treeViewNodes
     */
    public javax.swing.JTree getTreeViewNodes() {
        return treeViewNodes;
    }

    /**
     * @param treeViewNodes the treeViewNodes to set
     */
    public void setTreeViewNodes(javax.swing.JTree treeViewNodes) {
        this.treeViewNodes = treeViewNodes;
    }

    /**
     * @return the txtFUrl
     */
    public javax.swing.JTextField getTxtFUrl() {
        return txtFUrl;
    }

    /**
     * @param txtFUrl the txtFUrl to set
     */
    public void setTxtFUrl(javax.swing.JTextField txtFUrl) {
        this.txtFUrl = txtFUrl;
    }

    /**
     * @return the clwfu
     */
    public ControllerLoadWebpageFromUrl getClwfu() {
        return clwfu;
    }

    /**
     * @param clwfu the clwfu to set
     */
    public void setClwfu(ControllerLoadWebpageFromUrl clwfu) {
        this.clwfu = clwfu;
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
     * @return the jScrollPane4
     */
    public javax.swing.JScrollPane getjScrollPane4() {
        return jScrollPane4;
    }

    /**
     * @param jScrollPane4 the jScrollPane4 to set
     */
    public void setjScrollPane4(javax.swing.JScrollPane jScrollPane4) {
        this.jScrollPane4 = jScrollPane4;
    }

    /**
     * @return the jSplitPane2
     */
    public javax.swing.JSplitPane getjSplitPane2() {
        return jSplitPane2;
    }

    /**
     * @param jSplitPane2 the jSplitPane2 to set
     */
    public void setjSplitPane2(javax.swing.JSplitPane jSplitPane2) {
        this.jSplitPane2 = jSplitPane2;
    }

    /**
     * @return the txtAreaHTMLCode
     */
    public javax.swing.JTextArea getTxtAreaHTMLCode() {
        return txtAreaHTMLCode;
    }

    /**
     * @param txtAreaHTMLCode the txtAreaHTMLCode to set
     */
    public void setTxtAreaHTMLCode(javax.swing.JTextArea txtAreaHTMLCode) {
        this.txtAreaHTMLCode = txtAreaHTMLCode;
    }
}
