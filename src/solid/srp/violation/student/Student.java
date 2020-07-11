package solid.srp.violation.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Student {

    private String id;
    private String name;
    private String address;

    public void save() {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDB", "root", "password");

            statement = connection.createStatement();
            statement.execute("INSERT INTO student VALUES (" + this.getId() + ", '" + this.getName() + "', '" + this.getAddress() + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
