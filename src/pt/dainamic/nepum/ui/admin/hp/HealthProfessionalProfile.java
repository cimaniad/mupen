/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.dainamic.nepum.ui.admin.hp;


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import pt.dainamic.nepum.model.HealthProfessional;
import pt.dainamic.nepum.ws.HealthProfessionalWS;

/**
 *
 * @author jorge
 */
public class HealthProfessionalProfile extends javax.swing.JFrame {

    private Logger log = Logger.getLogger(HealthProfessionalProfile.class);
    private HealthProfessional hp;

    /**
     * Creates new form NewJFrame
     */
    public HealthProfessionalProfile(HealthProfessional hp) {
      try{
            initComponents();
            setIcon();
            this.hp = hp;
            setFields(hp);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(HealthProfessionalProfile.this,
                    e.getMessage(), "Erro ao carregar os dados do Profissional de saude", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setFields(HealthProfessional hp) {
        this.jTextFieldnamehp.setText(hp.getName());
        this.jTextFieldLastNamehp.setText(hp.getLastName());
        this.BirthDatehp.setText(hp.getBirthDate());
        this.jTextFieldGenderhp.setText(hp.getGender());
        this.jTextFieldTelhp.setText(String.valueOf(hp.getNumTel()));
        this.jTextFieldNationalityhp.setText(hp.getNationality());
        this.jTextFieldnCChp.setText(String.valueOf(hp.getNumCC()));
        this.jTextFieldEmailhp.setText(hp.getEmail());
        this.jTextFieldAdresshp.setText(hp.getAdress());
        if(hp.getNif()!=0){
            this.jTextFieldnifhp.setText(String.valueOf(hp.getNif()));
        }
        this.jTextFieldMaritalStatehp.setText(hp.getMaritalStatus());
        this.jTextFieldInstitutionhp.setText(hp.getInstitution());
        this.jTextField11.setText(hp.getBloodGroup());
        System.out.println(hp.getDevelopmentProfessional());
        if(hp.getDevelopmentProfessional() == 1){
            this.jCheckBoxDevelopmentProfessional.setSelected(true);
        }
        else{
            this.jCheckBoxDevelopmentProfessional.setSelected(false);
        }
        if (hp.getPicture().equals("profile")) {
            ImageIcon pic = new ImageIcon(getClass().getResource("/pt/dainamic/nepum/images/pics/profile.PNG"));
            jLabelPhoto.setIcon(new ImageIcon(pic.getImage().getScaledInstance(
                    jLabelPhoto.getWidth(), jLabelPhoto.getHeight(), Image.SCALE_DEFAULT)));
        } else {
            jLabelPhoto.setIcon(new ImageIcon(getImageFromServer(hp.getPicture(), 90, 90)));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelWallpaper = new javax.swing.JPanel();
        jPanelInformation = new javax.swing.JPanel();
        jLabelHealthProfessionalProfile = new javax.swing.JLabel();
        jLabelPhoto = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jLabelBirthDate = new javax.swing.JLabel();
        jLabelTel = new javax.swing.JLabel();
        jLabelCC = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelLastName = new javax.swing.JLabel();
        jLabelGender = new javax.swing.JLabel();
        jLabelNationality = new javax.swing.JLabel();
        jLabelAdress = new javax.swing.JLabel();
        jLabelNIF = new javax.swing.JLabel();
        jLabelMaritalStatus = new javax.swing.JLabel();
        jLabelBloodType = new javax.swing.JLabel();
        jLabelInstitution = new javax.swing.JLabel();
        jButtonBack = new javax.swing.JButton();
        jCheckBoxDevelopmentProfessional = new javax.swing.JCheckBox();
        jTextFieldnCChp = new javax.swing.JTextField();
        jTextFieldTelhp = new javax.swing.JTextField();
        BirthDatehp = new javax.swing.JTextField();
        jTextFieldnamehp = new javax.swing.JTextField();
        jTextFieldnifhp = new javax.swing.JTextField();
        jTextFieldInstitutionhp = new javax.swing.JTextField();
        jTextFieldLastNamehp = new javax.swing.JTextField();
        jTextFieldGenderhp = new javax.swing.JTextField();
        jTextFieldNationalityhp = new javax.swing.JTextField();
        jTextFieldAdresshp = new javax.swing.JTextField();
        jTextFieldMaritalStatehp = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jButtonEdit = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jTextFieldEmailhp = new javax.swing.JTextField();
        jLabelInformation = new javax.swing.JLabel();
        jLabelwallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelWallpaper.setMaximumSize(new java.awt.Dimension(700, 500));
        jPanelWallpaper.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelInformation.setMaximumSize(new java.awt.Dimension(680, 380));
        jPanelInformation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelHealthProfessionalProfile.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabelHealthProfessionalProfile.setText("Profissional de Saúde");
        jPanelInformation.add(jLabelHealthProfessionalProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabelPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pt/dainamic/nepum/images/pics/profile.PNG"))); // NOI18N
        jPanelInformation.add(jLabelPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 90, 90));

        jLabelName.setText(" Nome:");
        jPanelInformation.add(jLabelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 50, -1, 20));

        jLabelBirthDate.setText(" Data de nascimento:");
        jPanelInformation.add(jLabelBirthDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, -1, 20));

        jLabelTel.setText("  Nº Tel:");
        jPanelInformation.add(jLabelTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 50, 20));

        jLabelCC.setText("  Nº CC:");
        jPanelInformation.add(jLabelCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 60, 20));

        jLabelEmail.setText("    Email: ");
        jPanelInformation.add(jLabelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, -1, 20));

