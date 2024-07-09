<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %> <!-- isErrorPage : 에러 페이지로 선언-->
<html>
<head>
    <title>ErrorPage</title>
</head>
<body>
    <%
        // exception : 내장객체
        String exceptionType = exception.getClass().getName();
        String exceptionMessage = exception.getMessage();
    %>

    <h1><%= exceptionType%></h1>
    <h2><%= exceptionMessage%></h2>

</body>
</html>
