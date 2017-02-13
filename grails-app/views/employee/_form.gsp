<%@ page import="sampleapp.Employee" %>



<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'employeeId', 'error')} required">
	<label for="employeeId">
		<g:message code="employee.employeeId.label" default="Employee Id" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="employeeId" required="" value="${employeeInstance?.employeeId}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'employeeName', 'error')} required">
	<label for="employeeName">
		<g:message code="employee.employeeName.label" default="Employee Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="employeeName" required="" value="${employeeInstance?.employeeName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'age', 'error')} required">
	<label for="age">
		<g:message code="employee.age.label" default="Age" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="age" type="number" min="18" value="${employeeInstance.age}" required=""/>

</div>

