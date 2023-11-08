import java.util.Arrays;

class Pascals_Triangle {
	public static void main(String[] args) 
	{
		//Make sure you are testing your method here
		int rows = 6;
		for(int[] row : pascal(rows)) {
			for(int i: row) {
				//System.out.print(i + " ");
				System.out.print(i + " ");
			}
			System.out.println();
		}
		
		//Print your Triangle here
		
		/*int[][] fTri = pascal(16);
		for(int r=0; r<fTri.length; r++)
		{
			for(int b=fTri.length-1; b>r; b--) {
				System.out.print(" ");
			}
			
			for(int c=0;c>fTri[r].length; c++)
			{
				System.out.printf("%6d", fTri[r][c]);
			}
			System.out.println("");
		}*/
	}


	//Returns a jagged matrix that stores Pascal's Triangle
		//with the number of rows specified
	public static int[][] pascal(int rows)
	{
		//creates the cells pascal triangle as a template
		int[][] tri = new int[rows][];
		for(int i=0; i<rows; i++) {
			tri[i] = new int[i+1];
		}
		//goes through each cell in the triangle and uses the numbers from the row above it.
		//adds them together and that is the new number for each cell
		//the edges never change so those are done first then the other cells are filled
		for(int r=0;r<tri.length; r++) {
			tri[r][0]=1;
			tri[r][tri[r].length-1]=1;
			for(int c=1; c<tri[r].length - 1; c++) {
					tri[r][c] = (tri[r-1][c-1] + tri[r-1][c]);
			}
		}
		return tri; 
  	}
}