package om.abhi.rest.resource;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="employees")
public class EmpList {
	
	
	private List<Employee> employees;

	@XmlElement(name="employee")
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	

}
