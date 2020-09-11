package stream.collect;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import common.EmpDAO;
import common.Employee;
public class CollectionDataBaseGroupby {
	public static void main(String[] args) {	
	//직무별 사원그륩.
	List<Employee> list =new ArrayList<>();
	 try {
		list = EmpDAO.getEmpList();
	} catch (SQLException e) {
		e.printStackTrace();
	
	}
	 
	 Map<String , List<Employee>> map;
	 Map<String, List<Employee>> gmap = list.stream()
			 .collect(Collectors.groupingBy(new Function<Employee, String>() {
				@Override
				public String apply(Employee t) {
					return t.getJobId();
				}
			},Collectors.toList()));
	 Set<String> set = gmap.keySet();
	 for(String g : set) {
		 System.out.println(" ");
		 System.out.println("--"+g+"--");
		 
		 List<Employee> list2 = gmap.get(g);
		 for(Employee s : list2) {
			 System.out.println(s.getFirstName()+ " " +s.getLastName());
		 }
		 
	 }
	 
}
}