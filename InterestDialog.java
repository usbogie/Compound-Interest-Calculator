//Henry bgardus

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.*;
import java.lang.*;
public class InterestDialog extends JFrame
{
    JTextField mAccountBalance;
    JTextField mInterestRate;
    JTextField timesCompounded;
    public InterestDialog()
    {
        JFrame frame = new JFrame();
        setTitle("Interest Calculator");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel mainPane = new JPanel();
        mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));
        
        JPanel firstRow = new JPanel();
        mainPane.add(firstRow);
        JLabel firstRowLabel = new JLabel("Account Balance: ");
        mAccountBalance = new JTextField("$00.00", 8);
        firstRow.add(firstRowLabel);
        firstRow.add(mAccountBalance);
        
        JPanel secondRow = new JPanel();
        mainPane.add(secondRow);
        JLabel secondRowLabel = new JLabel("Interest rate: ");
        mInterestRate = new JTextField("0.00%", 11);
        secondRow.add(secondRowLabel);
        secondRow.add(mInterestRate);
        
        JPanel thirdRow = new JPanel();
        mainPane.add(thirdRow);
        JLabel thirdRowLabel = new JLabel("Times compounded: ");
        timesCompounded = new JTextField("0", 7);
        thirdRow.add(thirdRowLabel);
        thirdRow.add(timesCompounded);

        class ButtonListener implements ActionListener
        { 
            public void actionPerformed(ActionEvent event)
            {
                addInterest();
            }
        }
        JButton calculate = new JButton("Compound Interest");
        calculate.addActionListener(new ButtonListener());
        mainPane.add(calculate);
        
        
        add(mainPane);
        pack();
        setLocationRelativeTo(null);
    }
    
    public void addInterest()
    {
        DecimalFormat balanceFormat = new DecimalFormat("$0.00");
        DecimalFormat rateFormat = new DecimalFormat("0.00%");
        
        String balanceText = mAccountBalance.getText();
        Number balanceNumber = balanceFormat.parse(balanceText, new ParsePosition(0));
        double balance = balanceNumber.doubleValue();
        
        String interest = mInterestRate.getText();
        Number rateNumber = rateFormat.parse(interest, new ParsePosition(0));
        double interestRate = rateNumber.doubleValue();
        
        String compounds = timesCompounded.getText();
        int numCompounds = Integer.parseInt(compounds);
        numCompounds++;
        
        double newBalance = balance + balance * interestRate;
        
        timesCompounded.setText(Integer.toString(numCompounds));
        mAccountBalance.setText(balanceFormat.format(newBalance));
        mInterestRate.setText(rateFormat.format(interestRate));
    }
    
    public void showDialog()
    {
        setVisible(true);
    }
}
        