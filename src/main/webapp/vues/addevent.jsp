<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<body>
<%@include file="navbar.html" %>
<br>
<div class=container>
<div class="card m-5 p-2">
 <div class="card-header"><h2>Add event</h2></div>
<div class="card-body">
<form action="saveevent" method=post   enctype="multipart/form-data" >

 <div class="mb-3 mt-3">
 <label for="name" class="form-label">Nom:</label>
 <input type=text class="form-control" id="name" name="name" value="${event.name}">
 </div>
 <div class="mb-3">
 <label for="price" class="form-label">Prix:</label>
 <input type="number" class="form-control" id="price" name="price" value="${event.price}">
 </div>
 <div class="mb-3">
 <label for="quantity" class="form-label">Animator:</label>
 <input type="text" class="form-control" id="animator" name="animator" value="${event.animator}">
 </div>

 <div class="mb-3">
   <label for="eventAddress" class="form-label">Address :</label>
 <div class="mb-3">
  <label for="city" class="form-label">city:</label>
  <input type="text" class="form-control" id="city" name="city" value="${eventAddress.city}">
  </div>
  <div class="mb-3">
    <label for="district" class="form-label">district:</label>
    <input type="text" class="form-control" id="district" name="district" value="${eventAddress.district}">
    </div>
    <div class="mb-3">
      <label for="streetName" class="form-label">Street name:</label>
      <input type="text" class="form-control" id="streetName" name="streetName" value="${eventAddress.streetName}">
      </div>
      <div class="mb-3">
            <label for="streetCode" class="form-label">Street code:</label>
            <input type="text" class="form-control" id="streetCode" name="streetCode" value="${eventAddress.streetCode}">
            </div>
</div>



 <div class="mb-3">
  <label for="Theme" class="form-label">Theme :</label>
 <select name="theme">
 <c:forEach items="${listTheme}" var="theme">
 <option value="${theme.id}">${theme.name}</option>
 </c:forEach>
 </select>

  </div>


  <label class="form-label"> photo </label>
  <input type="file" name="file" accept="image/png, image/jpeg" class="form-control" />


 <button type="submit" class="btn btn-primary" >Save</button>
</form></div> </div></div></body>
