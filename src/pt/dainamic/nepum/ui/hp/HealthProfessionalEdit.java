/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.dainamic.nepum.ui.hp;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import pt.dainamic.nepum.model.HealthProfessional;
import pt.dainamic.nepum.model.LoginSession;
import pt.dainamic.nepum.ws.HealthProfessionalWS;
import sun.misc.BASE64Encoder;

/**
 *
 * @author jorge
 */
public class HealthProfessionalEdit extends javax.swing.JFrame {

    private Logger log = Logger.getLogger(HealthProfessionalProfile.class);
    private HealthProfessional hp;
    private BufferedImage pic = null;

    /**
     * Creates new form NewJFrame
     */
    public HealthProfessionalEdit(HealthProfessional hp) {
        initComponents();
        setIcon();
        this.hp = hp;
        try {
            setFields(hp);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(HealthProfessionalEdit.this,
                    e.getMessage(), "Erro ao carregar o seu perfil", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooserPhoto = new javax.swing.JFileChooser();
        jPanelWallpaper = new javax.swing.JPanel();
        jPanelInformation = new javax.swing.JPanel();
        jLabelHealthProfessionalEdit = new javax.swing.JLabel();
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
        jButtonEdit = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();
        jComboBoxGender = new javax.swing.JComboBox();
        jComboBoxBloodType = new javax.swing.JComboBox();
        jComboBoxMaritalStatus = new javax.swing.JComboBox();
        jTextFieldName = new javax.swing.JTextField();
        jTextFieldTel = new javax.swing.JTextField();
        jTextFieldCC = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldLastName = new javax.swing.JTextField();
        jTextFieldNationality = new javax.swing.JTextField();
        jTextFieldAdress = new javax.swing.JTextField();
        jTextFieldNIF = new javax.swing.JTextField();
        jTextFieldInstitution = new javax.swing.JTextField();
        jDateChooserBirth = new com.toedter.calendar.JDateChooser();
        jButtonEditPhoto = new javax.swing.JButton();
        jLabelInformation = new javax.swing.JLabel();
        jLabelwallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(705, 520));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelWallpaper.setMaximumSize(new java.awt.Dimension(700, 500));
        jPanelWallpaper.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelInformation.setMaximumSize(new java.awt.Dimension(680, 380));
        jPanelInformation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelHealthProfessionalEdit.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabelHealthProfessionalEdit.setText("Editar Profissional de Saúde");
        jPanelInformation.add(jLabelHealthProfessionalEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabelPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pt/dainamic/nepum/images/pics/profile.PNG"))); // NOI18N
        jLabelPhoto.setMaximumSize(new java.awt.Dimension(90, 90));
        jLabelPhoto.setMinimumSize(new java.awt.Dimension(90, 90));
        jPanelInformation.add(jLabelPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 90, 90));

        jLabelName.setText("Nome:");
        jPanelInformation.add(jLabelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 49, -1, 20));

        jLabelBirthDate.setText("Data de nascimento:");
        jPanelInformation.add(jLabelBirthDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, 20));

