package binaryconverter;
import java.util.Scanner;

public class DecimalToBinary {
	
	
	public static String decimalToBinary(int number) {
		String answer = "";
		
		int q = number;
		int r;
		
		while (q != 0) {
			r = q % 2;
			q = q / 2;
			
			answer = Integer.toString(r) + answer;
		}
		
		return answer;
	}
	
	
	
	
	public static void main(String[] args) {
		while(true) {
			@SuppressWarnings("resource")
			int number = new Scanner(System.in).nextInt();
			String result = decimalToBinary(number);
			System.out.println(result);
		}
	}
	
}
