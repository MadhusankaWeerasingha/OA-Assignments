package sampleTrial;

public class UserTest {

	public static void main(String[] args) {
		
		registorImpl user1=new registorImpl(001, "Dinesh", 954489655, "Udawalawa");
		user1.dipaly();
		
		System.out.println();
		System.out.println();
		
		registorImpl user2=new registorImpl(002,"Kamal",950930640,"Colombo");
		user2.dipaly();
		
		System.out.println();
		System.out.println();
		
		AccountImpl Ac1=new AccountImpl("AC01",1000000,12,2020-10-20);
		
		user1.account=Ac1;
		
		System.out.println("Custormer name is : "+user1.getUsername()+"\n He got a Loan : "+Ac1.getLoanAmount()+
				"\n We want to pay rental value is : "+Ac1.getRentalValue()); 
		
		System.out.println();
		System.out.println();
		
		Ac1.getSehdule();
	}

}
      