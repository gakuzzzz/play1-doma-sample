package controllers;

import static models.Aliases.EmployeeId;
import static models.Aliases.Name;

import java.util.List;

import javax.inject.Inject;

import models.Employee;
import models.EmployeeDao;
import play.modules.guice.InjectSupport;
import play.mvc.Controller;

@InjectSupport
public class Application extends Controller {

	@Inject
	static EmployeeDao dao;
	
    public static void index() {
    	domain();
    }

    public static void domain() {
    	final Employee employee = dao.findById(EmployeeId(1));
        render(employee);
    }
    
    public static void external() {
    	final List<Employee> employees = dao.findByName(Name("test1"));
        render(employees);
    }

    public static void basic() {
    	final Employee employee = dao.findById(1);
        render(employee);
    }

}