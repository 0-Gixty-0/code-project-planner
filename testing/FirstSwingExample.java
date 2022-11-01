package testing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.*;  

public class FirstSwingExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Example");
        final JTextField tf = new JTextField();
        tf.setBounds(100,100,150,20);
        JButton button = new JButton("Click");
        button.setBounds(0, 0, 100, 40);
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tf.setText("Welcome to JavatPoint");
            }
        });
        frame.add(button);
        frame.add(tf);
        frame.setSize(1536,820);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
