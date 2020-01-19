package day1;

import java.util.Objects;

public class Person {
	String name;
	Integer age;

	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Person(String name,Integer age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Person{" +
		"name=" + name+  "," + "age="+age+ "}";	
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
        //getClass() != o.getClass() 使用反射技术,判断o是否是Person类型  等效于 obj instanceof Person
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Person person = (Person)obj;
		return age == person.age && Objects.equals(name, person.name);
	}

}
