package mitternachtpage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * MouseListener des mitternachtPanels in der Klasse start.Startseite
 *
 * @author (K.Chen)
 * @version (1.0)
 */
public class MitternachtListener extends MouseAdapter
{
    private MitternachtFrame mitternachtFrame;
    @Override
    public void mouseReleased(MouseEvent e) {  
        if (mitternachtFrame == null) {
            mitternachtFrame = new MitternachtFrame();
        } else {
            mitternachtFrame.setup();
            mitternachtFrame.invalidate();
        }
    }
}
