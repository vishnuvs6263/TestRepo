package TestPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;



public class Jdbc_Connection {

	public static Connection con;
@Test
	public static void JDBC() throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://"+"", "postgres", "12345678");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("SELECT id, \"password\", last_login, is_superuser, is_staff, is_active, date_joined, user_key, username, mobile_number, email, first_name, middle_name, last_name, client_id, activity_status, account_status, is_invited, auth_type\r\n" + 
				"FROM public.auth_manager_user\r\n" + 
				"WHERE id=8;");
		System.out.println(rs.getString("username"));

	}

}
