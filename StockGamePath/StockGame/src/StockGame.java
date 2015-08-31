import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.text.Caret;
import javax.swing.Timer;	

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


public class StockGame {

	private JFrame frame;
	private JTextField txtStock;
	private JTextField txtHigh;
	private JTextField txtLow;
	private JLabel lblPickAHigh;
	private JTextField txtLong;
	private JLabel lblPickALow;
	private JTextField txtShort;

	private JButton selectShort;
	private JLabel lblNewLabel;
	private JTextField investment1;
	private JButton selectLti1;
	private JLabel lblPickLongTerm_1;
	private JLabel lblPickLongTerm;
	private JTextField investment2;
	private JTextField investment3;
	private JButton selectLti2;
	private JButton selectLti3;
	private JLabel lblNewLabel_1;
	private JTextField lblPoints;
	private JTextField lblShort;
	private JLabel lblNewLabel_2;
	private JTextField lblLong;
	private JLabel lblNewLabel_3;
	private JTextField txtStockCopy;
	private double longLastValue; 
	private double shortLastValue;
	private Timer tmrChecker = new Timer(30000, new CheckLastQuote());
	private int points = 0;
	private JTextField txtLongCopy;
	private JTextField txtShortCopy;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockGame window = new StockGame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StockGame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		points = 0;	
				
		frame = new JFrame();
		frame.setBounds(100, 100, 673, 627);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblStock = new JLabel("Stock");
		lblStock.setBounds(12, 50, 56, 16);
		frame.getContentPane().add(lblStock);

		txtStock = new JTextField();
		txtStock.setBounds(80, 47, 116, 22);
		frame.getContentPane().add(txtStock);
		txtStock.setColumns(10);

		

