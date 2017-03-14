package cn.edu.scut.sort;

public class QuickSort {
	
	/**快速排序，也是分治法
	 * 
	 * @param arr
	 */
	public static void quickSort(int[] arr, int beg, int end){
		if(end > beg){
			//1.选择一个数
			int pivot = arr[beg];
			int j = end;
			int i = beg;
			
			while(i < j){
				while(arr[j] > pivot && j > i){
					j--;
				}
				arr[i] = arr[j];
				while(arr[i] < pivot && j > i){
					i++;
				}
				arr[j] = arr[i];
			}
			arr[j] = pivot;
			quickSort(arr, beg, j-1);
			quickSort(arr, j+1, end);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {3,1,6,2,8,7,9,5,4};
		quickSort(arr, 0, arr.length-1);
		for(int i=0; i < arr.length; i++){
			System.out.print(arr[i] + "  ");
		}
	}
	
}
