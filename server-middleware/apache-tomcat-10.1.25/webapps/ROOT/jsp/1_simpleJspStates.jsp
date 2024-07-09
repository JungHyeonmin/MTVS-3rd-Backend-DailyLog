<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 페이지 지시자 태그-->
<html>
<head>
    <title>1_simpleJspStates</title>
</head>
<body>
<!--html 주석-->
<%--jsp 주석--%>

<!-- 선언 태그 -->
<!-- 서블릿으로 변환 시 선언 태그 내에 작성한 내용을 필드로 선언한다.-->
<%!
    private String name;
    private int age;
%>

<!-- <scriptlet> 태그-->
<!--간단한 자바 코드를 작성할  수 있는 부분이다.-->
<%
    // 자바 코드를 작성할 수 있음
        /* 자바 코드로 해석되기 때문에
        자바에서 사용하는 주석을 그대로 사용할 수 있다.
        */

    // jsp -> servlet (jps container 의 역할) - translate -> compile(.java-> .class)
    // jsp    --->   .java   ---> .class ---> runtime
    // 에러 translate       compile      execute

    name = "홍길동";
    age = 20;

    System.out.println("name = " + name);
    System.out.println("age = " + age);

    // String str = null;
    // str.charAt(0);
%>

    <!--expression 태그-->
    name:<%= name%><br>
    age : <%=age%><br>
</body>
</html>
