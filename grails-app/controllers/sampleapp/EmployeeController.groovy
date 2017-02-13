package sampleapp



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EmployeeController {

	def employeeService

	static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	def index(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		respond Employee.list(params), model:[employeeInstanceCount: Employee.count()]
	}

	def show(Employee employeeInstance) {
		respond employeeInstance
	}

	def find(){
		respond this.employeeService.find(params.employeeName);
	}

	def create() {
		respond new Employee(params)
	}

	@Transactional
	def save(Employee employeeInstance) {
		if (employeeInstance == null) {
			notFound()
			return
		}

		if (employeeInstance.hasErrors()) {
			respond employeeInstance.errors, view:'create'
			return
		}

		this.employeeService.save(employeeInstance)
		/*employeeInstance.save(flush:true)*/

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.created.message', args: [
					message(code: 'employee.label', default: 'Employee'),
					employeeInstance.id
				])
				redirect employeeInstance
			}
			'*' { respond employeeInstance, [status: CREATED] }
		}
	}

	def edit(Employee employeeInstance) {
		respond employeeInstance
	}

	@Transactional
	def update(Employee employeeInstance) {
		if (employeeInstance == null) {
			notFound()
			return
		}

		if (employeeInstance.hasErrors()) {
			respond employeeInstance.errors, view:'edit'
			return
		}

		this.employeeService.save(employeeInstance)
		/*employeeInstance.save flush:true*/

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.updated.message', args: [
					message(code: 'Employee.label', default: 'Employee'),
					employeeInstance.id
				])
				redirect employeeInstance
			}
			'*'{ respond employeeInstance, [status: OK] }
		}
	}

	@Transactional
	def delete(Employee employeeInstance) {

		if (employeeInstance == null) {
			notFound()
			return
		}

		this.employeeService.delete(employeeInstance)
		/*employeeInstance.delete flush:true*/

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.deleted.message', args: [
					message(code: 'Employee.label', default: 'Employee'),
					employeeInstance.id
				])
				redirect action:"index", method:"GET"
			}
			'*'{ render status: NO_CONTENT }
		}
	}

	protected void notFound() {
		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.not.found.message', args: [
					message(code: 'employee.label', default: 'Employee'),
					params.id
				])
				redirect action: "index", method: "GET"
			}
			'*'{ render status: NOT_FOUND }
		}
	}
}
