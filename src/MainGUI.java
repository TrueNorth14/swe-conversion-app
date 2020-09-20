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
    private final String [] leftLabels = {"Fahrenheit (Fº)", "Inch (in)", "Feet (ft)", "Mile (mi)", "Gallon (gal)", "Ounce (oz)", "Pound (lb)", "Hours (hr)"};
    private final String [] rightLabels = {"Celsius (Cº)", "Centimeter (cm)", "Meter (m)", "Kilometer (km)", "Liter (L)", "Gram (g)", "Kilogram (kg)", "Seconds (sec)"};

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

        isLeftField = !leftTextField.getText().equals(""); // true if textfield is not empty
        decimalPlaces = "%." + String.valueOf(decimalVal) + "f";

        // first calculate all of the possibilities for input in the left field
        // I don't want to do this, but i see no other way
        if(isLeftField){
            input = leftTextField.getText();
            switch (comboBox1.getSelectedIndex()){
                case 0:
                    value = String.format(decimalPlaces, Conversion.convertF2C(input));
                    rightTextField.setText(value);
                    break;
                case 1:
                    value = String.format(decimalPlaces, Conversion.convertIn2Cm(input));
                    rightTextField.setText(value);
                    break;
                case 2:
                    value = String.format(decimalPlaces, Conversion.convertF2M(input));
                    rightTextField.setText(value);
                    break;
                case 3:
                    value = String.format(decimalPlaces, Conversion.convertM2K(input));
                    rightTextField.setText(value);
                    break;
                case 4:
                    value = String.format(decimalPlaces, Conversion.convertG2L(input));
                    rightTextField.setText(value);
                    break;
                case 5:
                    value = String.format(decimalPlaces, Conversion.convertOz2G(input));
                    rightTextField.setText(value);
                    break;
                case 6:
                    value = String.format(decimalPlaces, Conversion.convertLb2K(input));
                    rightTextField.setText(value);
                    break;
                case 7:
                    value = String.format(decimalPlaces, Conversion.convertHr2Sec(input));
                    rightTextField.setText(value);
                    break;

            }
        } else {
            input = rightTextField.getText();
            switch (comboBox1.getSelectedIndex()){
                case 0:
                    value = String.format(decimalPlaces, Conversion.convertC2F(input));
                    leftTextField.setText(value);
                    break;
                case 1:
                    value = String.format(decimalPlaces, Conversion.convertCm2In(input));
                    leftTextField.setText(value);
                    break;
                case 2:
                    value = String.format(decimalPlaces, Conversion.convertM2F(input));
                    leftTextField.setText(value);
                    break;
                case 3:
                    value = String.format(decimalPlaces, Conversion.convertK2M(input));
                    leftTextField.setText(value);
                    break;
                case 4:
                    value = String.format(decimalPlaces, Conversion.convertL2G(input));
                    leftTextField.setText(value);
                    break;
                case 5:
                    value = String.format(decimalPlaces, Conversion.convertG2Oz(input));
                    leftTextField.setText(value);
                    break;
                case 6:
                    value = String.format(decimalPlaces, Conversion.convertK2Lb(input));
                    leftTextField.setText(value);
                    break;
                case 7:
                    value = String.format(decimalPlaces, Conversion.convertSec2Hr(input));
                    leftTextField.setText(value);
                    break;
            }
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
