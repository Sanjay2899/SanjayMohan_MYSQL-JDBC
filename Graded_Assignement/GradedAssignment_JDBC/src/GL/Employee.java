package GL;

public class Employee {
	
	private int Id;
	private String Name;
	private String Email_Id;
	private String Phone_Number;
	public Employee(int id, String name, String email_Id, String phone_Number) {
		super();
		Id = id;
		Name = name;
		Email_Id = email_Id;
		Phone_Number = phone_Number;
	}
	public Employee( String name, String phone_Number,int id) {
		super();
		Id = id;
		Name = name;
		Phone_Number = phone_Number;
	}
	public int getId() {
		return Id;
	}
	public String getName() {
		return Name;
	}
	public String getEmail_Id() {
		return Email_Id;
	}
	public String getPhone_Number() {
		return Phone_Number;
	}
	public void setId(int id) {
		Id = id;
	}
	public void setName(String name) {
		Name = name;
	}
	public void setEmail_Id(String email_Id) {
		Email_Id = email_Id;
	}
	public void setPhone_Number(String phone_Number) {
		Phone_Number = phone_Number;
	}
	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", Name=" + Name + ", Email_Id=" + Email_Id + ", Phone_Number=" + Phone_Number
				+ "]";
	}
	

}
