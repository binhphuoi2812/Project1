package Project;

import java.util.*;
import java.lang.*;

import Project.Employee;

public class ArrEmployee {

	public static void test() {

		List<Employee> personList = new ArrayList<>(); // khởi tạo một array list

		while(true) {
		System.out.println("Nhap vao lua chon cua ban :");
		System.out.println("Lua chon 1: Them nhan vien");
		System.out.println("Lua chon 2: Hien Thi thong tin nhan vien");
		System.out.println("Lua chon 3: Hien thi nhan vien thuoc tuoi nghi huu");
		System.out.println("Lua chon 4: Hien THi 10 nhan vien tre nhat:");
		System.out.println("Lua chon 5: exit");

		Scanner input = new Scanner(System.in);
		int choose = input.nextInt();
		switch (choose) {
		case 1:
			while (true) {
				System.out.println("Nhap vao thong tin nhan vien :" + "\n");

				Employee person = new Employee();

				System.out.println("Nhap vao ma nhan vien :" + "\n");
				Scanner nhap = new Scanner(System.in);
				int id = nhap.nextInt();
				person.setId(id); 

				System.out.println("Nhap vao ten nhan vien :" + "\n");
				Scanner nhap2 = new Scanner(System.in);
				String name = nhap2.nextLine();
				while (name.isEmpty()) {
					System.out.println("Ten nhan vien khong duoc de trong ! Nhap lai ten nhan vien :" + "\n");
					name = nhap2.nextLine();
				}
				person.setName(name);

				System.out.println("Nhap vao ma phong :" + "\n");
				Scanner nhap3 = new Scanner(System.in);
				String room = nhap3.nextLine();
				person.setRoom(room);

				System.out.println("Nhap vao tuoi nhan vien :" + "\n");
				Scanner nhap4 = new Scanner(System.in);
				int age = nhap4.nextInt();
				person.setAge(age);

				personList.add(person);  // thêm phần tử vào array list

				System.out.println(" Continue ? Y/N : 1/0 " + "\n");
				Scanner nhap5 = new Scanner(System.in);
				int confirm = nhap5.nextInt();

				if (confirm != 1) {
					break;
				}
			}

			break;

		case 2:
			for (Employee emp : personList) {
				System.out.println(emp.getId());
				System.out.println(emp.getName());
				System.out.println(emp.getRoom());
				System.out.println(emp.getAge());
			}

			break;

		case 3:
			for (Employee emp : personList) {

				if (emp.getAge() <= 59 && emp.getAge() >= 56) {
					System.out.println(emp.getId());
					System.out.println(emp.getName());
					System.out.println(emp.getRoom());
					System.out.println(emp.getAge());
				}

			}

			break;

		case 4:
			class SortByAge implements Comparator<Employee> {

				@Override
				public int compare(Employee a, Employee b) {

					return a.getAge() - b.getAge();
				}

			}

			Collections.sort(personList, new SortByAge());    // sắp xếp các phần tử trong array list 
			System.out.println("10 nhan vien tre nhat :" + "\n");
			for (int i = 0; i < personList.size(); i++) {      // độ dài array list
				System.out.println(personList.get(i));
			}

			break;

		default:
			break;

		}
		}
	}

	public static void main(String[] args) {
		test();
	}

}
