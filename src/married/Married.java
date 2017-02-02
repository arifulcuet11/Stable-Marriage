
package married;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Married extends JFrame implements ActionListener {

    Container con = null;
    JPanel panelBgImg;
    JMenu jmenuFile, jmenuHelp, edit;
    JTextField txtName = new JTextField(12);
     JPasswordField  txtName1 = new  JPasswordField (12);
    JButton btnn = new JButton("Login");
    JButton btnn1 = new JButton("Sign In");

    void BreackgroundImagge() {
        setTitle("MARRIAGE");
        btnn1.addActionListener(this);
        btnn.addActionListener(this);
        con = getContentPane();

        con.setLayout(null);
        ImageIcon imh = new ImageIcon("marriage.jpg");
        setSize(imh.getIconWidth(), imh.getIconHeight());

        panelBgImg = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                Image img = new ImageIcon("marriage.jpg").getImage();
                Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
                setPreferredSize(size);
                setMinimumSize(size);
                setMaximumSize(size);
                setSize(size);
                setLayout(null);
                g.drawImage(img, 0, 0, null);
            }
        };

        con.add(panelBgImg);
        panelBgImg.setBounds(0, 0, imh.getIconWidth(), imh.getIconHeight());

        GridBagLayout layout = new GridBagLayout();

        JPanel panelContent = new JPanel(layout);
        GridBagConstraints gc = new GridBagConstraints();

        gc.insets = new Insets(4, 4, 4, 4);
        gc.gridx = 1;
        gc.gridy = 1;

        JLabel label = new JLabel("UserName: ", JLabel.LEFT);
        panelContent.add(label, gc);
        gc.gridx = 1;
        gc.gridy = 2;
        JLabel label1 = new JLabel("Password:  ", JLabel.LEFT);
        panelContent.add(label1, gc);
        gc.gridx = 2;
        gc.gridy = 1;

        panelContent.add(txtName, gc);
        gc.gridx = 2;
        gc.gridy = 2;
        // txtName.addActionListener(this);
        panelContent.add(txtName1, gc);


        gc.insets = new Insets(3, 3, 3, 3);
        gc.gridx = 2;
        gc.gridy = 3;
        gc.gridwidth = 3;

        panelContent.add(btnn, gc);
        panelContent.setBackground(Color.GRAY);
        panelContent.setBorder(new LineBorder(Color.WHITE));

        gc.gridx = 3;
        gc.gridy = 3;
        gc.gridwidth = 3;
        panelContent.add(btnn1, gc);
        panelBgImg.add(panelContent);

        panelBgImg.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 150));
         setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        Married image = new Married();
        image.BreackgroundImagge();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String value, password, name;
        Sign ab = new Sign();
        value = ae.getActionCommand();
        name = txtName.getText();
        password = txtName1.getText();
        name = name.trim();
        password = password.trim();
        if ("Sign In".equals(value)) {
            ab.Login();
        } else if ("Login".equals(value) && "admin".equals(name) && "ariful".equals(password)) {
             setVisible(false);
            admine am = new admine();
    
        } else if ("Login".equals(value)) {
            try {
                String driver = "com.mysql.jdbc.Driver";
                String myUrl = "jdbc:mysql://localhost/married";
                Class.forName(driver);    
                Connection conn = DriverManager.getConnection(myUrl, "root", "");
                System.out.println("Connected\n");
                Statement stmt = conn.createStatement();
                String query = "select*from login where name = " + "'" + name + "'; ";
                String query2 = "select*from login where password = " + "'" + password + "'; ";
                String query3 = "select email from login where name = " + "'" + name + "'; ";
               
                String uname, upassword,email="";
                ResultSet rs1 = stmt.executeQuery(query3);
                while (rs1.next()) {
                   email= rs1.getString("email");
                }
                boolean found1 = false, found2 = false;
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    found1 = true;
                    rs.getString("name");
                }

                rs = stmt.executeQuery(query2);
                while (rs.next()) {
                    found2 = true;
                    rs.getString("password");
                }

                if (found1 == true && found2 == true) {
                    users as = new users(name,email);
                      System.out.println(email);
                } else {
                    System.out.println("Incorrect Password or name");
                }
                conn.close();
            } catch (ClassNotFoundException | SQLException e) {
                System.err.println("Got an exception!");
                System.err.println(e.getMessage());
            }
            setVisible(false);
          
        }
    }
}