		JButton btnGetQuote = new JButton("Get Quote");
		btnGetQuote.setBounds(80, 82, 114, 25);
		frame.getContentPane().add(btnGetQuote);
		btnGetQuote.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				getStock();
			}
		});

		JLabel lblHigh = new JLabel("High");
		lblHigh.setBounds(12, 125, 56, 16);
		frame.getContentPane().add(lblHigh);

		JLabel lblLow = new JLabel("Low");
		lblLow.setBounds(12, 154, 56, 16);
		frame.getContentPane().add(lblLow);

		txtHigh = new JTextField();
		txtLow = new JTextField();

		txtHigh.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtHigh.setBackground(Color.GREEN);
		txtHigh.setEditable(false);
		txtHigh.setBounds(80, 122, 116, 22);
		frame.getContentPane().add(txtHigh);
		txtHigh.setColumns(10);

		txtLow.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtLow.setEditable(false);
		txtLow.setColumns(10);
		txtLow.setBackground(Color.GREEN);
		txtLow.setBounds(80, 151, 116, 22);
		frame.getContentPane().add(txtLow);

		lblPickAHigh = new JLabel("Today's long:");
		lblPickAHigh.setBounds(272, 53, 145, 16);
		frame.getContentPane().add(lblPickAHigh);



		txtLong = new JTextField();
		txtLong.setBounds(419, 47, 116, 22);
		frame.getContentPane().add(txtLong);
		txtLong.setColumns(10);

		lblPickALow = new JLabel("Today's short:");
		lblPickALow.setBounds(272, 86, 135, 16);
		frame.getContentPane().add(lblPickALow);

		txtShort = new JTextField();
		txtShort.setBounds(419, 83, 116, 22);
		frame.getContentPane().add(txtShort);
		txtShort.setColumns(10);


		selectShort = new JButton("Select Short");
		selectShort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblShort.setText(getHigh(txtShort.getText()));
				try{
					shortLastValue = Double.parseDouble(lblShort.getText());
					
				} catch (NumberFormatException e){
					e.printStackTrace();
				}
				tmrChecker.start();
			}
		});
		selectShort.setBounds(547, 82, 108, 25);
		frame.getContentPane().add(selectShort);

		lblNewLabel = new JLabel("Pick long term investment #1");
		lblNewLabel.setBounds(209, 357, 183, 16);
		frame.getContentPane().add(lblNewLabel);

		investment1 = new JTextField();
		investment1.setBounds(404, 354, 116, 22);
		frame.getContentPane().add(investment1);
		investment1.setColumns(10);

		

		lblPickLongTerm_1 = new JLabel("Pick long term investment #2");
		lblPickLongTerm_1.setBounds(209, 386, 183, 16);
		frame.getContentPane().add(lblPickLongTerm_1);

		lblPickLongTerm = new JLabel("Pick long term investment #3");
		lblPickLongTerm.setBounds(209, 415, 183, 16);
		frame.getContentPane().add(lblPickLongTerm);

		investment2 = new JTextField();
		investment2.setColumns(10);
		investment2.setBounds(404, 386, 116, 22);
		frame.getContentPane().add(investment2);

		investment3 = new JTextField();
		investment3.setColumns(10);
		investment3.setBounds(404, 418, 116, 22);
		frame.getContentPane().add(investment3);

		selectLti1 = new JButton("Select");
		selectLti1.setBounds(532, 353, 97, 25);
		frame.getContentPane().add(selectLti1);
		
		selectLti2 = new JButton("Select");
		selectLti2.setBounds(532, 382, 97, 25);
		frame.getContentPane().add(selectLti2);
		selectLti2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		

		selectLti3 = new JButton("Select");
		selectLti3.setBounds(532, 411, 97, 25);
		frame.getContentPane().add(selectLti3);

		lblNewLabel_1 = new JLabel("Points:");
		lblNewLabel_1.setBounds(12, 501, 56, 16);
		frame.getContentPane().add(lblNewLabel_1);

		lblPoints = new JTextField();
		lblPoints.setEditable(false);
		lblPoints.setBackground(Color.GREEN);
		lblPoints.setForeground(new Color(0, 0, 0));
		lblPoints.setBounds(80, 498, 116, 22);
		frame.getContentPane().add(lblPoints);
		lblPoints.setColumns(10);

		lblShort = new JTextField(); //shortY is the new value (open price) of your selected short after one day
		lblShort.setBackground(Color.GREEN);
		lblShort.setBounds(419, 233, 116, 22);
		frame.getContentPane().add(lblShort);
		lblShort.setColumns(10);

		JLabel lblNewLlabel = new JLabel("Last value of short:");
		lblNewLlabel.setBounds(257, 236, 135, 16);
		frame.getContentPane().add(lblNewLlabel);

		JButton selectLong = new JButton("Select Long");
		selectLong.setBounds(547, 46, 108, 25);
		frame.getContentPane().add(selectLong);

		lblNewLabel_2 = new JLabel("Last value of long:");
		lblNewLabel_2.setBounds(257, 193, 124, 16);
		frame.getContentPane().add(lblNewLabel_2);

		lblLong = new JTextField();
		lblLong.setBackground(Color.GREEN);
		lblLong.setBounds(419, 190, 116, 22);
		frame.getContentPane().add(lblLong);
		lblLong.setColumns(10);

		lblNewLabel_3 = new JLabel("Stock Game 2D 3D!");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setBackground(Color.BLUE);
		lblNewLabel_3.setBounds(180, 13, 264, 21);
		frame.getContentPane().add(lblNewLabel_3);

		txtStockCopy = new JTextField();
		txtStockCopy.setEditable(false);
		txtStockCopy.setForeground(new Color(0, 0, 0));
		txtStockCopy.setBackground(new Color(0, 128, 0));
		txtStockCopy.setBounds(208, 139, 116, 22);
		frame.getContentPane().add(txtStockCopy);
		txtStockCopy.setColumns(10);
		
		JLabel lblForEvery = new JLabel("Gain .5 points per $5 earned. Lose .5 points per $5 lost.\r\n");
		lblForEvery.setForeground(new Color(0, 0, 0));
		lblForEvery.setBounds(273, 458, 326, 67);
		frame.getContentPane().add(lblForEvery);
		
		txtLongCopy = new JTextField();
		txtLongCopy.setEditable(false);
		txtLongCopy.setBackground(new Color(0, 128, 0));
		txtLongCopy.setBounds(539, 190, 116, 22);
		frame.getContentPane().add(txtLongCopy);
		txtLongCopy.setColumns(10);
		
		txtShortCopy = new JTextField();
		txtShortCopy.setEditable(false);
		txtShortCopy.setBackground(new Color(0, 128, 0));
		txtShortCopy.setBounds(539, 233, 116, 22);
		frame.getContentPane().add(txtShortCopy);
		txtShortCopy.setColumns(10);
		selectLong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				lblLong.setText(getHigh(txtLong.getText()));
				try {
					longLastValue = Double.parseDouble(lblLong.getText());
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				tmrChecker.start();
			}

		});
	}

	private  void getStock() {

		Scanner in;
		try {
			in = new Scanner(new URL("http://www.webservicex.net/stockquote.asmx/GetQuote?symbol=" + 
					txtStock.getText()).openStream());

			String s = "";
			while(in.hasNext()) {
				s += in.next() + " ";
			}
			s = s.replace("&lt;", "<").replace("&gt;", ">");
			in.close();

			txtStockCopy.setText(txtStock.getText());
			txtHigh.setText(getNodeValue(s, "High")); //grabs the (most recent?) high from stahr's stock reader
			txtLow.setText(getNodeValue(s, "Low"));  //grabs the (most recent?) low from stahr's stock reader
			//shortX.setText(getNodeValue(s, "Last")); //setting txtfield of shortX to last value of stock
			//we are doing that for reference, be sure to delete this 
			//do not setShortX= to last in final program!
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//		System.out.println("\n==========================================================");
		//		System.out.printf("Company: %s (%s)\n", getNodeValue(s, "Name") , getNodeValue(s, "Symbol"));
		//		System.out.printf("Last: %s\n" , getNodeValue(s, "Last"));
		//		System.out.printf("Date / Time: %s %s\n" , getNodeValue(s, "Date") , getNodeValue(s, "Time"));
		//		System.out.printf("Change: %s\n", getNodeValue(s, "Change"));
		//		System.out.printf("Open: %s\n", getNodeValue(s, "Open"));
		//		System.out.printf("High: %s  Low: %s\n", getNodeValue(s, "High"), getNodeValue(s, "Low"));
		//		System.out.printf("Volume: %s\n", getNodeValue(s, "Volume"));
		//		System.out.printf("MktCap: %s\n", getNodeValue(s, "MktCap"));
		//		System.out.printf("PreviousClose: %s\n", getNodeValue(s, "PreviousClose"));
		//		System.out.printf("PercentageChange: %s\n", getNodeValue(s, "PercentageChange"));
		//		System.out.printf("AnnRange: %s\n", getNodeValue(s, "AnnRange"));
		//		System.out.printf("Earns: %s\n", getNodeValue(s, "Earns"));
		//		System.out.printf("P-E: %s\n", getNodeValue(s, "P-E"));


	}

	private String readQuote(String ticket) {
		Scanner in;
		try {
			in = new Scanner(new URL("http://www.webservicex.net/stockquote.asmx/GetQuote?symbol=" + ticket).openStream());

			String s = "";
			while(in.hasNext()) {
				s += in.next() + " "; //this x was once an s. Changed to x because we use s in getstock();
			}
			s = s.replace("&lt;", "<").replace("&gt;", ">");
			in.close();
			return s;
		} catch(Exception e) {
			return "Error";
		}
	}

	private String getHigh(String ticket) {
		txtLongCopy.setText(txtLong.getText());
		return getNodeValue(readQuote(ticket),"Last");
		


	}

	private String getLow(String ticket) {
		txtShortCopy.setText(txtShort.getText());
		return getNodeValue(readQuote(ticket),"Low");

	}

	private class CheckLastQuote implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Time!...");
			//lblLong.setText(getHigh(txtLong.getText()));
			//if(txtHigh.getText().trim().length() == 0) return;
			
			double lv;
			double sv;
			
			try {
				lv = Double.parseDouble(getHigh(txtLong.getText()));
				if(lv > longLastValue)
					points++;
				else if(lv < longLastValue)
					points--;
				
				longLastValue = lv;
				lblLong.setText("" + longLastValue);
				lblPoints.setText("" + points);
				
				sv = Double.parseDouble(getLow(txtShort.getText()));
				if(sv > shortLastValue)
					points++;
				else if(lv < shortLastValue)
					points--;
				
				shortLastValue = sv;
				lblShort.setText("" + shortLastValue);
				lblPoints.setText("" + points);
				
			} catch(Exception ex) {
				System.out.println("Get Last failed to read");
			}
			
		}
		
	}



	private static String getNodeValue(String xml, String node) {
		String tmp = xml.toLowerCase();
		node = node.toLowerCase();
		int start = tmp.indexOf("<" + node) + node.length() + 2;
		int end = tmp.indexOf("</" + node, start);


		if(start == -1 || end == -1) return "na";

		return xml.substring(start, end);
	}
}
