import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class StockGameV1{
	public int points = 0;



	public static void main(String args[]) throws Exception {
		ArrayList<String> stocks = new ArrayList<String>();

		String symbol;
		while(true) {
			symbol = JOptionPane.showInputDialog("Enter Stock Symbol (hit enter to quit)", "");
			if(symbol.trim().length() == 0) break;
			stocks.add(symbol.toUpperCase());
		}
		Scanner in;

		for(String stock :  stocks) {
			in = new Scanner(new URL("http://www.webservicex.net/stockquote.asmx/GetQuote?symbol=" + stock).openStream());

			String s = "";
			while(in.hasNext()) {
				s += in.next() + " ";
			}
			s = s.replace("&lt;", "<").replace("&gt;", ">");

			System.out.println("\n==========================================================");
			System.out.printf("Company: %s (%s)\n", getNodeValue(s, "Name") , getNodeValue(s, "Symbol"));
			System.out.printf("Last: %s\n" , getNodeValue(s, "Last"));
			System.out.printf("Date / Time: %s %s\n" , getNodeValue(s, "Date") , getNodeValue(s, "Time"));
			System.out.printf("Change: %s\n", getNodeValue(s, "Change"));
			System.out.printf("Open: %s\n", getNodeValue(s, "Open"));
			System.out.printf("High: %s  Low: %s\n", getNodeValue(s, "High"), getNodeValue(s, "Low"));
			System.out.printf("Volume: %s\n", getNodeValue(s, "Volume"));
			System.out.printf("MktCap: %s\n", getNodeValue(s, "MktCap"));
			System.out.printf("PreviousClose: %s\n", getNodeValue(s, "PreviousClose"));
			System.out.printf("PercentageChange: %s\n", getNodeValue(s, "PercentageChange"));
			System.out.printf("AnnRange: %s\n", getNodeValue(s, "AnnRange"));
			System.out.printf("Earns: %s\n", getNodeValue(s, "Earns"));
			System.out.printf("P-E: %s\n", getNodeValue(s, "P-E"));

			in.close();
		}

	}

	/*
	public class gamePoints {
		boolean shortedStock;
		boolean longedStock;

		if (shortedStock == true) {
			points += 1;
		}
		else{
			points-=1;
		}

		if (longedStock == true){
			points += 1;
		}
		else{
			points -= 1;
		}

	}
	*/ 	


	private static String getNodeValue(String xml, String node) {
		String tmp = xml.toLowerCase();
		node = node.toLowerCase();
		int start = tmp.indexOf("<" + node) + node.length() + 2;
		int end = tmp.indexOf("</" + node, start);


		if(start == -1 || end == -1) return "na";

		return xml.substring(start, end); /*Maybe this should not be returned.
		 *I don't want the program to end yet.
		 *still need to ask user for # shares, etc
		 */


	}





}


//Read more: http://javarevisited.blogspot.com/2011/12/parse-xml-file-in-java-example-tutorial.html#ixzz3LYU3yFpO
/*prompt the user to type in name
 *every day, give the user 5 points if he makes a profit....
 *	actually, consider making this program similar to GameofStocks
 */ 