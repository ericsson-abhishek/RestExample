package om.abhi.rest.resource;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="employee")
public class Employee {
	
	public Employee()
	{
		
	}
	
	public Employee(String id,String name)
	{
		this.empId=id;
		this.empName=name;
	}
	private String empName;
	private String empId;
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}

}
