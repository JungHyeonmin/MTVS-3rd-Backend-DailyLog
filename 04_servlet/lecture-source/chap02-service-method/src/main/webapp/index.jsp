<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <h1> service() 메서드의 역할</h1>

    <h3>GET 방식의 요청</h3>

    <h4> a 태그의 href 속성값 변경</h4>

    <a href ="request-service">서비스 메서드 요청하기</a>

    <h4>form태그의 method 속성을 get으로 설정 get이 기본값이다.</h4>

    <!-- <form> : 텍스트 필드에 글자를 입력하거나, 체크박스나 라디오 버튼을 클릭하고 제출 버튼을 누르면 백엔드 서버에 양식이 전달되어 정보를 처리하게 됩니다.-->
    <form action="request-service" method="get">
        <input type="submit" value="GET방식 요청 전송"/>
    </form>

    <h3>POST 방식의 요청</h3>
    <h4>form 태그의 method 속성을 post로 설정</h4>
    <form action="request-service" method="post">
        <!-- <input> : 사용자로부터 입력을 받을 수 있는 입력 필드(input filed)를 정의할 때 사용합니다.-->
        <input type="submit" value ="POST방식 요청 전송">
    </form>
</body>
</html>