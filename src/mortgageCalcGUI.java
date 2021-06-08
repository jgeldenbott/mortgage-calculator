import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class mortgageCalcGUI extends JFrame {
    private JPanel panel1;
    private JPanel mainPanel;
    private JTextField principleTextField;
    private JLabel principleLabel;
    private JTextField interestTextField;
    private JLabel interestLabel;
    private JTextField textField1;
    private JLabel periodLabel;
    private JButton calculateButton;
    private JLabel mortgageValue;

    public mortgageCalcGUI(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // grab the text from the text fields
                // convert to a double
                // update the mortgage
                int principle = (int)((Double.parseDouble(principleTextField.getText())));
                //System.out.println("Principle: " + principle);
                double interest = ((Double.parseDouble(interestTextField.getText()))) / 1200;
                //System.out.println("Interest: " + interest);
                int period = (int)((Double.parseDouble(textField1.getText())));
                //System.out.println("Years: " + period);

                mortgageValue.setText(calculateMortgage(interest, period, principle));

            }
            public String calculateMortgage(double interestRate, double period, double principle) {
                double top = (Math.pow((1 + interestRate), 12 * period)) * interestRate;
                double bottom = (Math.pow((1 + interestRate), 12 * period) - 1);
                double mortgage = principle * (top / bottom);
                NumberFormat currency = NumberFormat.getCurrencyInstance();
                String result = currency.format(mortgage);
                return result;

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new mortgageCalcGUI("Mortgage Calculator");
        frame.setVisible(true);


    }
}
