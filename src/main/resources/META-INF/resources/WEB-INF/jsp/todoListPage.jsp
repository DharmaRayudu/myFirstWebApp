<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
		<title>To Do List</title>
		<style>
			h1{
				text-align: center;
			}
		</style>
	</head>
	<body>
		<%@ include file="common/navigation.jspf"%>
		<h1>Welcome! ${name}</h1>
		
		<div class="container">
		<hr>
		<h4>Your Todo List</h4>
			<table>
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Description</th>
						<th>Target Date</th>
						<th>IsCompleted</th>
						<th> </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.id}</td>
						<td>${todo.name}</td>
						<td>${todo.description}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.done}</td>
						<td> <a href="delete-todo?id=${todo.id}" class="btn btn-danger">DELETE</a> </td>
						<td> <a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a> </td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<hr>
			<a href="add-todo" class="btn btn-success">Add Todo</a>
		</div>
	</body>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	
</html>