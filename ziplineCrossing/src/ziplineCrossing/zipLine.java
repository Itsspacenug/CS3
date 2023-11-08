package ziplineCrossing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class zipLine {
	public static void main(String[] args) {
        File file = new File("src/input.txt");
        int[][] maze = getFile(file);
        int length = 9; // Length of the ziplines

        boolean possible = canCross(zip, 1, 0, 0, length);

        if (possible) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static int[][][] getFile(File file) throws FileNotFoundException {
		Scanner sc = new Scanner(file);
		int[][][] maze = new int[sc.nextInt()][][]; //initialize the array for each possible senario 
		sc.nextLine(); //moves to the next INT
		for(int z=0; z< maze.length; z++) {
			maze[z] = new int[sc.nextInt()][sc.nextInt()]; //sets the bounds for the 2D array
			sc.nextLine(); //moves to the next available number
			for(int r=0;r<maze[z].length; r++) {
				int num = sc.nextInt(); // finds the number of closed intervals per line
				//go through the each closed interval
				for(int c=0;c<num; c++) {
					int start=sc.nextInt(); //start each closed interval
					int end=sc.nextInt(); // ends of each closed interval
					//transribes each interval to array
					for(int l=start-1;l<end; l++) {
						maze[z][r][l] = 1; 
					}
				}
				try{sc.nextLine(); }catch(NoSuchElementException e) {}//go to the next Line if no possible solution
			}
		}
		sc.close();
		return maze;
		
	}

	private static boolean canCross(int[][] zip, int currentZipline, int currentPosition, int lastSwitch, int length) {
        if (currentPosition >= length) {
            return true; // Reached the end
        }

        if (currentZipline >= zip.length) {
            return false; // No more ziplines to switch to
        }

        int[] currentZip = zip[currentZipline];

        for (int i = 0; i < currentZip.length; i+=2) {
            int start = currentZip[i];
            int end = currentZip[i + 1];
            
            if (start <= currentPosition && end >= currentPosition && end > lastSwitch) {
                // Current position is within a valid interval
                for (int nextZipline = currentZipline + 1; nextZipline < zip.length; nextZipline++) {
                    if (canCross(zip, nextZipline, currentPosition + 1, currentPosition, length)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
