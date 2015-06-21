/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.dainamic.nepum.ui.hp.appointments;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import static java.lang.Integer.parseInt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import pt.dainamic.nepum.model.Appointment;
import pt.dainamic.nepum.model.LoginSession;
import pt.dainamic.nepum.ui.hp.HealthProfessionalMenu;
import pt.dainamic.nepum.ws.AppointmentWS;

/**
 *
 * @author jorge
 */
public class Schedule extends javax.swing.JFrame {

    /**
     * Creates new form Schedule
     */
    private AppointmentWS appoint;
    private List<Appointment> apList;
    private int i;

    public Schedule() {
        try {
            appoint = new AppointmentWS();
            apList = appoint.getHPAppointments(LoginSession.getInstance().getIdHealthProfessional());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(Schedule.this,
                    e.getMessage(), "Erro ao aceder à internet", JOptionPane.ERROR_MESSAGE);
        }
        initComponents();
        setIcon();
        i = 1;
        paintSchedule();
    }

    private void paintSchedule() {
        if (!apList.isEmpty()) {
            for (Appointment a : apList) {
                if (a.getPatientApproval() == 1 && a.getHealthProfessionalApproval() == 1) {
                    paintAppoint(a, "green");
                } else if (a.getPatientApproval() == 0 || a.getHealthProfessionalApproval() == 0) {
                    paintAppoint(a, "red");
                }
            }
        }
    }

    private void paintAppoint(Appointment a, String color) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(jCalendar.getDate());
        int month = cal.get(Calendar.MONTH) + 1;

        JPanel jpanel = jCalendar.getDayChooser().getDayPanel();
        Component component[] = jpanel.getComponents();
        String[] data = a.getDate().split("-");
        int appointMonth = parseInt(data[1]);
        int appointDay = parseInt(data[2]);
        // Calculate the offset of the first day of the month
        cal.set(Calendar.DAY_OF_MONTH, 1);
        int offset = cal.get(Calendar.DAY_OF_WEEK) - 1;
        //se o offset for 0 (Sunday) offset=7 (because of the components that are leaved behind)
        if (offset == 0) {
            offset = 7;
        }
        if (month == appointMonth) {
            if (color.equals("green")) {
                Color newGreen = new Color(0, 204, 51);
                component[appointDay - 1 + offset + 6].setBackground(newGreen);
                component[appointDay - 1 + offset + 6].setForeground(Color.GREEN);

            } else {
                Color newRed = new Color(173, 0, 2);
                component[appointDay - 1 + offset + 6].setForeground(Color.RED);
                component[appointDay - 1 + offset + 6].setBackground(newRed);
            }
        }
    }

    private Date formatDate(Date d) {
        return dateParse(parseDate(d));
    }

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

    private Date dateParse(String birthDate) {
        SimpleDateFormat dateFromat = new SimpleDateFormat("yyyy-MM-dd");
        Date d = null;
        try {
            d = dateFromat.parse(birthDate);
        } catch (ParseException ex) {

        }
        return d;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelWallpaper = new javax.swing.JPanel();
        jPanelInformation = new javax.swing.JPanel();
        jCalendar = new com.toedter.calendar.JCalendar();
        jButtonBack = new javax.swing.JButton();
        jButtonMakeAppointment = new javax.swing.JButton();
        jButtonSeeEvent = new javax.swing.JButton();
        jLabelAproved = new javax.swing.JLabel();
        jLabelUnAproved = new javax.swing.JLabel();
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

        jCalendar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendarPropertyChange(evt);
            }
        });
        jPanelInformation.add(jCalendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 540, 270));

        jButtonBack.setText("Voltar");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });
        jPanelInformation.add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, -1, -1));

        jButtonMakeAppointment.setText("Marcar Consulta");
        jButtonMakeAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMakeAppointmentActionPerformed(evt);
            }
        });
        jPanelInformation.add(jButtonMakeAppointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, -1, -1));

        jButtonSeeEvent.setText("Ver Consulta");
        jButtonSeeEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSeeEventActionPerformed(evt);
            }
        });
        jPanelInformation.add(jButtonSeeEvent, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, -1, -1));

        jLabelAproved.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelAproved.setForeground(new java.awt.Color(0, 204, 51));
        jLabelAproved.setText("Consulta Aprovada");
        jPanelInformation.add(jLabelAproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 130, -1));

        jLabelUnAproved.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelUnAproved.setForeground(new java.awt.Color(173, 0, 2));
        jLabelUnAproved.setText("Consulta por Aprovar ou Expirada");
        jPanelInformation.add(jLabelUnAproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, -1));

        jLabelInformation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pt/dainamic/nepum/images/backGround/second.jpg"))); // NOI18N
        jPanelInformation.add(jLabelInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 380));

        jPanelWallpaper.add(jPanelInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 680, 380));

        jLabelwallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pt/dainamic/nepum/images/backGround/first.jpg"))); // NOI18N
        jPanelWallpaper.add(jLabelwallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSeeEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSeeEventActionPerformed
        int idHealthProfessional = LoginSession.getInstance().getIdHealthProfessional();
        new FEAppointment(idHealthProfessional, parseDate(jCalendar.getDate())).setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonSeeEventActionPerformed

    private void jButtonMakeAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMakeAppointmentActionPerformed
        new AppointmentCreateEdit(parseDate(jCalendar.getDate())).setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonMakeAppointmentActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        new HealthProfessionalMenu().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jCalendarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendarPropertyChange
        if (i >= 1) {
            paintSchedule();
        }
        i++;

        Date selectDay = formatDate(jCalendar.getDate());
        Date today = formatDate(Calendar.getInstance().getTime());
        if (selectDay.before(today)) {

            jButtonMakeAppointment.setEnabled(false);

        } else {

            jButtonMakeAppointment.setEnabled(true);

        }
        if (!apList.isEmpty()) {
            for (Appointment a : apList) {
                if (selectDay.equals(dateParse(a.getDate()))) {
                    jButtonSeeEvent.setEnabled(true);
                    return;
                } else {
                    jButtonSeeEvent.setEnabled(false);
                }
            }
        } else {
            jButtonSeeEvent.setEnabled(false);
        }

    }//GEN-LAST:event_jCalendarPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonMakeAppointment;
    private javax.swing.JButton jButtonSeeEvent;
    private com.toedter.calendar.JCalendar jCalendar;
    private javax.swing.JLabel jLabelAproved;
    private javax.swing.JLabel jLabelInformation;
    private javax.swing.JLabel jLabelUnAproved;
    private javax.swing.JLabel jLabelwallpaper;
    private javax.swing.JPanel jPanelInformation;
    private javax.swing.JPanel jPanelWallpaper;
    // End of variables declaration//GEN-END:variables

}
