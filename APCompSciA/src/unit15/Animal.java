package unit15;

public class Animal {
	
	String name;
	int age;
	
	public Animal() {
		setName("spot");
		setAge(1);
	}
	
	public Animal(String n, int a) {
		setName(n);
		setAge(a);
	}
	
	public void setName(String n) {
		name=n;
	}
	
	public String getName() {
		return name; 
	}
	
	public void setAge(int a) {
		age = a; 
	}
	
	public int getAge() {
		return age;
	}

}
