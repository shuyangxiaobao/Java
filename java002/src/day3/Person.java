package day3;
import java.util.Objects;

public class Person implements Comparable<Person> {
	String name;
	int age;
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name,int age) {
		this.name = name;
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Person person = (Person) o;
		return age == person.age &&
				Objects.equals(name, person.name);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(name,age);
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		//return 0;//认为元素都是相同的
		//自定义比较的规则,比较两个人的年龄(this,参数Person)
		//return this.getAge() - o.getAge();//年龄升序排序
		return o.getAge() - this.getAge();//年龄升序排序	}
	}
}







