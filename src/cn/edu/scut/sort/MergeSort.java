package cn.edu.scut.sort;

public class MergeSort {
	
	/**归并排序
	 * 1.分而治之
	 * 2.合并
	 * @param arr
	 */
	public static void mergeSort(int[] arr){
		mergeSort(arr, 0, arr.length-1);
	}
	
	public static void mergeSort(int[] arr, int beg, int end){
		if(end > beg){
			int med = (beg + end) / 2;
			mergeSort(arr, beg, med);
			mergeSort(arr, med+1, end);
			merge(arr, beg, med, end);
		}
	}
	
	public static void merge(int[] arr, int beg, int med, int end){
		//两个循环
		int i = beg;
		int j = med + 1;
		int index = beg;
		int[] tmpArr = new int[arr.length];
		while(i <= med && j <= end){
			if(arr[i] < arr[j]){
				tmpArr[index] = arr[i];
				i++;
				index++;
			}else{
				tmpArr[index] = arr[j];
				j++;
				index++;
			}
		}
		
		while(i <= med){
			tmpArr[index] = arr[i];
			i++;
			index++;
		}
		
		while(j <= end){
			tmpArr[index] = arr[j];
			j++;
			index++;
		}
		
		//拷贝回去
		for(i=beg; i <= end; i++){
			arr[i] = tmpArr[i];
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {4,5,2,1,3,7,6};
		mergeSort(arr);
		for(int i=0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}
