package married;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class users extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
    JTextField tf5, tf6, tf7, tf8;
    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7;
    JComboBox c1, c2, c3, c4 = new JComboBox();
    String div, age, gnd, ocpp;
    String[] description1 = {"0", "Female", "Male"};
    String[] description2 = {"0", "Dhaka", "Chittagong", "Khulna", "Rajshahi", "Borisal", "Sylet"};
    String[] description3 = {"00", "15-20", "20-25", "25-30", "30+"};
    String[] description4 = {"0", "Student", "Teacher", "Doctor", "Engineer", "Others"};
    String c;

    users(String a, String b) {
        setTitle("Users InterFaces");
        c = b;
        setVisible(true);
        setSize(900, 900);
        getContentPane().setBackground(Color.cyan);
        setLayout(null);
        a = "Hi " + a;
        l1 = new JLabel(a);
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Serif", Font.BOLD, 40));
        l1.setBounds(350, 50, 300, 30);
        add(l1);


        btn1 = new JButton("Create Profile");
        btn1.setBounds(300, 200, 200, 30);
        add(btn1);
        btn1.addActionListener(this);

        btn2 = new JButton("LogOut");
        btn2.setBackground(Color.cyan);
        btn2.setBounds(700, 20, 100, 30);
        add(btn2);
        btn2.addActionListener(this);

        btn5 = new JButton("view profile");
        btn5.setBounds(300, 100, 200, 30);
        add(btn5);
        btn5.addActionListener(this);

        btn6 = new JButton("Edite profile");
        btn6.setBounds(300, 150, 200, 30);
        add(btn6);
        btn6.addActionListener(this);


        l4 = new JLabel("Are you Looking ?");
        l4.setForeground(Color.black);
        l4.setFont(new Font("Impact", Font.BOLD, 20));
        l4.setBounds(100, 250, 300, 30);
        add(l4);

        l5 = new JLabel("Gender      :");
        l6 = new JLabel("Location    :");
        l7 = new JLabel("Age         :");
        l8 = new JLabel("Ocapassion :");
        l5.setBounds(180, 300, 200, 30);
        l6.setBounds(180, 350, 200, 30);
        l7.setBounds(180, 400, 200, 30);
        l8.setBounds(180, 450, 200, 30);
        add(l5);
        add(l6);
        add(l7);
        add(l8);

        tf5 = new JTextField("0");
        tf6 = new JTextField("0");
        tf7 = new JTextField("00");
        tf8 = new JTextField("0");
        tf6.setEditable(false);
        tf5.setEditable(false);
        tf7.setEditable(false);
        tf8.setEditable(false);
        tf5.setBounds(270, 300, 200, 30);
        tf6.setBounds(270, 350, 200, 30);
        tf7.setBounds(270, 400, 200, 30);
        tf8.setBounds(270, 450, 200, 30);
        add(tf5);
        add(tf6);
        add(tf7);
        add(tf8);

        c1 = new JComboBox();
        c1.setBackground(Color.black);
        c1.setForeground(Color.PINK);
        for (int i = 0; i < description1.length; i++) {
            c1.addItem(description1[i]);
        }
        c1.setBounds(480, 300, 100, 30);
        add(c1);
        c1.addActionListener(this);


        c2 = new JComboBox();
        c2.setBackground(Color.black);
        c2.setForeground(Color.PINK);
        for (int i = 0; i < description2.length; i++) {
            c2.addItem(description2[i]);

        }
        c2.addActionListener(this);
        c2.setBounds(480, 350, 100, 30);
        add(c2);

        c3 = new JComboBox();
        c3.setBackground(Color.black);
        c3.setForeground(Color.PINK);
        for (int i = 0; i < description3.length; i++) {
            c3.addItem(description3[i]);
        }
        c3.setBounds(480, 400, 100, 30);
        c3.addActionListener(this);
        add(c3);

        c4 = new JComboBox();
        c4.setBackground(Color.black);
        c4.setForeground(Color.PINK);
        for (int i = 0; i < description4.length; i++) {
            c4.addItem(description4[i]);
        }
        c4.setBounds(480, 450, 100, 30);
        c4.addActionListener(this);
        add(c4);

        btn4 = new JButton("GO!");
        btn4.setBounds(350, 500, 100, 40);
        btn4.setFont(new Font("Impact", Font.BOLD, 20));
        btn4.setBackground(Color.cyan);
        add(btn4);
        btn4.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    users() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String value;
        int ag1, ag2 = 100, ag3;
        value = ae.getActionCommand();
        tf5.setText(c1.getSelectedItem().toString());
        tf6.setText(c2.getSelectedItem().toString());
        tf7.setText(c3.getSelectedItem().toString());
        tf8.setText(c4.getSelectedItem().toString());

        gnd = tf5.getText();
        div = tf6.getText();
        age = tf7.getText();
        ocpp = tf8.getText();

        if ("Female".equals(value) || "Male".equals(value)) {
            tf5.setText("");
            tf5.setText(value);
        }
        if ("LogOut".equals(value)) {
            setVisible(false);
            Married md = new Married();
            md.BreackgroundImagge();
        }
        if ("Create Profile".equals(value)) {
            System.out.println(value);
            userreg ab = new userreg();
            ab.Login(c);
        }
        if ("view profile".equals(value)) {
            showtable tbl = new showtable();
            tbl.showprofile(c);
        }
        if ("Edite profile".equals(value)) {
            // System.out.println(c);
            update upd = new update();
            upd.Login(c);

        }
        if ("GO!".equals(value)) {

            if (age.length() > 3) {
                ag1 = (age.charAt(0) - '0') * 10 + (age.charAt(1) - '0');

                ag2 = (age.charAt(3) - '0') * 10 + (age.charAt(4) - '0');

            } else {
                ag1 = (age.charAt(0) - '0') * 10 + (age.charAt(1) - '0');
            }
            int x = 1;
            showtable tb2 = new showtable();
            tb2.search(gnd, div, ag1, ag2, ocpp, x);
        }
    }
}
