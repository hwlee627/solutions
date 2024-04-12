import java.util.Arrays;

public class 패턴매칭_KMP {

	public static void main(String[] args) {
		String text = "ABABABACABAABABACACA";
		String pattern = "ABABACA";
		
		KMP(text,pattern);
		
	}

	private static void KMP(String T, String P) {
		
		int[] pi = getPi(P);
//		System.out.println(Arrays.toString(pi));
		int j = 0;
		for(int i = 0; i<T.length(); i++) {
			
			while(j>0 && T.charAt(i) != P.charAt(j)) {
				j = pi[j-1];
			}
			if(T.charAt(i) == P.charAt(j)) {
				if(j == P.length()-1) {
					//패턴과 같다면
					System.out.println(i-P.length()+1+"에서 시작하면 패턴을 찾았습니다.");
					j = pi[j];
				}else {
					j++;
				}
				
			}
		}
		
	}

	private static int[] getPi(String P) {
		//부분문자열 중 접두사와 접미사가 일치하는 최대길이를 담을 배열
		int[] pi = new int[P.length()];
		
		int j = 0; //여기까지는 같아요 ~
		
		for(int i = 1; i<P.length(); i++) {
			
			//지금 두개의 포인트가 가리키는 값이 다르면
			while(j>0 && P.charAt(i) != P.charAt(j)) {
				j = pi[j-1];
			}
			
			if(P.charAt(i) == P.charAt(j)) {
				pi[i] = ++j; //길이랑 1 차이 나니까, j를 ++해서 넣는다 !
			}
		}
		return pi;
	}

}
