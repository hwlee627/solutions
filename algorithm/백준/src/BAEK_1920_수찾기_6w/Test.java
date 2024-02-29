package BAEK_1920_수찾기_6w;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		String str = "45617";
		System.out.println(str.indexOf("r"));
		
		int[] arr = new int[] {-5,1,2,3,4};
		
		int num = 5;
		
		System.out.println(Arrays.binarySearch(arr, num));
	}

}
