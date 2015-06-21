/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.dainamic.nepum.ui.hp.patients;

import java.awt.Color;
import pt.dainamic.nepum.ui.hp.HealthProfessionalMenu;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;
import pt.dainamic.nepum.model.LoginSession;
import pt.dainamic.nepum.model.Notification;
import pt.dainamic.nepum.model.Patient;
import pt.dainamic.nepum.ui.hp.appointments.FEAppointment;
import pt.dainamic.nepum.util.JTableRenderer;
import pt.dainamic.nepum.util.PlaceholderTextField;
import pt.dainamic.nepum.ws.NotificationWS;
import pt.dainamic.nepum.ws.PatientWS;

/**
 *
 * @author jorge
 */
public class PatientsList extends javax.swing.JFrame {

    private Logger log = Logger.getLogger(PatientsList.class);
    private DefaultTableModel tableModel;
    private PatientWS pWS;
    private int idHealthProfessional;
    private List<Patient> pList;
    private List<Notification> nList;
    private NotificationWS nWS;

    /**
     * Creates new form PatientesList
     */
    public PatientsList() {
        try {
            initComponents();
            setIcon();
            nWS = new NotificationWS();
            pWS = new PatientWS();
            idHealthProfessional = LoginSession.getInstance().getIdHealthProfessional();
            nList = nWS.getHPNotifications(idHealthProfessional);
            pList = pWS.getPatientsByHealthProfessional(idHealthProfessional);
            drawTable();
        } catch (Exception e) {
            log.error(e.getMessage());
            JOptionPane.showMessageDialog(PatientsList.this, e.getMessage(),
                    "Lista de Pacientes", JOptionPane.ERROR_MESSAGE);
        }

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
        jLabelPatientslList = new javax.swing.JLabel();
        jButtonRegist = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();
        jScrollPaneList = new javax.swing.JScrollPane();
        jTableList = new javax.swing.JTable();
        jButtonSearch = new javax.swing.JButton();
         placeholderFieldSearch = new PlaceholderTextField("pesquise por nome ou contacto");
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

        jLabelPatientslList.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabelPatientslList.setText("Lista de pacientes");
        jPanelInformation.add(jLabelPatientslList, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jButtonRegist.setText("Registar");
        jButtonRegist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistActionPerformed(evt);
            }
        });
        jPanelInformation.add(jButtonRegist, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 330, -1, -1));

        jButtonBack.setText("Voltar");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });
        jPanelInformation.add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 330, -1, -1));

        jTableList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Apelido", "Patologia", "Notificações"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableListMousePressed(evt);
            }
        });
        jTableList.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTableListPropertyChange(evt);
            }
        });
        jScrollPaneList.setViewportView(jTableList);

        jPanelInformation.add(jScrollPaneList, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 630, 220));

        jButtonSearch.setText("Pesquisar");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });
        jPanelInformation.add(jButtonSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, -1, -1));

        placeholderFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                placeholderFieldSearchKeyPressed(evt);
            }
        });
        jPanelInformation.add(placeholderFieldSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 210, -1));

        jLabelInformation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pt/dainamic/nepum/images/backGround/second.jpg"))); // NOI18N
        jLabelInformation.setMaximumSize(new java.awt.Dimension(680, 380));
        jLabelInformation.setMinimumSize(new java.awt.Dimension(680, 380));
        jLabelInformation.setPreferredSize(new java.awt.Dimension(680, 380));
        jPanelInformation.add(jLabelInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 390));

        jPanelWallpaper.add(jPanelInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 680, 380));

        jLabelwallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pt/dainamic/nepum/images/backGround/first.jpg"))); // NOI18N
        jPanelWallpaper.add(jLabelwallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 500));

        getContentPane().add(jPanelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistActionPerformed
        new PatientRegist().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonRegistActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        new HealthProfessionalMenu().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jTableListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListMouseClicked
        if (evt.getClickCount() == 2) {
            new PatientProfile(getPatientAtTable()).setVisible(true);
            dispose();
        }

        if (!getPatientAtTable().getNotifications().isEmpty() && evt.getClickCount() == 1
                && jTableList.getSelectedColumn() == 3) {
            new NotificationPage(getPatientAtTable().getNotifications(), this).setVisible(true);

        }


    }//GEN-LAST:event_jTableListMouseClicked

    private void placeholderFieldSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_placeholderFieldSearchKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String input = placeholderFieldSearch.getText();
            pList = pWS.searchPatient(input, idHealthProfessional);
            drawTable();
        }
    }//GEN-LAST:event_placeholderFieldSearchKeyPressed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        String input = placeholderFieldSearch.getText();
        pList = pWS.searchPatient(input, idHealthProfessional);
        drawTable();
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jTableListPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTableListPropertyChange
    }//GEN-LAST:event_jTableListPropertyChange

    private void jTableListMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListMousePressed
        jLabelPatientslList.setBackground(Color.red);
    }//GEN-LAST:event_jTableListMousePressed

    private void drawTable() {
        try {
            initializeTable();

            for (Patient p : pList) {
                ImageIcon icon;
                int notifications = 0;
                for (Notification n : nList) {
                    if (n.getIdPatient() == p.getIdPatient()) {
                        ++notifications;
                        if (notifications == 1) {
                            icon = new ImageIcon(getClass().getResource("/pt/dainamic/nepum/images/icons/notificação laranja SF.PNG"));
                            addRow(p, icon);
                        }
                        System.out.println(n.toString());
                        p.addNotification(n);
                    }
                }
                if (notifications == 0) {
                    icon = new ImageIcon(getClass().getResource("/pt/dainamic/nepum/images/icons/notificação cinza SF.PNG"));
                    addRow(p, icon);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            JOptionPane.showMessageDialog(PatientsList.this, "Erro ao carregar a tabela dos \npacientes!",
                    "Erro  Lista de Pacientes", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void addRow(Patient p, ImageIcon icon) {
        int width = jTableList.getColumnModel().getColumn(2).getWidth();
        int height = 60;
        if (p.getPicture().equals("profile")) {
            ImageIcon pic = new ImageIcon(getClass().getResource("/pt/dainamic/nepum/images/pics/profile.PNG"));

            tableModel.addRow(new Object[]{p.getName(), p.getLastName(),
                new ImageIcon(pic.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT)),
                new ImageIcon(icon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT))

            });
        } else {

            tableModel.addRow(new Object[]{p.getName(), p.getLastName(),
                new ImageIcon(getImageFromServer(p.getPicture(), width, height)),
                new ImageIcon(icon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT))

            });
        }
    }

    private Patient getPatientAtTable() {

        return pList.get(jTableList.getSelectedRow());
    }

    private void initializeTable() {
        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        };
        jTableList.setModel(tableModel);
        tableModel.addColumn("Nome");
        tableModel.addColumn("Apelido");
        tableModel.addColumn("Foto");
        tableModel.addColumn("Notificações");
        JTableRenderer renderer = new JTableRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTableList.getColumnModel().getColumn(2).setCellRenderer(renderer);
        jTableList.getColumnModel().getColumn(3).setCellRenderer(renderer);
        jTableList.setRowHeight(60);
    }

    /**
     * This method gets the image of the Patient from the server and resize it
     * to the chosen dimensions
     *
     * @param picture
     * @param width
     * @param heigth
     * @return Image
     */
    private Image getImageFromServer(String picture, int width, int heigth) {
        try {
            URL url = new URL(picture.trim());
            log.debug(url.toString());
            BufferedImage image = ImageIO.read(url);
            ImageIcon pic = new ImageIcon(image);
            return pic.getImage().getScaledInstance(width, heigth, Image.SCALE_DEFAULT);
        } catch (MalformedURLException ex) {
            log.error("\n" + ex.getMessage());
        } catch (IOException ex) {
            log.error("\n" + ex.getMessage());
        }
        return null;
    }

    private void setIcon() {
        List<Image> icons = new ArrayList<>();
        icons.add(new ImageIcon(getClass().getResource("/pt/dainamic/nepum/images/logo.png")).getImage());
        icons.add(new ImageIcon(getClass().getResource("/pt/dainamic/nepum/images/logo-icon.png")).getImage());
        setIconImages(icons);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonRegist;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JLabel jLabelInformation;
    private javax.swing.JLabel jLabelPatientslList;
    private javax.swing.JLabel jLabelwallpaper;
    private javax.swing.JPanel jPanelInformation;
    private javax.swing.JPanel jPanelWallpaper;
    private javax.swing.JScrollPane jScrollPaneList;
    private javax.swing.JTable jTableList;
	private PlaceholderTextField placeholderFieldSearch;
    // End of variables declaration//GEN-END:variables

    private Object ImageIcon(Image scaledInstance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
