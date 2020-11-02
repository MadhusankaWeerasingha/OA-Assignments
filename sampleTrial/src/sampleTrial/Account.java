package sampleTrial;

import java.sql.Date;
import java.sql.ResultSet;

public abstract class Account{
	private String accountId;
	private int usernic;
	private double loanAmount;
	private double depositRentalValue;
	private double intersetrate = 12;
	private int repaymentPeroid;
	private double capitalBalance;
	private double rentalvalue;
	private int date;
	
	public  Account(String accountId,double depositRentalValue,int date) {
		this.accountId=accountId;
		this.depositRentalValue=depositRentalValue;
		this.date=date;
	}
	
	public Account(String accountId,double loanAmount,int repaymentPeroid , int date) {
		this.accountId=accountId;
		this.loanAmount=loanAmount;
		this.repaymentPeroid=repaymentPeroid;
		this.date=date;
	}
	
	public String getAccountid() {
		return this.accountId;
	}
	
	public int getUserNic() {
		return this.usernic;
	}
	
	public void setUsernic(int usernic) {
		this.usernic=usernic;
	}
	
	public void setLoanAmount(double loanAmount) {
		this.loanAmount=loanAmount;
	}
	
	public double getLoanAmount() {
		return this.loanAmount;
	}
	public void setDepositRental(String accountId, int depositRentalValue,int date) {
		this.depositRentalValue=depositRentalValue;
	}
	
	public double getDepositRental() {
		return this.depositRentalValue;
	}
	
	
	public void setRepaymentPeroid(int repaymentPeroid) {
		this.repaymentPeroid=repaymentPeroid;
	}
	
	public int getrepaymentPeroid() {
		return this.repaymentPeroid;
	}
	
	public double getCapitalBalance() {
		capitalBalance=capitalBalance+depositRentalValue;
		return this.capitalBalance;
	}
	
	public double getRentalValue() {
		double rental= (loanAmount*((intersetrate/1200))/(1-(1/(Math.pow((1+(intersetrate/1200)),repaymentPeroid)))));
		 rentalvalue=Math.round(rental*100)/100.00;
		return (rentalvalue);
	}
	
	public int getDate() {
		return this.date;
	}
	
	public void setDate(int date) {
		this.date=date;
	}
	public abstract void insert(Account Accountimpl);
	public abstract ResultSet select();

	public void getSehdule() {
		int year=repaymentPeroid/12;
		System.out.println("*************************"+year+" YEAR SCEDULE "+"***********************");
		System.out.println();
		System.out.println();
		System.out.print("Renta No \t" + "Rental Vlaue \t" +"Interest Amount \t"+"Capital Amount \t\t"+"Capital Balance \n");
		System.out.println();
		for(int i=1;i<=repaymentPeroid;i++) {
			double InsterestRate=intersetrate/100;
			double interest_amount=(loanAmount*InsterestRate)/12;
			double capital_amount=(rentalvalue-interest_amount);
			loanAmount=(loanAmount-capital_amount);
		System.out.println(i+"\t\t"+rentalvalue+"\t\t"+Math.round(interest_amount*100)/100.00+"\t\t\t"+Math.round(capital_amount*100)/100.00+"\t\t\t"+Math.round(loanAmount*100)/100.00);
		
	}
	}	
}