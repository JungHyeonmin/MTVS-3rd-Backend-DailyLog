<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <!--301,302라는 URL 을 강제로 바꾸라는 신호를 강제로 변환하는 것에 의의가 있다.-->
    <h1>redirect</h1>
    <ul>
        <!-- default 는 doGet() method-->
        <li><a href = "othersite">다른 웹 사이트로 redirect 테스트</a></li>
        <li><a href = "otherservlet">다른 서블릿으로 redirect 테스트</a></li>
    </ul>
</body>
</html>