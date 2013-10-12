import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DBConnection {
	private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://211.68.122.45:3306/misp?zeroDateTimeBehavior=convertToNull";
	private static final String DATABASE_USER = "root";
	private static final String DATABASE_PASSWORD = "mysql55";

	private Connection con = null;

	public Connection getConnection() {
		try {
			Class.forName(DRIVER_CLASS);
			con = DriverManager.getConnection(DATABASE_URL, DATABASE_USER,
					DATABASE_PASSWORD);
			System.out.println(DATABASE_URL + " is OK");
		} catch (Exception ex) {
			System.out.println("2:" + ex.getMessage());
		}
		return con;
	}

	public static void main(String[] args) throws SQLException {
		DBConnection dbc = new DBConnection();
		Connection con = dbc.getConnection();
		Calendar c = Calendar.getInstance();
		c.setTime(new Date(2013-1900, 1, 1));
		while (c.get(Calendar.YEAR) != 2015) {
			String timeFormat = new SimpleDateFormat("yyyy-MM-dd").format(c
					.getTime());
			String sql = "INSERT INTO `ut_calendar` (`day`) VALUES ('"
					+ timeFormat + "')";
			System.out.println(sql);
			con.createStatement().execute(sql);
			c.add(Calendar.DATE, 1);
		}

	}
}
