package pipage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * MouseListener des piPanels in der Klasse start.Startseite
 *
 * @author (K.Chen)
 * @version (1.0)
 */
public class PiListener extends MouseAdapter
{
    private PiFrame piFrame;
    @Override
    public void mouseReleased(MouseEvent e) {  
        if (piFrame == null) {
            piFrame = new PiFrame();
        } else {
            piFrame.setup();
            piFrame.invalidate();
        }
    }
}
