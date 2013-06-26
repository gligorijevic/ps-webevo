/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.main.ControllerMain;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Djordje Gligorijevic
 */
public class FrmMain extends javax.swing.JFrame {

    private ControllerMain controllerMain;

    /**
     * Creates new form FrmMain
     */
    public FrmMain() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
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

        jMenuItem5 = new javax.swing.JMenuItem();
        pnlMain = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mCorpus = new javax.swing.JMenu();
        miAddCorpus = new javax.swing.JMenuItem();
        miCorpusPreview = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        miPreviewCorpus = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        miAddSentence = new javax.swing.JMenuItem();
        mTrain = new javax.swing.JMenu();
        miTraingTagger = new javax.swing.JMenuItem();
        mWebsite = new javax.swing.JMenu();
        miLoadWebpageFromUrl = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        mAnotateText = new javax.swing.JMenu();
        mAbout = new javax.swing.JMenu();
        miAboutWebEvo = new javax.swing.JMenuItem();
        miAboutLingPipe = new javax.swing.JMenuItem();
        miAboutJsoup = new javax.swing.JMenuItem();
        miAboutJpa = new javax.swing.JMenuItem();

        jMenuItem5.setText("jMenuItem5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Web Evoluton");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/wc.png"))); // NOI18N

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
        );

        getContentPane().add(pnlMain, java.awt.BorderLayout.CENTER);

        mCorpus.setText("Korpus");

        miAddCorpus.setText("Add new corpus");
        miAddCorpus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAddCorpusActionPerformed(evt);
            }
        });
        mCorpus.add(miAddCorpus);

        miCorpusPreview.setText("All corpuses preview");
        miCorpusPreview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCorpusPreviewActionPerformed(evt);
            }
        });
        mCorpus.add(miCorpusPreview);
        mCorpus.add(jSeparator1);

        miPreviewCorpus.setText("Preview selected corpus");
        miPreviewCorpus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPreviewCorpusActionPerformed(evt);
            }
        });
        mCorpus.add(miPreviewCorpus);
        mCorpus.add(jSeparator2);

        miAddSentence.setText("Add new sentence to a corpus");
        miAddSentence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAddSentenceActionPerformed(evt);
            }
        });
        mCorpus.add(miAddSentence);

        jMenuBar1.add(mCorpus);

        mTrain.setText(" Train");

        miTraingTagger.setText("  Train tagging model");
        miTraingTagger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miTraingTaggerActionPerformed(evt);
            }
        });
        mTrain.add(miTraingTagger);

        jMenuBar1.add(mTrain);

        mWebsite.setText("Website");

        miLoadWebpageFromUrl.setText("Load webpage from Url");
        miLoadWebpageFromUrl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLoadWebpageFromUrlActionPerformed(evt);
            }
        });
        mWebsite.add(miLoadWebpageFromUrl);

        jMenuItem1.setText("Read webpage data");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mWebsite.add(jMenuItem1);

        jMenuBar1.add(mWebsite);

        mAnotateText.setText(" Anotate text");
        jMenuBar1.add(mAnotateText);

        mAbout.setText("About");

        miAboutWebEvo.setText("About WebEvo");
        miAboutWebEvo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAboutWebEvoActionPerformed(evt);
            }
        });
        mAbout.add(miAboutWebEvo);

        miAboutLingPipe.setText("About LingPipe");
        miAboutLingPipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAboutLingPipeActionPerformed(evt);
            }
        });
        mAbout.add(miAboutLingPipe);

        miAboutJsoup.setText("About JSoup");
        miAboutJsoup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAboutJsoupActionPerformed(evt);
            }
        });
        mAbout.add(miAboutJsoup);

        miAboutJpa.setText("Abut JPA");
        miAboutJpa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAboutJpaActionPerformed(evt);
            }
        });
        mAbout.add(miAboutJpa);

        jMenuBar1.add(mAbout);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miAddSentenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAddSentenceActionPerformed
//        controllerMain.addTaggedSentenceForm(this);
    }//GEN-LAST:event_miAddSentenceActionPerformed

    private void miCorpusPreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCorpusPreviewActionPerformed
//        controllerMain.frmKorpusesPreview(this);
    }//GEN-LAST:event_miCorpusPreviewActionPerformed

    private void miPreviewCorpusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPreviewCorpusActionPerformed
//        controllerMain.frmKorpusPreview();
    }//GEN-LAST:event_miPreviewCorpusActionPerformed

    private void miAddCorpusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAddCorpusActionPerformed
//        controllerMain.frmAddKorpus();
    }//GEN-LAST:event_miAddCorpusActionPerformed

    private void miTraingTaggerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miTraingTaggerActionPerformed
//        controllerMain.frmTrainingTaggerModel();
    }//GEN-LAST:event_miTraingTaggerActionPerformed

    private void miLoadWebpageFromUrlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLoadWebpageFromUrlActionPerformed
//        controllerMain.frmLoadWebpage();
    }//GEN-LAST:event_miLoadWebpageFromUrlActionPerformed

    private void miAboutWebEvoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAboutWebEvoActionPerformed
//        controllerMain.frmAboutWebEvo();
    }//GEN-LAST:event_miAboutWebEvoActionPerformed

    private void miAboutLingPipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAboutLingPipeActionPerformed
//        controllerMain.frmAboutLingPipe();
    }//GEN-LAST:event_miAboutLingPipeActionPerformed

    private void miAboutJsoupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAboutJsoupActionPerformed
//        controllerMain.frmAboutJSoup();
    }//GEN-LAST:event_miAboutJsoupActionPerformed

    private void miAboutJpaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAboutJpaActionPerformed
//        controllerMain.frmAboutJpa();
    }//GEN-LAST:event_miAboutJpaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
//        controllerMain.frmReadWebpageData();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMain().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenu mAbout;
    private javax.swing.JMenu mAnotateText;
    private javax.swing.JMenu mCorpus;
    private javax.swing.JMenu mTrain;
    private javax.swing.JMenu mWebsite;
    private javax.swing.JMenuItem miAboutJpa;
    private javax.swing.JMenuItem miAboutJsoup;
    private javax.swing.JMenuItem miAboutLingPipe;
    private javax.swing.JMenuItem miAboutWebEvo;
    private javax.swing.JMenuItem miAddCorpus;
    private javax.swing.JMenuItem miAddSentence;
    private javax.swing.JMenuItem miCorpusPreview;
    private javax.swing.JMenuItem miLoadWebpageFromUrl;
    private javax.swing.JMenuItem miPreviewCorpus;
    private javax.swing.JMenuItem miTraingTagger;
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the controllerMain
     */
    public ControllerMain getControllerMain() {
        return controllerMain;
    }

    /**
     * @param controllerMain the controllerMain to set
     */
    public void setControllerMain(ControllerMain controllerMain) {
        this.controllerMain = controllerMain;
    }

   
    public void setActivePanel(JPanel newPanel) {
        if (pnlMain != null) {
            this.remove(pnlMain);
        }

        pnlMain = newPanel;
        getContentPane().add(newPanel, java.awt.BorderLayout.CENTER);
        pnlMain.setVisible(true);
        validate();
        repaint();
        pack();
    }
}
