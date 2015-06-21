/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.dainamic.nepum.ui.hp.appointments;

import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import pt.dainamic.nepum.model.Appointment;
import pt.dainamic.nepum.model.LoginSession;
import pt.dainamic.nepum.model.Notification;
import pt.dainamic.nepum.model.Patient;
import pt.dainamic.nepum.ws.AppointmentWS;
import pt.dainamic.nepum.ws.NotificationWS;
import pt.dainamic.nepum.ws.PatientWS;

/**
 *
 * @author jorge
 */
public class AppointmentCreateEdit extends javax.swing.JFrame {

    /**
     * Creates new form EventRegist
     *
     */
    private Logger log = Logger.getLogger(AppointmentCreateEdit.class);
    private AppointmentWS appWS;
    private PatientWS patWS;
    private List<Patient> patList;
    private List<Appointment> apptList;

    public AppointmentCreateEdit(Appointment appoint) {
        try {
            appWS = new AppointmentWS();
            patWS = new PatientWS();
            patList = new ArrayList<>();
            //id Profissional de saude!!!!!!!!!!!!
            apptList = appWS.getHPAppointments(LoginSession.getInstance().getIdHealthProfessional());
            initComponents();
            setIcon();
            jTextFieldDate.setVisible(false);
            loadAppointToEdit(appoint);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(AppointmentCreateEdit.this,
                    e.getMessage(), "Erro ao carregar consulta", JOptionPane.ERROR_MESSAGE);
        }
    }

