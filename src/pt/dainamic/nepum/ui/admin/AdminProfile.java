/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.dainamic.nepum.ui.admin;



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
import pt.dainamic.nepum.model.Admin;
import pt.dainamic.nepum.ws.AdminWS;

/**
 *
 * @author jorge
 */
public class AdminProfile extends javax.swing.JFrame {

    private Logger log = Logger.getLogger(AdminProfile.class);
    private AdminWS admWS;


    /**
     * Creates new form AdminProfile
     * @param idAdmin
     */
    public AdminProfile(int idAdmin) {
        try {
            initComponents();
            setIcon();
            admWS = new AdminWS();
            setFields(admWS.getAdminById(idAdmin));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(AdminProfile.this,
                    e.getMessage(), "Erro ao carregar os dados do Administrador", JOptionPane.ERROR_MESSAGE);
        }
    }



    private void setFields(Admin a) {
        this.jTextFieldName.setText(a.getName());
        this.jTextFieldLastName.setText(a.getLastName());
        this.jTextFieldBirthDate.setText(a.getBirthDate());
        this.jTextFieldNTel.setText(String.valueOf(a.getNumTel()));
        this.jTextFieldNatio.setText(a.getNationality());
        this.jTextFieldNCC.setText(String.valueOf(a.getNumCC()));
        this.jTextFieldEmail.setText(a.getEmail());
        this.jTextFieldAdress.setText(a.getAdress());
        this.jTextFieldBloodGroup.setText(a.getBloodGroup());

        if (a.getPicture().equals("profile")) {
            ImageIcon pic = new ImageIcon(getClass().getResource("/pt/dainamic/nepum/images/pics/profile.PNG"));
            jLabelPhoto.setIcon(new ImageIcon(pic.getImage().getScaledInstance(
                    jLabelPhoto.getWidth(), jLabelPhoto.getHeight(), Image.SCALE_DEFAULT)));
        } else {
            jLabelPhoto.setIcon(new ImageIcon(getImageFromServer(a.getPicture(), 90, 90)));
        }

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelWallpaper = new javax.swing.JPanel();
        jPanelInformation = new javax.swing.JPanel();
        jLabelProfile = new javax.swing.JLabel();
        jLabelPhoto = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jLabelBirthDate = new javax.swing.JLabel();
        jLabelTel = new javax.swing.JLabel();
        jLabelCC = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelLastName = new javax.swing.JLabel();
        jLabelNationality = new javax.swing.JLabel();
        jLabelAdress = new javax.swing.JLabel();
        jLabelBloodType = new javax.swing.JLabel();
        jButtonEditProfile = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();
        jTextFieldName = new javax.swing.JTextField();
        jTextFieldBirthDate = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldAdress = new javax.swing.JTextField();
        jTextFieldLastName = new javax.swing.JTextField();
        jTextFieldBloodGroup = new javax.swing.JTextField();
        jTextFieldNatio = new javax.swing.JTextField();
        jTextFieldNCC = new javax.swing.JTextField();
        jTextFieldNTel = new javax.swing.JTextField();
        jLabelInformation = new javax.swing.JLabel();
        jLabelwallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(705, 520));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelWallpaper.setMaximumSize(new java.awt.Dimension(700, 500));
        jPanelWallpaper.setMinimumSize(new java.awt.Dimension(700, 500));
        jPanelWallpaper.setPreferredSize(new java.awt.Dimension(700, 500));
        jPanelWallpaper.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelInformation.setMaximumSize(new java.awt.Dimension(680, 380));
        jPanelInformation.setMinimumSize(new java.awt.Dimension(680, 380));
        jPanelInformation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelProfile.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabelProfile.setText("Administrador");
        jPanelInformation.add(jLabelProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabelPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pt/dainamic/nepum/images/pics/profile.PNG"))); // NOI18N
        jPanelInformation.add(jLabelPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 80, 80));

