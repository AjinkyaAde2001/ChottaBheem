<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    <meta charset="ISO-8859-1">
    <title>Login Page</title>
    <link rel="stylesheet" href="log.css">
</head>
<body>

<c:set var="sesreg" value="${sesreg}"></c:set>
<c:choose>
    <c:when test="${sesreg=='success'}">
        <script type="text/javascript">alert("Registration Success New Logged In")</script>
    </c:when>
</c:choose>
<c:remove scope="session" var="sesreg"/>

<section>
    <span></span>
    <!-- Other span elements... -->
    <span></span>

    <div class="signin">
        <div class="content">
            <h2>Sign In</h2>
            <form action="LoginController" method="post"> <!-- Specify the form action -->
                <div class="form">
                    <div class="inputBox">
                        <input type="text" name="email" placeholder="Email" required> <!-- Use name attribute to capture the input -->
                    </div>
                    <div class="inputBox">
                        <input type="password" name="password" placeholder="Password" required> <!-- Use name attribute to capture the input -->
                    </div>
                    <div class="links">
                        <a href="#">Forgot Password</a>
                        <a href="#">Signup</a>
                    </div>
                    <div class="inputBox">
                        <input type="submit" value="Login">
                    </div>
                </div>
            </form>
        </div>
    </div>
</section>

</body>
</html>

