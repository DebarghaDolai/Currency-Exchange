import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class LoaderPage extends JFrame {

    Border border = BorderFactory.createLineBorder(Color.black);

    String[] currency = {"INR", "USD", "AED"};
    JComboBox comboBox1, comboBox2;
    JTextField inputAmt, outputAmt;
    JButton ExchangeButton;

    LoaderPage() {
        super("Currency Exchange");

        JLabel jlabel1 = new JLabel("Select Currency : ");
        jlabel1.setBounds(160, 80, 350, 140);
        jlabel1.setFont(new Font("Kohinoor Bangla", Font.BOLD, 22));
        add(jlabel1);

        comboBox1 = new JComboBox(currency);
        comboBox1.setBounds(175, 170, 150, 40);
        comboBox1.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 16));
        add(comboBox1);

        JLabel AmtLabel1 = new JLabel("Amount : ");
        AmtLabel1.setBounds(110, 200, 350, 140);
        AmtLabel1.setFont(new Font("Kohinoor Bangla", Font.BOLD, 18));
        add(AmtLabel1);

        inputAmt = new JTextField();
        inputAmt.setBorder(border);
        inputAmt.setBounds(200, 255, 150, 30);
        inputAmt.setFont(new Font("Kohinoor Bangla", Font.BOLD, 18));
        add(inputAmt);

        ExchangeButton = new JButton("Exchange");
        ExchangeButton.addActionListener(e -> exchange());
        ExchangeButton.setBounds(190, 324, 150, 40);
        ExchangeButton.setOpaque(true);
        ExchangeButton.setForeground(new Color(0,0,0));
        ExchangeButton.setBackground(new Color(255, 51, 0));
        ExchangeButton.setFont(new Font("Kohinoor Bangla", Font.BOLD, 16));
        add(ExchangeButton);


        JLabel jlabel2 = new JLabel("Select Currency : ");
        jlabel2.setBounds(160, 350, 350, 140);
        jlabel2.setFont(new Font("Kohinoor Bangla", Font.BOLD, 22));
        add(jlabel2);

        comboBox2 = new JComboBox(currency);
        comboBox2.setSelectedIndex(1);
        comboBox2.setBounds(175, 440, 150, 40);
        comboBox2.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 16));
        add(comboBox2);

        JLabel AmtLabel2 = new JLabel("Amount : ");
        AmtLabel2.setBounds(110, 470, 350, 140);
        AmtLabel2.setFont(new Font("Kohinoor Bangla", Font.BOLD, 18));
        add(AmtLabel2);

        outputAmt = new JTextField();
        outputAmt.setBorder(border);
        outputAmt.setEditable(false);
        outputAmt.setBounds(200, 550, 150, 30);
        outputAmt.setFont(new Font("Kohinoor Bangla", Font.BOLD, 18));
        add(outputAmt);


        setSize(500, 740);
        setLocationRelativeTo(null);
        //contanpant().setBackground(123,234,32);
        setLayout(null);
        setVisible(true);
    }

    private void exchange() {
        String input = inputAmt.getText();
        String from = (String) comboBox1.getSelectedItem();
        String to = (String) comboBox2.getSelectedItem();

        try {
            if (from == "INR"  && to == "USD") {
                float inAmt = Integer.parseInt(input);
                float opAmt = (float) (inAmt / 84.03);
                outputAmt.setText(String.valueOf(opAmt)); 
            }else if (from == "INR" && to == "AED") {
                float inAmt = Integer.parseInt(input);
                float opAmt = (float)(inAmt / 22.86);
                outputAmt.setText(String.valueOf(opAmt));
            }else if (from == "USD" && to == "INR") {
                float inAmt = Integer.parseInt(input);
                float opAmt = (float) (inAmt * 84.03);
                outputAmt.setText(String.valueOf(opAmt));
            }else if (from == "USD" && to == "AED") {
                float inAmt = Integer.parseInt(input);
                float opAmt = (float)(inAmt * 3.67);
                outputAmt.setText(String.valueOf(opAmt));
            }else if (from == "AED" && to == "INR") {
                float inAmt = Integer.parseInt(input);
                float opAmt = (float)(inAmt * 22.86);
                outputAmt.setText(String.valueOf(opAmt));
            }else if (from == "AED" && to == "USD") {
                float inAmt = Integer.parseInt(input);
                float opAmt = (float) (inAmt / 3.67);
                outputAmt.setText(String.valueOf(opAmt));
            }else {
                JOptionPane.showMessageDialog(null, "Please select valid currency");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // private void exchangeCurrency() {
    //     try {
    //         // Get selected currencies and input amount
    //         String sourceCurrency = (String) comboBox1.getSelectedItem();
    //         String targetCurrency = (String) comboBox2.getSelectedItem();
    //         double amount = Double.parseDouble(inputAmt.getText());

    //         // Fetch exchange rates (replace with your API or local data)
    //         double exchangeRate = fetchExchangeRate(sourceCurrency, targetCurrency);

    //         // Calculate converted amount
    //         double convertedAmount = amount * exchangeRate;

    //         // Update output field
    //         outputAmt.setText(String.format("%.2f", convertedAmount));

    //     } catch (NumberFormatException e) {
    //         JOptionPane.showMessageDialog(this, "Please enter a valid amount.");
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         JOptionPane.showMessageDialog(this, "An error occurred. Please try again.");
    //     }
    // }

    // // Method to fetch exchange rate from an API or local data
    // private double fetchExchangeRate(String sourceCurrency, String targetCurrency) {
    //     // Replace this with your actual API call or data retrieval logic
    //     // For example, using a REST API:
    //     String apiUrl = "https://api.example.com/exchange-rate?source=" + sourceCurrency + "&target=" + targetCurrency;
    //     // Use a library like HttpClient or OkHttp to make the API request
    //     // Parse the response to extract the exchange rate
    //     double exchangeRate = 1.0; // Replace with the actual value from the API
    //     return exchangeRate;
    // }


    public static void main(String[] args) {
        new LoaderPage();
    }
}