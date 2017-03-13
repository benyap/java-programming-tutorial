public class ArrayDemo {
	
	public static void arrayDemo() {
		
		// Arrays are a finite list of elements of the same data type.
		// An array is represented by using square brackets
		// Two ways to declare arays: after the type name, or after the variable name
		
		int[] myArray;	// This method is preferred
		int myOtherArray[];
		
		// Arrays must be initialised with a specific size before they can be used
		myArray = new int[50];
		myOtherArray = new int[50];
		
		// Array indices start at 0
		System.out.println(myArray[0]);
		System.out.println(myOtherArray[0]);
		
		System.out.println();
		
		
		// EXAMPLE: how to fill an array with numbers 1 to 50?
		for(int i = 0; i < 50; i++) {
			myArray[i] = i + 1;
		}
		
		printArray(myArray);
		
		
		// EXAMPLE: how to fill an array with even numbers?
		for(int i = 0; i < myArray.length; i++) {
			myArray[i] = i * 2;
		}
		
		for(int i = 0; i < myArray.length * 2; i += 2) {
			myArray[i/2] = i;
		}
		
		printArray(myArray);
		
	
		// EXAMPLE: how to fill an array with even numbers?
		for(int i = 0; i < myArray.length; i++) {
			myArray[i] = i * 2 + 1;
		}
		
		for(int i = 1; i < myArray.length * 2 + 1; i += 2) {
			myArray[i/2] = i;
		}
		
		printArray(myArray);		
		
	}
	
	
	public static void printArray(int[] array) {	
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		arrayDemo();
	}
	
}