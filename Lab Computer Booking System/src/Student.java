
public class Student {
	
	private int id;
	private String name;
	
	public Student(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void printStudent(){
		System.out.print(name);
	}
	
}