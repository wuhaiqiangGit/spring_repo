<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>跨服务器上传</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/upload/other" method="post" enctype="multipart/form-data">
    <input type="file" name="upload"><br/><br/>
    <input type="submit" value="上传">
</form>
</body>
</html>