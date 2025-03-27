<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<meta charset="ISO-8859-1">
<title>Dashboard</title>

 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>
 <link rel="stylesheet" href="dashboard.css">
</head>
<body>

		<c:set var="sesreg" value="${sesreg}"></c:set>
	<c:choose>
		<c:when test="${sesreg=='success'}">
			
		</c:when>
	</c:choose>
	<c:remove scope="session" var="sesreg"/>

  <div class="container">
    <nav>
      <ul>
        <li><a href="#" class="logo">
          <img src="/logo.jpg" alt="">
          <span class="nav-item">DashBoard</span>
        </a></li>
        <li><a href="#">
          <i class="fas fa-home"></i>
          <span class="nav-item">Home</span>
        </a></li>
        <li><a href="#">
          <i class="fas fa-user"></i>
          <span class="nav-item">Profile</span>
        </a></li>
        <li><a href="#">
          <i class="fas fa-wallet"></i>
          <span class="nav-item">Wallet</span>
        </a></li>
        <li><a href="#">
          <i class="fas fa-chart-bar"></i>
          <span class="nav-item">Analytics</span>
        </a></li>
        <li><a href="#">
          <i class="fas fa-tasks"></i>
          <span class="nav-item">Tasks</span>
        </a></li>
        <li><a href="#">
          <i class="fas fa-cog"></i>
          <span class="nav-item">Settings</span>
        </a></li>
        <li><a href="#">
          <i class="fas fa-question-circle"></i>
          <span class="nav-item">Help</span>
        </a></li>
        <li><a href="#" class="logout">
          <i class="fas fa-sign-out-alt"></i>
          <span class="nav-item">Log out</span>
        </a></li>
      </ul>
    </nav>

    <section class="main">

 <table style="" class="table table-dark">
  
  <thead>
    <tr>
<% System.out.println("Session attribute 'list' set: " + session.getAttribute("list")); // Debugging %>
     
     <th scope="col">ID</th>
      <th scope="col">name</th>
      <th scope="col">email</th>
      <th scope="col">password</th>
      <th scope="col">phone</th>
      <th scope="col">dob</th>
      <th scope="col">course</th>
      <th scope="col">gender</th>
      <th scope="col">address</th>
      <th scope="col">country</th>
     
      <th scope="col">region</th>
      <th scope="col">pin</th>
     
      
     
    </tr>
    
    <c:forEach var="rm" items="${list}">
    <tr><td>${rm.id}</td>
    <td>${rm.name}</td>
    <td>${rm.email}</td>
    <td>${rm.password}</td>
    <td>${rm.mob}</td>
    <td>${rm.dob}</td>
    <td>${rm.course}</td>
    <td>${rm.gender}</td>
    <td>${rm.address}</td>
    <td>${rm.country}</td>
 
    <td>${rm.region}</td>
    <td>${rm.pin}</td>
    <td>
        <a href="EditController?id=${rm.id}" class="btn btn-primary">Edit</a>
     </td>
    </tr>
       
    </c:forEach>
  </thead>
 </table>

    </section>
  </div>
</body>
</html>