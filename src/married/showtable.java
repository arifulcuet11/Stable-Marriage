package married;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class showtable extends JFrame implements ActionListener {

    JButton btn1, btn2;
    String query = "select a.name,a.father_name, a.email,a.phone,a.birthday,a.hair_color,"
            + "a.weight,a.hight,a.age,g.gender_name, b.District_name,e.education,"
            + "o.occapation from general_info a join district b"
            + " on a.district_id = b.District_id join  education_info e "
            + "on a.educattion_id = e.educattion_id join gender_info g "
            + "on a.gender_id = g.gender_id join occupation o "
            + "on a.occupation_id = o.occupation_id where a.email = ";
    String query3 = "delete from  general_info where email IN (";
    String[] columnNames = {"Name", "Father Name", "Email", "Phone", "BirthDay", "Hair Color", "Weight", "Hight", "Age", "Gender", "District", "Education", "Occupation"};
    //   Object[][] data;
    private Vector data;

    Vector getTable(ResultSet res) {
        try {
            ResultSetMetaData metaData = res.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            Vector<Vector<String>> data = new Vector<Vector<String>>();

            while (res.next()) {
                Vector<String> newRow = new Vector<String>();
                for (int i = 1; i <= numberOfColumns; i++) {
                    newRow.addElement(res.getObject(i).toString());
                }
                data.addElement(newRow);
            }

            return data;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    JTable table, tb;

    void showprofile(String email) {
      
        setSize(1000, 200);
        setVisible(true);
        setTitle("PROFILE");

        try {
            String driver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost/married";
            Class.forName(driver);
            try (Connection conn = DriverManager.getConnection(myUrl, "root", "")) {
                System.out.println("Connected\n");
                Statement stmt = conn.createStatement();
                query = query + "'" + email + "';";
                ResultSet rs = stmt.executeQuery(query);
                Vector<Vector<String>> data = getTable(rs);
                table = new JTable(data, new Vector(Arrays.asList(columnNames)));
                table.setPreferredScrollableViewportSize(new Dimension(500, 50));
                table.setFillsViewportHeight(true);
                JScrollPane scrollPane = new JScrollPane(table);
                add(scrollPane);
                conn.close();
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }


    }

    void search(String gnd, String div, int age1, int age2, String ocpp, int x) {
        String query1 = "select a.name,a.father_name, a.email,a.phone,a.birthday,a.hair_color,"
                + "a.weight,a.hight,a.age,g.gender_name, b.District_name,e.education,"
                + "o.occapation from general_info a join district b"
                + " on a.district_id = b.District_id join  education_info e "
                + "on a.educattion_id = e.educattion_id join gender_info g "
                + "on a.gender_id = g.gender_id join occupation o "
                + "on a.occupation_id = o.occupation_id where  a.age between " + age1 + " and " + age2;

        if (!gnd.equals("0")) {
            query1 = query1 + " and g.gender_name = '" + gnd + "' ";

        }
        if (!div.equals("0")) {
            query1 = query1 + " and  b.District_name= '" + div + "' ";
        }
        if (!ocpp.equals("0")) {
            query1 = query1 + " and o.occapation= '" + ocpp + "'";
        }
        query1 = query1 + ";";
        System.out.print(query1);
        setSize(1000, 200);
        setVisible(true);
        setTitle("JTable Output");
        btn1 = new JButton("Delete");

        try {
            String driver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost/married";
            Class.forName(driver);
            try (Connection conn = DriverManager.getConnection(myUrl, "root", "")) {
                System.out.println("Connected\n");
                Statement stmt = conn.createStatement();

                ResultSet rs = stmt.executeQuery(query1);
                Vector<Vector<String>> data = getTable(rs);
                table = new JTable(data, new Vector(Arrays.asList(columnNames)));
                table.setPreferredScrollableViewportSize(new Dimension(500, 50));
                table.setFillsViewportHeight(true);

              

                JScrollPane scrollPane = new JScrollPane(table);
                add(scrollPane, BorderLayout.CENTER);
                if (x == 0) {
                    add(btn1, BorderLayout.PAGE_END);
                    btn1.addActionListener(this);

                }

                conn.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }


    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String value = ae.getActionCommand();
        int row[] = table.getSelectedRows();
        System.out.println(row.length);
        String query1 = "";
        JScrollPane scrollPane = new JScrollPane();
        for (int i = 0; i < row.length; i++) {
            query1 = query1 + "'" + table.getValueAt(i, 2).toString() + "'";
            if (i < row.length - 1) {
                query1 += ",";
            }
        }
        query1 = query1 + ");";
        if (value.equals("Delete")) {
            try {
                String driver = "com.mysql.jdbc.Driver";
                String myUrl = "jdbc:mysql://localhost/married";
                Class.forName(driver);
                try (Connection conn = DriverManager.getConnection(myUrl, "root", "")) {
                    Statement stmt = conn.createStatement();
                    query3 = query3+query1;
                    System.out.println(query3);
                    stmt.execute(query3);
                      JOptionPane.showMessageDialog(null, "Delete Complete");
                    conn.close();
                }

            } catch (ClassNotFoundException | SQLException e) {
                System.err.println("Got an exception!");
                System.err.println(e.getMessage());
            }
        }

    }
}
