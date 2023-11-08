// File name: BufferedImageStack
// By: Aaron Nguyen and Jeremy Schoonover
//WHAT IS IT DOING
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.EmptyStackException;

public class BufferedImageStack {

	public BufferedImage[] array;
	
	public BufferedImageStack() {
		array = new BufferedImage[2];
		
	}
	public BufferedImageStack(BufferedImage[] b) {
		array = new BufferedImage[2];
		array = b;
		
	}
	public static void main(String[] args) {
		
	}
	
	//enters buffered image into stack and returns nothing 
	//If this would exceed the capacity of the array,
	//then a new array should be allocated having double the size of the old array,
	//and the old array's elements copied to the new array.
	public void push(BufferedImage someBufferedImage) {
		int cap=0; //measures capacity
		for(int i = 0; i<array.length; i++) {
			if(array[i] == null) { //checks if image is there
				cap++; // if not adds to cap
				array[i] = someBufferedImage; // sets an image to that spot
			}
		}
		BufferedImage[] newArray;//creates a bigger array
		if(cap==0) {
			newArray = new BufferedImage[array.length];
			for(int i = 0; i<array.length; i++) {
				newArray[i] = someBufferedImage; //copies to new array
			}
			newArray[array.length] = someBufferedImage; 
		}
		else {newArray = new BufferedImage[array.length * 2]; newArray[array.length] = someBufferedImage; }
	}
	
	/*throws an exception if the stack is empty; otherwise returns the top
	buffered image, removing it from the stack. The exception should be an
	instance of java.util.EmptyStackException. In this assignment, you are not
	required to ever replace a large array by a smaller array when the number of
	stack elements decreases because of pop operations.*/
	public BufferedImage pop() {
		if(array.length == 0) {
			throw new EmptyStackException(); //returns excpetion if empty 
		}
		BufferedImage image;
		for(int i=array.length-1; i<0; i--) { // goes backwords from the top
			if(array[i] != null) { //if that postion has an image it returns 
				image = array[i];
				return image; //return
			}
		}
		return null;		 //returns null if none are found
	}
	
	//returns true if there are no items in the stack; false otherwise.
	public boolean isEmpty() {
		for(BufferedImage image: array) { //goes through every slot in array
			if(image != null) { //if something returns false
				return false;
			}
		}
		return true; // if no false returns true;
	}
	
	/*returns the buffered image at the position given by the index.
	This is not commonly available in a stack, but it facilitates the testing by our
	autograder.) If the index is out of range, the method should throw an
	IndexOutOfBounds exception. (Note: get(0) gets the bottom element of the
	stack -- the one that was pushed in first, but not yet popped out.)*/
	public BufferedImage get(int index) {
		return array[index]; //gets image at certain index 
	}
	
	//returns the number elements currently in the stack.
	public int getSize() {
		int size=0;
		for(int i=0;i<array.length; i++) {
			if(array[i] != null) {
				size++;
			}
		}
		return size; //returns size of array with elements in it
	}
	
	/*returns the current size of the array being used to hold the
	stack elements. Like the get operation, this is not a normal stack operation,
	but may be used by the grading software to assure compliance with the
	specifications.*/
	public int getArraySize() {
		return array.length; //returns array size
	}
	
	
	/*BufferedImage biTemp; // Used when reading in an image.
    BufferedImage biWorking; // The current image.
    BufferedImage biFiltered; // Result of processing the current image.*/
	public BufferedImage undoStack(BufferedImage biTemp, BufferedImage biWorking, BufferedImage biFiltered) {
		return null;
		
	}
	public BufferedImage redoStack(BufferedImage biTemp, BufferedImage biWorking, BufferedImage biFiltered) {
		return null;
	}
}
