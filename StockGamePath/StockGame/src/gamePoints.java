public class gamePoints {

	
	
	public static int points = 0;
	public static boolean shortedStock;
	public static boolean longedStock;
	
	/* If the user correctly predicts that a certain stock will
	 * decrease in value(short), he gets a point.
	 * If he's wrong, he loses a point.
	 * If the user correctly predicts that a certain stock will
	 * increase in value(long), he gets a point.
	 * If he's wrong, he loses a point.
	 */
	public static void shortLong(){
		if(shortedStock == true){
			points += 1;
		} else points -= 1;
		
		if(longedStock == true){
			points += 1;
		} else points -=1;		
	}
	
	
	
	
	
	
	}