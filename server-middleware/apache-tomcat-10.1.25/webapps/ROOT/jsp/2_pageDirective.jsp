<!--지시자 태그는 page, include, taglib(수업에서 안배움) 지시자 태그가 있다.-->
<%@ page contentType="text/html;charset=UTF-8" language="java"

         import="java.util.Date, java.util.ArrayList" errorPage="errorPage.jsp"
%>
<!-- == resp.setContentType("text/html; charset=UTF-8");-->
<html>
<head>
    <title>2_pageDirective.jsp</title>
</head>
<body>
    <%
        java.util.Date date = new java.util.Date(); // import : 클래스명을 안쓰기 위해서 사한다. 페이지 지시자 태그에서 import 문 작성한다.
        System.out.println(date);

        // String str = null;
        // char ch = str.charAt(0);
    %>
</body>
</html>
