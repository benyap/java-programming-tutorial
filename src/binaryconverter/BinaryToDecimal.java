package binaryconverter;

public class BinaryToDecimal {
	
	
	public static String binaryToDecimal(int number) {
		
		String num = Integer.toString(number);
		int answer = 0;
		
		for(int i = 0; i < num.length(); i++) {
			char c = num.charAt(num.length() - 1 - i);
			
			if (c == '1') {
				answer += Math.pow(2, i);
			}
		}
		
		return Integer.toString(answer);
	}
	
	
	public static void main(String[] args) {
		String answer = binaryToDecimal(1010101100);
		System.out.println(answer);
	}
}
