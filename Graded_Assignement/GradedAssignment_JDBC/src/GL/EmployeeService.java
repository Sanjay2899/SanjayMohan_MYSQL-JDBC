package GL;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;



public class EmployeeService {

	EmployeeDAO dao;
	public EmployeeService(String url,String username,String passward)
	{
		dao=new EmployeeDAO();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dao.con=DriverManager.getConnection(url,username,passward);
			dao.stmt=dao.con.createStatement();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//Driver name
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<Employee> getEmployeeRecords()
	{
		return dao.getAllEmployee();
	}
	public boolean insertEmployeeRecord(Employee emplI)
	{
	 return dao.insertEmployee(emplI);
	}
	public boolean ModifyColumn(String columnName)
	{
		return dao.AlterTableColumn(columnName);
	}
	public boolean updateTableRecords(Employee empUR)
	{
		return dao.updateEmployee(empUR);
	}
	public boolean DeleteRecord(int empid)
	{
		return dao.deleteEmployeeById(empid);
	}
	public boolean DeleteAllRecord()
	{
		return dao.deleteAllRecords();
	}
}
