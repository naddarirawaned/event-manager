<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Page Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <!-- Add any additional stylesheets or scripts here -->
    <style>
        .card {
            height: 100%;
        }
        .card-body {
            height: 300px; /* Increased height to accommodate additional content */
            overflow: hidden; /* Hide content if it exceeds the fixed height */
        }
        .card-img-top {
            height: 250px; /* Set a fixed height for card image */
            object-fit: cover; /* Ensure the image covers the entire container */
        }
    </style>
</head>
<body>

    <%@include file="navbar.html"%>
    <br>
    <br>
    <br>

    <form method="get" action="eventmc" class="mt-4">
        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <label for="mc" class="form-label">Mot Cle:</label>
                </div>
                <div class="col-md-6">
                    <div class="input-group">
                        <input type="text" id="mc" class="form-control" name="mc">
                        <div class="input-group-append">
                            <button type="submit" class="btn btn-primary">Search</button>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <a href="/eventapi/addevent" class="btn btn-primary">Add Event</a>
                </div>
            </div>
        </div>
    </form>

    <hr>

    <div class="container mt-4">
        <div class="row">
            <c:forEach items="${events}" var="e">
                <div class="col-md-4 mb-4">
                    <div class="card">
                        <img src="/eventapi/images/${e.picture}" class="card-img-top" alt="Event Image">
                        <div class="card-body">
                            <h5 class="card-title">${e.name}</h5>
                            <p class="card-text">Price: ${e.price}</p>
                            <p class="card-text">Animator: ${e.animator}</p>
                            <p class="card-text">Theme: ${e.theme.name}</p>
                            <p class="card-text">Sponsors: ${e.sponsors}</p>
                            <p class="card-text">Address: ${e.address.city}, ${e.address.district}</p>
                            <a href="/eventapi/event/${e.id}" class="btn btn-primary">Details</a>
                            <form action="/eventapi/deleteevent/${e.id}" method="post" style="display: inline;">
                                <button type="submit" class="btn btn-danger">Delete</button>
                            </form>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <!-- Add any additional scripts here -->

</body>
</html>
