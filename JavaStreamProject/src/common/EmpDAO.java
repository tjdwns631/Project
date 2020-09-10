package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;

public class EmpDAO {
	// List<Employee> getEmplList();
	public static List<Employee> getEmpList() throws SQLException { //getemplist를 호출하면 list<employee>타입이 반환됨
		Connection conn = ConnectDB.getDB();
		List<Employee> list = new ArrayList<>(); //리스트에다 담음 
			String sql = "select * from emp_temp";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {//데이터를 가지고 올거라고 생성자에 매개값으로 바로 넣어줌
				Employee emp = new Employee(//new로 생성자를 호출 
						rs.getInt("employee_id"), //칼럼이름employeeid를 정수형으로 받아온다 
						rs.getString("first_name"),
						rs.getString("last_name"), 
						rs.getString("email"), 
						rs.getDate("hire_Date").toLocalDate(),
						rs.getString("job_id"), 
						rs.getInt("salary")
						);
				list.add(emp);
			}
		return list;
	}
//List<Employee> getEmpList();
}
