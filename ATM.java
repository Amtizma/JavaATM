package ATM;

import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class ATM extends SignUp{
    static JFrame frame1 = new JFrame("ATM");
    JButton SIGNINButton;
    JButton CLEARButton;
    JButton SIGNUPButton;
    JPanel MainPanel;
    JPanel TitlePanel;
    JPanel CardDataPanel;
    JPanel CardDataValues;
    JPanel CardDataInfo;
    JPanel ButtonsPanel;
    JPanel SignAndClearPanel;
    JPanel SignInPanel;
    JPanel ClearPanel;
    JPanel SignUpPanel;
    JFormattedTextField CardNumberText;
    JFormattedTextField PINText;
    Boolean verifydata;


    public ATM() {
        SIGNUPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            PopUp();
            frame1.setVisible(false);
            }
        });
        CLEARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardNumberText.setText("");
                PINText.setText("");
            }
        });
        SIGNINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignIn();
            }
        });
        CardNumberText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
                if(CardNumberText.getText().length() > 15) e.consume();
            }
        });
        PINText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
                if(PINText.getText().length() > 3) e.consume();
            }
        });
        RETURNButtonSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                frame1.setVisible(true);
            }
        });
    }
    public void SignIn(){
        try {
            BufferedReader b = new BufferedReader(new FileReader("carddata.txt"));
            String readLine = "";
            while ((readLine = b.readLine()) != null) {
                String sir[] = readLine.split(",");
                if(sir[0].equals(CardNumberText.getText()) && sir[1].equals(PINText.getText()))
                {
                    OperationsMenuPopUp();
                    verifydata = true;
                    frame1.setVisible(false);
                    break;
                }
                else {
                    verifydata = false;
                }
            }
            if (!verifydata) {
                Error();
                ErrorMesage.setText("Incorrect data.");
            };
        } catch (Exception e) {
            e.printStackTrace();
        } }
        public static void Start(){
            frame1.setContentPane(new ATM().MainPanel);
            frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame1.setLocationRelativeTo(null);
            frame1.setResizable(false);
            frame1.setSize(300, 300);
            frame1.setVisible(true);
        }

}
