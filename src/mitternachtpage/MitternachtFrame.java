package mitternachtpage;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.math.*;
import java.math.RoundingMode;

/**
 * JFrame für Aufgabe 2
 *
 * @author (K. Chen)
 * @version (1.0
 */
public class MitternachtFrame extends JFrame
{  
    public MitternachtFrame() {
        setup();
        addComponents();
    }

    public void setup() {
        setTitle("Numerisch stabile Mitternachtsformel");
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
        setUpRechenListener();
    }

    private void setupJLabels(GridBagConstraints c){
        int top = 5;
        int left = 5;
        int bottom = 5;
        int right = 5;

        ImageIcon mitternachtImage2 = new ImageIcon("mitternachtpage/Mitternacht_stabil.png");
        JLabel mitternachtImageL2 = new JLabel(mitternachtImage2);
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(top, left, bottom, right);
        panel.add(mitternachtImageL2, c);

        eingabelabel = new JLabel("Bitte geben Sie hier die Koeffizienten a, b, c ein:");
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(top, left, bottom, right);
        panel.add(eingabelabel, c);

        eingabelabel = new JLabel("Bitte geben Sie hier die Koeffizienten a, b, c ein:");
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(top, left, bottom, right);
        panel.add(eingabelabel, c);

        eingabelabela = new JLabel("a =");
        c.fill = GridBagConstraints.NONE;
        top = 5;
        left = -315;
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

        eingabelabelc = new JLabel("c =");
        c.gridx = 0;
        c.gridy = 5;
        panel.add(eingabelabelc, c);

        x1Num = new JLabel("numerisches x1 =");
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

        x2Num = new JLabel("numerisches x2 =");
        c.gridx = 0;
        c.gridy = 8;
        panel.add(x2Num, c);

        x1Exakt = new JLabel("exaktes x1 =");
        c.anchor = GridBagConstraints.PAGE_START;
        c.gridx = 0;
        c.gridy = 9;
        panel.add(x1Exakt, c);

        x2Exakt = new JLabel("exaktes x2 =");
        c.gridx = 0;
        c.gridy = 10;
        panel.add(x2Exakt, c);

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
        left = -225;
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
        c.gridy = 8;
        panel.add(x2loesNum, c);
        x1loesExakt = new JTextField(10);
        x1loesExakt.setEditable(false);

        top = 5;
        left = -255;
        bottom = 5;
        right = 5;
        c.gridx = 1;
        c.gridy = 9;
        c.insets = new Insets(top, left, bottom, right);
        panel.add(x1loesExakt, c);

        x2loesExakt = new JTextField(10);
        x2loesExakt.setEditable(false);
        c.gridx = 1;
        c.gridy = 10;
        c.insets = new Insets(top, left, bottom, right);
        panel.add(x2loesExakt, c);
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
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 12;
        bemerkungenfeld.setLineWrap(true);
        bemerkungenfeld.setWrapStyleWord(true);
        bemerkungenfeld.setEditable(false);
        panel.add(bemerkungenfeld, c);
    }

    private ActionListener setUpRechenListener() {
        RechenListener c1 = new RechenListener();
        return c1;
    }

    private class RechenListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                BigDecimal a = new BigDecimal(eingabefelda.getText());
                BigDecimal b = new BigDecimal(eingabefeldb.getText());
                BigDecimal c = new BigDecimal(eingabefeldc.getText());
                checkDiskriminante(getDiskriminante(a, b, c)); 
                printParameters(a, b, c);
                if(getDiskriminante(a,b,c).compareTo(zero) == -1){
                    printnoSolutions();
                    return;
                }
                printSolutions(getx1Exact(a, b, c), 
                    getx2Exact(a, b, c),
                    getx1Num(a, b, c),  
                    getx2Num(a, b, c));
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
    private String checkDiskriminante(BigDecimal diskriminante) {
        int check = diskriminante.compareTo(zero);
        if(check == -1) {  
            return "Die Diskriminante ist negativ D: " + diskriminante + "\n" +
            "Es existiert keine Lösung im reelen Zahlenbereich";
        }
        if(check == 0) {
            return "Die Diskriminante beträgt 0: " + "\n" +
            "Es existiert eine Lösung im reelen Zahlenbereich";
        }
        return "Die Diskriminante beträgt: " + diskriminante + "\n" +
        "Es existieren zwei Lösungen im reelen Zahlenbereich";        
    }

