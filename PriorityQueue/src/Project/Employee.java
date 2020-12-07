package Project;
import java.util.*;


public class Employee {

	private int id;
	private String name;
	private String room;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String toString() {
		return this.id + this.name + this.room+ this.age ;  //Phương thức toString() trả về chuỗi đại diện của đối tượng.
		
	}
 }
