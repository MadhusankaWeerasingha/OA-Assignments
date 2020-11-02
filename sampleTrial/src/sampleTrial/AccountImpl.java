package sampleTrial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.JdbcConnection;

import connection.JDBCConnection;

public class AccountImpl extends Account {
	
	public AccountImpl(String accountId, double loanAmount, int repaymentPeroid, int date) {
		super(accountId, loanAmount, repaymentPeroid, date);
		// TODO Auto-generated constructor stub
	}

	private String SNic="SELECT * FROM `registor` WHERE `usernic`=?;";
	private String InsertAcc="INSERT INTO `account`(`AccountId`, `usernic`, `Deposit`, `Irate`, `paymentPeriod`, `date`) VALUES (?,?,?,12,?,?);";

	

	@Override
	public void insert(Account Accountimpl) {
		JDBCConnection newjdbcc=new JDBCConnection();
		Connection conn= (Connection) JDBCConnection.getConnection();
		PreparedStatement statement;
		try {
			statement = conn.prepareStatement(this.InsertAcc);
			statement.setString(1,Accountimpl.getAccountid());
			statement.setInt(2,Accountimpl.getUserNic());
			statement.setDouble(3, Accountimpl.getLoanAmount());
			statement.setInt(4, Accountimpl.getrepaymentPeroid());
			statement.setInt(5, Accountimpl.getDate());	 
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("");
				System.out.println(" save ");
			}
			else {
				System.out.println("");
				System.out.println("not save ");
			}
		} 
		catch (SQLException e) {
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
