package elektro.rechen;


import javax.swing.*;
import java.awt.*;

public class Rahmen extends JFrame {

    Rechner rechner = new Rechner();

    public void initGUI() {
        setTitle("Supertolle Elektro-Rechenmaschine");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));
        panel.setVisible(true);

        getContentPane().add(initPlusPanel());
        getContentPane().add(initMinusPanel());

        setVisible(true);
    }

    public JPanel initPlusPanel() {
        // TODO extract panel creation to its own class
        JTextField textFieldPlus1 = new JTextField(8);
        JLabel labelPlus = new JLabel(" + ");
        JTextField textFieldPlus2 = new JTextField(8);
        JButton buttonPlus = new JButton(" = ");
        JLabel labelErgebnis = new JLabel("  ?  ");
        JButton buttonClear = new JButton("x");
        buttonPlus.addActionListener(e -> {
            String summandString1 = textFieldPlus1.getText();
            String summandString2 = textFieldPlus2.getText();
            String ergebnisString = null;
            try {
                int summand1 = Integer.parseInt(summandString1);
                int summand2 = Integer.parseInt(summandString2);
                int ergebnis = rechner.plus(summand1, summand2);
                ergebnisString = String.valueOf(ergebnis);

            } catch(Exception ex) {

            }
            if (ergebnisString != null) {
                labelErgebnis.setText(ergebnisString);
            }
        });
        buttonClear.addActionListener(e -> {
            clearComponents(textFieldPlus1, textFieldPlus2, labelErgebnis);
        });

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBackground(Color.yellow);

        panel.add(textFieldPlus1);
        panel.add(labelPlus);
        panel.add(textFieldPlus2);
        panel.add(buttonPlus);
        panel.add(labelErgebnis);
        panel.add(buttonClear);

        return panel;
    }

    public JPanel initMinusPanel() {
        JTextField textFieldMinus1 = new JTextField(8);
        JLabel labelPlus = new JLabel(" - ");
        JTextField textFieldMinus2 = new JTextField(8);
        JButton buttonMinus = new JButton(" = ");
        JLabel labelErgebnis = new JLabel("  ?  ");
        JButton buttonClear = new JButton("x");

        buttonMinus.addActionListener(e -> {
            String minuendString = textFieldMinus1.getText();
            String subtrahendString = textFieldMinus2.getText();
            String ergebnisString = null;
            try {
                int minuend = Integer.parseInt(minuendString);
                int subtrahend = Integer.parseInt(subtrahendString);
                int ergebnis = rechner.minus(minuend, subtrahend);
                ergebnisString = String.valueOf(ergebnis);

            } catch(Exception ex) {

            }
            if (ergebnisString != null) {
                labelErgebnis.setText(ergebnisString);
            }
        });
        buttonClear.addActionListener(e -> {
            clearComponents(textFieldMinus1, textFieldMinus2, labelErgebnis);
        });

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBackground(Color.red);

        panel.add(textFieldMinus1);
        panel.add(labelPlus);
        panel.add(textFieldMinus2);
        panel.add(buttonMinus);
        panel.add(labelErgebnis);
        panel.add(buttonClear);

        return panel;
    }

    private void clearComponents(JTextField textField1, JTextField textField2, JLabel label) {
        textField1.setText("");
        textField2.setText("");
        label.setText("  ?  ");
    }
}