        jLabelLastName.setText(" Apelido:");
        jPanelInformation.add(jLabelLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 50, 20));

        jLabelGender.setText("    Sexo:");
        jPanelInformation.add(jLabelGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 50, 20));

        jLabelNationality.setText("  Nacionalidade:");
        jPanelInformation.add(jLabelNationality, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 90, 20));

        jLabelAdress.setText("    Morada:");
        jPanelInformation.add(jLabelAdress, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 60, 20));

        jLabelNIF.setText("  NIF:");
        jPanelInformation.add(jLabelNIF, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 30, 20));

        jLabelMaritalStatus.setText(" Estado Civil: ");
        jPanelInformation.add(jLabelMaritalStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, -1, 20));

        jLabelBloodType.setText("Grupo sanguíneo:  ");
        jPanelInformation.add(jLabelBloodType, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, -1, 20));

        jLabelInstitution.setText("  Instituição: ");
        jPanelInformation.add(jLabelInstitution, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 70, 20));

        jButtonBack.setText("Voltar");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });
        jPanelInformation.add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 330, -1, -1));

        jCheckBoxDevelopmentProfessional.setText("Profissional de Desenvolvimento");
        jCheckBoxDevelopmentProfessional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxDevelopmentProfessionalActionPerformed(evt);
            }
        });
        jPanelInformation.add(jCheckBoxDevelopmentProfessional, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 260, 40));

        jTextFieldnCChp.setEditable(false);
        jTextFieldnCChp.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanelInformation.add(jTextFieldnCChp, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 150, -1));

        jTextFieldTelhp.setEditable(false);
        jTextFieldTelhp.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanelInformation.add(jTextFieldTelhp, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 150, -1));

        BirthDatehp.setEditable(false);
        BirthDatehp.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanelInformation.add(BirthDatehp, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 150, -1));

        jTextFieldnamehp.setEditable(false);
        jTextFieldnamehp.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanelInformation.add(jTextFieldnamehp, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 150, 20));

        jTextFieldnifhp.setEditable(false);
        jTextFieldnifhp.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextFieldnifhp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldnifhpActionPerformed(evt);
            }
        });
        jPanelInformation.add(jTextFieldnifhp, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 150, -1));

        jTextFieldInstitutionhp.setEditable(false);
        jTextFieldInstitutionhp.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanelInformation.add(jTextFieldInstitutionhp, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 150, -1));

        jTextFieldLastNamehp.setEditable(false);
        jTextFieldLastNamehp.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanelInformation.add(jTextFieldLastNamehp, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 48, 150, -1));

        jTextFieldGenderhp.setEditable(false);
        jTextFieldGenderhp.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextFieldGenderhp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldGenderhpActionPerformed(evt);
            }
        });
        jPanelInformation.add(jTextFieldGenderhp, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 150, -1));

        jTextFieldNationalityhp.setEditable(false);
        jTextFieldNationalityhp.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanelInformation.add(jTextFieldNationalityhp, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 138, 150, -1));

        jTextFieldAdresshp.setEditable(false);
        jTextFieldAdresshp.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanelInformation.add(jTextFieldAdresshp, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 410, -1));

        jTextFieldMaritalStatehp.setEditable(false);
        jTextFieldMaritalStatehp.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanelInformation.add(jTextFieldMaritalStatehp, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, 150, -1));

        jTextField11.setEditable(false);
        jTextField11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanelInformation.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 200, 40, -1));

        jButtonEdit.setText("Promover/Despromover");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });
        jPanelInformation.add(jButtonEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, -1, -1));

        jButtonDelete.setText("Eliminar");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });
        jPanelInformation.add(jButtonDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, -1, -1));

        jTextFieldEmailhp.setEditable(false);
        jTextFieldEmailhp.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanelInformation.add(jTextFieldEmailhp, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 150, -1));

        jLabelInformation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pt/dainamic/nepum/images/backGround/second.jpg"))); // NOI18N
        jLabelInformation.setMaximumSize(new java.awt.Dimension(680, 380));
        jLabelInformation.setMinimumSize(new java.awt.Dimension(680, 380));
        jLabelInformation.setPreferredSize(new java.awt.Dimension(680, 380));
        jPanelInformation.add(jLabelInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanelWallpaper.add(jPanelInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 680, 380));

        jLabelwallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pt/dainamic/nepum/images/backGround/first.jpg"))); // NOI18N
        jPanelWallpaper.add(jLabelwallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 500));

        getContentPane().add(jPanelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        new HealthProfessionalList().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        try {

            HealthProfessionalWS hpWS = new HealthProfessionalWS();
            hpWS.saveEditHealthProfessional(loadHealthProfessionalFromPanel());
            new HealthProfessionalProfile(hp).setVisible(true);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(HealthProfessionalProfile.this,
                    e.getMessage(), "Erro ao promover/despromover o profissional", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed

        try {
            HealthProfessionalWS hpWS = new HealthProfessionalWS();
            hpWS.deleteHealthProfessional(hp.getIdHealthProfessional());
            new HealthProfessionalList().setVisible(true);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(HealthProfessionalProfile.this,
                    e.getMessage(), "Erro ao eliminar o Profissional de saude", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jTextFieldnifhpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldnifhpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldnifhpActionPerformed

    private void jTextFieldGenderhpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldGenderhpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGenderhpActionPerformed

    private void jCheckBoxDevelopmentProfessionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxDevelopmentProfessionalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxDevelopmentProfessionalActionPerformed

    private Image getImageFromServer(String picture, int with, int heigth) {
        try {
            URL url = new URL(picture.trim());
            log.debug("\n\tProfile Image: " + url.toString());
            BufferedImage image = ImageIO.read(url);
            ImageIcon pic = new ImageIcon(image);
            return pic.getImage().getScaledInstance(with, heigth, Image.SCALE_DEFAULT);
        } catch (MalformedURLException ex) {
            log.error(ex.getMessage());
            throw new RuntimeException("Erro ao carregar imagem");
        } catch (IOException ex) {
            log.error(ex.getMessage());
            throw new RuntimeException("Erro ao carregar imagem");
        }
    }
    private void setIcon(){
        List<Image> icons = new ArrayList<>();
        icons.add(new ImageIcon(getClass().getResource("/pt/dainamic/nepum/images/logo.png")).getImage());
        icons.add(new ImageIcon(getClass().getResource("/pt/dainamic/nepum/images/logo-icon.png")).getImage());
        setIconImages(icons);
    }
    
    private HealthProfessional loadHealthProfessionalFromPanel() {
        byte developmentPro = jCheckBoxDevelopmentProfessional.isSelected() ? (byte)1 : (byte)0;
        hp.setDevelopmentProfessional(developmentPro);
        return hp;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BirthDatehp;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JCheckBox jCheckBoxDevelopmentProfessional;
    private javax.swing.JLabel jLabelAdress;
    private javax.swing.JLabel jLabelBirthDate;
    private javax.swing.JLabel jLabelBloodType;
    private javax.swing.JLabel jLabelCC;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelGender;
    private javax.swing.JLabel jLabelHealthProfessionalProfile;
    private javax.swing.JLabel jLabelInformation;
    private javax.swing.JLabel jLabelInstitution;
    private javax.swing.JLabel jLabelLastName;
    private javax.swing.JLabel jLabelMaritalStatus;
    private javax.swing.JLabel jLabelNIF;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelNationality;
    private javax.swing.JLabel jLabelPhoto;
    private javax.swing.JLabel jLabelTel;
    private javax.swing.JLabel jLabelwallpaper;
    private javax.swing.JPanel jPanelInformation;
    private javax.swing.JPanel jPanelWallpaper;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextFieldAdresshp;
    private javax.swing.JTextField jTextFieldEmailhp;
    private javax.swing.JTextField jTextFieldGenderhp;
    private javax.swing.JTextField jTextFieldInstitutionhp;
    private javax.swing.JTextField jTextFieldLastNamehp;
    private javax.swing.JTextField jTextFieldMaritalStatehp;
    private javax.swing.JTextField jTextFieldNationalityhp;
    private javax.swing.JTextField jTextFieldTelhp;
    private javax.swing.JTextField jTextFieldnCChp;
    private javax.swing.JTextField jTextFieldnamehp;
    private javax.swing.JTextField jTextFieldnifhp;
    // End of variables declaration//GEN-END:variables


}
