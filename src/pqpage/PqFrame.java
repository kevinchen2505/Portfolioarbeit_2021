package pqpage;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.math.*;
import java.math.RoundingMode;

/**
 * JFrame für Aufgabe 1
 *
 * @author (K. Chen)
 * @version (1.0)
 */
public class PqFrame extends JFrame {
    public PqFrame() {
        setup();
        addComponents();
    }

    public void setup() {
        setTitle("Numerisch stabile pq-Formel");
        setLayout(new GridBagLayout());
        setSize(600, 600);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
    }

    private JPanel panel;
    private JLabel header;
    private JLabel eingabelabel;
    private JLabel eingabelabela;
    private JLabel eingabelabelb;
    private JLabel ausgabelabel;
    private JTextField eingabefeldp;
    private JTextField eingabefeldq;
    private JLabel x1loeslabel;
    private JLabel x2loeslabel;
    private JLabel bemerkungenLabel;
    private JTextArea bemerkungenfeld;
    private JTextField x1loesfeld;
    private JTextField x2loesfeld;
    private JButton rechnen;

    private void addComponents() {
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        add(panel);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        setupJLabels(c);
        setupJTextFields(c);
        setupRechenbutton(c);
        setupBemerkungenfeld(c);
    }

    private void setupJLabels(GridBagConstraints c){
        int top = 5;
        int left = 5;
        int bottom = 5;
        int right = 5;

         ImageIcon pqImage = new ImageIcon("pqpage/pq_stabil.png");
        JLabel pqImageL = new JLabel(pqImage);
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(top, left, bottom, right);
        panel.add(pqImageL, c);

        eingabelabel = new JLabel("Bitte geben Sie hier die Koeffizienten p, q ein:");
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(top, left, bottom, right);
        panel.add(eingabelabel, c);

        eingabelabela = new JLabel("p =");
        c.fill = GridBagConstraints.NONE;
        top = 5;
        left = -380;
        bottom = 5;
        right = 5;
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(top, left, bottom, right);
        panel.add(eingabelabela, c);

        eingabelabelb = new JLabel("q =");
        c.gridx = 0;
        top = 5;
        left = -300;
        bottom = 5;
        right = 5;
        c.gridy = 4;
        panel.add(eingabelabelb, c);

        x1loeslabel = new JLabel("x1 =");
        c.fill = GridBagConstraints.HORIZONTAL;
        top = 5;
        left = 5;
        bottom = 5;
        right = 5;
        c.gridx = 0;
        c.gridy = 7;
        c.gridwidth = 2;
        c.insets = new Insets(top, left, bottom, right);
        c.gridwidth = 1;
        panel.add(x1loeslabel, c);

        x2loeslabel = new JLabel("x2 =");
        c.gridx = 0;
        c.gridy = 8;
        panel.add(x2loeslabel, c);

        bemerkungenLabel = new JLabel("Bemerkungen:");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 11;
        panel.add(bemerkungenLabel, c);
    }

    private void setupJTextFields(GridBagConstraints c){
        eingabefeldp = new JTextField(8);
        c.fill = GridBagConstraints.HORIZONTAL;
        int top = 5;
        int left = -370;
        int bottom = 5;
        int right = 5;
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 2;
        c.insets = new Insets(top, left, bottom, right);
        panel.add(eingabefeldp, c);

        eingabefeldq = new JTextField(10);
        c.gridx = 1;
        c.gridy = 4;
        panel.add(eingabefeldq, c);

        x1loesfeld = new JTextField(10);
        c.fill = GridBagConstraints.HORIZONTAL;
        x1loesfeld.setEditable(false);
        top = 5;
        left = -370;
        bottom = 5;
        right = 5;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 7;
        c.insets = new Insets(top, left, bottom, right);
        panel.add(x1loesfeld, c);

        x2loesfeld = new JTextField(10);
        x2loesfeld.setEditable(false);
        c.gridx = 1;
        c.gridy = 8;
        panel.add(x2loesfeld, c);
    }

