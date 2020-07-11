package solid.srp.solution.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class StudentRepository {
    public void save(Student student) {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDB", "root", "password");

            statement = connection.createStatement();
            statement.execute("INSERT INTO student VALUES (" + student.getId() + ", '" + student.getName() + "', '" + student.getAddress() + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
