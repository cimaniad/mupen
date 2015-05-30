package pt.dainamic.nepum.util;


/**
 *
 * @author Ricardo
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPasswordField;
import javax.swing.text.Document;

@SuppressWarnings("serial")
public class PlaceholderPassField extends JPasswordField {

    private String placeholder;

    public PlaceholderPassField() {
    }

    public PlaceholderPassField(
        final Document pDoc,
        final String pText,
        final int pColumns)
    {
        super(pDoc, pText, pColumns);
    }

    public PlaceholderPassField(final int pColumns) {
        super(pColumns);
    }

    public PlaceholderPassField(final String pText) {
        super(pText);
    }

    public PlaceholderPassField(final String pText, final int pColumns) {
        super(pText, pColumns);
    }

    public String getPlaceholder() {
        return placeholder;
    }

    @Override
    protected void paintComponent(final Graphics pG) {
        super.paintComponent(pG);

        if (placeholder.length() == 0 || getText().length() > 0) {
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

    public void setPlaceholder(final String s) {
        placeholder = s;
    }

}