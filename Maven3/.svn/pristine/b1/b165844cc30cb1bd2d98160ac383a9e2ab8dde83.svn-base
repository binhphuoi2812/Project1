<%@page import="com.trungtamjava.outmodel.Person" import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Form</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="ThemeClient/table.css">
<title>Database</title>
</head>
<body>
<%
      System.out.println(session.getId());
      Person loginUser = (Person) session.getAttribute("LoginUser");
%>
<h1>Xin chao <%= loginUser.getName() %></h1>
<h1>${sessionScope.loginUser.name}</h1>
	<div id="header"></div>
	<div id="container">
		<div class="force">
			<div class="logo">
				<a href=""><img src="ThemeClient/img/10.jpg" alt=""></a>
			</div>
			<div class="filter">
				<div class="wr1">
					<div class="from">
						<label for="sel1">From</label> <select class="form-control"
							id="sel1">
							<option>VietNam</option>
							<option>Japan</option>
							<option>USA</option>
							<option>Korean</option>
						</select>
					</div>
					<div class="to">
						<label for="sel1">To</label> <select class="form-control"
							id="sel1">
							<option>VietNam</option>
							<option>Japan</option>
							<option>USA</option>
							<option>Korean</option>
						</select>
					</div>
					<div class="plane">
						<label for="sel1">Plane</label> <select class="form-control"
							id="sel1">
							<option>VietNamAirlines</option>
							<option>BambooAirWays</option>
							<option>JetStar</option>
							<option>VietJet</option>
						</select>
					</div>
				</div>
			</div>
		</div>
			<%
				List<Person> persons = (List<Person>) request.getAttribute("personlist");
			%>
		<form action="/Maven02/SearchClient" method="get">
			<ul>	
				  <li><a href="/Final/AddClient">Them Person</a></li>
				  <li><a href="/Final/SearchClient">Tim Kiem Person</a></li>
				</ul>
		<div class="f form-group">
						<label for="">Admin Name:</label> <input class="form-control"
							name="fname" type="text" value=""
							placeholder="Enter Admin Name">
					</div>
						<div class="f9">

						<button type="submit btn btn-primary">Submit</button>
					</div>
            
			<div class="table1">
				<table border="1">
					<thead>
						<tr>
							<th>id</th>
							<th>Name</th>
							<th>Role</th>
							<th>ImageUrl</th>

						</tr>
					</thead>
                    <c:forEach items ="${personlist}" var="p">
                    	<tr>
						<td>${p.getId()}</td>
						<td>${p.getName()}</td>
						<td>${p.getRole()}</td>
						<td>${p.getImageurl()}</td>
						<td>
						    <a href="/Maven02/UpdateClient?id=${p.id }">Update</a>
							<a href="/Maven02/DeleteClient?id=${p.id }">Delete</a>
						</td>
					</tr>
                    </c:forEach>
				</table>
			</div>
		</form>
	</div>
</body>
</html>