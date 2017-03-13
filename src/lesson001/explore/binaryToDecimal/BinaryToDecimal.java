package lesson001.explore.binaryToDecimal;

public class BinaryToDecimal {
	
	public static void main(String[] args) {
		int answer = binaryToDecimal(10000000);
		System.out.println(answer);
	}
	
	public static int binaryToDecimal(int binaryNum) {
		String num = Integer.toString(binaryNum);
		int pow = 0;
		int decimalNumber = 0;
		
		for(int i = 0; i < num.length(); i++) {
			String digit = Character.toString(num.charAt(num.length() - i - 1));
			decimalNumber += Integer.parseInt(digit) * Math.pow(2, pow);
			pow++;
		}
		
		return decimalNumber;
	}
	
}
