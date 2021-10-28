package start;

import cosinuspage.CosinusListener;
import mitternachtpage.MitternachtListener;
import pipage.PiListener;
import pqpage.PqListener;

import javax.swing.*;
import java.awt.*;

public class StartFrame extends JFrame {
    private JPanel headerPanel;
    private JPanel pqPanel;
    private JPanel mitternachtPanel;
    private JPanel cosinusPanel;
    private JPanel piPanel;
    private JLabel header;
    private JLabel header2;
    private JLabel wahl;
    private JLabel pqLabel;
    private JLabel mitternachtLabel;
    private JLabel cosinusLabel;
    private JLabel piLabel;
    private JPanel panel;
    private JLabel pqheader;
    private JTextField eingabefeld;
    private JTextField ausgabefeld;
    private JLabel eingabelabel;
    private JLabel ausgabelabel;
    public StartFrame(PqListener pqListener, PiListener piListener, MitternachtListener mitternachtListener,
                      CosinusListener cosinusListener) throws HeadlessException {
        setTitle("start.Startseite");
        // Festlegung des Layouts als GridBag
        setLayout(new GridBagLayout());
        // 1024 x 612 px size
        setSize(1024, 720);
        // Das Fenster soll in der Mitte des Bildschirms angezeigt werden
        // if =/null wird die Position relativ zu einem anderen Fenster bestimmt
        setLocationRelativeTo(null);
        // Das Fenster soll nicht vergrössert/verkleinert werden können
        setResizable(false);
        // Generierung eines Objekts mit spezifischer RGB-Kombination für Werte 0 - 255
        Color darkblue = new Color(67, 0, 191);
        // Hintergrundfarbe
        // mainframe.getContentPane().setBackground(darkblue);
        // closing frame option
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Bestimmung von location, size, growth factor, anchor, inset, filling, and padding
        GridBagConstraints c = new GridBagConstraints();
        // Die Komponenten sollen kein extra Platz beanspruchen
        c.fill = GridBagConstraints.NONE;

        // Insets für den Abstand zwischen den Zellen
        int top = 0;
        int left = 0;
        int bottom = 0;
        int right = 0;
        c.insets = new Insets(top, left, bottom, right);
        // Extra Platz für Komponenten innerhalb eines Containers
        // Wird auch in Kombination mit anchor benutzt
        c.weighty = 1.0;
        c.weightx = 1.0;
        // Spezifikation der Kolonnenbesetzung (gridheight) und Reihenbesetzung (gridwidth)
        // c.gridwidth = 1;
        // c.gridheight = 1;

        setupHeaderPanel(c);
        setupPanels(c);

        //Konstruktion der JLabel
        setupWelcomeHeaders(c);

        pqLabel = new JLabel("Numerisch stabile pq-Formel");
        setupLabelFont(pqLabel);
        setupGridBagConstraints(c);
        pqPanel.add(pqLabel, c);

        mitternachtLabel = new JLabel("Numerisch stabile Mitternachtsformel");
        setupLabelFont(mitternachtLabel);
        setupGridBagConstraints(c);
        mitternachtPanel.add(mitternachtLabel, c);

        cosinusLabel = new JLabel("Stabilisierung des Cosinussatzes");
        setupLabelFont(cosinusLabel);
        setupGridBagConstraints(c);
        cosinusPanel.add(cosinusLabel, c);

        piLabel = new JLabel("Numerisch stabile π-Berechnung");
        setupLabelFont(piLabel);
        setupGridBagConstraints(c);
        piPanel.add(piLabel, c);

        // importierte Bilder als JLabel
        ImageIcon headerImage = new ImageIcon("start/java_logo.jpg");
        JLabel headerImageL = new JLabel(headerImage);
        c.anchor = GridBagConstraints.FIRST_LINE_END;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        top = 12;
        left = 0;
        bottom = 0;
        right = 30;
        c.insets = new Insets(top, left, bottom, right);
        headerPanel.add(headerImageL, c);

        ImageIcon mitternachtImage = new ImageIcon("mitternachtpage/Mitternachtsformel.png");
        JLabel mitternachtImageL = new JLabel(mitternachtImage);
        c.anchor = GridBagConstraints.FIRST_LINE_END;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        top = 20;
        left = 10;
        bottom = 0;
        right = 45;
        c.insets = new Insets(top, left, bottom, right);
        mitternachtPanel.add(mitternachtImageL, c);

        ImageIcon piImage = new ImageIcon("pipage/Pi.png");
        JLabel piImageL = new JLabel(piImage);
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        top = 20;
        left = 20;
        bottom = 0;
        right = 70;
        c.insets = new Insets(top, left, bottom, right);
        piPanel.add(piImageL, c);

        // Panels werden MouseListener für die jeweiligen Klassen zugeordnet
        addMouseListeners(pqListener, piListener, mitternachtListener, cosinusListener);

        setVisible(true);
    }

