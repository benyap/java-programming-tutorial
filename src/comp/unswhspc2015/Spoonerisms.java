package comp.unswhspc2015;

/**
 * Problem statement at
 * <a href="https://cgi.cse.unsw.edu.au/~progcomp/pop.php?loc=2015opentasks#task2">
 * 	https://cgi.cse.unsw.edu.au/~progcomp/pop.php?loc=2015opentasks#task2
 * </a>
 * 
 * @author bwyap
 * @since 31 May 2017
 *
 */
public class Spoonerisms {
	
	public static void main(String[] args) {
		spoonerism("the three little pigs and the big bad wolf");
	}
	
	
	/**
	 * An array containing the vowels
	 */
	static final String[] vowels = new String[]{"a", "e", "i", "o", "u"};
	
	
	/**
	 * Generate the spoonerism of the given line and print out the result
	 * @param line
	 */
	static void spoonerism(String line) {
		// Print the original line
		System.out.println(line);
		
		// Generate the spoonerism and print it out
		for(String s : generateSpoonerism(line)) {
			System.out.print(s + " ");
		}
	}
	
	
	/**
	 * Generates the spoonerisms for a string of words
	 * @param line
	 * @return
	 */
	static String[] generateSpoonerism(String line) {
		
		// Trivial words
		final String[] trivialWords = new String[]{
				"for", "has", "have", "she", "that", "the", "this", "will", "with"};
		
		// Split the string into separate words
		String[] words = line.split(" ");
		
		String prefix = "";
		int firstSwapWord = -1;
		
		// Iterate through all words
		for(int i = 0; i < words.length; i++) {
			
			// Check for trivial words or vowels
			if (!contains(words[i], trivialWords) && !contains(words[i].charAt(0) + "", vowels)) {
				
				// If it is the first word to be swapped, keep a record of it
				if (firstSwapWord < 0) firstSwapWord = i;
				
				// Find the end of the prefix
				int suffix = findEndPrefix(words[i]);
				
				// Grab the prefix of the word
				String newPrefix = words[i].substring(0, suffix);
				
				// System.out.println("new prefix: " + newPrefix); // TODO for debuggin purposes
				
				// Add the previous prefix to the current word
				words[i] = prefix + words[i].substring(suffix);
				
				prefix = newPrefix;
			}
		}
		
		// Put the first word back in place
		words[firstSwapWord] = prefix + words[firstSwapWord];
		
		return words;
	}
	
	
	/**
	 * Check if an array of strings contains the word
	 * @param word the word to search for
	 * @param wordList the list to search through
	 * @return true if the list of words contains the word
	 */
	private static boolean contains(String word, String[] wordList) {
		for(int i = 0; i < wordList.length; i++) {
			if (word.equals(wordList[i])) return true;
		}
		return false;
	}
	
	
	/**
	 * Finds the end of the prefix of the given word
	 * @param word 
	 * @return the index of the end of the prefix of the word
	 */
	private static int findEndPrefix(String word) {
		// Check through each letter in the word
		for(int i = 0; i < word.length(); i++) {
			String letter = word.charAt(i) + "";
			
			// Once we find a vowel, we return
			for(String v : vowels) {
				if (letter.equals(v)) {
					return i;
				}
				// Exception for "q" - check if it is followed by "u"
				else if (letter.equals("q")) {
					if (word.charAt(i + 1) + "" == "u") {
						return i + 1;
					}
				}
			}	
		}
		
		return 0;
	}
	
}
