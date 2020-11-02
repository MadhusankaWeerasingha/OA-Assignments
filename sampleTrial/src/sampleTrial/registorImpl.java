package sampleTrial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.JDBCConnection;

public class registorImpl extends registor{
	private String SNic="SELECT * FROM `registor` WHERE `usernic`=?;";
	private String InsertReg="INSERT INTO `registor`(`usernic`, `userName`, `Address`) VALUES (?,?,?);";

	public registorImpl(int userid, String username, int usernic, String Address) {
		super(userid, username, usernic, Address);
		
	}

	@Override
	public void insert(registorImpl registorimpl) {
		JDBCConnection input=new JDBCConnection();
		Connection conn= (Connection) JDBCConnection.getConnection();		
			try {
				PreparedStatement statement = conn.prepareStatement(this.InsertReg);
				statement.setString(1, registorimpl.getUsernic());
				statement.setString(2, registorimpl.getUsername());
				statement.setString(3, registorimpl.getAddress());
				
				int rowsInserted = statement.executeUpdate();
				if (rowsInserted > 0) {
					System.out.println(" Saved");
				}
				else {
					System.out.println(" Save fail");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		

	@Override
	public ResultSet select() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
