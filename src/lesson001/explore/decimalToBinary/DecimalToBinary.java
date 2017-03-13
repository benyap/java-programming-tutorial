package lesson001.explore.decimalToBinary;

public class DecimalToBinary {
	
	public static void main(String[] args) {
		int answer = decimalToBinary(50);
		System.out.println(answer);
	}
	
	
	public static int decimalToBinary(int decimalNumber) {
		int num = decimalNumber;
		String binaryNum = "";
		
		while (num != 0) {
			int r = num % 2;
			num = num / 2;
			binaryNum += r;
		}
		
		// Reverse binaryNum
		String reverseBinaryNum = "";
		for (int i = 0; i < binaryNum.length(); i++) {
			reverseBinaryNum += binaryNum.charAt(binaryNum.length() - i - 1);
		}
		
		return Integer.parseInt(reverseBinaryNum);
	}
	
}
