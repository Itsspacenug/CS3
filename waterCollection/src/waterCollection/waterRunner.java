package waterCollection;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
public class waterRunner {
	public static void main(String[] args) throws Exception {
		//when you need to input it change the numbers
		
		File file = new File("H:\\CS3\\waterCollection\\src");
		Scanner sc = new Scanner(file);
		int[] array = {5,2,0,4,2};
		//initialize arrays to hold highest height left and right of an index.
		int[] larlef = new int[array. length];
		int[] larrig = new int[array. length];
		//set first values of arrays
		larlef[0] = array[0];
		larrig[array. length - 1] = array [array. length - 1];
		//go through array to set each index to the largest height to the left or on that index.
		for(int i = 1; i < array. length; i++ ) {
			larlef[i] = array[i] > larlef[i - 1] ? array[i] : larlef[i - 1];
		}
		System.out .println(Arrays. toString(larlef));
		//go through array to set each index to the largest height to the right or on that index.
		for(int i = array. length - 2; i >= 0; i--) {
			larrig[i] = array[i] > larrig[i + 1] ? array[i] : larrig[i + 1];
		}
		System.out.println(Arrays.toString(larrig));
		int sum = 0;//total amount of water spaces.
		//if the height is shorter than the tallest heights left and right of it, 
		//it can hold the difference of the shorter height and itself.
		for(int i = 0; i < array. length; i++ ) {
			int smaller = larlef[i] < larrig[i] ? larlef[i] : larrig[i];
			sum += smaller> array[i] ? smaller - array[i] : 0;
		}
		System.out.println(sum);

		/*ArrayList<Integer> arr = new ArrayList<Integer>();
		
		while(sc.hasNextInt())
		{
			arr.add(sc.nextInt());			
		}
		Integer i = 1;
		
		int[][] buc = new int[arr.get(0)][arr.get(0)];
		for(int r=0; r<buc.length; r++)
		{
			for(int c=0; c<buc[r].length;c++)
			{
				if(r)
				buc[r][c] = arr.get(r*c);
			}
		}*/
		
		
		/*int i;
		int len = -1;
		int fNum = 0;
		while((i =file.read()) != -1)
		{
			len++;
			if(len > 0) {
				fNum=i;
			}
		}
		file.close();
		int[][] buc = new int[fNum][len];
		for(int r=0;r<fNum;r++)
		{
			for(int c=0; c<len; c++) 
			{
				
			}
		}*/
		
		//0 is empty
		//1 is solid
		//2 is water
		
		
	}

}
