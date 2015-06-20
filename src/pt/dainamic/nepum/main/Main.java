/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.dainamic.nepum.main;

import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaSilverMoonLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaSimple2DLookAndFeel;
import pt.dainamic.nepum.ui.hp.HealthProfessionalMenu;

import org.apache.log4j.Logger;
import pt.dainamic.nepum.ui.admin.AdminMenu;
import pt.dainamic.nepum.ui.login.LoginPage;

/**
 *
 * @author Ricardo
 */
public class Main {

    private static Logger log = Logger.getLogger(Main.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       // com.sun.java.swing.plaf.windows.WindowsLookAndFeel
        // UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
        // new SyntheticaAluOxideLookAndFeel()
        try {
            javax.swing.UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());

        } catch (Exception e) {
            log.error(e.getMessage());
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginPage().setVisible(true);
//                new HealthProfessionalMenu().setVisible(true);
//                new AdminMenu().setVisible(true);
            }
        });
    }

}
