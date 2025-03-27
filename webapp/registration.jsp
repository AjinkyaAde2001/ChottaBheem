<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="reg.css">
</head>
<body>
<section class="container">
      <header>Registration Form</header>
      <form action="RegController" class="form" method="post">
        <div class="input-box">
          <label>Full Name</label>
          <input type="text" placeholder="Enter full name" name="name" required />
        </div>

        <div class="input-box">
          <label>Email Address</label>
          <input type="text" placeholder="Enter email address" name="email" required />
        </div>
    
    <div class="input-box">
    <label>Password</label>
    <input type="password" placeholder="Enter password" name="password" required>
    </div>
    
        <div class="column">
          <div class="input-box">
            <label>Phone Number</label>
            <input type="number" placeholder="Enter phone number" name="mob" required />
          </div>
          <div class="input-box">
            <label>Birth Date</label>
            <input type="date" placeholder="Enter birth date" name="dob" required /><br><br>
          </div>
        </div>
        <div class="course-box">
        <lable>Course</lable>
        <input type="checkbox" name="course" value="JAVA">
        <lable>JAVA</lable>
        <input type="checkbox" name="course" value="HTML">
        <lable>HTML</lable>
        <input type="checkbox" name="course" value="JSP">
        <lable>JSP</lable>
        <input type="checkbox" name="course" value="CSS">
        <lable>CSS</lable>
        
        </div>
        
        <div class="gender-box">
          <h3>Gender</h3>
          <div class="gender-option">
            <div class="gender">
              <input type="radio" value="Male" name="gender" >
              <label for="check-male">Male</label>
            </div>
            <div class="gender">
              <input type="radio" value="Female" name="gender" />
              <label for="check-female">Female</label>
            </div>
            <div class="gender">
              <input type="radio" value="Other" name="gender" />
              <label for="check-other">prefer not to say</label>
            </div>
          </div>
        </div>
        <div class="input-box address">
          <label>Address</label>
          <input type="text" placeholder="Enter Your address" name="address" required />
          <div class="column">
            <div class="select-box">
              <select name="country">
                <option hidden>Country</option>
                <option>America</option>
                <option>Japan</option>
                <option>India</option>
                <option>Nepal</option>
              </select>
            </div>
            <input type="text" placeholder="Enter your city" name="city" required />
          </div>
          <div class="column">
            <input type="text" placeholder="Enter your region" name="region" required />
            <input type="number" placeholder="Enter Pin Code" name="pin" required />
          </div>
        </div>
        <button type="submit">Submit</button>
      </form>
    </section>
</body>
</html>