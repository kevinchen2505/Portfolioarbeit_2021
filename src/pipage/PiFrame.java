package pipage;

import java.awt.*;

import static java.lang.Math.PI;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

/**
 * JFrame für Aufgabe 2
 *
 * @author (K. Chen)
 * @version (1.0
 */
public class PiFrame extends JFrame {
    public PiFrame() {
        setup();
        addComponents();
    }
    
    public void setup() {
        setTitle("Annäherung der Kreiszahl π");
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
    private JRadioButton piStabil;
    private JRadioButton piInstabil;
    private JRadioButton konsole;
    private JRadioButton textoutput;
    private JTextField eingabefelda;
    private JTextField eingabefeldb;
    private JTextField eingabefeldc;
    private JLabel bemerkungenLabel;
    private JTextArea bemerkungenfeld;
    private JButton rechnen;

    private void addComponents() {
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        add(panel);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        setupJLabels(c);
        setupJTextFields(c);
        setupJRadioButtons(c);
        setupRechenbutton(c);
    }

    private void setupJLabels(GridBagConstraints c) {
        int top = 5;
        int left = 70;
        int bottom = 20;
        int right = 5;

        eingabelabela = new JLabel("1. Wählen Sie Ihre Annäherungsmethode aus:");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(top, left, bottom, right);
        panel.add(eingabelabela, c);

        ImageIcon piInstabilImage = new ImageIcon("pipage/Pi_instabil.png");
        JLabel piInstabilL = new JLabel(piInstabilImage);
        c.gridwidth = 1;
        left = 0;
        bottom = 0;
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(top, left, bottom, right);
        panel.add(piInstabilL, c);

        ImageIcon pistabilImage = new ImageIcon("pipage/Pi_stabil.png");
        JLabel pistabilL = new JLabel(pistabilImage);
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(top, left, bottom, right);
        panel.add(pistabilL, c);

        eingabelabela = new JLabel("2. Bitte geben Sie Ihre gewünschte Genauigkeit eps ein:");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        top = 5;
        left = 50;
        bottom = 10;
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(top, left, bottom, right);
        panel.add(eingabelabela, c);

        eingabelabelb = new JLabel("3. Bitte wählen Sie eine Ausgabeform aus:");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        top = 10;
        left = 80;
        bottom = 5;
        c.gridx = 0;
        c.gridy = 5;
        c.insets = new Insets(top, left, bottom, right);
        panel.add(eingabelabelb, c);

    }

    private void setupJRadioButtons(GridBagConstraints c) {
        int top = 5;
        int left = 5;
        int bottom = 5;
        int right = 5;
        c.gridwidth = 1;

        piInstabil = new JRadioButton("Instabile π-Annäherung", false);
        c.insets = new Insets(top, left, bottom, right);
        c.gridx = 0;
        c.gridy = 2;
        panel.add(piInstabil, c);

        piStabil = new JRadioButton("Stabile π-Annäherung", false);
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(top, left, bottom, right);
        panel.add(piStabil, c);

        konsole = new JRadioButton("Konsolenausgabe", false);
        c.insets = new Insets(top, left, bottom, right);
        c.gridx = 0;
        c.gridy = 6;
        panel.add(konsole, c);

        textoutput = new JRadioButton("Ausgabe als .txt-Datei", false);
        c.gridx = 1;
        c.gridy = 6;
        c.insets = new Insets(top, left, bottom, right);
        panel.add(textoutput, c);
    }

    private void setupJTextFields(GridBagConstraints c) {
        int top = 5;
        int left = 5;
        int bottom = 5;
        int right = 5;

        eingabefelda = new JTextField(10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        c.insets = new Insets(top, left, bottom, right);
        panel.add(eingabefelda, c);
    }

    private void setupRechenbutton(GridBagConstraints c) {
        int top = 5;
        int left = 5;
        int bottom = 5;
        int right = 5;
        rechnen = new JButton("Execute");
        c.gridx = 0;
        c.gridy = 7;
        c.gridwidth = 2;
        c.insets = new Insets(top, left, bottom, right);
        rechnen.addActionListener(new RechenListener(this));
        panel.add(rechnen, c);
    }

    private class RechenListener implements ActionListener {
        private PiFrame piFrame;

        public RechenListener(PiFrame piFrame) {
            this.piFrame = piFrame;
        }

        public void actionPerformed(ActionEvent e) {
            try {
                if (checkSelectionRadioButton() == 1) {
                    piFrame.a_nStable();           
                }
                if (checkSelectionRadioButton() == 0){
                    piFrame.a_nUnstable();  
                }
            } catch (Exception ex) {
                System.out.println("Bitte prüfen Sie Ihre Angaben!");
            }
        }
    }
    public static final double radius = 1;

    private int getGenauigkeit() {
        int a = Integer.parseInt(eingabefelda.getText());
        return a;
    }

    private int checkSelectionRadioButton() {
        if (piInstabil.isSelected()) {
            return 0;
        }
        return 1;
    }

    private int checkSelectionOutput() {
        if (konsole.isSelected()) {
            return 0;
        }
        return 1;
    }

    public  void a_nUnstable() {
        StringBuilder output = new StringBuilder();

        double sinAlpha = Math.sin(Math.PI * 2 / 6f); //startet mit 6 Ecken
        drawCircle();

        for (int n = 12; n <= 196608; n *= 2) {
            //alpha wird halbiert, formel: sin(α/2) = sqrt((1-sqrt(1-sin^2(α))/2)
            sinAlpha = Math.sqrt((1 - Math.sqrt(1 - Math.pow(sinAlpha, 2))) / 2); // instabile rekursive formel
            double a_n = n / 2f * sinAlpha;
            output.append("\nn = ").append(n)
            .append("\t\tPI ≈ a_n = ")
            .append(a_n)
            .append("\t\t sin(α) = ").append(sinAlpha);            Grafik.drawPolygon2n(0, 0, radius, n);
        }
        handleOutput(output.toString());
    }

    public  void a_nStable() {
        StringBuilder output = new StringBuilder();
        double sinAlpha = Math.sin(Math.PI * 2 / 6f); //startet mit 6 Ecken
        drawCircle();

        for (int n = 12; n <= 196608; n *= 2) {
            // stabile rekursive formel
            sinAlpha = sinAlpha / Math.sqrt(1 + Math.sqrt(1 - Math.pow(1 - sinAlpha, 2)));
            double a_n = n / 2f * sinAlpha;
            output.append("\nn = ").append(n)
            .append("\t\tPI ≈ a_n = ")
            .append(a_n)
            .append("\t\t sin(α) = ").append(sinAlpha);
            Grafik.drawPolygon2n(0, 0, radius, n);
        }
        handleOutput(output.toString());
    }

    private void handleOutput(String output) {
        if(konsole.isSelected()) System.out.println(output);
        else TextFileHandler.writeToTextFile("Pi_output", output);
    }

    private static void drawCircle() {
        StdDraw.setScale(-1.2, 1.2);
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(Color.RED);
        StdDraw.text(0.8, 0.8, "Perfect circle", -45);
        StdDraw.circle(0, 0, radius);
        StdDraw.setPenColor(Color.GRAY);
        StdDraw.setPenRadius(0.002);
        StdDraw.text(0.55, 0.55, "Approximations (polygons)", -45);
    }

    private static class TextFileHandler {
        public static void writeToTextFile(String filename, String text) {
            try {
                FileWriter myWriter = new FileWriter(filename + ".txt");
                myWriter.write(text);
                myWriter.close();
                System.out.println("Die Datei wurde geschrieben. Sie können die .txt Dateit im Projektordner finden.");
            } catch (IOException e) {
                System.out.println("An error occurred when writing to file");
                e.printStackTrace();
            }
        }
    }

    private static class Grafik {
        public static void main(String[] args) {
            StdDraw.setScale(-1.2, 1.2);
            drawPolygon2n(0, 0, 1, 100);
            //drawPolygon2n(0.5, 0.5, 0.2, 6);
        }

        public static void drawPolygon2n(double xCenter, double yCenter, double radiusLong, int numCorners) {
            //if (numCorners % 2 != 0) return;
            double alpha = 2 * PI / numCorners;

            double[] xValues = new double[numCorners];
            double[] yValues = new double[numCorners];

            for (int i = 0; i < numCorners; i++) {
                double angle = alpha * (i + 0.5);
                xValues[i] = xCenter + Math.sin(angle) * radiusLong;
                yValues[i] = yCenter + Math.cos(angle) * radiusLong;
            }
            StdDraw.polygon(xValues, yValues);
        }
    }
}