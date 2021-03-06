
<%@ page import="sampleapp.Employee"%>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'employee.label', default: 'Employee')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
	<a href="#list-employee" class="skip" tabindex="-1"><g:message
			code="default.link.skip.label" default="Skip to content&hellip;" /></a>
	<div class="nav" role="navigation">
		<ul>
			<li><a class="home" href="${createLink(uri: '/')}"><g:message
						code="default.home.label" /></a></li>
			<li><g:link class="create" action="create">
					<g:message code="default.new.label" args="[entityName]" />
				</g:link></li>
		</ul>
	</div>
	<div id="list-employee" class="content scaffold-list" role="main">
		<h1>
			<g:message code="default.list.label" args="[entityName]" />
		</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		<table>
			<thead>
				<tr>

					<g:sortableColumn property="employeeId"
						title="${message(code: 'employee.employeeId.label', default: 'Employee Id')}" />

					<g:sortableColumn property="employeeName"
						title="${message(code: 'employee.employeeName.label', default: 'Employee Name')}" />

					<g:sortableColumn property="age"
						title="${message(code: 'employee.age.label', default: 'Age')}" />

				</tr>
			</thead>
			<tbody>
				<g:each in="${employeeInstanceList}" status="i"
					var="employeeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

						<td><g:link action="show" id="${employeeInstance.id}">
								${fieldValue(bean: employeeInstance, field: "employeeId")}
							</g:link></td>

						<td>
							${fieldValue(bean: employeeInstance, field: "employeeName")}
						</td>

						<td>
							${fieldValue(bean: employeeInstance, field: "age")}
						</td>

					</tr>
				</g:each>
			</tbody>
		</table>
		<div class="pagination">
				<g:paginate total="${employeeInstanceCount ?: 0}" />
			</div>
		
	</div>
</body>
</html>
