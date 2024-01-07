<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<body>
    <%@include file="navbar.html" %>
        <br>

        <div class=container>
            <div class="card m-5 p-2">
                <div class="card-header">
                    <h2>event details</h2>
                </div>
                <div class="card-body">
                    <form action="/eventapi/event" method=post>

                        <input type="hidden" name="id"  id="id"  value="${event.id}"  >
                        <div class="mb-3 mt-3">
                            <label for="name" class="form-label">Nom:</label>
                            <input type=text class="form-control" id="name" name="name" value="${event.name}">
                        </div>
                        <div class="mb-3">
                            <label for="price" class="form-label">Prix:</label>
                            <input type="number" class="form-control" id="price" name="price" value="${event.price}">
                        </div>
                        <div class="mb-3">
                            <label for="animator" class="form-label">Animator:</label>
                            <input type="text" class="form-control" id="animator" name="animator"
                                value="${event.animator}">
                        </div>


                        <div class="mb-3">
                            <label for="Event" class="form-label">Event:</label>
                            <select name="themeId">
                                <c:forEach items="${listTheme}" var="theme">
                                    <c:if test="${event.theme.id == theme.id}"><option value="${theme.id}" selected >${theme.name}</option></c:if>
                                    <c:if test="${event.theme.id != theme.id}"><option value="${theme.id}"          >${theme.name}</option></c:if>
                                </c:forEach>
                            </select>

                        </div>


                        <label class="form-label"> photo </label>
                        <br>
                        <img src="/eventapi/images/${event.picture}"  width="50" height="50" />
                        <button type="submit" class="btn btn-primary">Save</button>
                    </form>
                </div>
            </div>
        </div>
</body>
