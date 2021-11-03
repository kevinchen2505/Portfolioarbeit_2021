package start;

import cosinuspage.CosinusListener;
import mitternachtpage.MitternachtListener;
import pipage.PiListener;
import pqpage.PqListener;

/**
 * Benutzerinterface für alle weiteren Module des Projekts
 *
 * @author (K. Chen)
 * @version (1.0)
 */
public class Startseite {
    // Deklaration der Objekte ausserhalb dem Rumpf des Programmes
    private final StartFrame startFrame;

    public Startseite() {
        // Konstruktion des grafischen Fensters
        startFrame = new StartFrame(new PqListener(),
                new PiListener(), new MitternachtListener(),
                new CosinusListener());
    }

    public StartFrame getFrame() {
        return startFrame;
    }

    public static void main(String[] args) {
        //hello
        // Instanz der Klasse start.Startseite
        Startseite main = new Startseite();

    }
}