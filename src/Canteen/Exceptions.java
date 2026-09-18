package Canteen;
import java.util.*;

public class Exceptions {
	private static final Scanner scanner = new Scanner(System.in);
	//Integer  Character Input Handling
	public static int IntegerException(String prompt) {
		while(true) {
			try {
				System.out.print(prompt);
				int value = Integer.parseInt(scanner.nextLine().trim());
				if(value <= 0) {
					System.out.println("Value cannot be less than 0! or 0 ");
					continue;
				}
				return value;
			}catch(NumberFormatException e){
				System.out.println("Input should be number! ");
			}
		}
	}
	
	//Double Character Input Handling
	public static double DoubleException(String prompt) {
		while(true) {
			try {
				System.out.print(prompt);
				double value = Double.parseDouble(scanner.nextLine().trim());
				if(value < 0.0) {
					System.out.println("Value cannot be less than 0! ");
					continue;
				}
				return value;
			}catch(NumberFormatException e) {
				System.out.println("Input should be number! ");
			}
		}
	}
	
	//String Empty Input Handling
	public static String StringException(String prompt) {
		while(true) {
			System.out.print(prompt);
			String value = scanner.nextLine();
			if(value.isBlank()) {
				System.out.println("Input cannot be blank! ");
				continue;
			}
			
			return value;
		}
	}
	
}
