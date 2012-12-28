package models;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import config.DomaConfig;

@Dao(config = DomaConfig.class)
public interface EmployeeDao {

	@Select
	Employee findById(EmployeeId employeeId);

	@Select
	Employee findById(Integer employeeId);
	
	@Select
	List<Employee> findByName(Name name);
	
}
