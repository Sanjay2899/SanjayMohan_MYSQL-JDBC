package GL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class EmployeeDAO {

	Connection con;
	ResultSet rs;
	Statement stmt;
	PreparedStatement ps;
	ArrayList<Employee> employees;
	Employee employee;
	
	public boolean insertEmployee(Employee empI)
	{
		try {
			ps=con.prepareStatement("insert into employee (Id,Name,Email_Id,Phone_Number)values(?,?,?,?)");
			ps.setInt(1, empI.getId());
			ps.setString(2, empI.getName());
			ps.setString(3, empI.getEmail_Id());
			ps.setString(4, empI.getPhone_Number());
			return ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean AlterTableColumn(String columnName)
	{
		try {
			 stmt= con.createStatement();
			 String sql = "ALTER TABLE employee MODIFY "+columnName;
			 return stmt.execute(sql);
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	public ArrayList<Employee> getAllEmployee()
	{
		String query="select * from employee";
		employees=new ArrayList<Employee>();
		try {
			rs=stmt.executeQuery(query);
			while(rs.next())
			{
				employees.add(new Employee(rs.getInt("Id"),rs.getString("Name") , rs.getString("Email_Id"),rs.getString("Phone_Number")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
		
		
	}
	public boolean updateEmployee(Employee empu)
	{
		try {
			ps=con.prepareStatement("update employee set Name= ?,Phone_Number=? where Id=?");
			ps.setString(1, empu.getName());
			ps.setString(2, empu.getPhone_Number());
			ps.setInt(3, empu.getId());
			return ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean deleteEmployeeById(int empid)
	{
		String query="delete from employee where Id ='"+empid+"'";
		try {
			return stmt.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean deleteAllRecords()
	{
		String query="truncate table employee;";
		try {
			return stmt.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
