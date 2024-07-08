<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<!-- /forward : 절대경로 - 최상위 파일(root)로부터의 경로-->
<!-- forward : 상대경로 - 현재 파일위치를 기준으로 연결하려는 파일의 상대적인 경로(../)-->
<h1>forward</h1>
<form action="forward" method="post"> <!--post 형식으로 전달-->
    <label>아이디 : </label> <input type="text" name="userId"><br>
    <label>비밀번호 : </label> <input type="password" name="password"><br>
    <input type="submit" value="로그인">
</form>
</body>
</html>