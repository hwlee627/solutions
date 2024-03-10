package BOJ_10814;

// 나이순정렬
// Comparable을 구현, 오름차순이면 this - p
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Person> people = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			people.add(new Person(sc.nextInt(), sc.next()));
		}
		Collections.sort(people);
		for (int i = 0; i < N; i++) {
			System.out.print(people.get(i).age + " " + people.get(i).name + "\n");
		}
	}
}

class Person implements Comparable<Person> {
	int age;
	String name;

	Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	@Override
	public int compareTo(Person p) {

		return this.age - p.age;
	}
}