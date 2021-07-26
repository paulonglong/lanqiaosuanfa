package lwl.ouc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * @author wlli
 * @date 2021/07/26
 */
public class ConnectionPoolTest {
    public static void main(String[] args) throws SQLException {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/learnjdbc?useSSL=false&characterEncoding=utf8");
        config.setUsername("root");
        config.setPassword("123456");
        // 连接超时：1秒
        config.addDataSourceProperty("connectionTimeout", "1000");
        // 空闲超时：60秒
        config.addDataSourceProperty("idleTimeout", "60000");
        // 最大连接数：10
        config.addDataSourceProperty("maximumPoolSize", "10");
        DataSource ds = new HikariDataSource(config);
        List<Student> students = new ArrayList<>();
        try (Connection conn = ds.getConnection()) {
            try (
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM students WHERE grade = ? AND score >= ?")) {
                // 第一个参数grade=?
                ps.setInt(1, 1);
                // 第二个参数score=?
                ps.setInt(2, 90);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        students.add(QueryTest.extractRow(rs));
                    }
                }
            }
        }
        students.forEach(System.out::println);
    }
}
