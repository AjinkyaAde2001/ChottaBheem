<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<meta charset="UTF-8">
<title>Edit User Information</title>
<link rel="stylesheet" href="reg.css">
</head>
<body>
<section class="container">
      <header>Edit User Information</header>
      <form action="updateController" class="form" method="post">
        <div class="input-box">
        
        <div class="input-box">
          <label>Id</label>
          <input type="number" placeholder="Enter ID" name="id" value="${sessionScope.rm.id}" required />
        </div>
        
        
          <label>Full Name</label>
          <input type="text" placeholder="Enter full name" name="name" value="${sessionScope.rm.name}" required />
        </div>

        <div class="input-box">
          <label>Email Address</label>
          <input type="text" placeholder="Enter email address" name="email" value="${sessionScope.rm.email}" required />
        </div>
    
        <div class="input-box">
          <label>Password</label>
          <input type="password" placeholder="Enter password" name="password" value="${sessionScope.rm.password}" required>
        </div>

        <div class="input-box">
          <label>Phone Number</label>
          <input type="number" placeholder="Enter phone number" name="mob" value="${sessionScope.rm.mob}" required />
        </div>




        <div class="input-box">
          <label>Birth Date</label>
          <input type="date" placeholder="Enter birth date" name="dob" value="${sessionScope.rm.dob}" required /><br><br>
        </div>

        <div class="course-box">
          <label>Course</label>
          <input type="checkbox" name="course" value="JAVA" ${sessionScope.rm.course.equals("JAVA") ? "checked" : ""}>
          <label>JAVA</label>
          <input type="checkbox" name="course" value="HTML" ${sessionScope.rm.course.equals("HTML") ? "checked" : ""}>
          <label>HTML</label>
          <input type="checkbox" name="course" value="JSP" ${sessionScope.rm.course.equals("JSP") ? "checked" : ""}>
          <label>JSP</label>
          <input type="checkbox" name="course" value="CSS" ${sessionScope.rm.course.equals("CSS") ? "checked" : ""}>
          <label>CSS</label>
        </div>
        
        <div class="gender-box">
          <h3>Gender</h3>
          <div class="gender-option">
            <div class="gender">
              <input type="radio" value="Male" name="gender" ${sessionScope.rm.gender.equals("Male") ? "checked" : ""}>
              <label for="check-male">Male</label>
            </div>
            <div class="gender">
              <input type="radio" value="Female" name="gender" ${sessionScope.rm.gender.equals("Female") ? "checked" : ""}>
              <label for="check-female">Female</label>
            </div>
            <div class="gender">
              <input type="radio" value="Other" name="gender" ${sessionScope.rm.gender.equals("Other") ? "checked" : ""}>
              <label for="check-other">prefer not to say</label>
            </div>
          </div>
        </div>
        <div class="input-box address">
          <label>Address</label>
          <input type="text" placeholder="Enter Your address" name="address" value="${sessionScope.rm.address}" required />
          <div class="column">
            <div class="select-box">
              <select name="country">
                <option hidden>Country</option>
                <option value="America" ${sessionScope.rm.country.equals("America") ? "selected" : ""}>America</option>
                <option value="Japan" ${sessionScope.rm.country.equals("Japan") ? "selected" : ""}>Japan</option>
                <option value="India" ${sessionScope.rm.country.equals("India") ? "selected" : ""}>India</option>
                <option value="Nepal" ${sessionScope.rm.country.equals("Nepal") ? "selected" : ""}>Nepal</option>
              </select>
            
          <div class="column">
            <input type="text" placeholder="Enter your region" name="region" value="${sessionScope.rm.region}" required />
            <input type="text" placeholder="Enter Pin Code" name="pin" value="${sessionScope.rm.pin}" required />
          </div>
        </div>
        <button type="submit">Update</button>
      </form>
    </section>
</body>
</html>
