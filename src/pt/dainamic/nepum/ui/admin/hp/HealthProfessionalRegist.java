/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.dainamic.nepum.ui.admin.hp;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import pt.dainamic.nepum.model.HealthProfessional;
import pt.dainamic.nepum.ws.HealthProfessionalWS;
import sun.misc.BASE64Encoder;

/**
 * This class is the interface with the Admin so he can make the register of the
 * Health Professional in the system
 *
 * @author Ricardo
 */
public class HealthProfessionalRegist extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    private BufferedImage pic = null;

    public HealthProfessionalRegist() {
        initComponents();
        setIcon();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooserPhoto = new javax.swing.JFileChooser();
        jPanelWallpaper = new javax.swing.JPanel();
        jPanelInformation = new javax.swing.JPanel();
        jLabelHealthProfessionalRegist = new javax.swing.JLabel();
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
        jButtonRegist = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();
        jComboBoxBloodType = new javax.swing.JComboBox();
        jComboBoxMaritalStatus = new javax.swing.JComboBox();
        jTextFieldName = new javax.swing.JTextField();
        jTextFieldTel = new javax.swing.JTextField();
        jTextFieldCC = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldLastName = new javax.swing.JTextField();
        jTextFieldNationality = new javax.swing.JTextField();
        jTextFieldInstitution = new javax.swing.JTextField();
        jButtonAddPhoto = new javax.swing.JButton();
        jDateChooserBirth = new com.toedter.calendar.JDateChooser();
        jTextFieldNIF = new javax.swing.JTextField();
        jTextFieldAdress = new javax.swing.JTextField();
        jCheckBoxDevelopmentProfessional = new javax.swing.JCheckBox();
        jComboBoxGender = new javax.swing.JComboBox();
        jLabelInformation = new javax.swing.JLabel();
        jLabelwallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(705, 520));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelWallpaper.setMaximumSize(new java.awt.Dimension(700, 500));
        jPanelWallpaper.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelInformation.setMaximumSize(new java.awt.Dimension(680, 380));
        jPanelInformation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelHealthProfessionalRegist.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabelHealthProfessionalRegist.setText("Registar Profissional de Saúde");
        jPanelInformation.add(jLabelHealthProfessionalRegist, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabelPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pt/dainamic/nepum/images/pics/profile.PNG"))); // NOI18N
        jPanelInformation.add(jLabelPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 90, 90));

        jLabelName.setText("Nome:");
        jPanelInformation.add(jLabelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 55, -1, -1));

        jLabelBirthDate.setText("  Data de nascimento:");
        jPanelInformation.add(jLabelBirthDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 85, -1, -1));

        jLabelTel.setText("Nº Tel.:");
        jPanelInformation.add(jLabelTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 115, -1, -1));

        jLabelCC.setText(" Nº CC:");
        jPanelInformation.add(jLabelCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 145, -1, -1));

        jLabelEmail.setText("Email:");
        jPanelInformation.add(jLabelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 145, -1, -1));

        jLabelLastName.setText("Apelido:");
        jPanelInformation.add(jLabelLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 55, -1, -1));

        jLabelGender.setText("Sexo:");
        jPanelInformation.add(jLabelGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 85, -1, -1));

        jLabelNationality.setText(" Nacionalidade:");
        jPanelInformation.add(jLabelNationality, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 115, -1, -1));

        jLabelAdress.setText("Morada:");
        jPanelInformation.add(jLabelAdress, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 175, -1, -1));

        jLabelNIF.setText("  NIF:");
        jPanelInformation.add(jLabelNIF, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 205, 30, -1));

        jLabelMaritalStatus.setText(" Estado Civil:");
        jPanelInformation.add(jLabelMaritalStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 205, -1, -1));

        jLabelBloodType.setText("   Grupo sanguíneo:");
        jPanelInformation.add(jLabelBloodType, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, -1, 20));

        jLabelInstitution.setText(" Instituição:");
        jPanelInformation.add(jLabelInstitution, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 235, -1, -1));

        jButtonRegist.setText("Submeter Dados");
        jButtonRegist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistActionPerformed(evt);
            }
        });
        jPanelInformation.add(jButtonRegist, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, -1, -1));

        jButtonBack.setText("Voltar");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });
        jPanelInformation.add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 330, -1, -1));

        jComboBoxBloodType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "O+", "O-", "A+", "A-", "B+", "B-", "AB+", "AB-" }));
        jPanelInformation.add(jComboBoxBloodType, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 170, -1));

        jComboBoxMaritalStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Solteiro", "Casado", "Divorciado", "Viúvo" }));
        jPanelInformation.add(jComboBoxMaritalStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 200, 170, -1));

        jTextFieldName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNameKeyTyped(evt);
            }
        });
        jPanelInformation.add(jTextFieldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 170, -1));
        jPanelInformation.add(jTextFieldTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 170, -1));
        jPanelInformation.add(jTextFieldCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 170, -1));
        jPanelInformation.add(jTextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 170, -1));

        jTextFieldLastName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldLastNameKeyTyped(evt);
            }
        });
        jPanelInformation.add(jTextFieldLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 170, -1));

        jTextFieldNationality.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNationalityKeyTyped(evt);
            }
        });
        jPanelInformation.add(jTextFieldNationality, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 170, -1));

        jTextFieldInstitution.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldInstitutionKeyTyped(evt);
            }
        });
        jPanelInformation.add(jTextFieldInstitution, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 170, -1));

        jButtonAddPhoto.setText("Inserir foto");
        jButtonAddPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddPhotoActionPerformed(evt);
            }
        });
        jPanelInformation.add(jButtonAddPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jDateChooserBirth.setDoubleBuffered(false);
        jPanelInformation.add(jDateChooserBirth, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 170, -1));
        jPanelInformation.add(jTextFieldNIF, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 170, -1));
        jPanelInformation.add(jTextFieldAdress, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 430, -1));

        jCheckBoxDevelopmentProfessional.setText("Profissional de desenvolvimento");
        jPanelInformation.add(jCheckBoxDevelopmentProfessional, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 180, -1));

        jComboBoxGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Feminino" }));
        jPanelInformation.add(jComboBoxGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 170, -1));

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
/**
     * This method reacts to the click at the jButtonRegist, and sends the
     * information of the Health Professional to the server where it gonna be
     * saved. Also catches the errors, and displays a error message if catch
     * some error.
     *
     * @param evt
     */
    private void jButtonRegistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistActionPerformed
        try {
            HealthProfessional hp = loadHealthProfessionalFromPanel();
            HealthProfessionalWS hpWS = new HealthProfessionalWS();
            hpWS.saveEditHealthProfessional(hp);
            new HealthProfessionalList().setVisible(true);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(HealthProfessionalRegist.this,
                    e.getMessage(), "Erro ao registar Profissional de saude", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonRegistActionPerformed
    /**
     * This method reacts to the click at the jButtonBack, and close this frame
     * and opens the HeatlProfessionalList frame
     *
     * @param evt
     */
    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        new HealthProfessionalList().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed
    /**
     * This method reacts to the click at the jButtonAddPhoto and allows the
     * user to choose the profile image thru the computer
     *
     * @param evt
     */
    private void jButtonAddPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddPhotoActionPerformed
        jFileChooserPhoto.showOpenDialog(this);
        File f = jFileChooserPhoto.getSelectedFile();
        try {
            ImageIcon image = new ImageIcon(f.getAbsolutePath());
            jLabelPhoto.setIcon(new ImageIcon(image.getImage().getScaledInstance(
                    jLabelPhoto.getWidth(), jLabelPhoto.getHeight(), Image.SCALE_DEFAULT)));
            pic = ImageIO.read(f);

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(HealthProfessionalRegist.this,
                    "Erro ao carregar imagem", "Erro ao registar Profissional de saude",
                    JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonAddPhotoActionPerformed

    private void jTextFieldNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNameKeyTyped
        numberConsume(evt);
    }//GEN-LAST:event_jTextFieldNameKeyTyped

    private void jTextFieldLastNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldLastNameKeyTyped
        numberConsume(evt);
    }//GEN-LAST:event_jTextFieldLastNameKeyTyped

    private void jTextFieldNationalityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNationalityKeyTyped
        numberConsume(evt);
    }//GEN-LAST:event_jTextFieldNationalityKeyTyped

    private void jTextFieldInstitutionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldInstitutionKeyTyped
        numberConsume(evt);
    }//GEN-LAST:event_jTextFieldInstitutionKeyTyped

    private void numberConsume(KeyEvent evt) {
        String numbers = "0123456789";
        if (numbers.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }

    /**
     * This method checks if the required fields are filled. If the required
     * fields are empty it returns a String with that field names.
     *
     * @return String
     */
    private String validator() {
        StringBuilder warns = new StringBuilder();
        warns.append(jTextFieldName.getText().isEmpty() ? "Nome, " : "");
        warns.append(jTextFieldLastName.getText().isEmpty() ? "Apelido, " : "");
        warns.append(jDateChooserBirth.getDate().toString().isEmpty() ? "Data de Nascimento, " : "");
        warns.append(jTextFieldCC.getText().isEmpty() ? "Numero CC, " : "");
        warns.append(jTextFieldEmail.getText().isEmpty() ? "E-mail, " : "");

        if (!warns.toString().isEmpty()) {
            warns.delete(warns.toString().length() - 2, warns.toString().length());
            warns.append("!");
        }

        return warns.toString();
    }

    /**
     * This method gets the Health Professional information from the Panel, and
     * checks is the informations are as they should be if yes, it returns a
     * HealthProfessional Object otherwise it throws an error.
     *
     * @return HealthProfessional
     */
    private HealthProfessional loadHealthProfessionalFromPanel() {
        String warn = validator();
        if (!warn.isEmpty()) {
            throw new RuntimeException("Preencha o(s) seguintes dado(s): " + warn);
        }
        String name = jTextFieldName.getText();
        String lastName = jTextFieldLastName.getText();
        String email = jTextFieldEmail.getText().trim();
        String adress = jTextFieldAdress.getText();
        String nacionality = jTextFieldNationality.getText();
        String institution = jTextFieldInstitution.getText();
        String gender = String.valueOf(jComboBoxBloodType.getSelectedItem());
        String maritalStatus = String.valueOf(jComboBoxMaritalStatus.getSelectedItem());
        String bloodGroup = String.valueOf(jComboBoxBloodType.getSelectedItem());
        Date birthDate = jDateChooserBirth.getDate();
        String pass = generatePass();
        int numTel = 0;
        int numCC = 0;
        int nif = 0;
        byte developmentPro = jCheckBoxDevelopmentProfessional.isSelected() == true ? (byte)1 : (byte)0;
        try {
            if (jTextFieldTel.getText().trim().length() != 9) {
                throw new RuntimeException("O NºTel deve ter 9 digitos!");
            }
            if (jTextFieldCC.getText().trim().length() != 8) {
                throw new RuntimeException("O NºCC deve ter 8 digitos!");
            }

            if (jTextFieldNIF.getText().trim().length() != 9 && !jTextFieldNIF.getText().trim().isEmpty()) {
                throw new RuntimeException("NIF deve ter 9 digitos!");
            } else if (!jTextFieldNIF.getText().trim().isEmpty() && jTextFieldNIF.getText().trim().length() == 9) {
                nif = Integer.valueOf(jTextFieldNIF.getText().trim());
            }
            numTel = Integer.valueOf(jTextFieldTel.getText().trim());
            numCC = Integer.valueOf(jTextFieldCC.getText().trim());

        } catch (NumberFormatException e) {
            throw new RuntimeException("Apenas numeros são permitidos nos campos NºTel, NIF e NºCC");
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }

        return new HealthProfessional(name, lastName, numCC, adress, numTel, nif,
                email, maritalStatus, parseDate(birthDate), bloodGroup, nacionality,
                gender, pass, encodeToString(pic, "jpg"), institution, developmentPro);
    }

    /**
     * Method to generate passwords
     *
     * @return String password
     */
    private String generatePass() {
        StringBuilder sb = new StringBuilder();
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();

        for (int i = 0; i < 8; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }

    /**
     * This method receive a Date object and passes it to a String in the format
     * yyyy-MM-dd
     *
     * @param d
     * @return String date
     */
    private String parseDate(Date d) {
        SimpleDateFormat dateFromat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFromat.format(d);
        return date;
    }

    /**
     * This method receives a image and passes is to Base64 String
     *
     * @param image
     * @param type
     * @return String image Base64
     */
    private String encodeToString(BufferedImage image, String type) {
        if (image == null) {
            return "profile";
        }

        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ImageIO.write(image, type, bos);
            byte[] imageBytes = bos.toByteArray();

            BASE64Encoder encoder = new BASE64Encoder();
            imageString = encoder.encode(imageBytes);

            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }

    private void setIcon() {
        List<Image> icons = new ArrayList<>();
        icons.add(new ImageIcon(getClass().getResource("/pt/dainamic/nepum/images/logo.png")).getImage());
        icons.add(new ImageIcon(getClass().getResource("/pt/dainamic/nepum/images/logo-icon.png")).getImage());
        setIconImages(icons);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddPhoto;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonRegist;
    private javax.swing.JCheckBox jCheckBoxDevelopmentProfessional;
    private javax.swing.JComboBox jComboBoxBloodType;
    private javax.swing.JComboBox jComboBoxGender;
    private javax.swing.JComboBox jComboBoxMaritalStatus;
    private com.toedter.calendar.JDateChooser jDateChooserBirth;
    private javax.swing.JFileChooser jFileChooserPhoto;
    private javax.swing.JLabel jLabelAdress;
    private javax.swing.JLabel jLabelBirthDate;
    private javax.swing.JLabel jLabelBloodType;
    private javax.swing.JLabel jLabelCC;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelGender;
    private javax.swing.JLabel jLabelHealthProfessionalRegist;
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
    private javax.swing.JTextField jTextFieldAdress;
    private javax.swing.JTextField jTextFieldCC;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldInstitution;
    private javax.swing.JTextField jTextFieldLastName;
    private javax.swing.JTextField jTextFieldNIF;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldNationality;
    private javax.swing.JTextField jTextFieldTel;
    // End of variables declaration//GEN-END:variables

}
