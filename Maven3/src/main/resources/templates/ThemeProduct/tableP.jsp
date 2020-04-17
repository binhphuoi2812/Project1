<%@page import="com.trungtamjava.outmodel.Product" import="java.util.List"%>
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
<link rel="stylesheet" href="ThemeProduct/tableP.css">
<title>Database</title>
</head>
<body>
	<div id="header"></div>
	<div id="container">
		<div class="force">
			<div class="logo">
				<a href=""><img src="/ThemeProduct/img/10.jpg" alt=""></a>
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
		<div class="ground">
			<div class="forum">
				<%
				List<Product> products = (List<Product>) request.getAttribute("productlist");
			%>
				<form action="/Maven02/SearchProduct" method="get">
					<ul>
						<li><a href="/Maven02/AddProduct">Them Product</a></li>
						<li><a href="/Maven02/SearchProduct">Tim Kiem Product</a></li>
					</ul>
					<div class="f form-group">
						<label for="">Product Name:</label> <input class="form-control"
							name="fname" type="text" value=""
							placeholder="Enter Product Name">
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
                                    <th>Price</th>
                                    <th>Image</th>
                                    <th>Description</th>
                                    <th>Category</th>
								</tr>
							</thead>

						
                     <c:forEach items="${productlist}" var ="p">

							<tr>
								<td>${p.getId()}</td>
								<td>${p.name}</td>
								<td>${p.getPrice()}</td>
						        <td>${p.getImage()}</td>
								<td>${p.getDescription()}</td>
							    <td>${p.getCategory().getName()}</td>
								
								<td><a href="/Maven02/UpdateProduct?id=${p.getId()}">Update</a>
									<a href="/Maven02/DeleteProduct?id=${p.getId()}">Delete</a>
								</td>
							</tr>
					</c:forEach>

						</table>
					</div>
				</form>
			</div>
		</div>

	</div>
</body>
</html>