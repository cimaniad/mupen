/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.dainamic.nepum.ui.admin;

import pt.dainamic.nepum.ui.admin.hp.HealthProfessionalList;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import pt.dainamic.nepum.model.LoginSession;

/**
 *
 * @author jorge
 */
public class AdminMenu extends javax.swing.JFrame {

    /**
     * Creates new form MenuAdmin
     */
    public AdminMenu() {
        initComponents();
        setIcon();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelWallpaper = new javax.swing.JPanel();
        jButtonHealthProfessional = new javax.swing.JButton();
        jButtonProfile = new javax.swing.JButton();
        jLabelwallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 500));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelWallpaper.setMaximumSize(new java.awt.Dimension(700, 500));
        jPanelWallpaper.setMinimumSize(new java.awt.Dimension(700, 500));
        jPanelWallpaper.setName(""); // NOI18N
        jPanelWallpaper.setPreferredSize(new java.awt.Dimension(700, 500));
        jPanelWallpaper.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonHealthProfessional.setText("Profissionais de Saude");
        jButtonHealthProfessional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHealthProfessionalActionPerformed(evt);
            }
        });
        jPanelWallpaper.add(jButtonHealthProfessional, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 180, 40));

        jButtonProfile.setText("Perfil");
        jButtonProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProfileActionPerformed(evt);
            }
        });
        jPanelWallpaper.add(jButtonProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 140, 40));

        jLabelwallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pt/dainamic/nepum/images/backGround/first.jpg"))); // NOI18N
        jPanelWallpaper.add(jLabelwallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 500));

        getContentPane().add(jPanelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonHealthProfessionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHealthProfessionalActionPerformed
        new HealthProfessionalList().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonHealthProfessionalActionPerformed

    private void jButtonProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProfileActionPerformed
        int idAdmin = LoginSession.getInstance().getIdAdmin();

        new AdminProfile(idAdmin).setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonProfileActionPerformed

    private void setIcon(){
        List<Image> icons = new ArrayList<>();
        icons.add(new ImageIcon(getClass().getResource("/pt/dainamic/nepum/images/logo.png")).getImage());
        icons.add(new ImageIcon(getClass().getResource("/pt/dainamic/nepum/images/logo-icon.png")).getImage());
        setIconImages(icons);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonHealthProfessional;
    private javax.swing.JButton jButtonProfile;
    private javax.swing.JLabel jLabelwallpaper;
    private javax.swing.JPanel jPanelWallpaper;
    // End of variables declaration//GEN-END:variables
}
