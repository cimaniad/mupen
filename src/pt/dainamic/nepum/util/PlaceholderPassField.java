package pt.dainamic.nepum.util;


/**
 *
 * @author Ricardo
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class PlaceholderPassField extends JPasswordField {

    private String placeholder;

    public PlaceholderPassField(String txt) {
      super();
      setPlaceholder(txt);
    }


    public String getPlaceholder() {
        return placeholder;
    }

    @Override
    protected void paintComponent(final Graphics pG) {
        super.paintComponent(pG);
        int t=0;
        for(char c: getPassword()){
            t++;
        }
        
        if (placeholder.length() == 0 || t > 0) {
            return;
        }

        final Graphics2D g = (Graphics2D) pG;
        g.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(getDisabledTextColor());
        g.drawString(placeholder, getInsets().left, pG.getFontMetrics()
            .getMaxAscent() + getInsets().top);
    }

    private void setPlaceholder(final String s) {
        placeholder = s;
    }

}