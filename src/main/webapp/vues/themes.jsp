<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<body>
<%@include file="navbar.html"%>
<br><br>

<div class=container>
<div class="row mt-4 pl-2">
<a href="/themeapi/addtheme" class="btn btn-primary" > Add Theme </a>
</div> </div>
<br><hr>

<table class="table table-hover">
<tr>
 <th>Id</th><th>Name</th>
</tr>
<c:forEach items="${themes}" var="t">
<tr>
<td>${t.id}</td>
<td>${t.name}</td>

<td> <form action="deletetheme/${t.id}" method="post">
         <button type="submit" class="btn btn-primary">Delete</button></form>

</td>

</tr>
</c:forEach>
</table>
</body>
