public class DataTypes {
	
	public static void dataTypes() {
		// In Java there are 8 PRIMITIVE data types.
		// We'll declare a few of each of the types and give an example value.
		
		// BOOLEAN: true or false values.
		boolean myBoolean;
		myBoolean = true;
		System.out.println("Boolean: " + myBoolean);
		System.out.println();
		
		// INT: a 32-bit integer
		int myInt;
		myInt = 2017;
		System.out.println("Integer: " + myInt);
		System.out.println("Max: " + Integer.MAX_VALUE);
		System.out.println("Min: " + Integer.MIN_VALUE);
		System.out.println();
		// What happens when you try to assign a decimal value to it?
		
		// SHORT: a 16-bit integer
		// By default, a number is assumed to be an integer.
		// The compiler will throw an error if you try to convert 
		// from integer to short as you might lose precision.
		// To explicitly specify that it is a SHORT, use the letter 's'.
		short myShort;
		myShort = (short)100000;
		System.out.println("Short: " + myShort);
		System.out.println("Max: " + Short.MAX_VALUE);
		System.out.println("Min: " + Short.MIN_VALUE);
		System.out.println();
		
		// LONG: a 32-bit integer
		// By default, a number is assumed to be an integer.
		// If it is too long, the compiler will throw an error.
		// To explicitly specify that it is a LONG, use the letter 'L'.
		long myLong;
		myLong = 8192000000L;
		System.out.println("Long: " + myLong);
		System.out.println("Max: " + Long.MAX_VALUE);
		System.out.println("Min: " + Long.MIN_VALUE);
		System.out.println();
		
		// FLOAT: a 32-bit floating point value
		// By default, a decimal number is assumed to be a double.
		// The compiler will throw an error if you try to convert 
		// from double to float as you might lose precision.
		// To explicitly specify that it is a FLOAT, use the letter 'F'.
		float myFloat;
		myFloat = 92.103f;
		System.out.println("Float: " + myFloat);
		System.out.println("Max: " + Float.MAX_VALUE);
		System.out.println("Min: " + Float.MIN_VALUE);
		System.out.println();
		
		// DOUBLE: a 64-bit floating point value
		double myDouble;
		myDouble = 28910.273918727387;
		System.out.println("Double: " + myDouble);
		System.out.println("Max: " + Double.MAX_VALUE);
		System.out.println("Min: " + Double.MIN_VALUE);
		System.out.println();

		// CHAR: a 16-bit integer representing a single character
		char myChar;
		myChar = 'h';	// IMPORTANT: you must use single quotes for a char.
		System.out.println("Char: " + myChar);
		myChar = 65;
		System.out.println(myChar);
		
		// BYTE: an 8-bit integer value
		byte myByte;
		myByte = 100;
		System.out.println("Byte: " + myByte);
		System.out.println("Max: " + Byte.MAX_VALUE);
		System.out.println("Min: " + Byte.MIN_VALUE);

	}

	
	public static void main(String[] args) {
		dataTypes();
	}
	
}