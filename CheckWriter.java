import java.util.Scanner;
	public class CheckWriter{
		public static void main(String[] args){
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter your name: ");				//asks user for name
			String name = scan.nextLine();
			System.out.print("Enter the date: ");				//asks user for date
			String date = scan.nextLine();		
			System.out.print("Enter money amount <0 and 999,999,999.99>: "); //prints money amount 
			double money = scan.nextDouble();				 //asks user for money amount 
			System.out.println("\n\n\n----"); 				//spacing for seperation 
			
			int number = (int) money; 					//converting user's double input to an int
			
			int lastThreeDigits = number % 1000; 				//getting last three digits of input 
			int middleThreeDigits = (number/1000) % 1000; 			//getting middle three digits of input
			int firstThreeDigits = number/1000000; 				//getting first three digits of input
			
			int lastThreeHundredsDigits = lastThreeDigits/100; 		//getting last hundreds digit
			int lastThreeTensDigits = (lastThreeDigits/10) % 10; 		//getting last tens digit
			int lastThreeOnesDigits = lastThreeDigits % 10; 		//getting last ones digit
			
			int middleThreeHundredsDigits = middleThreeDigits/100;		//getting middle hundreds digit
			int middleThreeTensDigits = (middleThreeDigits/10) % 10;	//getting middle tens digit
			int middleThreeOnesDigits = middleThreeDigits % 10;		//getting middle ones digit
			
			int firstThreeHundredsDigits = firstThreeDigits/100;		//getting first hundreds digit
			int firstThreeTensDigits = (firstThreeDigits/10) % 10;		//getting first tens digit
			int firstThreeOnesDigits = firstThreeDigits % 10;		//getting first ones digit
			
			String[] arrayHundreds = {"", "One Hundred ", "Two Hundred ", "Three Hundred ", "Four Hundred ", "Five Hundred ", "Six Hundred ", "Seven Hundred ", "Eight Hundred ", "Nine Hundred "};	//Initializing array for hundreds
			String[] arrayTens = {"", "", "Twenty ", "Thirty ", "Fourty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};									//Initializing array for tens
			String[] arrayOnes = {"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine "};										//Initializing array for ones
			String[] arrayTeens = {"Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};						//Initializing array for teens
			
			System.out.print("Pay to the order of: " + name);
			System.out.print("\t\t\t\t" + "Date: " + date);
			System.out.println("");
			
			int millions1 = firstThreeOnesDigits;			//new variable for million
			int millions2 = firstThreeTensDigits;			//new variable for ten million
			int millions3 = firstThreeHundredsDigits;		//new variable for hundred million
			int thousands1 = middleThreeOnesDigits;			//new variable for thousand
			int thousands2 = middleThreeTensDigits;			//new variable for ten thousand
			int thousands3 = middleThreeHundredsDigits;		//new variable for hundred thousand
			

			if(number > 1000000 && number < 10000000){
				if(middleThreeTensDigits == 1){
					System.out.print(arrayOnes[millions1] + "Million " + arrayHundreds[thousands3] + arrayTeens[middleThreeOnesDigits] + "Thousand " ); 		//accounting for teens inside millions amount					
				}else if(lastThreeTensDigits == 1){
					System.out.print(arrayOnes[millions1] + "Million " + arrayHundreds[thousands3] + "Thousand " + arrayTeens[lastThreeOnesDigits]); 
				}else if(middleThreeTensDigits == 1 && lastThreeTensDigits == 1){
					System.out.print(arrayOnes[millions1] + "Million " + arrayHundreds[thousands3] + arrayTeens[middleThreeOnesDigits] + "Thousand " + arrayTeens[lastThreeOnesDigits]); 
				}else{		
					System.out.print(arrayOnes[millions1] + "Million " + arrayHundreds[thousands3] + arrayTens[thousands2] + arrayOnes[thousands1] + "Thousand " ); 			
				}
			}
			if(number > 10000000 && number < 100000000){
				if(middleThreeTensDigits == 1){
					System.out.print(arrayTens[millions2] + arrayOnes[millions1] + "Million" + arrayHundreds[thousands3] + arrayTeens[middleThreeOnesDigits] + "Thousand ");	//accounting for teens inside millions amount					
				}else if(firstThreeTensDigits == 1){
					System.out.print(arrayTeens[firstThreeOnesDigits]  + "Million " + arrayHundreds[thousands3] + arrayTens[thousands2] + arrayOnes[thousands1] + "Thousand ");
				}else if(lastThreeTensDigits == 1){
					System.out.print(arrayOnes[millions1] + "Million " + arrayHundreds[thousands3] + arrayTeens[middleThreeOnesDigits] + "Thousand " + arrayHundreds[thousands3] + arrayTeens[lastThreeOnesDigits]); 
				}else{
					System.out.print(arrayTens[millions2] + arrayOnes[millions1] + "Million " + arrayHundreds[thousands3] + arrayTens[thousands2] + arrayOnes[thousands1] + "Thousand ");
				}
			}
			if(number > 100000000){	
				if(firstThreeTensDigits == 1){
					System.out.print(arrayHundreds[millions3] + arrayTeens[firstThreeOnesDigits] + "Million " + arrayHundreds[thousands3] + arrayTeens[middleThreeOnesDigits] + "Thousand ");			//accounting for teens inside millions amount					
				}else if(middleThreeTensDigits == 1){
					System.out.print(arrayHundreds[millions3] + arrayTens[millions2] + arrayOnes[millions1] + "Million " + arrayHundreds[thousands3] + arrayTens[thousands2] + arrayOnes[thousands1] + "Thousand ");	
				}else{
					System.out.print(arrayHundreds[millions3] + arrayTens[millions2] + arrayOnes[millions1] + "Million " + arrayHundreds[thousands3] + arrayTens[thousands2] + arrayOnes[thousands1] + "Thousand ");	
				}													
			}
			if(number >= 1000 && number < 10000){	
	
				if(lastThreeTensDigits == 1){
					System.out.print(arrayOnes[thousands1] + "Thousand " + arrayHundreds[lastThreeHundredsDigits] + arrayTeens[lastThreeOnesDigits]);		//accounting for teens inside thousands amount
				}else{
					System.out.print(arrayOnes[thousands1] + "Thousand " + arrayHundreds[lastThreeHundredsDigits] + arrayTens[lastThreeTensDigits] + arrayOnes[lastThreeOnesDigits]); 		
				}
			}
			if(number >= 10000 && number < 100000){
				
				if(middleThreeOnesDigits > 0 && middleThreeOnesDigits < 10){					//accounting for teens inside thousands amount
					System.out.print(arrayTeens[middleThreeOnesDigits] + "Thousand ");
				}else if(middleThreeOnesDigits > 0 && middleThreeOnesDigits < 10 && lastThreeTensDigits == 1){
					System.out.print(arrayTeens[middleThreeOnesDigits] + arrayTeens[lastThreeOnesDigits] + "Thousand ");
				}
				if(lastThreeTensDigits == 1){
					System.out.print(arrayTeens[lastThreeTensDigits] + "Thousand ");			//accounting for teens inside thousands amount
				}else if(lastThreeTensDigits != 1 && middleThreeOnesDigits > 10){
					System.out.print(arrayTens[thousands2] + arrayOnes[thousands1] + "Thousand ");		
				}
			}
			if(number >= 100000 && number < 1000000){ 
				
				if(middleThreeTensDigits == 1 && lastThreeTensDigits == 1){
					System.out.print(arrayHundreds[thousands3] + arrayTeens[middleThreeOnesDigits] + arrayTeens[lastThreeOnesDigits] + "Thousand ");	
				}else if(lastThreeTensDigits == 1){
					System.out.print(arrayHundreds[thousands3] + "Thousand " + arrayTeens[lastThreeOnesDigits]);
				}else if(middleThreeTensDigits == 1){
					System.out.print(arrayHundreds[thousands3] + arrayTeens[middleThreeOnesDigits] + "Thousand ");
				}else{
					System.out.print(arrayHundreds[thousands3] + arrayTens[thousands2] + arrayOnes[thousands1] + "Thousand ");	//accounting for teens inside thousands amount
				}
			}
			
			if(lastThreeTensDigits == 1 && number < 1000){	
				System.out.print(arrayHundreds[lastThreeHundredsDigits] + arrayTeens[lastThreeOnesDigits] + "dollars");		//accounting for teens in the tens amount
			}else if(number >= 2){	
				System.out.print(arrayHundreds[lastThreeHundredsDigits] + arrayTens[lastThreeTensDigits] + arrayOnes[lastThreeOnesDigits] + "dollars");
			}	
			
			if(number == 0){
				System.out.print("Zero dollars");				//accounting if user inputs 0
			}
			if(number == 1){
				System.out.print("One dollar");					//accounting if user inputs 1
			}
			
			double cents = money - number;								//cents accounting for everything after the decimal
			if(cents > 0){
				int c = (int) (cents * 100);					 		//new variable for cents
				int a = c/10;									//seperating tens digit from ones digit
				int b = c % 10;									//seperating ones digit from tens digit
				
				if(cents == 0.01){
					System.out.print(" and " + arrayOnes[1] + "cent");
				}else if(a == 1){
					System.out.print(" and " + arrayTeens[b + 1] + "cents");	
				}else if(c > 1){
					System.out.print(" and " + arrayTens[ c/10 ] + arrayOnes[c % 10] + "cents"); 	//prints decimals into words
				}
		        }

			System.out.print("\t[" + "$" + money + "]");
		
	}
}