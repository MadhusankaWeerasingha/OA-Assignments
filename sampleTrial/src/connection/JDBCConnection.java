package connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCConnection {

private static JDBCConnection Connection;

public static JDBCConnection getConnection() {
	try {
		Connection=(JDBCConnection) DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return Connection;
}

public static void closeConection(JDBCConnection con) throws SQLException {
	if(con!=null) {
		
	}
}
public static void closePrepaerdStatement(PreparedStatement stmt)throws SQLException{
	if(stmt!=null) {
		stmt.close();
	}
}
public static void closeResultSet(ResultSet rs) throws SQLException{
	if(rs!=null) {
		rs.close();
	}
}
}
