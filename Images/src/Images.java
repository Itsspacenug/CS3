/*
 * Note: these methods are public in order for them to be used by other files
 * in this assignment; DO NOT change them to private.  You may add additional
 * private methods to implement required functionality if you would like.
 *
 * You should remove the stub lines from each method and replace them with your
 * implementation that returns an updated image.
 */

import acm.graphics.*;

public class Images implements ImageConversions {

    public GImage flipHorizontal(GImage source) {
    	int temp;
    	int[][] arr = source.getPixelArray();
        for(int i = 0; i<arr.length; i++) {
        	for(int j = 0; j<arr[i].length/2; j++) {
        		temp = arr[i][j];
        		arr[i][j]=arr[i][arr[i].length-(j+1)];
        		arr[i][arr[i].length-(j+1)]=temp;
        	}
        }
        return new GImage(arr);
    }

    public GImage rotateLeft(GImage source) {
    	int[][] arr = source.getPixelArray();
    	int[][] arr2 = new int[arr[0].length][arr.length];
        for(int r = 0;r<arr[0].length;r++) {
        	for(int c = 0; c<arr.length; c++) {
        		arr2[r][c]=arr[c][arr[c].length-(r+1)];
        	}
        }
        return new GImage(arr2);

    }

    public GImage rotateRight(GImage source) {
    	int[][] arr = source.getPixelArray();
    	int[][] arr2 = new int[arr[0].length][arr.length];
        for(int r = 0;r<arr[0].length;r++) {
        	for(int c = 0; c<arr.length; c++) {
        		arr2[r][c]=arr[arr.length-1-c][r];
        	}
        }
        return new GImage(arr2);

    }

    public GImage greenScreen(GImage source) {
    	int[][] arr = source.getPixelArray();
        for(int i = 0; i<arr.length; i++) {
        	for(int j = 0; j<arr[i].length; j++) {
        		arr[i][j]=(GImage.getGreen(arr[i][j])>2*GImage.getRed(arr[i][j])&&GImage.getGreen(arr[i][j])>2*GImage.getBlue(arr[i][j]))?GImage.createRGBPixel(1,1,1,0):arr[i][j];
        	}
        }
        return new GImage(arr);

    }

    public GImage equalize(GImage source) {
    	int[][] arr = source.getPixelArray();
    	int[] luminosity = new int[256];
        for(int r=0; r<arr.length; r++) {
        	for(int c=0; c<arr[r].length; c++) {
        		luminosity[computeLuminosity(GImage.getRed(arr[r][c]), GImage.getGreen(arr[r][c]), GImage.getBlue(arr[r][c]))]++;
        	}
        }
        for(int r=1; r< luminosity.length; r++) { 
        		luminosity[r] += luminosity[r-1];
        }
        for(int r=0; r<arr.length; r++) {
        	for(int c=0; c<arr[r].length; c++) {
        		int rgbValues = 255 * luminosity[computeLuminosity(GImage.getRed(arr[r][c]), GImage.getGreen(arr[r][c]), GImage.getBlue(arr[r][c]))] / luminosity[255];
        		arr[r][c] = GImage.createRGBPixel(rgbValues, rgbValues, rgbValues);
        	}
        }
        
        return new GImage(arr);
    }

    public GImage negative(GImage source) {
    	int[][] arr = source.getPixelArray();
        for(int i = 0; i<arr.length; i++) {
        	for(int j = 0; j<arr[i].length; j++) {
        		arr[i][j]=GImage.createRGBPixel(255-GImage.getRed(arr[i][j]), 255-GImage.getGreen(arr[i][j]), 255-GImage.getBlue(arr[i][j]));
        	}
        }
        
        
        return new GImage(arr);
        
    }

    public GImage translate(GImage source, int dx, int dy) {
    	int[][] arr = source.getPixelArray();
    	int width = arr[0].length; 
    	int height = arr.length; 
    	int[][] translatedPixels = new int[height][width];
    	for(int r=0; r < height; r++){
    		for(int c=0; c<width; c++) {
    			int newRow = (r+dy+height) % height;
                int newCol = (c+dx+width) % width;
                translatedPixels[newRow][newCol] = arr[r][c];

    		}
    	}
    	return new GImage(translatedPixels);
    }

    public GImage blur(GImage source) {
    	int[][]pix = source.getPixelArray();//establish array
    	int[][]Rpix = source.getPixelArray();//establish array
    	//int[][]Rpix =new int[pix.length][pix[0].length];//make new array
    	int R=0;int G=0;int B=0; int count=0;
        for(int i =0;i<pix.length;i++)//loop through rows
        {
        	for(int x =0;x<pix[0].length;x++)//loop column
        	{
        		for(int smoli=0;smoli<3;smoli++)//make loop for accessed pixel row
        		{
        			for(int smolx=0;smolx<3;smolx++)//make loop for accessed pixel column
            		{
        				if(i-1+smoli<0||x-1+smolx<0||i-1+smoli>pix.length-1||x-1+smolx>pix[0].length-1)//checks for border pixels
        				{
        					//stops it before it goes out of bounds
        				}
        				else
        				{
        					R += GImage.getRed(pix[i-1+smoli][x-1+smolx]);
        	        		G += GImage.getGreen(pix[i-1+smoli][x-1+smolx]);//adds value to corresponding color
        	        		B += GImage.getBlue(pix[i-1+smoli][x-1+smolx]);
        	        		count++;
        				}
            		}
        		}
        		R=R/count; G=G/count; B=B/count;//gets average
        		Rpix[i][x]=GImage.createRGBPixel(R ,G ,B);//set values to inverse
        		R=0;G=0;B=0;count=0;//resets values
        		
        	}
        }
        source.setPixelArray(Rpix);//set the array and return it
        return source;
        
    }
}

    }
}