    private void addCosinusImage(GridBagConstraints c) {
        int top;
        int left;
        int bottom;
        int right;
        ImageIcon cosinusImage = new ImageIcon("cosinuspage/Cosinussatz.png");
        JLabel cosinusImageL = new JLabel(cosinusImage);
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        top = 20;
        left = 0;
        bottom = 0;
        right = 0;
        c.insets = new Insets(top, left, bottom, right);
        cosinusPanel.add(cosinusImageL, c);
    }

    private void setupPanels(GridBagConstraints c) {
        setpPQPanel(c);
        settupMitternachtsPanel(c);
        setupCosinusPanel(c);
        setupPiPanel(c);
    }

    private void setupCosinusPanel(GridBagConstraints c) {
        int left;
        int right;
        int bottom;
        int top;
        cosinusPanel = new JPanel();
        cosinusPanel.setLayout(new GridBagLayout());
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.LAST_LINE_START;
        c.gridx = 0;
        c.gridy = 3;
        top = 5;
        left = 200;
        bottom = 60;
        right = 5;
        c.insets = new Insets(top, left, bottom, right);
        add(cosinusPanel, c);

        addCosinusImage(c);
    }

    private void addMouseListeners(PqListener pqListener, PiListener piListener, MitternachtListener mitternachtListener, CosinusListener cosinusListener) {
        pqPanel.addMouseListener(pqListener);
        mitternachtPanel.addMouseListener(mitternachtListener);
        cosinusPanel.addMouseListener(cosinusListener);
        piPanel.addMouseListener(piListener);
    }

    private static final Font DEFAULT_FONT = new Font("Serif", Font.PLAIN, 13);

    private void setupLabelFont(JLabel label) {
        label.setFont(DEFAULT_FONT);
    }

    private void setupGridBagConstraints(GridBagConstraints c) {
        int top;
        int left;
        int bottom;
        int right;
        c.gridx = 0;
        c.gridy = 1;
        c.fill = GridBagConstraints.NONE;
        top = 5;
        left = 10;
        bottom = 30;
        right = 5;
        c.insets = new Insets(top, left, bottom, right);
    }

    private void setupWelcomeHeaders(GridBagConstraints c) {
        int left;
        int right;
        int bottom;
        int top;
        header = new JLabel("Numerisch stabile Algorithmen");
        header.setFont(new Font("HelveticaNeue", Font.ITALIC, 42));
        //c.anchor = GridBagConstraints.NORTH;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.gridx = 0;
        c.gridy = 0;
        top = 60;
        left = 20;
        bottom = 5;
        right = 0;
        c.insets = new Insets(top, left, bottom, right);
        headerPanel.add(header, c);

        header2 = new JLabel("Portfolioarbeit 2021");
        header2.setFont(new Font("HelveticaNeue", Font.ITALIC, 20));
        //c.anchor = GridBagConstraints.NORTH;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 4;
        c.gridx = 0;
        c.gridy = 1;
        top = -80;
        left = 20;
        bottom = 0;
        right = 0;
        c.insets = new Insets(top, left, bottom, right);
        headerPanel.add(header2, c);

        wahl = new JLabel("Bitte wählen Sie Ihr gewünschtes Programm aus:");
        wahl.setFont(new Font("Serif", Font.PLAIN, 15));
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 4;
        c.fill = GridBagConstraints.HORIZONTAL;
        top = 30;
        left = -215;
        bottom = 0;
        right = 5;
        c.insets = new Insets(top, left, bottom, right);
        add(wahl, c);
    }

