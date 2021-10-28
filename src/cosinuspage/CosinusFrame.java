package cosinuspage;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.math.*;
import java.math.RoundingMode;
import java.lang.Math;
/**
 * JFrame für Aufgabe 2
 *
 * @author (K. Chen)
 * @version (1.0
 */
public class CosinusFrame extends JFrame
{  
    public CosinusFrame() {
        setup();
        addComponents();
    }

    public void setup() {
        setTitle("Stabilisierung des Cosinussatzes");
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
    private JLabel eingabelabelc;
    private JLabel ausgabelabel;
    private JTextField eingabefelda;
    private JTextField eingabefeldb;
    private JTextField eingabefeldc;
    private JLabel x1Num;
    private JLabel x2Num;
    private JLabel x1Exakt;
    private JLabel x2Exakt;
    private JLabel bemerkungenLabel;
    private JTextArea bemerkungenfeld;
    private JTextField x1loesNum;
    private JTextField x2loesNum;
    private JTextField x1loesExakt;
    private JTextField x2loesExakt;
    private ImageIcon headerImage;
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

        ImageIcon cosinusImage = new ImageIcon("cosinuspage/Cosinussatz_stabil.png");
        JLabel cosinusImageL = new JLabel(cosinusImage);
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(top, left, bottom, right);
        panel.add(cosinusImageL, c);

        eingabelabel = new JLabel("Bitte geben Sie hier die Koeffizienten a, b, c ein:");
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(top, left, bottom, right);
        panel.add(eingabelabel, c);

        eingabelabela = new JLabel("a =");
        c.fill = GridBagConstraints.NONE;
        top = 5;
        left = -325;
        bottom = 5;
        right = 5;
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(top, left, bottom, right);
        panel.add(eingabelabela, c);

        eingabelabelb = new JLabel("b =");
        c.gridx = 0;
        top = 5;
        left = 5;
        bottom = 5;
        right = 5;
        c.gridy = 4;
        panel.add(eingabelabelb, c);

        eingabelabelc = new JLabel("γ =");
        c.gridx = 0;
        c.gridy = 5;
        panel.add(eingabelabelc, c);

        x1Num = new JLabel("numerisches c =");
        c.fill = GridBagConstraints.HORIZONTAL;
        top = 5;
        left = -350;
        bottom = 5;
        right = 5;
        c.gridx = 0;
        c.gridy = 7;
        c.gridwidth = 2;
        c.insets = new Insets(top, left, bottom, right);
        c.gridwidth = 1;
        panel.add(x1Num, c);

        x2Num = new JLabel("instabiles c =");
        c.gridx = 0;
        c.gridy = 8;
        panel.add(x2Num, c);

        bemerkungenLabel = new JLabel("Bemerkungen:");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 11;
        panel.add(bemerkungenLabel, c);
    }

    private void setupJTextFields(GridBagConstraints c){
        eingabefelda = new JTextField(8);
        c.fill = GridBagConstraints.HORIZONTAL;
        int top = 5;
        int left = -320;
        int bottom = 5;
        int right = 5;
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 2;
        c.insets = new Insets(top, left, bottom, right);
        panel.add(eingabefelda, c);

        eingabefeldb = new JTextField(10);
        c.gridx = 1;
        c.gridy = 4;
        panel.add(eingabefeldb, c);

        eingabefeldc = new JTextField(10);
        c.gridx = 1;
        c.gridy = 5;
        panel.add(eingabefeldc, c);

        x1loesNum = new JTextField(10);
        c.fill = GridBagConstraints.HORIZONTAL;
        x1loesNum.setEditable(false);
        top = 5;
        left = -230;
        bottom = 5;
        right = 5;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 7;
        c.insets = new Insets(top, left, bottom, right);
        panel.add(x1loesNum, c);

        x2loesNum = new JTextField(10);
        x2loesNum.setEditable(false);
        c.gridx = 1;
        left = -240;
        c.gridy = 8;
        panel.add(x2loesNum, c);
    }

    private void setupRechenbutton(GridBagConstraints c) {
        rechnen = new JButton("Lösungen berechnen");
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 2;
        rechnen.addActionListener(new RechenListener());
        panel.add(rechnen, c);
    }

    private void setupBemerkungenfeld(GridBagConstraints c){
        bemerkungenfeld = new JTextArea(5, 10);
        c.gridwidth = 2;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 12;
        bemerkungenfeld.setLineWrap(true);
        bemerkungenfeld.setWrapStyleWord(true);
        bemerkungenfeld.setEditable(false);
        panel.add(bemerkungenfeld, c);
    }

    private class RechenListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                BigDecimal a = new BigDecimal(eingabefelda.getText());
                BigDecimal b = new BigDecimal(eingabefeldb.getText());
                BigDecimal gamma = new BigDecimal(eingabefeldc.getText());

                if(gamma.compareTo(zero) == -1 || gamma.compareTo(BigDecimal.valueOf(180)) == 1 ) {
                    printBemerkungen("Bitte geben Sie einen gültigen Wert für gamma ein!");
                    return;
                }

                printSolutions(getStablec(a, b, gamma), getUnstablec(a, b, gamma));

            } 
            catch (Exception ex) {
                printnoSolutions();
                printBemerkungen("Bitte geben Sie gültige Parameter ein!");
            }
        }
    }
    private static final MathContext mc = new MathContext(100, RoundingMode.HALF_UP);
    private static final BigDecimal zero = BigDecimal.ZERO;
    private static final BigDecimal one = BigDecimal.ONE;
    private static final BigDecimal two = BigDecimal.valueOf(2);

    private BigDecimal getBinome2(BigDecimal a, BigDecimal b) {
        // (a-b)²
        BigDecimal binome = a.subtract(b).pow(2);
        return binome;
    }

    private BigDecimal getStablec(BigDecimal a, BigDecimal b, BigDecimal gamma) {       
        BigDecimal cStable = getBinome2(a, b).add((BigDecimal.valueOf(4).multiply(a).multiply(b).multiply(getSinusterm(gamma.divide(two)).pow(2))));
        cStable = cStable.sqrt(mc);
        return cStable;
    }

    private BigDecimal getUnstablec(BigDecimal a, BigDecimal b, BigDecimal gamma) {
        BigDecimal cUnstable = a.pow(2).add((b).pow(2)).subtract(two.multiply(a).multiply(b).multiply(getCosinusterm(gamma)));
        cUnstable = cUnstable.sqrt(mc);
        return cUnstable;
    }

    private BigDecimal getCosinusterm(BigDecimal gamma) {
        double radians = Math.toRadians(gamma.doubleValue());
        double cosinustermdouble = Math.cos(radians);
        BigDecimal cosinusterm = new BigDecimal(cosinustermdouble);
        return cosinusterm;
    }

    private BigDecimal getSinusterm(BigDecimal gamma) {
        double radians = Math.toRadians(gamma.doubleValue());
        double sinustermdouble = Math.sin(radians);
        BigDecimal sinustermUnstable = new BigDecimal(sinustermdouble);
        return sinustermUnstable;
    }

    private void printSolutions(BigDecimal x1Exact, BigDecimal x2Exact) {
        x1loesNum.setText((x1Exact.setScale(5, RoundingMode.HALF_UP)).toString());
        x2loesNum.setText((x2Exact.setScale(5, RoundingMode.HALF_UP)).toString());
    }

    private void printnoSolutions() {
        x1loesNum.setText("-");
        x2loesNum.setText("-");
    }

    private void printBemerkungen(String ausgabe) {
        bemerkungenfeld.setText(ausgabe);   
    }
}
