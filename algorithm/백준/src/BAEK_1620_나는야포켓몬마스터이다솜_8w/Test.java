package BAEK_1620_나는야포켓몬마스터이다솜_8w;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "A";
		try {
			System.out.println(Integer.parseInt(a));
		}catch(Exception e) {
			if(e instanceof NumberFormatException) {
				System.out.println("숫자 잘 해라");
			}
		}finally {
			System.out.println("메롱");
		}
		
	}

}
