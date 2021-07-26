package lwl.ouc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wlli
 * @date 2021/07/26
 */
public class QueryTest {
    static final String jdbcUrl = "jdbc:mysql://localhost:3306/learnjdbc?useSSL=false&characterEncoding=utf8";
    static final String jdbcUsername = "root";
    static final String jdbcPassword = "123456";

    public static void main(String[] args) throws Exception {
        insert();
        List<Student> students = queryStudents();
        students.forEach(System.out::println);
    }

    static List<Student> queryStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            try (
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM students WHERE grade = ? AND score >= ?")) {
                // 第一个参数grade=?
                ps.setInt(1, 1);
                // 第二个参数score=?
                ps.setInt(2, 90);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        students.add(extractRow(rs));
                    }
                }
            }
        }
        return students;
    }

    static Student extractRow(ResultSet rs) throws SQLException {
        Student std = new Student();
        std.setId(rs.getLong("id"));
        std.setName(rs.getString("name"));
        std.setGender(rs.getBoolean("gender"));
        std.setGrade(rs.getInt("grade"));
        std.setScore(rs.getInt("score"));
        return std;
    }

    static void insert() throws SQLException {
        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            try (PreparedStatement ps =
                conn.prepareStatement("INSERT INTO students (grade, name, gender, score) VALUES (?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS)) {
                ps.setObject(1, 1);
                ps.setObject(2, "Bob3");
                ps.setObject(3, 2);
                ps.setObject(4, 93);
                int n = ps.executeUpdate(); // 1
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        long id = rs.getLong(1);
                        System.out.println(id);
                    }
                }
            }
        }
    }

    static void update() throws SQLException {
        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            try (PreparedStatement ps = conn.prepareStatement("UPDATE students SET name=? WHERE id=?")) {
                ps.setObject(1, "Bob");
                ps.setObject(2, 999);
                int n = ps.executeUpdate();
                System.out.println(n);
            }
        }
    }

    static void delete() throws SQLException {
        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            try (PreparedStatement ps = conn.prepareStatement("DELETE FROM students WHERE id=?")) {
                ps.setObject(1, 15);
                int n = ps.executeUpdate();
                System.out.println(n);
            }
        }
    }

}
