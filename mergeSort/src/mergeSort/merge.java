package mergeSort;

import java.util.Arrays;

//Libny Lopez, Aaron Nguyen
//Period: 7
public class merge{
	public static void main(String[] args)
	{
		int [] arr = {12,5,9,42,7,65,8,21};
		int[] sa = mergeSort(arr,0,arr.length-1);
		System.out.print("Sorted Array -> ");
	    System.out.println(Arrays.toString(sa));
		
	}
	public static int[] mergeSort(int[] arr, int firstIndx, int LastIndx) {
		if(firstIndx == LastIndx) {
			int [] one=new int[1];
			one[0]=arr[firstIndx];
			return one;
		}
		int mid = (firstIndx + LastIndx)/2;
		int [] ls=mergeSort(arr,firstIndx,mid);
		int[] rs=mergeSort(arr,mid+1,LastIndx);
		int [] ans=mergeTwoSortedArrays(ls,rs);
		return ans;
	}
	public static int[] mergeTwoSortedArrays(int[] left, int[] right) {
		int arr1 = 0, arr2 =0, arr3 = 0;
		int[] full = new int[left.length+right.length];
		while(arr1<left.length && arr2 < right.length) {
			if(left[arr1] <= right[arr2])
			{
				full[arr3] = left[arr1];
				arr1++;
				arr3++;
			}
			else {
				full[arr3] = right[arr2];
				arr2++;
				arr3++;
			}
		}
		while(arr1 < left.length) {
				full[arr3] = left[arr1];
				arr1++;
				arr3++;
		}
		while(arr2 < right.length) {
				full[arr3] = right[arr2];
				arr2++;
				arr3++;
		}
		return full;
	}
}