    private void setupRechenbutton(GridBagConstraints c) {
        rechnen = new JButton("Lösungen berechnen");
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 2;
        rechnen.addActionListener(setUpRechenListener());
        panel.add(rechnen, c);
    }

    private void setupBemerkungenfeld(GridBagConstraints c){
        bemerkungenfeld = new JTextArea(5, 10);
        c.gridwidth = 2;
        c.gridheight = 2;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 12;
        bemerkungenfeld.setLineWrap(true);
        bemerkungenfeld.setWrapStyleWord(true);
        bemerkungenfeld.setEditable(false);
        panel.add(bemerkungenfeld, c);
    }

    private RechenListener setUpRechenListener() {
        RechenListener c1 = new RechenListener();
        return c1;
    }

    private class RechenListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                PqResult result = calculate(new BigDecimal(eingabefeldp.getText()),
                        new BigDecimal(eingabefeldq.getText()));
                x1loesfeld.setText(result.getX1() == null ? "" : result.getX1().toString());
                x2loesfeld.setText(result.getX2() == null ? "" : result.getX2().toString());
                bemerkungenfeld.setText(result.getBemerkung());
            } catch (Exception ex) {
                x1loesfeld.setText("");
                x2loesfeld.setText("");
                bemerkungenfeld.setText("Bitte geben Sie gültige Parameter ein!");
            }
        }
    }

    private static final BigDecimal TWO = new BigDecimal(2);
    private static final MathContext MC = new MathContext(100, RoundingMode.HALF_UP);

    private PqResult calculate(BigDecimal p, BigDecimal q) {
        PqResult result = new PqResult();

        BigDecimal x1;
        BigDecimal x2;

        BigDecimal psub = p.negate();

        BigDecimal p_div_2 = p.divide(TWO, MC);
        BigDecimal p_div_2_squared = p_div_2.pow(2);
        BigDecimal diskriminante = p_div_2_squared.subtract(q);

        // Diskriminante < 0
        if (diskriminante.compareTo(BigDecimal.valueOf(0)) == -1) {
            result.setBemerkung("Die Diskriminante der pq-Fomel ist kleiner 0. Es existiert keine Lösung");
            return result;
        }

        BigDecimal wurzel = diskriminante.sqrt(MC);
        BigDecimal psub_div_2 = psub.divide(TWO, MC);

        // Instanzen von numerischer Instabilität
        // case: numerische Auslöschung
        // p ist 1,000,000x grösser als q
        BigDecimal qabs = q.abs();
        BigDecimal MILLION = BigDecimal.TEN.pow(6);
        if (qabs.multiply(MILLION).compareTo(p_div_2_squared) == -1) {
            // betragsmässig grössere Lösung ist eine Addition, denn p ist grösser, gleich 0
            if(p.compareTo(BigDecimal.ZERO) >= 0) {
                return calculateResultIf_p_div_2_squared_much_bigger_than_qabs(result, p, q, psub, wurzel);
            }
            // betragsmässig grössere Lösung ist eine Subtraktion, denn p ist kleiner, gleich 0
            if(p.compareTo(BigDecimal.ZERO) < 0) {
                return calculateResultIf_p_div_2_squared_much_bigger_than_qabs(result, p, q, psub, wurzel);
            }
        }
        // (p/2)^2 liegt ausserhalb des Rechenbereichs [(p/2)^2 < 10^-37 (Unterlauf) || (p/2)^2 > 10^37 (Überlauf)]
        else if (p_div_2_squared.compareTo(BigDecimal.valueOf(Math.pow(10, -37))) == -1 || p_div_2_squared.compareTo(BigDecimal.valueOf(Math.pow(10, 37))) == 1) {
            if ( p_div_2_squared.compareTo(BigDecimal.valueOf(Math.pow(10, 37))) == 1) {
                return calculateResultIf_Überlauf(p, q, p_div_2, psub_div_2);
            }
            //p < 0
            if(p_div_2_squared.compareTo(BigDecimal.valueOf(Math.pow(10, -37))) == -1) {
                return calculateResultIf_Unterlauf(p, q, p_div_2, psub_div_2);
            }
        }
        //case weder numerische Auslöschung, not Über-oder Unterlauf
        diskriminante = p_div_2_squared.subtract(q);
        BigDecimal sqrtDiskr = diskriminante.sqrt(MC);
        x1 = ((psub_div_2).add(sqrtDiskr));
        x2 = ((psub_div_2).subtract(sqrtDiskr));
        String bemerkung = "Es kommt weder zu einer numerischen Auslöschung noch zu Unter-oder Überlauf." + "\n" +
            "Zur Berechnung der Lösungen wird die unmodifizierte pq-Formel benutzt.";
        return new PqResult(diskriminante, x1.setScale(5, RoundingMode.HALF_UP), x2.setScale(5, RoundingMode.HALF_UP), bemerkung);
    }

    private PqResult calculateResultForNegative_p(BigDecimal p, BigDecimal q, BigDecimal p_div_2, BigDecimal psub_div_2) {
        BigDecimal x1;
        BigDecimal x2;
        BigDecimal diskriminante;
        diskriminante = (BigDecimal.valueOf(1).subtract((q.multiply(BigDecimal.valueOf(4))
                    .divide(q.pow(2), MC)))).setScale(5, RoundingMode.HALF_UP);
        x1 = (psub_div_2.add(p_div_2.multiply(diskriminante.sqrt(MC))));
        x2 = (psub_div_2.subtract(p_div_2).multiply(diskriminante.sqrt(MC)));

        String bemerkung = "Es kommt durch den kleinen p-Wert zu einem Unterlauf: " + p + " < 10^-39" + "\n" +
            "Zur Berechnung wird das (p/2)^ aus der Wurzel ausgeklammert. Dabei ist p negativ.";
        return new PqResult(diskriminante, x1.setScale(5, RoundingMode.HALF_UP), x2.setScale(5, RoundingMode.HALF_UP), bemerkung);
    }

    private PqResult calculateResultIf_Überlauf(BigDecimal p, BigDecimal q, BigDecimal p_div_2, BigDecimal psub_div_2) {
        BigDecimal p_div_2_squared = p_div_2.pow(2);

        BigDecimal diskriminante = BigDecimal.ONE.subtract((q.multiply(BigDecimal.valueOf(4))
                    .divide((q.divide(p, MC)).divide(p, MC))));

        BigDecimal sqrt_diskriminante = diskriminante.sqrt(MC);
        BigDecimal x1 = ((psub_div_2).add((p_div_2).multiply(sqrt_diskriminante)));
        BigDecimal x2 = (psub_div_2.subtract((p_div_2).multiply(sqrt_diskriminante)));

        String bemerkung = "Es kommt durch den grossen p-Wert zu einem Überlauf: " + p_div_2_squared + " > 10^39" + "\n" +
            "Zur Berechnung wird das (p/2)^ aus der Wurzel ausgeklammert.";
        return new PqResult(diskriminante, x1.setScale(5, RoundingMode.HALF_UP), x2.setScale(5, RoundingMode.HALF_UP), bemerkung);
    }

    private PqResult calculateResultIf_Unterlauf(BigDecimal p, BigDecimal q, BigDecimal p_div_2, BigDecimal psub_div_2) {
        BigDecimal diskriminante = BigDecimal.ONE.subtract((q.multiply(BigDecimal.valueOf(4))
                    .divide((q.divide(p, MC)).divide(p, MC))));

        BigDecimal p_div_2_squared = p_div_2.pow(2);

        // Bei Unterlauf wird q = 0 -> Wurzel wird zu 1
        BigDecimal sqrt_diskriminante = BigDecimal.ONE;
        BigDecimal x1 = ((psub_div_2).add((p_div_2).multiply(sqrt_diskriminante)));
        BigDecimal x2 = (psub_div_2.subtract((p_div_2).multiply(sqrt_diskriminante)));

        String bemerkung = "Es kommt durch den kleinen p-Wert zu einem Unterlauf: " + p_div_2_squared + " < 10^-39" + "\n" +
            "Zur Berechnung wird das (p/2)^ aus der Wurzel ausgeklammert.";
        return new PqResult(diskriminante, x1.setScale(5, RoundingMode.HALF_UP), x2.setScale(5, RoundingMode.HALF_UP), bemerkung);
    }

    private PqResult calculateResultIf_p_div_2_squared_much_bigger_than_qabs(PqResult result, BigDecimal p, BigDecimal q, BigDecimal psub, BigDecimal wurzel) {
        BigDecimal x1;
        BigDecimal x2;
        // case: Betragsmässig grössere Lösung wird mit pq-Formel ausgerechnet
        // wenn p > 0 ist die betragsmässig grössere Lösung eine Addierung
        if (p.compareTo(BigDecimal.ZERO) >= 1) {
            x1 = ((psub.divide(TWO, MC)).add(wurzel));

            // x2 durch Vieta
            x2 = (q.divide(x1, MC));

            result.setX1(x1.setScale(5, RoundingMode.HALF_UP));
            result.setX2(x2.setScale(5, RoundingMode.HALF_UP));
            result.setBemerkung("Es kommt zu einer numerischen Auslöschung auf, denn: " + "\n" +
                "(" + p + "/2)^2  >> |" + q + "|" + "\n" +
                "Dabei ist die betragsmässig grössere Lösung eine Addition in der pq-Formel." + "\n" +
                "Die Lösung x2 wird zur Korrektur durch den Satz von Vita berechnet: x2 = q/x1");
            return result;
        }
        // wenn p < 0 ist die betragsmässig grössere Lösung eine Subtraktion
        if (p.compareTo(BigDecimal.valueOf(0)) == -1) {
            x1 = psub.divide(TWO, MC).subtract(wurzel);//.setScale(5, RoundingMode.HALF_UP);

            // x2 durch Vieta
            x2 = (q.divide(x1, MC));

            result.setX1(x1.setScale(5, RoundingMode.HALF_UP));
            result.setX2(x2.setScale(5, RoundingMode.HALF_UP));
            result.setBemerkung("Es tritt Auslöschung auf, denn: " + "(" + p + "/2)^2  >> |" + q + "|" + "\n" +
                "Die Lösung x2 wird zur Korrektur durch den Satz von Vita berechnet: x2 = q/x1");
            return result;
        }
        return null;
    }

    private static class PqResult {
        private BigDecimal diskriminante;
        private BigDecimal x1;
        private BigDecimal x2;
        private String bemerkung;

        public PqResult(BigDecimal discriminante, BigDecimal x1, BigDecimal x2, String bemerkung) {
            this.diskriminante = diskriminante;
            this.x1 = x1;
            this.x2 = x2;
            this.bemerkung = bemerkung;
        }

        public PqResult() {

        }

        public String getBemerkung() {
            return bemerkung;
        }

        public void setBemerkung(String bemerkung) {
            this.bemerkung = bemerkung;
        }

        public BigDecimal getDiscriminante() {
            return diskriminante;
        }

        public void setDiscriminante(BigDecimal discriminante) {
            this.diskriminante = diskriminante;
        }

        public BigDecimal getX1() {
            return x1;
        }

        public void setX1(BigDecimal x1) {
            this.x1 = x1;
        }

        public BigDecimal getX2() {
            return x2;
        }

        public void setX2(BigDecimal x2) {
            this.x2 = x2;
        }
    }
}