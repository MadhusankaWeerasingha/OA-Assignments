package sampleTrial;

import java.sql.ResultSet;

public abstract class registor {

		private int userid;
		private String username;
		private int usernic;
		private String Address;
		Account account;

		public registor(int userid,String username,int usernic,String Address) {
			this.userid=userid;
			this.username=username;
			this.usernic=usernic;
			this.Address=Address;
		}

		public int getUserid() {
			return this.userid;
		}
		
		public void setUsername(String username) {
			this.username=username;
		}
		public  String getUsername() {
			return this.username;
		}
		
		public int getUsernic() {
			return this.usernic;
		}
		
		public void setAddress(String Address) {
			this.Address=Address;
		}
		public String getAddress() {
			return this.Address;
		}
		
		public void dipaly() {
			System.out.println(" My name is : "+this.username +"\n My NIC number : "+this.usernic);
		}
		
		public abstract void insert(registorImpl registorimpl);
		public abstract ResultSet select();
}