        jLabelName.setText("Nome:");
        jPanelInformation.add(jLabelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, -1, 20));

        jLabelBirthDate.setText("  Data de nascimento:");
        jPanelInformation.add(jLabelBirthDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, -1, 20));

        jLabelTel.setText("  Nº Tel:");
        jLabelTel.setToolTipText("");
        jPanelInformation.add(jLabelTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, -1, 20));

        jLabelCC.setText("  Nº CC:");
        jPanelInformation.add(jLabelCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(443, 139, -1, 20));

        jLabelEmail.setText("  E-mail:");
        jPanelInformation.add(jLabelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, 20));

        jLabelLastName.setText(" Apelido:");
        jPanelInformation.add(jLabelLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(441, 49, -1, 20));

        jLabelNationality.setText(" Nacionalidade:");
        jPanelInformation.add(jLabelNationality, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 79, -1, 20));

        jLabelAdress.setText("   Morada:");
        jPanelInformation.add(jLabelAdress, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, -1, 20));

        jLabelBloodType.setText("Grupo sanguíneo:");
        jPanelInformation.add(jLabelBloodType, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 169, 90, 20));

        jButtonEditProfile.setText("Editar Perfil");
        jButtonEditProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditProfileActionPerformed(evt);
            }
        });
        jPanelInformation.add(jButtonEditProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, -1, -1));

        jButtonBack.setText("Voltar");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });
        jPanelInformation.add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 330, -1, -1));

        jTextFieldName.setEditable(false);
        jTextFieldName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanelInformation.add(jTextFieldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 150, -1));

        jTextFieldBirthDate.setEditable(false);
        jTextFieldBirthDate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanelInformation.add(jTextFieldBirthDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 150, -1));

        jTextFieldEmail.setEditable(false);
        jTextFieldEmail.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanelInformation.add(jTextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 150, -1));

        jTextFieldAdress.setEditable(false);
        jTextFieldAdress.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanelInformation.add(jTextFieldAdress, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 400, -1));

        jTextFieldLastName.setEditable(false);
        jTextFieldLastName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanelInformation.add(jTextFieldLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 140, -1));

        jTextFieldBloodGroup.setEditable(false);
        jTextFieldBloodGroup.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanelInformation.add(jTextFieldBloodGroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 40, -1));

        jTextFieldNatio.setEditable(false);
        jTextFieldNatio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanelInformation.add(jTextFieldNatio, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 140, -1));

        jTextFieldNCC.setEditable(false);
        jTextFieldNCC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanelInformation.add(jTextFieldNCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 140, -1));

        jTextFieldNTel.setEditable(false);
        jTextFieldNTel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanelInformation.add(jTextFieldNTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 150, -1));

        jLabelInformation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pt/dainamic/nepum/images/backGround/second.jpg"))); // NOI18N
        jLabelInformation.setMaximumSize(new java.awt.Dimension(680, 380));
        jLabelInformation.setMinimumSize(new java.awt.Dimension(680, 380));
        jLabelInformation.setPreferredSize(new java.awt.Dimension(680, 380));
        jPanelInformation.add(jLabelInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanelWallpaper.add(jPanelInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 680, 380));

        jLabelwallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pt/dainamic/nepum/images/backGround/first.jpg"))); // NOI18N
        jPanelWallpaper.add(jLabelwallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEditProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditProfileActionPerformed
        new AdminProfileEdit().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonEditProfileActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        new AdminMenu().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonEditProfile;
    private javax.swing.JLabel jLabelAdress;
    private javax.swing.JLabel jLabelBirthDate;
    private javax.swing.JLabel jLabelBloodType;
    private javax.swing.JLabel jLabelCC;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelInformation;
    private javax.swing.JLabel jLabelLastName;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelNationality;
    private javax.swing.JLabel jLabelPhoto;
    private javax.swing.JLabel jLabelProfile;
    private javax.swing.JLabel jLabelTel;
    private javax.swing.JLabel jLabelwallpaper;
    private javax.swing.JPanel jPanelInformation;
    private javax.swing.JPanel jPanelWallpaper;
    private javax.swing.JTextField jTextFieldAdress;
    private javax.swing.JTextField jTextFieldBirthDate;
    private javax.swing.JTextField jTextFieldBloodGroup;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldLastName;
    private javax.swing.JTextField jTextFieldNCC;
    private javax.swing.JTextField jTextFieldNTel;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldNatio;
    // End of variables declaration//GEN-END:variables

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
}
