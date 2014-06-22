package FindANextgraterInSubarrayofK;

public class FindMaxNumberOfEachSubArry {
	public static void main(String[] args) {
		int arr[]={45,68,80,90,40,30,60,100,80};
		int k=4;
		int i=0;
		for(;i<=arr.length-1;){
			int max=arr[i];
			for(int j=1;j<k;j++){
				if((i+j>= arr.length))
				{
					break;
				}
				if(  arr[i+j]>max){
					max=arr[i+j];
				}
			}
			i=i+k;

			System.out.println(max);
		}
	}

}
;