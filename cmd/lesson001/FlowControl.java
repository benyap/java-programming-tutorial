public class FlowControl {
	
	public static void flowControl() {
		
		// Equality and comparison operators
		// > >= < <= == != !
		System.out.println("5 < 10: " + (5 < 10));
		System.out.println("5 > 10: " + (5 > 10));
		System.out.println("5 >= 5: " + (5 >= 5));
		System.out.println("5 >= 5: " + (5 >= 5));
		System.out.println("5 == 5: " + (5 == 5));
		System.out.println("5 != 5: " + (5 != 5));
		
		
		// Logical operators
		// AND: &&     OR: ||     NOT: !
		System.out.println("T && T: " + (true && true));
		System.out.println("T && F: " + (true && false));
		System.out.println("F && F: " + (false && false));
		
		System.out.println("T || T: " + (true || true));
		System.out.println("T || F: " + (true || false));
		System.out.println("F || F: " + (false || false));	
		
		System.out.println("!T: " + !(true));
		System.out.println("!F: " + !(false));
		
		int x = 4;
		int y = -2;
		System.out.println("\nThe value of x is " + x);
		System.out.println("The value of y is " + y);
		System.out.println("x > 10 && x < 15: " + (x > 10 && x < 15));
		System.out.println("x > 0 || y > 5: " + (x > 0 || y > 5));
		System.out.println("x > 3 || !(y < 0): " + (x > 3 || !(y < 0)));
		System.out.println();
		
		
		// if-else statement
		// Structure: 
		/*
			if (condition is true) {
				do something
			}
			
			================
			
			if (condition is true) {
				do something
			}
			else if (condition is true) {
				do something
			}
			else {
				do something
			}
		*/
		
		boolean condition = true;
		
		if (condition) {
			System.out.println("Condition was true");
		}
		
		condition = false;
		
		if (condition) {
			System.out.println("Condition was false");
		}
		
		boolean condition2 = true;
		
		if (condition2) {
			System.out.println("Condition2 was true");
		}
		else {
			System.out.println("Condition2 was false");
		}
		
		System.out.println();
		
		
		// switch statement
		// Structure:
		/*
			switch(expression) {
			case match1:
				do something
			case match2: 
				do something
				break;
			case match3: 
				do something
				break;
			default:
				do something
			}
		*/
		
		String grade = "D";
		switch (grade) {
			case "HD":
				System.out.println("High distinction!");
				break;
			case "D":
				System.out.println("Distinction!");
				break;
			case "C":
				System.out.println("Credit!");
				break;
			case "P":
				System.out.println("Pass!");
				break;
			case "F":
				System.out.println("Fail!");
				break;
			default:
				System.out.println("No such grade.");
		}
		
		System.out.println();
		
		
		// while loop
		// Structure:
		/*
			while(condition is true) {
				do something
			}
		*/
		
		int count = 0;
		while(count < 10) {
			System.out.println(count);
			count++;
		}
		
		boolean alwaysTrue = false;
		
		while(alwaysTrue) {
			System.out.println("Infinite loop!");
			try {
				Thread.sleep(1000);
			}
			catch (Exception e) {}
		}
		
		System.out.println();
		
		
		// do while loop
		// Structure:
		/*
			do {
				do something
			} while (condition is true);
		*/
		count = 0;
		
		do {
			System.out.println("Doing the loop " + count + " time(s)!");
			count++;
		} 
		while (count < 5);
		
		System.out.println();
		
		
		// for loop
		// Structure:
		/*
			for(initial state; condition; increment) {
				do something
			}
		*/
		
		for(int i = 0; i < 5; i++) {
			System.out.println("For loop " + i);
		}
	}
	
	
	public static void main(String[] args) {
		flowControl();
	}
	
}