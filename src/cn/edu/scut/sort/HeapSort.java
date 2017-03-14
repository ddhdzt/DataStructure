package cn.edu.scut.sort;

public class HeapSort {
	//子节点
	public static int leftChild(int i){
		return 2*i + 1;
	}
	
	//调整堆
	/**
	 * 
	 * @param arr
	 * @param i
	 * @param end 尾下标
	 */
	public static void adjustHeap(int[]arr, int pos, int end){
		int tmp = arr[pos];
		int i = pos;
		for(;leftChild(i) <= end;){
			//比较左右孩子节点大小
			int child = leftChild(i);
			if(child < end && arr[child] < arr[child+1]){
				child++;
			}
			//最大堆，小的往后
			if(tmp < arr[child]){
				arr[i] = arr[child];
			}else
				break;
			
			i = child;
		}
		arr[i] = tmp;
	}
	
	
	
	public static void heapSort(int[] arr){
		//建堆
		for(int i=arr.length / 2 - 1; i >= 0; i--){
			adjustHeap(arr, i, arr.length-1);
		}
		
		for(int i=arr.length-1; i >= 0; i--){
			//交换arr[0] arr[i]
			int tmp = arr[0];
			arr[0] = arr[i];
			arr[i] = tmp;
			adjustHeap(arr, 0, i-1);
		}
	}
	
	
	public static void main(String[] args) {
		int[] arr = {3,1,6,2,8,7,9,5,4};
		heapSort(arr);
		for(int i=0; i < arr.length; i++){
			System.out.print(arr[i] + "  ");
		}
	}
}
