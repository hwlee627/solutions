package BOJ_10814;

// 나이순정렬
// Comparator 이용
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Person2> people = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			people.add(new Person2(sc.nextInt(), sc.next()));
		}
		Collections.sort(people, new Comparator<Person2>() {

			@Override
			public int compare(Person2 o1, Person2 o2) {
				// TODO Auto-generated method stub
				return o1.age-o2.age;
			}
		});
		for (int i = 0; i < N; i++) {
			System.out.print(people.get(i).age + " " + people.get(i).name + "\n");
		}
	}
}
class Person2{
	int age;
	String name;

	Person2(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
}