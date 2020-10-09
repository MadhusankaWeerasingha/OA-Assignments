import java.util.Scanner;
public class TestTrialCalculation {

	public static void main(String[] args) {
		
		double LoanAmount;
		int RepaymentPeriod;
		double InsterestRat;
		
		Scanner input = new Scanner(System.in);
		System.out.print(" What you want to Loan Amount : ");
		LoanAmount = input.nextDouble();
		
		Scanner input2 = new Scanner(System.in);
		System.out.print(" What you want to Repayment Period : ");
		RepaymentPeriod = input2.nextInt();
		
		Scanner input3=new Scanner(System.in);
		System.out.print(" Insterest Rate ");
		InsterestRat =input3.nextDouble();
		
		double rental= (LoanAmount*((InsterestRat/1200))/(1-(1/(Math.pow((1+(InsterestRat/1200)),RepaymentPeriod)))));
		double rentalvalue=Math.round(rental*100)/100.00;
		System.out.println(rentalvalue);
		
		
		System.out.println();
		
		System.out.print("Renta No \t" + "Rental Vlaue \t" +"Interest Amount \t"+"Capital Amount \t\t"+"Capital Balance \n");
		
		for(int i=1;i<=RepaymentPeriod;i++) {
			double InsterestRate=InsterestRat/100;
			double interest_amount=(LoanAmount*InsterestRate)/12;
			double capital_amount=(rentalvalue-interest_amount);
			double capital_balance=(LoanAmount-capital_amount);
			
			
			System.out.println(i+"\t\t"+rentalvalue+"\t\t"+Math.round(interest_amount*100)/100.00+"\t\t\t"+Math.round(capital_amount*100)/100.00+"\t\t\t"+Math.round(capital_balance*100)/100.00);
						
		}
	}

}
