import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Coder implements ActionListener {
    private JTextField jtfPlaintext;
    private JTextField jtfCiphertext;

    public Coder (){
        JFrame jfrm= new JFrame("Coder frame");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(350,120);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel jlabPlaintext= new JLabel("Plain text:");
        JLabel jlabCiphertext= new JLabel("Cipher text:");

        jtfPlaintext= new JTextField(20);
        jtfCiphertext = new JTextField(20);

        jtfPlaintext.setActionCommand("Encode");
        jtfCiphertext.setActionCommand("Decode");

        jtfPlaintext.addActionListener(this);
        jtfCiphertext.addActionListener(this);

        jfrm.add(jlabPlaintext);
        jfrm.add(jtfPlaintext);
        jfrm.add(jlabCiphertext);
        jfrm.add(jtfCiphertext);

        JButton jbtnEncode= new JButton("Encode");
        JButton jbtnDecode = new JButton("Decode");
        JButton jbtnReset = new JButton("Reset");

        jbtnEncode.addActionListener(this);
        jbtnDecode.addActionListener(this);
        jbtnReset.addActionListener(this);

        jfrm.add(jbtnEncode);
        jfrm.add(jbtnDecode);
        jfrm.add(jbtnReset);

        jfrm.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Encode")){
            StringBuilder str= new StringBuilder(jtfPlaintext.getText());
            for (int i=0;i<str.length();i++){
                str.setCharAt(i,(char)(str.charAt(i)+1));
                jtfCiphertext.setText(str.toString());
            }
        }
        else if (e.getActionCommand().equals("Decode")){
            StringBuilder str= new StringBuilder(jtfCiphertext.getText());
            for (int i=0; i<str.length(); i++){
                str.setCharAt(i,(char)(str.charAt(i)-1));
                jtfPlaintext.setText(str.toString());
            }
        }
        else {
            jtfPlaintext.setText("");
            jtfCiphertext.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Coder();
            }
        });
    }
}
