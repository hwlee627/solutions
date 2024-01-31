package 테네스씨의특별한소수_sw_4698_2w;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] primeNumber = new boolean [1000001];
		
		primeNumber[0] = true;
		primeNumber[1] = true;
		
		for (int i = 2; i < Math.sqrt(1000000); i++) {
			if(primeNumber[i]) {
				continue;
			}
			for(int j = i*i; j < primeNumber.length; j = j+i) {
				primeNumber[j] = true;
			}
		}
		System.out.println(Arrays.toString(primeNumber));
	}

}
