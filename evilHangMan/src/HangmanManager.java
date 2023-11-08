import java.util.*;
public class HangmanManager
{
	private Set<String> words = new HashSet<String>();
	private int len;
	private int gLeft;
	private String pat;
	private Set<Character> wrong = new HashSet<Character>();
	private Map<Character> current = new TreeMap<>();
	
	public HangmanManager( List<String> dictionary, int length, int max )
	{
		if(length < 1 || max < 0) {
			throw new IllegalArgumentException();
		}
		len = length;
		gLeft = max;
		TreeSet<String> guessed = new TreeSet<String>();
		for(String s: dictionary) {
			if(s.length() == length)
			{
				words.add(s);
			}
		}
	}
	
	public Set<String> words()
	{
		return words; //returns the words being considered by the game
	}	
	
	public int guessesLeft()
	{
		return gLeft - wrong.size(); // returns how many guesses the user has left
	}
		
	public Set<Character> guesses()
	{
		return wrong; //current set of letters that have been guessed
		
	}
	
	public String pattern()
	{
		String[] fam = new String[0];
		if(wrong.isEmpty())
		{
			throw new IllegalStateException();
		}
		/*if(wrong)
		return null;*/
		
	}
	
	public int record( char guess )
	{
		//go through the word family and see if it fits and narrow it down ?? 
		pat = "";
		int occur =0;
		int temp =0;
		
		if(guessesLeft() <= 1 || words.isEmpty()) { 
			throw new IllegalStateException(); //exception
		}
		if(!words.isEmpty() && wrong.contains(guess)) {
			throw new IllegalArgumentException(); //exception
		}
		
		for(String w: words) { //goes through the set of words 
			for(char c: w.toCharArray()) //goes through each character through the word
			{
				if(c == guess) { //if that character is the guess the number of occurences goes up 1
					occur++;
				}
			}
		}
		return gLeft;
	}
}