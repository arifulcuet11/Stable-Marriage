package married;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class userreg extends JFrame implements ActionListener {

    String find = "SELECT * FROM general_info WHERE  email = ";
    String find2 = "SELECT * FROM female WHERE  email=";
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l21;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10, tf11, tf12, tf13, tf14, tf15, tf16, p1, p2, gnder;
    JButton btn1, btn2;
    //  JPasswordField p1, p2;
    JRadioButton Male = new JRadioButton("Male");
    JRadioButton Female = new JRadioButton("Female");
    ButtonGroup bg1 = new ButtonGroup();
    JComboBox c = new JComboBox();
    String d;

/////////////////////////////////////////////////////////////////////////////////////////////////////////
    void Login(String b) {
        d=b;
        setVisible(true);
        setSize(700, 900);
        setLayout(null);
        setTitle("Registration Form in Java");
        l1 = new JLabel("Registration Form ");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));
        l2 = new JLabel("Name:");
        l3 = new JLabel("Email-ID:");
        l4 = new JLabel("Father's Name:");
        l5 = new JLabel("division:");
        l6 = new JLabel("Phone No:");
        l7 = new JLabel("BirthDay");
        l8 = new JLabel("Hair Color");
        l9 = new JLabel("Weight: ");
        l10 = new JLabel("Hight:");
        //l11 = new JLabel("Hight:");
        l12 = new JLabel("Age");
        l13 = new JLabel("Gender");
        l14 = new JLabel("Education");
        l15 = new JLabel("Occupation");
      
        tf1 = new JTextField();
        tf2 = new JTextField();
        p1 = new JTextField();
        p2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        tf7 = new JTextField();
        tf8 = new JTextField();
        tf9 = new JTextField();
        tf10 = new JTextField();
        tf11 = new JTextField();
        tf12 = new JTextField();
        tf13 = new JTextField();
        tf14 = new JTextField();
        tf15 = new JTextField();
       
        gnder = new JTextField();
        btn1 = new JButton("Submit");
        btn2 = new JButton("Clear");

/////////////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////////////////////////////
        l1.setBounds(100, 30, 400, 30);
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        l4.setBounds(80, 150, 200, 30);
        l5.setBounds(80, 190, 200, 30);
        l6.setBounds(80, 230, 200, 30);
        l7.setBounds(80, 270, 200, 30);
        l8.setBounds(80, 310, 200, 30);
        l9.setBounds(80, 350, 200, 30);
        l10.setBounds(80, 390, 200, 30);
  
        l12.setBounds(80, 440, 200, 30);
        l13.setBounds(80, 480, 200, 30);
        l14.setBounds(80, 510, 200, 30);
        l15.setBounds(80, 540, 200, 30);
       


        tf1.setBounds(300, 70, 200, 30);
        tf2.setBounds(300, 110, 200, 30);
        tf3.setBounds(300, 150, 200, 30);
        tf4.setBounds(300, 190, 200, 30);
        tf5.setBounds(300, 230, 200, 30);
        tf6.setBounds(300, 270, 200, 30);
        tf7.setBounds(300, 310, 200, 30);
        tf8.setBounds(300, 350, 200, 30);
        tf9.setBounds(300, 390, 200, 30);
        //   gnder.setBounds(300, 340, 200, 30);
        // Female.setBounds(300, 360, 200, 30);
        tf10.setBounds(300, 430, 200, 30);
        tf11.setBounds(300, 470, 200, 30);
        tf12.setBounds(300, 510, 200, 30);
        tf13.setBounds(300, 540, 200, 30);
        tf2.setText(d);
        tf2.setEditable(false);
     

        btn1.setBounds(300, 660, 100, 30);

//................................................................................................


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
        add(l7);
        add(tf4);
        add(l8);
        add(tf5);
        add(tf6);
        add(l9);
        add(l10);
       // add(l11);
        add(l12);
        add(l13);
        add(l14);
        add(l15);
       
//        add(l17);
//        add(l19);
        add(tf7);
        add(tf8);
        add(tf9);
        add(tf10);
        add(tf11);
        add(tf12);
        add(tf13);
      
        add(gnder);
        add(btn1);
        add(c);
        ///////////////////////////////////////////////////////////////////////////////////////////
        btn1.addActionListener(this);
    }
