package ATM;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OperationsMenu extends Deposit{
    JFrame frame = new JFrame("MAIN MENU");
    JPanel OperationsMenu;
    JButton DEPOSITButton;
    JButton WITHDRAWButton;
    JButton TRANSACTIONSHISTORYButton;
    JButton QUITButton;
    JButton TRANSFERButton;
    JLabel BalanceLabel;
    int balance = 0;

    public OperationsMenu() {
        DEPOSITButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    balance = balance + Integer.parseInt(DepositValue.getText());
                    getDepositframe().dispose();
                    history.add("You have deposited " + DepositValue.getText());
                    DepositValue.setText("");
                    BalanceLabel.setText("Balance: " + balance);
                    frame.setVisible(true);
                }
                catch (NumberFormatException ex)
                {
                    ErrorMesage.setText("You must introduce a number. ");
                    Error();
                }
            }
        });
        DEPOSITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DepositSum();
                frame.setVisible(false);
            }
        });
        WITHDRAWButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WithdrawSum();
                frame.setVisible(false);
            }
        });
        WITHDRAWButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    if(balance >= Integer.parseInt(WithdrawValue.getText())) {
                        balance = balance - Integer.parseInt(WithdrawValue.getText());
                        withdrawframe.dispose();
                        history.add("You have withdrawn " + WithdrawValue.getText());
                        WithdrawValue.setText("");
                        BalanceLabel.setText("Balance: " + balance);
                        frame.setVisible(true);

                    }
                    else {
                        ErrorMesage.setText("You don't have enough money. ");
                        Error();
                    }
                }
                catch (NumberFormatException ex)
                {
                    ErrorMesage.setText("You must introduce a number. ");
                    Error();
                }
            }
        });
        QUITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        TRANSFERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TransferSum();
                frame.setVisible(false);
            }
        });
        TRANSFERButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (balance >= Integer.parseInt(TransferSum.getText())) {
                        if (ReceiverCardNumber.getText().length() == 16) {
                            balance = balance - Integer.parseInt(TransferSum.getText());
                            BalanceLabel.setText("Balance: " + balance);
                            TransferInfo.setText("Transfer successful.");
                            history.add("You have transfered " + TransferSum.getText() + " to card number " + ReceiverCardNumber.getText());
                        }
                        else TransferInfo.setText("The Card Number is wrong. ");
                    }
                    else TransferInfo.setText("You don't have enough money.");
                }
                catch (NumberFormatException ex)
                {
                    TransferInfo.setText("You must introduce a number. ");
                }
            }
        });
        RETURNButtonDeposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                depositframe.dispose();
                frame.setVisible(true);
            }
        });
        RETURNButtonWithdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdrawframe.dispose();
                frame.setVisible(true);
            }
        });
        RETURNButtonTransfer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transferframe.dispose();
                frame.setVisible(true);
            }
        });
        RETURNButtonHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                historyframe.dispose();
                frame.setVisible(true);
            }
        });
        TRANSACTIONSHISTORYButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                historytext.setEditable(false);
                historytext.setText("");
                frame.setVisible(false);
                for (int i = 0; i < history.size(); i++) {
                    historytext.append(history.get(i) + '\n');
                }
                History();
            }
        });
    }

    public void OperationsMenuPopUp(){
    frame.setContentPane(OperationsMenu);
    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    frame.setResizable(false);
    frame.setSize(300, 300);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
}
}
