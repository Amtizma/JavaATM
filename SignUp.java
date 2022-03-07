package ATM;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SignUp extends OperationsMenu{
    JFrame frame = new JFrame("Sign Up");
    JPanel SignUpPopUp;
    JFormattedTextField PINValue;
    JButton GENERATEButton;
    private JFormattedTextField IDValue;
    private JLabel Confirmation;
    private JLabel InfoArea;
    private JButton ClearSignUp;
    JButton RETURNButtonSignUp;

    public SignUp() {
        GENERATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PINValue.getText().length() == 4) {
                    if (IDValue.getText().length() == 16) {
                        try {

                            FileWriter myWriter = new FileWriter("carddata.txt", true);
                            myWriter.write(IDValue.getText() + "," + PINValue.getText() + "\n");
                            myWriter.close();
                        } catch (IOException ex) {
                            System.out.println("An error occurred.");
                            ex.printStackTrace();
                        }
                        Confirmation.setText("Your card has been generated");
                    }
                    else Confirmation.setText("The Card Number doesn't have 16 characters.");
                }
                else Confirmation.setText("The PIN doesn't have 4 characters.");
            }
        });
        PINValue.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
                if(PINValue.getText().length() > 3) e.consume();

            }
        });
        IDValue.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
                if(IDValue.getText().length() > 15) e.consume();

            }
        });

                ClearSignUp.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        IDValue.setText("");
                        PINValue.setText("");
                    }
                });
    }

    public void PopUp(){

            frame.setContentPane(SignUpPopUp);
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setResizable(true);
            frame.pack();
            frame.setVisible(true);
    }

}
