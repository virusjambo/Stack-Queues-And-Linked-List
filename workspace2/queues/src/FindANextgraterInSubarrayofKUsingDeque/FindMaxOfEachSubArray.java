package FindANextgraterInSubarrayofKUsingDeque;

import dequeusingarrays.Dequeue;

public class FindMaxOfEachSubArray {

	static void findMaxOfEachSubArr(int arr[],int k){
		Dequeue<Integer> de=new Dequeue<>(k);
		int i=0;
		for(;i<k;i++){
			while(!de.isEmpty() && arr[i]>=de.peekLast()){
				de.pollLast();
				
			}
			de.addLast(i);
		}
		
		for(;i<arr.length;++i){
			System.out.println(arr[de.peekFirst()]);
			while(!de.isEmpty() && de.peekFirst()<=i-k)
				de.pollFirst();
				while(!de.isEmpty() && arr[i]>=arr[de.peekLast()]){
					de.pollLast();
				}
					de.addLast(i);	
					
			}
		System.out.println(arr[de.peekFirst()]);		
		}
	public static void main(String[] args) {
		int a[]={12, 100, 78, 90, 57, 89, 56};
		findMaxOfEachSubArr(a,3);
	}
		
	}
	

