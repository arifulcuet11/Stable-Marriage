    package married;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Sign extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
    JTextField tf1, tf2, tf3, tf6, tf7;
    JButton btn1, btn2;
    JPasswordField p1, p2;
    String view = "select * from login where gender = ";

    void Login() {
        setVisible(true);
        setSize(600, 600);
        setLayout(null);
        setTitle("Registration Form ");
        l1 = new JLabel("Sign Up Form ");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));
        l2 = new JLabel("Username:");
        l3 = new JLabel("Email-ID:");
        l4 = new JLabel("Create Passowrd:");
        l5 = new JLabel("Confirm Password:");
        l6 = new JLabel("Gender");
        tf1 = new JTextField();
        tf2 = new JTextField();
        p1 = new JPasswordField();
        p2 = new JPasswordField();
        tf3 = new JTextField();
        tf6 = new JTextField();
        tf7 = new JTextField();
        btn1 = new JButton("Submit");
        btn2 = new JButton("Clear");

        btn1.addActionListener(this);

        l1.setBounds(100, 30, 400, 30);
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        l4.setBounds(80, 150, 200, 30);
        l5.setBounds(80, 190, 200, 30);
        l6.setBounds(80, 230, 200, 30);

        tf1.setBounds(300, 70, 200, 30);
        tf2.setBounds(300, 110, 200, 30);
        p1.setBounds(300, 150, 200, 30);
        p2.setBounds(300, 190, 200, 30);
        tf3.setBounds(300, 230, 200, 30);

        btn1.setBounds(50, 400, 100, 30);
        btn2.setBounds(300, 400, 100, 30);

        add(l1);
        add(l2);
        add(tf1);
        add(l3);
        add(tf2);
        add(l4);
        add(p1);
        add(l5);
        add(p2);
        add(l6);
        add(tf3);

        add(btn1);
        add(btn2);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String name, conframpassword, password, email, submit;
        submit = ae.getActionCommand();
        int flag = 0;
        name = tf1.getText();
        password = p1.getText();
        conframpassword = p2.getText();
        email = tf2.getText();
        try {
            String driver = "com.mysql.jdbc.Driver";
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost/married";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");
            System.out.println("Connected\n");
            String sql1 = "CREATE TABLE login ("
               + "name VARCHAR(30),"
               + "email VARCHAR(100),"
               + "password VARCHAR(50),"
               + ");";

            String query = " insert into login (name, password, email)"
                    + " values (?, ?, ?)";
            if ("Submit".equals(submit)) {
                Statement stmt = conn.createStatement();
            //    stmt.executeUpdate(sql1); 
                String sql = "select name from login";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    String username = rs.getString("name");
                    if (username == null ? name == null : username.equals(name)) {
                        flag = 1;
                        JOptionPane.showMessageDialog(null, "User name already exist :o");
                        break;
                    }
                }
                if (password == null ? conframpassword != null : !password.equals(conframpassword)) {
                    JOptionPane.showMessageDialog(null, "Password not Match");
                } else if (flag == 0) {
                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString(1, name);
                    preparedStmt.setString(2, password);
                    preparedStmt.setString(3, email);
                    preparedStmt.execute();
                    JOptionPane.showMessageDialog(null, "Successfully registration :)");
                    setVisible(false);
                }

            }

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
}