    private void printParameters(BigDecimal a, BigDecimal b, BigDecimal c) {
        printBemerkungen("Ihre quadratische Gleichung lautet: " + "\n" +
            a + "x^2 " + getVorzeichenB(b) + b + "x " + getVorzeichenC(c) + c + "  = 0" + "\n" +
            checkDiskriminante(getDiskriminante(a,b,c)));
    }

    private BigDecimal getDiskriminante(BigDecimal a, BigDecimal b, BigDecimal c) {
        BigDecimal diskriminante = b.pow(2).subtract((BigDecimal.valueOf(4).multiply(a).multiply(c)));
        return diskriminante;
    }

    private BigDecimal getExactroot(BigDecimal a, BigDecimal b, BigDecimal c) {
        BigDecimal wurzel = BigDecimal.ZERO;
        wurzel = getDiskriminante(a, b, c).sqrt(mc);
        return wurzel;
    }

    private BigDecimal getNumroot(BigDecimal a, BigDecimal b, BigDecimal c) {
        BigDecimal wurzelNum = ((one.subtract((BigDecimal.valueOf(4).multiply(a).multiply(c).divide(b, mc))
                        .divide(b, mc))).divide(two, mc)).sqrt(mc);
        return wurzelNum;
    }

    private BigDecimal getbsub(BigDecimal b){
        BigDecimal bsub = b.negate();  
        return bsub;
    }

    private BigDecimal getx1Exact(BigDecimal a, BigDecimal b, BigDecimal c) {
        BigDecimal x1 = BigDecimal.ZERO;
        BigDecimal wurzel = getExactroot(a, b, c);
        x1 = (getbsub(b).add(wurzel)).divide(getDenominator(a), mc);
        return x1;     
    }

    private BigDecimal getx2Exact(BigDecimal a, BigDecimal b, BigDecimal c) {
        BigDecimal x2 = BigDecimal.ZERO;
        BigDecimal wurzel = getExactroot(a, b, c);
        x2 = (getbsub(b).subtract(wurzel)).divide(getDenominator(a), mc);
        return x2;
    }

    private BigDecimal getx1Num(BigDecimal a, BigDecimal b, BigDecimal c) {
        BigDecimal x1 = BigDecimal.ZERO;
        x1 = (getbsub(b).add(b.abs()).multiply(getNumroot(a, b, c))).divide(getDenominator(a), mc);
        return x1;     
    }

    private BigDecimal getx2Num(BigDecimal a, BigDecimal b, BigDecimal c) {
        BigDecimal x2 = BigDecimal.ZERO;
        x2 = (getbsub(b).subtract(b.abs()).multiply(getNumroot(a, b, c))).divide(getDenominator(a), mc);
        return x2;
    }

    private BigDecimal getDenominator(BigDecimal a) {
        BigDecimal denominator = two.multiply(a);
        return denominator;
    }

    private String getVorzeichenB(BigDecimal b) {
        if(b.compareTo(zero) == -1) {
            return "";
        }
        return "+";
    }

    private String getVorzeichenC(BigDecimal c) {
        if(c.compareTo(zero) == -1) {
            return "";
        }
        return "+";
    }

    private void printSolutions(BigDecimal x1Exact, BigDecimal x2Exact, BigDecimal x1Num, BigDecimal x2Num) {
        x1loesNum.setText((x1Num.setScale(5, RoundingMode.HALF_UP)).toString());
        x2loesNum.setText((x2Num.setScale(5, RoundingMode.HALF_UP)).toString());
        x1loesExakt.setText((x1Exact.setScale(5, RoundingMode.HALF_UP)).toString());
        x2loesExakt.setText((x2Exact.setScale(5, RoundingMode.HALF_UP)).toString());
    }

    private void printnoSolutions() {
        x1loesNum.setText("-");
        x2loesNum.setText("-");
        x1loesExakt.setText("-");
        x2loesExakt.setText("-");
    }

    private void printBemerkungen(String ausgabe) {
        bemerkungenfeld.setText(ausgabe);   
    }

}

