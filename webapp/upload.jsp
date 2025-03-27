<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>File Upload</title>
</head>
<body>

    <h2>Upload a File</h2>

    <form action="${pageContext.request.contextPath}/RegController" method="post" enctype="multipart/form-data">
        <label>Select file:</label>
        <input type="file" name="file" required />
        <br><br>
        <input type="submit" value="Upload" />
    </form>

</body>
</html>