    private void setupPiPanel(GridBagConstraints c) {
        int left;
        int right;
        int bottom;
        int top;
        piPanel = new JPanel();
        piPanel.setLayout(new GridBagLayout());
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.LAST_LINE_END;
        c.gridx = 1;
        c.gridy = 3;
        top = -30;
        left = 5;
        bottom = 60;
        right = 200;
        c.insets = new Insets(top, left, bottom, right);
        add(piPanel, c);
    }

    private void settupMitternachtsPanel(GridBagConstraints c) {
        int left;
        int right;
        int bottom;
        int top;
        mitternachtPanel = new JPanel();
        mitternachtPanel.setLayout(new GridBagLayout());
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.LINE_END;
        c.gridx = 1;
        c.gridy = 2;
        top = -30;
        left = 5;
        bottom = 5;
        right = 200;
        c.insets = new Insets(top, left, bottom, right);
        add(mitternachtPanel, c);
    }

    private void setpPQPanel(GridBagConstraints c) {
        int left;
        int right;
        int bottom;
        int top;
        pqPanel = new JPanel();
        pqPanel.setLayout(new GridBagLayout());
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.LINE_START;
        c.weighty = 1.0;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        top = -30;
        left = 200;
        bottom = 5;
        right = 5;
        c.insets = new Insets(top, left, bottom, right);
        add(pqPanel, c);

        addPqImage(c);

    }

    private void addPqImage(GridBagConstraints c) {
        int top;
        int left;
        int bottom;
        int right;
        ImageIcon pqImage = new ImageIcon("pqpage/pq-formel0.png");
        JLabel pqImageL = new JLabel(pqImage);
        c.anchor = GridBagConstraints.FIRST_LINE_END;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        top = 20;
        left = 10;
        bottom = 0;
        right = 45;
        c.insets = new Insets(top, left, bottom, right);
        pqPanel.add(pqImageL, c);
    }

    public void setupHeaderPanel(GridBagConstraints c) {
        int left;
        int right;
        int bottom;
        int top;
        headerPanel = new JPanel();
        headerPanel.setLayout(new GridBagLayout());
        headerPanel.setBackground(Color.LIGHT_GRAY);
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 0;
        //Komponente soll 4 horizontale Zellen besetzen
        c.gridwidth = 4;
        c.weighty = 0.05;
        top = 0;
        left = -2;
        bottom = 5;
        right = -2;
        c.insets = new Insets(top, left, bottom, right);
        add(headerPanel, c);
    }

    public void setupnewPanel(GridBagConstraints c) {
       pqPanel = new  JPanel();
       //pqPanel.add(new JLabel("lol"));
       add(pqPanel, c);
    }

    public void addheaderpq(GridBagConstraints c) {
        int top;
        int bottom;
        int right;
        int left;
        pqheader = new JLabel("Numerisch stabile pq-Formel");
        pqheader.setFont(new Font("HelveticaNeue", Font.ITALIC, 42));
        //c.anchor = GridBagConstraints.NORTH;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.PAGE_START;
        c.gridwidth = 4;
        c.gridx = 1;
        c.gridy = 0;
        top = 60;
        left = 20;
        bottom = 5;
        right = 0;
        c.insets = new Insets(top, left, bottom, right);
        pqPanel.add(pqheader, c);
    }

    public void clear(){
        repaint();
        getContentPane().removeAll();
        getContentPane().invalidate();
    }
}