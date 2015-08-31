import java.util.Scanner;


public class SellStocks {

	public static void main(String[] args) {
		System.out.println("This program calculates the net proceeds from a sale of stock");
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter stock price: ");
		double stockPrice = Double.parseDouble(in.nextLine());
		
		System.out.println("Enter number of shares: ");
		int shares = Integer.parseInt(in.nextLine());
		
		System.out.println("Enter commission rate (as a %): ");
		double comRate = Double.parseDouble(in.nextLine()); //commission rate
		
		
		double valueOfShares = stockPrice * shares;
		valueOfShares = Math.round(valueOfShares * 100.0 )/100.0; //rounding to nearest hundreth
		System.out.println("The value of shares is: " + valueOfShares);
		
		double netCom = (comRate/100.0) * valueOfShares; //commission collected
		netCom = Math.round(netCom * 100.0) / 100.0; //rounded to nearest hundreth
		System.out.println("Commission collected: " + netCom);
		
	double netProceeds = valueOfShares - netCom; 
	
	System.out.println("Net proceeds: " + Math.round(netProceeds * 100.0)/100.0);
		
		
		
		
	
		
		
	}

}
