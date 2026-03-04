import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TemperatureConverter extends JFrame implements ActionListener {

    JTextField inputField;
    JComboBox<String> unitBox;
    JButton convertButton;
    JLabel resultLabel;

    TemperatureConverter(){

        setTitle("Temperature Converter");

      
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width/2, screenSize.height/2);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4,1,10,10));

       
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter Temperature:"));

        inputField = new JTextField(10);
        inputPanel.add(inputField);

        add(inputPanel);

       
        JPanel unitPanel = new JPanel();
        unitPanel.add(new JLabel("Select Unit:"));

        String units[] = {"Celsius", "Fahrenheit", "Kelvin"};
        unitBox = new JComboBox<>(units);

        unitPanel.add(unitBox);

        add(unitPanel);

        
        convertButton = new JButton("Convert");
        convertButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(convertButton);

        add(buttonPanel);

        
        resultLabel = new JLabel("Converted temperature will appear here", JLabel.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));

        add(resultLabel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        try{

            double temp = Double.parseDouble(inputField.getText());
            String unit = (String) unitBox.getSelectedItem();

            double c=0,f=0,k=0;

            if(unit.equals("Celsius")){
                c = temp;
                f = (c * 9/5) + 32;
                k = c + 273.15;
            }
            else if(unit.equals("Fahrenheit")){
                f = temp;
                c = (f - 32) * 5/9;
                k = c + 273.15;
            }
            else if(unit.equals("Kelvin")){
                k = temp;
                c = k - 273.15;
                f = (c * 9/5) + 32;
            }

            resultLabel.setText(
                    String.format("Celsius: %.2f  |  Fahrenheit: %.2f  |  Kelvin: %.2f", c,f,k)
            );

        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(this,"Please enter a valid number");
        }

    }

    public static void main(String[] args) {

        new TemperatureConverter();

    }
}