    public AppointmentCreateEdit(String date) {
        try {
            initComponents();
            jDateChooser1.setVisible(false);
            appWS = new AppointmentWS();
            patWS = new PatientWS();
            //colocar id HealthProfessional
            apptList = appWS.getHPAppointments(LoginSession.getInstance().getIdHealthProfessional());
            jTextFieldDate.setText(date);
            //colocar id do terapeuta
            patList = patWS.getPatientsByHealthProfessional(LoginSession.getInstance().getIdHealthProfessional());
            if (!patList.isEmpty()) {
                for (Patient p : patList) {
                    jComboBoxPatientList.addItem(p.getName() + " " + p.getLastName());
                }
                comboChange();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            JOptionPane.showMessageDialog(AppointmentCreateEdit.this,
                    e.getMessage(), "Erro ao carregar a lista de pacientes", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void comboChange() {
        jTextFieldPathology.setText(getSelectPat().getPathology());
    }
    
    private void loadAppointToEdit(Appointment appoint) {
        try {
            Patient pat = patWS.getPatientById(appoint.getIdPatient());
            patList.add(pat);

            jTextAreaDescription.setText(appoint.getDescription());
            jTextFieldLocal.setText(appoint.getLocal());
            jComboBoxPatientList.addItem(pat.getName() + " " + pat.getLastName());
            jTextFieldPathology.setText(pat.getPathology());
            jLabelIdApp.setText(String.valueOf(appoint.getIdAppointment()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(AppointmentCreateEdit.this,
                    e.getMessage(), "Erro ao carregar paciente", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Appointment loadAppointmentFromPanel() {
        String warn = validator();
        if (!warn.isEmpty()) {
            throw new RuntimeException("Preencha o(s) seguintes dado(s): " + warn);
        }

        int idPatient = getSelectPat().getIdPatient();
        //pôr IDHealthPro
        int idHealthProfessional = LoginSession.getInstance().getIdHealthProfessional();
        String date = null;
        if (jDateChooser1.isVisible()) {
            date = parseDate(jDateChooser1.getDate());
        } else {
            date = jTextFieldDate.getText();
        }
        String hour = jSpinFieldHour.getValue() + ":" + jSpinFieldMin.getValue();
        String local = jTextFieldLocal.getText();
        byte healthProAprov = 1;
        String description = jTextAreaDescription.getText();
        int idApp = jLabelIdApp.getText().isEmpty() ? 0 : Integer.valueOf(jLabelIdApp.getText());

        return new Appointment(idApp, idPatient, idHealthProfessional, date, hour, local, (byte) 0,
                healthProAprov, description);
    }

    private Patient getSelectPat() {
        return patList.get(jComboBoxPatientList.getSelectedIndex());
    }

    private String validator() {
        StringBuilder warns = new StringBuilder();
        if (jDateChooser1.isVisible()) {
            warns.append(jDateChooser1.getDate().toString().isEmpty() ? "Data, " : "");
        }
        warns.append(jSpinFieldHour.getValue() == 0 ? "Horas, " : "");
        warns.append(jTextFieldPathology.getText().isEmpty() ? "Patologia, " : "");
        warns.append(jTextFieldLocal.getText().isEmpty() ? "Local, " : "");

        if (!warns.toString().isEmpty()) {
            warns.delete(warns.toString().length() - 2, warns.toString().length());
            warns.append("!");
        }

        return warns.toString();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelWallpaper = new javax.swing.JPanel();
        jPanelInformation = new javax.swing.JPanel();
        jLabelHealthPatientProfile = new javax.swing.JLabel();
        jButtonBack = new javax.swing.JButton();
        jLabelDate = new javax.swing.JLabel();
        jLabelPatient = new javax.swing.JLabel();
        jLabelLocal = new javax.swing.JLabel();
        jLabelDescription = new javax.swing.JLabel();
        jLabelHours = new javax.swing.JLabel();
        jLabelPathology = new javax.swing.JLabel();
        jComboBoxPatientList = new javax.swing.JComboBox();
        jTextFieldPathology = new javax.swing.JTextField();
        jTextFieldDate = new javax.swing.JTextField();
        jTextFieldLocal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescription = new javax.swing.JTextArea();
        jButtonMakeAppointment = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jSpinFieldHour = new com.toedter.components.JSpinField();
        jSpinFieldMin = new com.toedter.components.JSpinField();
        jLabelsep = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelIdApp = new javax.swing.JLabel();
        jLabelwallpaper = new javax.swing.JLabel();
        jLabelwallpaper1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(705, 520));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelWallpaper.setMaximumSize(new java.awt.Dimension(700, 500));
        jPanelWallpaper.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelInformation.setMaximumSize(new java.awt.Dimension(680, 380));
        jPanelInformation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelHealthPatientProfile.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabelHealthPatientProfile.setText("Consulta");
        jPanelInformation.add(jLabelHealthPatientProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jButtonBack.setText("Voltar");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });
        jPanelInformation.add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 330, -1, -1));

        jLabelDate.setText("Data:");
        jPanelInformation.add(jLabelDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, 20));

        jLabelPatient.setText("Paciente:");
        jPanelInformation.add(jLabelPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, 20));

        jLabelLocal.setText("Local: ");
        jPanelInformation.add(jLabelLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, -1, 20));

        jLabelDescription.setText("Descrição:");
        jPanelInformation.add(jLabelDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        jLabelHours.setText("Hora:");
        jPanelInformation.add(jLabelHours, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, -1, 20));

        jLabelPathology.setText("Patologia:");
        jPanelInformation.add(jLabelPathology, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, -1, 20));

        jComboBoxPatientList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPatientListActionPerformed(evt);
            }
        });
        jPanelInformation.add(jComboBoxPatientList, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 460, -1));

        jTextFieldPathology.setEditable(false);
        jPanelInformation.add(jTextFieldPathology, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 180, -1));

        jTextFieldDate.setEditable(false);
        jPanelInformation.add(jTextFieldDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 180, -1));
        jPanelInformation.add(jTextFieldLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 180, -1));

        jTextAreaDescription.setColumns(20);
        jTextAreaDescription.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDescription);

        jPanelInformation.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 460, -1));

        jButtonMakeAppointment.setText("Marcar Consulta");
        jButtonMakeAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMakeAppointmentActionPerformed(evt);
            }
        });
        jPanelInformation.add(jButtonMakeAppointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, -1, -1));
        jPanelInformation.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 180, -1));

        jSpinFieldHour.setMaximum(23);
        jSpinFieldHour.setMinimum(0);
        jPanelInformation.add(jSpinFieldHour, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 40, -1));

        jSpinFieldMin.setMaximum(60);
        jSpinFieldMin.setMinimum(0);
        jPanelInformation.add(jSpinFieldMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 40, -1));

        jLabelsep.setText(":");
        jPanelInformation.add(jLabelsep, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 20, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pt/dainamic/nepum/images/backGround/second.jpg"))); // NOI18N
        jPanelInformation.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 380));
        jPanelInformation.add(jLabelIdApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, -1, -1));

        jPanelWallpaper.add(jPanelInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 680, 380));
        jPanelWallpaper.add(jLabelwallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabelwallpaper1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pt/dainamic/nepum/images/backGround/first.jpg"))); // NOI18N
        jPanelWallpaper.add(jLabelwallpaper1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        new Schedule().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jButtonMakeAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMakeAppointmentActionPerformed
        try {
            Appointment appt = loadAppointmentFromPanel();
            String hourAppt = appt.getHour().split(":")[0];
            for (Appointment a : apptList) {
                String hourA = a.getHour().split(":")[0];
                if (a.getDate().equals(appt.getDate()) && hourA.equals(hourAppt)) {
                    throw new RuntimeException("Já existe uma consulta marcada neste dia a esta hora");
                }
                if (a.getDate().equals(appt.getDate()) && a.getIdPatient() == appt.getIdPatient()) {
                    throw new RuntimeException("Só é possivel marcar uma consulta por dia para cada paciente. ");
                }

            }

            NotificationWS nWS = new NotificationWS();
            int idApp = Integer.parseInt(appWS.saveEditAppointment(appt).getMsg());
            nWS.createEditNotification(new Notification(0, 0, idApp,
                    0, (byte) 0, "Foi criada uma nova consulta!",
                    (byte) 0, appt.getIdPatient(), appt.getIdHealthProfessional()));
            new Schedule().setVisible(true);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(AppointmentCreateEdit.this, e.getMessage(),
                    "Erro ao guardar Consulta", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonMakeAppointmentActionPerformed

    private void jComboBoxPatientListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPatientListActionPerformed
        comboChange();
    }//GEN-LAST:event_jComboBoxPatientListActionPerformed

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

    private void setIcon() {
        List<Image> icons = new ArrayList<>();
        icons.add(new ImageIcon(getClass().getResource("/pt/dainamic/nepum/images/logo.png")).getImage());
        icons.add(new ImageIcon(getClass().getResource("/pt/dainamic/nepum/images/logo-icon.png")).getImage());
        setIconImages(icons);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonMakeAppointment;
    private javax.swing.JComboBox jComboBoxPatientList;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelDescription;
    private javax.swing.JLabel jLabelHealthPatientProfile;
    private javax.swing.JLabel jLabelHours;
    private javax.swing.JLabel jLabelIdApp;
    private javax.swing.JLabel jLabelLocal;
    private javax.swing.JLabel jLabelPathology;
    private javax.swing.JLabel jLabelPatient;
    private javax.swing.JLabel jLabelsep;
    private javax.swing.JLabel jLabelwallpaper;
    private javax.swing.JLabel jLabelwallpaper1;
    private javax.swing.JPanel jPanelInformation;
    private javax.swing.JPanel jPanelWallpaper;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.components.JSpinField jSpinFieldHour;
    private com.toedter.components.JSpinField jSpinFieldMin;
    private javax.swing.JTextArea jTextAreaDescription;
    private javax.swing.JTextField jTextFieldDate;
    private javax.swing.JTextField jTextFieldLocal;
    private javax.swing.JTextField jTextFieldPathology;
    // End of variables declaration//GEN-END:variables

}