        jLabelTel.setText("Nº Tel.:");
        jPanelInformation.add(jLabelTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 109, -1, 20));

        jLabelCC.setText(" Nº CC:");
        jPanelInformation.add(jLabelCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 139, -1, 20));

        jLabelEmail.setText("Email:");
        jPanelInformation.add(jLabelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, -1, 20));

        jLabelLastName.setText("Apelido:");
        jPanelInformation.add(jLabelLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 49, -1, 20));

        jLabelGender.setText("Sexo:");
        jPanelInformation.add(jLabelGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 85, -1, -1));

        jLabelNationality.setText("Nacionalidade:");
        jPanelInformation.add(jLabelNationality, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, -1, 20));

        jLabelAdress.setText("Morada:");
        jPanelInformation.add(jLabelAdress, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, -1, -1));

        jLabelNIF.setText("  NIF:");
        jPanelInformation.add(jLabelNIF, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 30, 20));

        jLabelMaritalStatus.setText(" Estado Civil:");
        jPanelInformation.add(jLabelMaritalStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, -1, 20));

        jLabelBloodType.setText("  Grupo sanguíneo:");
        jPanelInformation.add(jLabelBloodType, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, -1, 20));

        jLabelInstitution.setText(" Instituição:");
        jPanelInformation.add(jLabelInstitution, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, -1, 20));

        jButtonEdit.setText("Submeter Alterações");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });
        jPanelInformation.add(jButtonEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, -1, -1));

        jButtonBack.setText("Voltar");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });
        jPanelInformation.add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 330, -1, -1));

        jComboBoxGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Feminino", " " }));
        jPanelInformation.add(jComboBoxGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 170, -1));

        jComboBoxBloodType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "O+", "O-", "A+", "A-", "B+", "B-", "AB+", "AB-" }));
        jPanelInformation.add(jComboBoxBloodType, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 170, -1));

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
        jPanelInformation.add(jTextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 170, -1));

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
        jPanelInformation.add(jTextFieldNationality, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 170, -1));
        jPanelInformation.add(jTextFieldAdress, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 430, -1));
        jPanelInformation.add(jTextFieldNIF, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 170, -1));

        jTextFieldInstitution.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldInstitutionKeyTyped(evt);
            }
        });
        jPanelInformation.add(jTextFieldInstitution, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 170, -1));
        jPanelInformation.add(jDateChooserBirth, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 170, -1));

        jButtonEditPhoto.setText("Editar foto");
        jButtonEditPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditPhotoActionPerformed(evt);
            }
        });
        jPanelInformation.add(jButtonEditPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

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

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        try {

            HealthProfessionalWS hpWS = new HealthProfessionalWS();
            hpWS.saveEditHealthProfessional(loadHealthProfessionalFromPanel());
            new HealthProfessionalProfile(hp.getIdHealthProfessional()).setVisible(true);
            dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(HealthProfessionalEdit.this,
                    e.getMessage(), "Erro ao editar perfil", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonEditPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditPhotoActionPerformed
        jFileChooserPhoto.showOpenDialog(this);
        File f = jFileChooserPhoto.getSelectedFile();
        try {
            ImageIcon image = new ImageIcon(f.getAbsolutePath());
            jLabelPhoto.setIcon(new ImageIcon(image.getImage().getScaledInstance(
                    jLabelPhoto.getWidth(), jLabelPhoto.getHeight(), Image.SCALE_DEFAULT)));
            pic = ImageIO.read(f);

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(HealthProfessionalEdit.this,
                    "Erro ao carregar imagem", "Erro editar Profissional de saude",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_jButtonEditPhotoActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        new HealthProfessionalProfile(LoginSession.getInstance().getIdHealthProfessional()).setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

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

    private void setFields(HealthProfessional hp) {
        this.jTextFieldName.setText(hp.getName());
        this.jTextFieldLastName.setText(hp.getLastName());

        this.jDateChooserBirth.setDate(dateParse(hp.getBirthDate()));
        this.jComboBoxGender.setSelectedItem(hp.getGender());
        this.jTextFieldTel.setText(String.valueOf(hp.getNumTel()));
        this.jTextFieldNationality.setText(hp.getNationality());
        this.jTextFieldCC.setText(String.valueOf(hp.getNumCC()));
        this.jTextFieldEmail.setText(hp.getEmail());
        this.jTextFieldAdress.setText(hp.getAdress());
        if(hp.getNif()!=0){
            this.jTextFieldNIF.setText(String.valueOf(hp.getNif()));
        }
        this.jComboBoxMaritalStatus.setSelectedItem(hp.getMaritalStatus());
        this.jTextFieldInstitution.setText(hp.getInstitution());
        this.jComboBoxBloodType.setSelectedItem(hp.getBloodGroup());

        if (hp.getPicture().equals("profile")) {
            ImageIcon pic = new ImageIcon(getClass().getResource("/pt/dainamic/nepum/images/pics/profile.PNG"));
            jLabelPhoto.setIcon(new ImageIcon(pic.getImage().getScaledInstance(
                    jLabelPhoto.getWidth(), jLabelPhoto.getHeight(), Image.SCALE_DEFAULT)));
        } else {
            jLabelPhoto.setIcon(new ImageIcon(getImageFromServer(hp.getPicture(), 90, 90)));
        }
    }

    private String validator() {
        StringBuilder warns = new StringBuilder();
        warns.append(jTextFieldName.getText().isEmpty() ? "Nome, " : "");
        warns.append(jTextFieldLastName.getText().isEmpty() ? "Apelido, " : "");
        warns.append(jDateChooserBirth.getDate().toString().isEmpty() ? "Data de Nascimento, " : "");
        warns.append(jTextFieldCC.getText().isEmpty() ? "Numero CC, " : "");
        warns.append(jTextFieldEmail.getText().isEmpty() ? "E-mail, " : "");
        warns.append(jTextFieldTel.getText().trim().isEmpty() ? "Número de Telemóvel, " : "");
        if (!warns.toString().isEmpty()) {
            warns.delete(warns.toString().length() - 2, warns.toString().length());
            warns.append("!");
        }

        return warns.toString();
    }

    private HealthProfessional loadHealthProfessionalFromPanel() {
        String warn = validator();
        if (!warn.isEmpty()) {
            throw new RuntimeException("Preencha o(s) seguintes dado(s): " + warn);
        }
        String name = jTextFieldName.getText();
        hp.setName(name);
        String lastName = jTextFieldLastName.getText();
        hp.setLastName(lastName);
        String email = jTextFieldEmail.getText().trim();
        hp.setEmail(email);
        String adress = jTextFieldAdress.getText();
        hp.setAdress(adress);
        String nationality = jTextFieldNationality.getText();
        hp.setNationality(nationality);
        String institution = jTextFieldInstitution.getText();
        hp.setInstitution(institution);
        String gender = String.valueOf(jComboBoxGender.getSelectedItem());
        hp.setGender(gender);
        String maritalStatus = String.valueOf(jComboBoxMaritalStatus.getSelectedItem());
        hp.setMaritalStatus(maritalStatus);
        String bloodGroup = String.valueOf(jComboBoxBloodType.getSelectedItem());
        hp.setBloodGroup(bloodGroup);
        Date birthDate = jDateChooserBirth.getDate();
        hp.setBirthDate(parseDate(birthDate));
        int numTel = 0;
        int numCC = 0;
        int nif=0;
        try {
            if (jTextFieldTel.getText().trim().length() != 9) {
                throw new RuntimeException("O NºTel deve ter 9 digitos!");
            }
            if (jTextFieldCC.getText().trim().length() != 8) {
                throw new RuntimeException("O NºCC deve ter 8 digitos!");
            }
            if (jTextFieldNIF.getText().trim().length() != 9 && !jTextFieldNIF.getText().trim().isEmpty()) {
                throw new RuntimeException("O NIF deve ter 9 digitos!");
            } else if (!jTextFieldNIF.getText().trim().isEmpty() && jTextFieldNIF.getText().trim().length() == 9){
                nif = Integer.valueOf(jTextFieldNIF.getText().trim());
                hp.setNif(nif);
            }
            numTel = Integer.valueOf(jTextFieldTel.getText().trim());
            hp.setNumTel(numTel);
            numCC = Integer.valueOf(jTextFieldCC.getText().trim());
            hp.setNumCC(numCC);

        } catch (NumberFormatException e) {
            throw new RuntimeException("Apenas numeros são permitidos nos campos NºTel, NIF e NºCC");
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
        if (pic == null) {
            hp.setPicture("profile");
        } else {
            hp.setPicture(encodeToString(pic, "jpg"));
        }

        return hp;
    }

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

    public String parseDate(Date d) {
        SimpleDateFormat dateFromat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFromat.format(d);
        return date;
    }

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
    
    private Date dateParse(String birthDate) {
        SimpleDateFormat dateFromat = new SimpleDateFormat("yyyy-MM-dd");
        Date d = null;
        try {
            d = dateFromat.parse(birthDate);
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(HealthProfessionalEdit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonEditPhoto;
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
    private javax.swing.JLabel jLabelHealthProfessionalEdit;
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
