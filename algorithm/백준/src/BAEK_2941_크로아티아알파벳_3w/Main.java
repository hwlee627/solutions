package BAEK_2941_크로아티아알파벳_3w;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String croatia = sc.next();

		int croatialetterCnt = 0;
		while(true) {
			if (croatia.contains("c=")) {
				
				croatia = croatia.replace("c=", "o");
			} else if (croatia.contains("c-")) {
				
				croatia = croatia.replace("c-", "o");
			} else if (croatia.contains("dz=")) {
				
				croatia = croatia.replace("dz=", "o");
			} else if (croatia.contains("d-")) {
				
				croatia = croatia.replace("d-", "o");
			} else if (croatia.contains("lj")) {
				
				croatia = croatia.replace("lj", "o");
			} else if (croatia.contains("nj")) {
				
				croatia = croatia.replace("nj", "o");
			} else if (croatia.contains("s=")) {
				
				croatia = croatia.replace("s=", "o");
			} else if (croatia.contains("z=")) {
				
				croatia = croatia.replace("z=", "o");
			}else {
				break;
			}
		}
		croatialetterCnt += croatia.length();
		
		System.out.println(croatialetterCnt);

	}

}
