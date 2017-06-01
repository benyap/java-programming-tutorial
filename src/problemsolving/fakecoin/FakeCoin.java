package problemsolving.fakecoin;

import java.util.Random;

import static problemsolving.fakecoin.FakeCoin.Balance.LEFT_HEAVY;
import static problemsolving.fakecoin.FakeCoin.Balance.RIGHT_HEAVY;
import static problemsolving.fakecoin.FakeCoin.Balance.BALANCED;

/**
 * An implementation of the algorithm that solves the Fake Coin problem with 12 coins.
 * @author bwyap
 *
 */
class FakeCoin {
	
	public static void main(String[] args) {
		// Create an array of 12 coins
		Coin[] coins = new Coin[12];
		
		for(int i = 0; i < coins.length; i++) {
			coins[i] = new Coin((char) (i + 'a') + "", 10);
		}
		
		// Create a fake coin
		// Note that there is a chance that the fake coin weighs the same as the others.
		// In this case, the algorithm will not be able to find the fake coin by using the weight.
		Random r = new Random();
		int index = r.nextInt(12);
		coins[index] = new Coin(coins[index].id, (r.nextInt(19) + 1));
		
		// Print all coins
		for(Coin c : coins) {
			System.out.println(c + " weighs " + c.weight);
		}
		
		// Find the fake coin
		findFake(coins);
	}
	
	/**
	 * Locate the fake coin inside the given array by only using the {@code weigh()} function.
	 * Expecting an array of 12 coins.
	 * @param coins
	 * @return
	 */
	private static void findFake(Coin[] coins) {
		// Ensure that we received an array of 12 coins
		if (coins.length != 12) throw new RuntimeException("Expecting 12 coins!");
		
		// *** FIRST WEIGHING ***
		// Weigh 0, 1, 2, 3 against 4, 5, 6, 7
		Balance result = weigh(new Coin[]{coins[0],coins[1],coins[2],coins[3]}, new Coin[]{coins[4],coins[5],coins[6],coins[7]});
		
		if (result == BALANCED) {
			// *** SECOND WEIGHING ***
			// Fake coin is one of 8, 9, 10, 11
			result = weigh(new Coin[]{coins[0],coins[1],coins[2]}, new Coin[]{coins[8],coins[9],coins[10]});
			
			if (result == BALANCED) {
				// *** THIRD WEIGHING ***
				// Fake coin is 11
				result = weigh(new Coin[]{coins[0]}, new Coin[]{coins[11]});
				
				if (result == LEFT_HEAVY) System.out.println(coins[11] + " is light!");
				else if (result == RIGHT_HEAVY) System.out.println(coins[11] + " is heavy!");
				
				// Also a possible scenario if all coins weigh the same
				else System.out.println("No fake coins found."); 
			}
			else {
				// Fake must be 8, 9 or 10
				String state;
				Balance oldResult = result;
				if (result == LEFT_HEAVY)
					state = " is light!";
				else 
					// result can only be RIGHT_HEAVY here
					state = " is heavy!";
				
				// *** THIRD WEIGHING ***
				result = weigh(new Coin[]{coins[8]}, new Coin[]{coins[9]});
				
				// If two coins balance, the fake must be coins[10]
				if (result == BALANCED) System.out.println(coins[10] + state);
				// If result was same as previous result, coins[9] is fake.
				// Otherwise the fake coin is coins[8].
				else System.out.println((result == oldResult ? coins[9] : coins[8]) + state);
			}
		}
		else {
			// Coins 8, 9, 10, 11 are real
			Coin[] light, heavy;
			Coin[] real = new Coin[]{coins[8],coins[9],coins[10],coins[11]};
			
			// Split coins into a heavier and lighter pile
			if (result == LEFT_HEAVY) {
				light = new Coin[]{coins[4],coins[5],coins[6],coins[7]};
				heavy = new Coin[]{coins[0],coins[1],coins[2],coins[3]};
			}
			else {
				light = new Coin[]{coins[0],coins[1],coins[2],coins[3]};
				heavy = new Coin[]{coins[4],coins[5],coins[6],coins[7]};
			}
			
			// *** SECOND WEIGHING ***
			// Weigh +--- against -ooo (+ represents heavy, - represents light, o represents real)
			result = weigh(new Coin[]{heavy[0],light[0],light[1],light[2]}, new Coin[]{light[3],real[0],real[1],real[2]});
			
			if (result == BALANCED) {
				// *** THIRD WEIGHING ***
				// Fake is either heavy[1], heavy[2] or heavy[3]
				result = weigh(new Coin[]{heavy[1]}, new Coin[]{heavy[2]});
				
				if (result == LEFT_HEAVY) System.out.println(heavy[1] + " is heavy!");
				else if (result == RIGHT_HEAVY) System.out.println(heavy[2] + " is heavy!");
				else if (result == BALANCED) System.out.println(heavy[3] + " is heavy!");
			}
			else if (result == LEFT_HEAVY) {
				// *** THIRD WEIGHING ***
				// Fake is heavy[0] or light[3]
				result = weigh(new Coin[]{heavy[0]}, new Coin[]{real[0]});
				
				if (result == LEFT_HEAVY) System.out.println(heavy[0] + " is heavy!");
				else if (result == BALANCED) System.out.println(light[3] + " is light!");
			}
			else if (result == RIGHT_HEAVY) {
				// *** THIRD WEIGHING ***
				// Fake is light[0], light[1] or light[2]
				result = weigh(new Coin[]{light[0]}, new Coin[]{light[1]});
				
				if (result == LEFT_HEAVY) System.out.println(light[1] + " is light!");
				else if (result == RIGHT_HEAVY) System.out.println(light[0] + " is light!");
				else if (result == BALANCED) System.out.println(light[2] + " is light!");
			}
		}
	}
	
	
	// =================
	//  Utility classes 
	// =================
	
	/**
	 * An enumeration to represent the three possible states of a balance scale
	 * @author bwyap
	 *
	 */
	public enum Balance {
		LEFT_HEAVY,
		RIGHT_HEAVY,
		BALANCED
	}
	
	/**
	 * Weigh a set of coins against each other
	 * @param left
	 * @param right
	 * @return
	 */
	private static Balance weigh(Coin[] left, Coin[] right) {
		System.out.println("Weighing coins...");
		
		int leftWeight = 0, rightWeight = 0;
		
		for(Coin c : left) {
			leftWeight += c.weight;
		}
		
		for(Coin c : right) {
			rightWeight += c.weight;
		}
		
		if (leftWeight == rightWeight) return BALANCED;
		if (leftWeight > rightWeight) return LEFT_HEAVY;
		else return RIGHT_HEAVY;
	}
	
	/**
	 * A class to represent a coin.
	 * Each coin has an id and a weight.
	 * @author bwyap
	 *
	 */
	private static class Coin {
		final String id;
		final int weight;
		
		public Coin(String id, int weight) {
			this.id = id;
			this.weight = weight;
		}
		
		public String toString() {
			return id;
		}
	}
	
}
