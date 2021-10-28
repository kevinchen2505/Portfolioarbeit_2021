package cosinuspage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * MouseListener des cosinusPanels in der Klasse start.Startseite
 *
 * @author (K.Chen)
 * @version (1.0)
 */
public class CosinusListener extends MouseAdapter
{
    private CosinusFrame cosinusFrame;
    @Override
    public void mouseReleased(MouseEvent e) {  
        if (cosinusFrame == null) {
            cosinusFrame = new CosinusFrame();
        } else {
            cosinusFrame.setup();
            cosinusFrame.invalidate();
        }
    }
}
