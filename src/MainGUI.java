import com.sun.tools.javac.Main;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.*;
import java.util.regex.Pattern;

public class MainGUI extends JFrame {
    private JPanel main;
    private JTextField leftTextField;
    private JTextField rightTextField;
    private JComboBox comboBox1;
    private JButton convertButton;
    private JButton clearButton;
    private JLabel leftUnitField;
    private JLabel rightUnitField;
    private JComboBox floatingSelector;

    private int decimalVal;
    private final String [] leftLabels = {"Fahrenheit (Fº)", "Inch (in)", "Feet (ft)", "Mile (mi)", "Gallon (gal)", "Ounce (oz)", "Pound (lb)", "Hours (hr)", "MPH", "Kelvin (Kº)"};
    private final String [] rightLabels = {"Celsius (Cº)", "Centimeter (cm)", "Meter (m)", "Kilometer (km)", "Liter (L)", "Gram (g)", "Kilogram (kg)", "Seconds (sec)", "KPH", "Celsius (Cº)"};

    public MainGUI (String name) {
        super(name);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(main);

        this.initComboBox();
        this.initTextFields();
        this.initButtons();
        this.initFloatingSelector();

        this.pack();
    }

    private void initFloatingSelector(){
        decimalVal = floatingSelector.getSelectedIndex();

        this.floatingSelector.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                decimalVal = floatingSelector.getSelectedIndex();
            }
        });
    }

    private void initButtons(){
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (leftTextField.getText().equals("") || rightTextField.getText().equals("")){
                    System.out.println("pass!");
                    calculateValue();
                } else {
                    displayMessage("One input field must be empty!");
                }
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leftTextField.setText("");
                rightTextField.setText("");
            }
        });

    }

    private void initTextFields(){
        this.leftTextField.setText("");
        this.rightTextField.setText("");

        this.leftTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateInput();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateInput();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateInput();
            }

            private void validateInput(){
                if(!isValidInput(leftTextField.getText())){
                    convertButton.setEnabled(false);
                } else{
                    convertButton.setEnabled(true);
                }
            }

        });

        this.rightTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateInput();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateInput();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateInput();
            }

            private void validateInput(){
                if(!isValidInput(rightTextField.getText())){
                    convertButton.setEnabled(false);
                } else{
                    convertButton.setEnabled(true);
                }
            }

        });
    }

    private void calculateValue(){
        String input;
        String value;
        boolean isLeftField;
        String decimalPlaces;
        JTextField selected;
        JTextField unselected;

        isLeftField = !leftTextField.getText().equals(""); // true if textfield is not empty
        selected = (isLeftField) ? leftTextField : rightTextField;
        unselected = (isLeftField) ? rightTextField : leftTextField;

        decimalPlaces = "%." + String.valueOf(decimalVal) + "f";

        input = selected.getText();
        switch (comboBox1.getSelectedIndex()){
                case 0:
                    value = String.format(decimalPlaces, Conversion.farCelConversion(input, isLeftField));
                    unselected.setText(value);
                    break;
                case 1:
                    value = String.format(decimalPlaces, Conversion.inCmConversion(input, isLeftField));
                    unselected.setText(value);
                    break;
                case 2:
                    value = String.format(decimalPlaces, Conversion.feetMeterConversion(input, isLeftField));
                    unselected.setText(value);
                    break;
                case 3:
                    value = String.format(decimalPlaces, Conversion.mileKmConversion(input, isLeftField));
                    unselected.setText(value);
                    break;
                case 4:
                    value = String.format(decimalPlaces, Conversion.galLiterConversion(input, isLeftField));
                    unselected.setText(value);
                    break;
                case 5:
                    value = String.format(decimalPlaces, Conversion.ozGConversion(input, isLeftField));
                    unselected.setText(value);
                    break;
                case 6:
                    value = String.format(decimalPlaces, Conversion.lbKgConversion(input, isLeftField));
                    unselected.setText(value);
                    break;
                case 7:
                    value = String.format(decimalPlaces, Conversion.hrSecConversion(input,isLeftField));
                    unselected.setText(value);
                    break;
                case 8:
                    value = String.format(decimalPlaces, Conversion.mphKphConversion(input, isLeftField));
                    unselected.setText(value);
                    break;
                case 9:
                    value = String.format(decimalPlaces, Conversion.kelvinCelsiusConversion(input, isLeftField));
                    unselected.setText(value);
                    break;
        }

    }

    private void displayMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }

    private boolean isValidInput(String input){
        System.out.println(input);
        Pattern pattern = Pattern.compile("^[-+]?\\d*\\.?\\d*$"); // regular expression to check if a string is a float value
        return pattern.matcher(input).matches();
    }

    private void initComboBox(){
        this.leftUnitField.setText(leftLabels[0]);
        this.rightUnitField.setText(rightLabels[0]);

        this.comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                leftUnitField.setText(leftLabels[comboBox1.getSelectedIndex()]);
                rightUnitField.setText(rightLabels[comboBox1.getSelectedIndex()]);
            }
        });
    }

    public static void main(String [] args){
        JFrame frame = new MainGUI("Conversion App");
        frame.setVisible(true);

    }
}
