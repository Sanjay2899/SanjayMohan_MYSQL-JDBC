package GL;

import java.util.ArrayList;
import java.util.Scanner;




public class EmployeeDataManagement {
	
	public void showMenu()
	{
	
		int cont=0;
		EmployeeService service=new EmployeeService("jdbc:mysql://localhost:3306/GL", "root", "root");
		Scanner sc=new Scanner(System.in);
		while(cont!=7)
		{
			System.out.println("1.Insert Employee Record");
			System.out.println("2.Modify Coluumn Type");
			System.out.println("3.Update Employee Name and Phone_Number");
			System.out.println("4.Delete a Record From Employee");
			System.out.println("5.View All Employee Records");
			System.out.println("6.Delete All Employee Records");
			System.out.println("7.Exit");
			cont=sc.nextInt();
			switch(cont)
			{
			case 1:
				System.out.println("Enter number records you want to insert : ");
				int r=sc.nextInt();
				int count=0;
				while(count!=r)
				{
					System.out.println("Enter the Id : ");
					int Id=sc.nextInt();
					System.out.println("Enter the Name : ");
					String Name=sc.next();
					System.out.println("Enter the Email_Id : ");
					String Email_id=sc.next();
					System.out.println("Enter the Phone_Number : ");
					String Phone_Number=sc.next();
					Employee emp=new Employee(Id, Name, Email_id, Phone_Number);
					service.insertEmployeeRecord(emp);
					count++;
				}
				break;
			case 2:
				System.out.println("Enter the Columan Name and Type To change : ");
				sc.nextLine();
				String M=sc.nextLine();
				service.ModifyColumn(M);
				break;
			case 3:
				System.out.println("Enter the Name needed to update :");
				String Name=sc.next();
				System.out.println("Enter the Phone_Number needed to update :");
				String Phone_Number=sc.next();
				System.out.println("Enter the Id : ");
				int Id=sc.nextInt();
				Employee emp=new Employee(Name,Phone_Number,Id);
				service.updateTableRecords(emp);
				break;
			case 4:
				System.out.println("Enter the Id : ");
				int Id1=sc.nextInt();
				service.DeleteRecord(Id1);
				break;
			case 5:
				ArrayList<Employee> Emp=new ArrayList<>();
				Emp=service.getEmployeeRecords();
				for(Employee emp1:Emp)
				{
					System.out.println(emp1);
				}
				break;
			case  6:
				System.out.println("Deleting all records");
				service.DeleteAllRecord();
				break;
			case 7:
				System.out.println("Exiting");
				System.exit(0);
				break;
			}
			
		}
		
	}

}
