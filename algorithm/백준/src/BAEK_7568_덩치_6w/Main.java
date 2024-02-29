package BAEK_7568_덩치_6w;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int N = sc.nextInt(); //사람 수
		Person[] arr = new Person[N];
		for(int i = 0; i<N; i++) {
			
			Person person = new Person(sc.nextInt(), sc.nextInt());
			arr[i] = person;
		}
		
		for(int i = 0; i<N; i++) {
			int cnt = 0;
			for(int j = 0; j<N; j++) {
				if(arr[i].height < arr[j].height && arr[i].weight<arr[j].weight) {
					cnt++;
				}
			}
			System.out.print((cnt+1)+" ");
		}
		

	}

}
class Person{
	int weight;
	int height;
	
	Person(int weight, int height){
		this.weight = weight;
		this.height = height;
	}
}
