package introLabs;



///////////////////////////////////////////////////////////////////////////
//
//         Write a Java program to determine that a given expression 
//          contains a set of correctly nested brackets of various 
//          kinds ( {,} [,] (,) ). That is, we want to check that:
//            - There are an equal number of right and left parentheses, 
//              curly brackets, and square brackets.
//            - Every right bracket is preceded by a corresponding 
//              left bracket.
//
//          Read a string expression using an input dialog interface.
//
//          For example, your program should print
//              true for [()]{}{[()()]()} and
//              false for [(]).
//
///////////////////////////////////////////////////////////////////////////
//
//          This checker must implement the following algorithm:
//
//          1. Make an empty stack.
//
//          2. Read symbols until the end of the source code file.
//                a.  If the symbol is an opening symbol,
//                      push it onto the stack.
//                b.  If it is a closing symbol, do the following:
//                    i.  If the stack is empty, report an error.
//                    ii. Otherwise, pop the stack.
//                          If the symbol popped is not the
//                          corresponding opening symbol,
//                          report an error.
//
//          3. At the end of the string, if the stack is not empty,
//             report an error.
//
///////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.*;

public class Stack1{
	public static void main (String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner("input.txt");
		Stack<Character> brackets = new Stack<Character>();
		String input = sc.nextLine();
		
		for(char sym : input.toCharArray()) {
			if(sym == '{' || sym == '(' || sym == '}') {
				brackets.push(sym);
			}
			if(sym == '}' || sym == ')' || sym == ']') {
				if(brackets.isEmpty()) {
					System.out.println("ERROR: EMPTY STACK");
					//break();
				}
				else {
					char symbol = brackets.peek();
					brackets.pop();
					if((sym == '{' && symbol != '}' )|| (sym == '(' && symbol != ')') || (sym == '[' && symbol != ']')) {
						System.out.println("ERROR: NO CORRESPONDING SYMBOL");
					}
				}
			}
		}
		if(input.isEmpty()) {
			System.out.println("ERROR: STRING IS NOT EMPTY");
		}
		else {
			System.out.println("SUCCESS: THE STRING IS TRUE");

		}
	}
/*

SAMPLE DATA
[()]{}{[()()]()} 
[(])
[]
((())

SAMPLE OUTPUT
GOOD
BAD
GOOD
BAD

*/
}
