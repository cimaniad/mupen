/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.dainamic.nepum.ui.hp.patients.exercises;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.apache.log4j.Logger;
import pt.dainamic.nepum.model.Comment;
import pt.dainamic.nepum.model.Exercise;
import pt.dainamic.nepum.model.Patient;
import pt.dainamic.nepum.ws.CommentWS;
import pt.dainamic.nepum.ws.PatientWS;

/**
 *
 * @author jorge
 */
public class ExerciseInterface extends javax.swing.JFrame {

    private PatientWS patWS;
    private CommentWS cmWS;
    private Logger log = Logger.getLogger(ExerciseInterface.class);
    private int idPatient;

    /**
     * Creates new form ExerciseDescription
     */
    public ExerciseInterface(Exercise ex) {
        initComponents();
        setIcon();
        setField(ex);
    }

    public ExerciseInterface(Exercise ex, Comment a) {
        initComponents();
        setIcon();
        setField(ex);
        jTextAreaComment.setText(a.getComment());
        jTextFieldPatient.setText(a.getName()+" "+a.getLastName());
    }

    private void setField(Exercise ex) {
        this.jTextFieldName.setText(ex.getName());
        this.jTextFieldLevel.setText(String.valueOf(ex.getLevel()));
        this.jTextFieldDomain.setText(ex.getDomain());
        this.jTextFieldSubDomain.setText(ex.getSubDomain());
        
        if (ex.getTime() == 0) {
            this.jTextFieldTime.setText("Tempo ilimitado");
        } else {
            this.jTextFieldTime.setText(String.valueOf(ex.getTime() + "segundos"));
        }
        try {
            jLabelPhoto.setIcon(new ImageIcon(getImageFromServer(ex.getPicture(), 310, 220)));
        } catch (Exception e) {
            log.error(e.getMessage());
        }

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

    private void setIcon() {
        List<Image> icons = new ArrayList<>();
        icons.add(new ImageIcon(getClass().getResource("/pt/dainamic/nepum/images/logo.png")).getImage());
        icons.add(new ImageIcon(getClass().getResource("/pt/dainamic/nepum/images/logo-icon.png")).getImage());
        setIconImages(icons);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelWallpaper = new javax.swing.JPanel();
        jPanelInformation = new javax.swing.JPanel();
        jLabelExercise = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jLabelLevel = new javax.swing.JLabel();
        jButtonBack = new javax.swing.JButton();
        jTextFieldName = new javax.swing.JTextField();
        jTextFieldLevel = new javax.swing.JTextField();
        jTextFieldDomain = new javax.swing.JTextField();
        jTextFieldTime = new javax.swing.JTextField();
        jLabelDomain = new javax.swing.JLabel();
        jLabelSubDomain = new javax.swing.JLabel();
        jTextFieldSubDomain = new javax.swing.JTextField();
        jLabelLimitTime = new javax.swing.JLabel();
        jLabelPhoto = new javax.swing.JLabel();
        jLabelComment = new javax.swing.JLabel();
        jScrollPaneComment = new javax.swing.JScrollPane();
        jTextAreaComment = new javax.swing.JTextArea();
        jTextFieldPatient = new javax.swing.JTextField();
        jLabelInformation = new javax.swing.JLabel();
        jLabelwallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(705, 520));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelWallpaper.setMaximumSize(new java.awt.Dimension(700, 500));
        jPanelWallpaper.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelInformation.setMaximumSize(new java.awt.Dimension(680, 380));
        jPanelInformation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelExercise.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabelExercise.setText("Exercícios");
        jPanelInformation.add(jLabelExercise, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabelName.setText("Nome:");
        jPanelInformation.add(jLabelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 20));

        jLabelLevel.setText("Nivel:");
        jPanelInformation.add(jLabelLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 20));

        jButtonBack.setText("Voltar");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });
        jPanelInformation.add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 330, -1, -1));
        jPanelInformation.add(jTextFieldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 260, -1));
        jPanelInformation.add(jTextFieldLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 80, -1));
        jPanelInformation.add(jTextFieldDomain, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 190, 20));
        jPanelInformation.add(jTextFieldTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 80, -1));

        jLabelDomain.setText("Domínio:");
        jPanelInformation.add(jLabelDomain, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, 20));

        jLabelSubDomain.setText("Sub-domínio:");
        jPanelInformation.add(jLabelSubDomain, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, 20));
        jPanelInformation.add(jTextFieldSubDomain, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 190, -1));

        jLabelLimitTime.setText("Tempo limite:");
        jPanelInformation.add(jLabelLimitTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 80, 20));
        jPanelInformation.add(jLabelPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 300, 180));

        jLabelComment.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelComment.setText("Comentário");
        jPanelInformation.add(jLabelComment, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 90, 20));

        jTextAreaComment.setColumns(20);
        jTextAreaComment.setLineWrap(true);
        jTextAreaComment.setRows(5);
        jTextAreaComment.setWrapStyleWord(true);
        jScrollPaneComment.setViewportView(jTextAreaComment);

        jPanelInformation.add(jScrollPaneComment, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 270, 130));

        jTextFieldPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPatientActionPerformed(evt);
            }
        });
        jPanelInformation.add(jTextFieldPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, 270, 30));

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

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        
        dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jTextFieldPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPatientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPatientActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JLabel jLabelComment;
    private javax.swing.JLabel jLabelDomain;
    private javax.swing.JLabel jLabelExercise;
    private javax.swing.JLabel jLabelInformation;
    private javax.swing.JLabel jLabelLevel;
    private javax.swing.JLabel jLabelLimitTime;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelPhoto;
    private javax.swing.JLabel jLabelSubDomain;
    private javax.swing.JLabel jLabelwallpaper;
    private javax.swing.JPanel jPanelInformation;
    private javax.swing.JPanel jPanelWallpaper;
    private javax.swing.JScrollPane jScrollPaneComment;
    private javax.swing.JTextArea jTextAreaComment;
    private javax.swing.JTextField jTextFieldDomain;
    private javax.swing.JTextField jTextFieldLevel;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldPatient;
    private javax.swing.JTextField jTextFieldSubDomain;
    private javax.swing.JTextField jTextFieldTime;
    // End of variables declaration//GEN-END:variables
}
