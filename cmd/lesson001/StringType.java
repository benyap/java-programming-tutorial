public class StringType {
	
	public static void stringType() {
		// STRING is a very important data type in Java.
		// It is not a primitive data type - it is an Object class.
		// This means it has methods that can be executed.
		
		// Notice that it has a capital letter.
		// In Java it is a convention to start all object/class names with a capital,
		// and all variable and method names with a lower case letter.
		String myString;
		
		// Strings are always enclosed within double quotes.
		myString = "Hello!";
		
		// You can concatenate two strings using the plus (+) operator.
		myString = "Hello" + " " + "World!";
		System.out.println(myString);
		
		// Check out some of the methods you can do with a string.
		System.out.println(myString.length());
		System.out.println(myString.charAt(4));
		System.out.println(myString.substring(0, 5));
	}
	
	public static void main(String[] args) {
		stringType();
	}
}