package sampleapp

import grails.transaction.Transactional

@Transactional
class EmployeeService {

	def serviceMethod() {
	}

	def save(Employee employeeInstance){
		employeeInstance.save flush:true
	}

	def update(Employee employeeInstance){
		employeeInstance.save flush:true
	}

	def delete(Employee employeeInstance){
		employeeInstance.delete flush:true
	}

	def find(def name){
		def list=Employee.findAllByEmployeeName(name)
		return list
	}
}
