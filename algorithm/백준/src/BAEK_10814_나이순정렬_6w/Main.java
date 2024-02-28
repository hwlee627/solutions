package BAEK_10814_나이순정렬_6w;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int peoCnt = sc.nextInt();
		List<Person> personList = new ArrayList<Person>();
		int peoIdx = 0;
		int age = 0;
		
		for(int i = 0; i<peoCnt*2; i++) {
			if(i%2 == 0) {
				age = sc.nextInt();
			}else {
				String name = sc.next();
				Person person = new Person(age, name);
				personList.add(person);
			}
		}
		personList.sort(new ageCompare());
		
		for(Person peo : personList) {
			System.out.println(peo.age+" "+peo.name);
		}
		
	}
	
}
class Person{
	public int age;
	public String name;
	
	Person(int age, String name){
		this.age = age;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
}
class ageCompare implements Comparator<Person>{
	@Override
	public int compare(Person o, Person o2) {
		if(o.age>o2.age) {
			return 1;
		}else if(o.age == o2.age) {
			return 0;
		}else {
			return -1;
		}
	}
}
