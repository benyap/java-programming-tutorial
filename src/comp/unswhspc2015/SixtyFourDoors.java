package comp.unswhspc2015;

/**
 * Problem statement at
 * <a href="https://cgi.cse.unsw.edu.au/~progcomp/pop.php?loc=2015opentasks#task1">
 * 	https://cgi.cse.unsw.edu.au/~progcomp/pop.php?loc=2015opentasks#task1
 * </a>
 * 
 * @author bwyap
 * @since 31 May 2017
 *
 */
public class SixtyFourDoors {
	
	public static void main(String[] args) {
		sixtyFourDoors();
	}
	
	
	/**
	 * Simulate the monks and the 64 doors
	 */
	static void sixtyFourDoors() {
		// A boolean array represents the state of the 64 doors
		boolean[] doors = new boolean[64];
		
		for(int monk = 0; monk < doors.length; monk++) {
			// Every monk goes through doors which are multiples of its 'number'
			for(int i = monk; i < doors.length; i += (monk + 1)) {
				// Switch the state of the door
				doors[i] = !doors[i];
			}
		}
		
		// Print open doors
		printOpenDoors(doors);
	}
	
	
	/**
	 * Print the index of all doors that are open
	 * @param doors
	 */
	static void printOpenDoors(boolean[] doors) {
		// Print all doors out 
		for(int i = 0; i < doors.length; i++) {
			// Door indexes start a 1
			System.out.print((doors[i] ? (i + 1) + " " : ""));
		}
		System.out.println();
	}
	
}
