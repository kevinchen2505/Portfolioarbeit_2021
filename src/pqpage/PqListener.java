package pqpage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * MouseListener des pqPanels in der Klasse start.Startseite
 *
 * @author (K.Chen)
 * @version (1.0)
 */
public class PqListener extends MouseAdapter
{
    private PqFrame pqFrame;
    @Override
    public void mouseReleased(MouseEvent e) {  
        if (pqFrame == null) {
            pqFrame = new PqFrame();
        } else {
            pqFrame.setup();
            pqFrame.invalidate();
        }
    }
}