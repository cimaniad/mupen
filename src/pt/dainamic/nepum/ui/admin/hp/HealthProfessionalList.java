/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.dainamic.nepum.ui.admin.hp;



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
import org.apache.log4j.*;
import pt.dainamic.nepum.model.HealthProfessional;
import pt.dainamic.nepum.ui.admin.AdminMenu;
import pt.dainamic.nepum.util.JTableRenderer;
import pt.dainamic.nepum.util.PlaceholderTextField;
import pt.dainamic.nepum.ws.HealthProfessionalWS;

/**
 *
 * @author Dainamic
 */
public class HealthProfessionalList extends javax.swing.JFrame {

    private Logger log = Logger.getLogger(HealthProfessionalList.class);
    private DefaultTableModel tableModel;
    private HealthProfessionalWS hpWS;
    private List<HealthProfessional> hpList;

    /**
     * Creates new form HeathProfessionalList
     */
    public HealthProfessionalList() {
        try {
            initComponents();
            setIcon();
            hpWS = new HealthProfessionalWS();
            hpList = hpWS.getAllHealthProfessionals();
            drawTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(HealthProfessionalList.this,
                    e.getMessage(), "Erro ao carregar os dados do Profissional de saude", JOptionPane.ERROR_MESSAGE);

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelWallpaper = new javax.swing.JPanel();
        jPanelInformation = new javax.swing.JPanel();
        jLabelHealthProfessionalList = new javax.swing.JLabel();
        jButtonRegist = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();
        jButtonSearch = new javax.swing.JButton();
        placeholderFieldSearch = new PlaceholderTextField("");
        jScrollPaneList = new javax.swing.JScrollPane();
        jTableList = new javax.swing.JTable();
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

        jLabelHealthProfessionalList.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabelHealthProfessionalList.setText("Lista de profissionais de saúde");
        jPanelInformation.add(jLabelHealthProfessionalList, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jButtonRegist.setText("Registar");
        jButtonRegist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistActionPerformed(evt);
            }
        });
        jPanelInformation.add(jButtonRegist, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, -1, -1));

        jButtonBack.setText("Voltar");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });
        jPanelInformation.add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 330, -1, -1));

        jButtonSearch.setText("Pesquisar");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });
        jPanelInformation.add(jButtonSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, -1, -1));

        placeholderFieldSearch.setPlaceholder("Pequise por nome ou contacto");
        placeholderFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                placeholderFieldSearchKeyPressed(evt);
            }
        });
        jPanelInformation.add(placeholderFieldSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 210, -1));

        jTableList.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTableList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Apelido", "Foto"
            }
        ));
        jTableList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListMouseClicked(evt);
            }
        });
        jScrollPaneList.setViewportView(jTableList);

        jPanelInformation.add(jScrollPaneList, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 630, 240));

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
     * This method opens the HealthProfessionalRegist Jfram and close this when
     * the jButtonRegist is clicked
     *
     * @param evt
     */
    private void jButtonRegistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistActionPerformed
        new HealthProfessionalRegist().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonRegistActionPerformed
    /**
     * This method makes the serch by the HealthProfessional, and redraw the
     * table
     *
     * @param evt
     */
    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        try {
            String input = placeholderFieldSearch.getText();
            hpList = hpWS.searchHealthProfessional(input);
            drawTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(HealthProfessionalList.this,
                    e.getMessage(), "Erro ao pesquisar Profissional de saude", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonSearchActionPerformed
    /**
     * This method reacts to the click at the Jtable, and opens the profile of
     * the selected HealthProfessional
     *
     * @param evt
     */
    private void jTableListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListMouseClicked
        if (evt.getClickCount() == 2) {
            new HealthProfessionalProfile(getHealthProAtTable()).setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jTableListMouseClicked
    /**
     * This method reacts to the click at the jButtonBack, and close this Jframe
     * and opens the AdminMenu Jframe
     *
     * @param evt
     */
    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        new AdminMenu().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void placeholderFieldSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_placeholderFieldSearchKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jButtonSearch.doClick();
        }
    }//GEN-LAST:event_placeholderFieldSearchKeyPressed
    /**
     * This method draw and fill the table
     */
    private void drawTable() {
        try {
            initializeTable();
            int width = jTableList.getColumnModel().getColumn(2).getWidth();
            int height = 60;

            for (HealthProfessional hp : hpList) {
                if (hp.getPicture().equals("profile")) {
                    ImageIcon pic = new ImageIcon(getClass().getResource("/pt/dainamic/nepum/images/pics/profile.PNG"));
                    tableModel.addRow(new Object[]{hp.getName(), hp.getLastName(),
                        new ImageIcon(pic.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT))});
                } else {

                    tableModel.addRow(new Object[]{hp.getName(), hp.getLastName(),
                        new ImageIcon(getImageFromServer(hp.getPicture(), width, height))});
                }

            }
        } catch (Exception ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
            JOptionPane.showMessageDialog(HealthProfessionalList.this, "Erro ao carregar a tabela dos \nprofissionais de saude",
                    "Erro  Profissional de saude", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method returns the HealthProfessional selected at the Table
     *
     * @return
     */
    private HealthProfessional getHealthProAtTable() {
        return hpList.get(jTableList.getSelectedRow());
    }

    /**
     * This method sets the configs to the jTableList
     */
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
        JTableRenderer renderer = new JTableRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTableList.getColumnModel().getColumn(2).setCellRenderer(renderer);
        jTableList.setRowHeight(60);
    }

    /**
     * This method gets the image of the Health professional from the server and
     * resize it to the chosen dimensions
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
    private javax.swing.JLabel jLabelHealthProfessionalList;
    private javax.swing.JLabel jLabelInformation;
    private javax.swing.JLabel jLabelwallpaper;
    private javax.swing.JPanel jPanelInformation;
    private javax.swing.JPanel jPanelWallpaper;
    private javax.swing.JScrollPane jScrollPaneList;
    private javax.swing.JTable jTableList;
    private PlaceholderTextField placeholderFieldSearch;
    // End of variables declaration//GEN-END:variables

}