//........................................................................................................

    public void actionPerformed(ActionEvent ae) {
        String value, name, email, father, mother, district, phone, age, weight, hight, yourself, hobby, gender, occupation, education, birthday, heir;
        Sign ab = new Sign();
        value = ae.getActionCommand();
        name = tf1.getText();
        email = d;
        father = tf3.getText();
        district = tf4.getText();
        phone = tf5.getText();
        birthday = tf6.getText();
        heir = tf7.getText();
        weight = tf8.getText();
        hight = tf9.getText();
        age = tf10.getText();
        gender = tf11.getText();
        education = tf12.getText();
         occupation= tf13.getText();
        
        //..............................................................................................

        String general = " insert into general_info (name,father_name,mother_name,Gender,birthday)"
                + " values (?, ?, ?, ?, ?)";
        String gend = " insert into  gender_info (gender_name)"
                + " values (?)";
        String dist = " insert into district (District_name)"
                + " values (?)";
        String edu = " insert into education_info (education)"
                + " values (?)";
        String occap = " insert into occupation (occapation)"
                + " values (?)";
        String dist_in = "SELECT * FROM district WHERE  District_name = ";
        String gender_in = "SELECT * FROM gender_info  WHERE  gender_name = ";
        String edu_in = "SELECT * FROM education_info  WHERE education = ";
        String occap_in = "SELECT * FROM occupation  WHERE occapation = ";
        String eml = " SELECT * FROM general_info WHERE email = ";
        
       
        
        
        
        

        String persion = "INSERT INTO general_info(email, name, father_name, phone, birthday, hair_color, weight, hight, age,gender_id, Occupation_id,District_id, Educattion_id)"
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String distt = "(select District_id  from district  where District_name= " + "'" + district + "'),";
        String genderr = "(select gender_id from gender_info where gender_name= "+"'"+gender+"')";
        String educc = "(select Educattion_id  from education_info  where  education =" + "'" + education + "'),";
        String occapp = "(select Occupation_id  from occupation where occapation=" + "'" + occupation + "')";

        
         String query ="INSERT INTO `general_info`(`email`, `name`, `father_name`, `phone`, `birthday`, `hair_color`, `weight`, `hight`, `age`, `gender_id`, `Occupation_id`, `District_id`, `Educattion_id`) VALUES ('"+email+"','"+name+"','"+father+"','"+phone+"','"+birthday+"','"+heir+"',"+weight+",'"+hight+"',"+age+","
+"(select gender_id from gender_info where gender_name="+"'"+ gender+"'),"
+"(select Occupation_id  from occupation where occapation="+"'"+occupation+"'),"
+"(select District_id  from district  where  	District_name="+"'"+district+"'),"
+"(select Educattion_id  from education_info  where  education ="+"'"+education+"'))";
//...............................................................................................................

        if ("Submit".equals(value)) {
            try {
                String driver = "com.mysql.jdbc.Driver";
                String myUrl = "jdbc:mysql://localhost/married";
                Class.forName(driver);
                try (Connection conn = DriverManager.getConnection(myUrl, "root", "")) {
                    System.out.println("Connected\n");
                    Statement stmt = conn.createStatement();

                    occap_in = occap_in + "'" + occupation + "';";
                    ResultSet rs4 = stmt.executeQuery(occap_in);
                    if (!rs4.next()) {
                        PreparedStatement preparedStmt = conn.prepareStatement(occap);
                        preparedStmt.setString(1, occupation);
                        preparedStmt.execute();
                    }

                    //....................................................

                    dist_in = dist_in + "'" + district + "';";
                    ResultSet rs = stmt.executeQuery(dist_in);
                    if (!rs.next()) {
                        PreparedStatement preparedStmt1 = conn.prepareStatement(dist);
                        preparedStmt1.setString(1, district);
                        preparedStmt1.execute();
                    }


                    //''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
                    edu_in = edu_in + "'" + education + "';";
                    ResultSet rs2 = stmt.executeQuery(edu_in);
                    if (!rs2.next()) {
                        PreparedStatement preparedStmt2 = conn.prepareStatement(edu);
                        preparedStmt2.setString(1, education);
                        preparedStmt2.execute();
                    }


                    //'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
                    gender_in = gender_in + "'" + gender + "';";
                    ResultSet rs3 = stmt.executeQuery(gender_in);
                    if (!rs3.next()) {
                        PreparedStatement preparedStmt3 = conn.prepareStatement(gend);
                        preparedStmt3.setString(1, gender);
                        preparedStmt3.execute();
                    }
                    //.......................................................................................
                    eml = eml + "'" + email + "';";
                    ResultSet rs5 = stmt.executeQuery(eml);
                    if (rs5.next()) {
                        JOptionPane.showMessageDialog(null, "Email Alreay Exist!!!!");
                    } else {
                         stmt.executeUpdate(query);                   
                          JOptionPane.showMessageDialog(null, "Registration Complete");
                          setVisible(false);
                    }

                }
            } catch (ClassNotFoundException | SQLException e) {
                System.err.println("Got an exception!");
                System.err.println(e.getMessage());
            }

        }
    }
}
