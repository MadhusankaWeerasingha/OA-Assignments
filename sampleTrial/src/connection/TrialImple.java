package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.Statement;

import sampleTrial.Account;
import sampleTrial.registor;

public class TrialImple extends registor{


	public TrialImple(int userid, String username, String usernic, String Address) {
		super(userid, username, usernic, Address);
		// TODO Auto-generated constructor stub
	}
	private String readSummary="SELECT customer.Name ,trial.Date ,trial.LoanAmount, trial.NoOfPeiriods ,trial.IR ,trial.Rental FROM customer,trial WHERE customer.NIC=trial.CNIC;";
	private String write="INSERT INTO `trial` (`CNIC`, `Date`, `LoanAmount`, `NoOfPeiriods`, `IR`, `Rental`, `TrialID`) VALUES (?, ?, ?, ?, ?, ?, NULL);";

	public void insert(TrialImple trialDaoImpl) {
		JDBCConnection newnew=new JDBCConnection();
		
		Connection conn= (Connection)newnew.getConnection();
		PreparedStatement statement;
		try {
			statement = conn.prepareStatement(this.write);
			statement.setString(1, trialDaoImpl.getUsernic());
			statement.setString(2, trialDaoImpl.getDate());
			statement.setBigDecimal(3, trialDaoImpl.getLoanAmount());
			statement.setInt(4, trialDaoImpl.getNoOfPeiriods());
			statement.setDouble(5, trialDaoImpl.getInterestRate()*100);
			statement.setBigDecimal(6, trialDaoImpl.getRentelAmount());	 
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("");
				System.out.println("Your Trail Calculation is save ");
			}
			else {
				System.out.println("");
				System.out.println("Your Trail Calculation isn't save ");
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	public ResultSet select() {
		ResultSet result=null;	
		JDBCConnection newnew=new JDBCConnection();
		Connection conn = null;
		try {
			conn = (Connection) newnew.getConnection();
		} catch (SQLClientInfoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement statement;
		try {
			statement = conn.prepareStatement(this.readSummary);
			result = statement.executeQuery();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}



	@Override
	public void insert(Account trialImple) {
		// TODO Auto-generated method stub
		
	}


}
