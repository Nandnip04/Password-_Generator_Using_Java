import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;
public class Generator {
    JFrame frame;
    JLabel passwordLabel;
    JTextField text;
    // JComboBox sixCharCombo, tenCharCombo,tewlvCharCombo;
    JCheckBox sixCharChack,tenCharChack,twelvCharChack;
    JButton generateBtn;
    Container c;
    Generator(){
        frame=new JFrame();
        frame.setBounds(350,100,670,560);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c=frame.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.GRAY); 


        passwordLabel=new JLabel("Password Generator");
        passwordLabel.setBounds(140,50,400,50);
        Font font=new Font("Arial",Font.BOLD,40);
        passwordLabel.setFont(font);
        frame.add(passwordLabel);

        text=new JTextField();
        text.setBounds(220,180,240,28);
        text.setFont(new Font("Times new roman",Font.BOLD,20));
        frame.add(text);

       
        Font font2 =new Font("Arial",Font.BOLD,20);
        sixCharChack =new JCheckBox("6 Character");
        tenCharChack =new JCheckBox("10 Character");
        twelvCharChack =new JCheckBox("12 Character");

        sixCharChack.setBounds(240,250,200,25);
        tenCharChack.setBounds(240,300,200,25);
        twelvCharChack.setBounds(240,350,200,25);

        sixCharChack.setFont(font2);
        tenCharChack.setFont(font2);
        twelvCharChack.setFont(font2);

        sixCharChack.setBackground(null);
        tenCharChack.setBackground(null);
        twelvCharChack.setBackground(null);

        frame.add(sixCharChack);
        frame.add(tenCharChack);
        frame.add(twelvCharChack);

        generateBtn =new JButton("Generate");
        generateBtn.setBounds(240,400,150,35);
        generateBtn.setFont(font2);
        frame.add(generateBtn);

        frame.setVisible(true);
        frame.setResizable(false);

        generateBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (sixCharChack.isSelected()){
                    passGenerator(06);
                }
                else if (tenCharChack.isSelected()){
                    passGenerator(10);
                }
                else if (twelvCharChack.isSelected()){
                    passGenerator(12);
                }
                else{
                    passGenerator(8);
                }
            }
        });
    }
    public void passGenerator(int len){
            String validChar="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ012356789@#%^&*<>+-_";
            StringBuilder st=new StringBuilder();
            Random rand=new Random();
            while(0<len--){
                st.append(validChar.charAt(rand.nextInt(validChar.length())));

                }
            text.setText(st.toString());
            

    }
    public static void main(String[]args){
        new Generator();
    }
}
