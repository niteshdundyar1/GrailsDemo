package sampleapp

import org.springframework.beans.factory.annotation.Autowired

class Employee {
	@Autowired
	def employeeService
	
	String employeeId
	String employeeName
	Integer age

	static constraints = {
		employeeId nullable:false, blank:false, unique:true
		employeeName nullable:false, blank:false
		age min:18
	}
}
