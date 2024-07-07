<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>

<body>
<h1>Request Parameter</h1>
<h3>GET 방식의 요청</h3>
<h4>form 태그를 이용한 get 방식 요청</h4>
<!--<form> : 텍스트 필드에 글자를 입력하거나, 체크박스나 라디오 버튼을 클릭하고 제출 버튼을 누르면 백엔드 서버에 양식이 전달되어 정보를 처리하게 됩니다.-->
<!--<form> 태그의 action 속성은 폼 데이터(form data)를 서버로 보낼 때 해당 데이터가 도착할 URL을 명시합니다.-->
<!--querystring 이라는 url 로 호출시 QueryStringTestServlet 클래스가 응답을 한다.-->
<form action="querystring" method="get">
    <!-- <label> : 사용자 인터페이스를 제공하는 컨트롤 요소들의 이름표(label, 레이블)를 나타내는 태그입니다.-->
    <label>이름 : </label><input type="text" name="name">
    <br>

    <label>나이 : </label><input type="number" name="age">
    <br>

    <label>생일 : </label><input type="date" name="birthday">
    <br>

    <label>성별 : </label><input type="number" name="gender">
    <br>

    <input type="radio" name="gender" id="male" value="M">
    <label for="male">남자</label>

    <input type="radio" name="gender" id="female" value="F">
    <label for="female">여자</label>
    <br>

    <label>국적 : </label>
    <!-- <select> : 옵션 메뉴를 제공하는 드롭다운 리스트(drop-down list)를 정의할 때 사용합니다.(선택창)-->
    <select name="national">
        <option value="ko">한국</option>
        <option value="ch">중국</option>
        <option value="jp">일본</option>
        <option value="etc">기타</option>
    </select>
    <br>

    <label>취미 : </label>
    <input type="checkbox" name="hobbies" id="movie" value="movie">
    <label for="movie">영화</label>
    <input type="checkbox" name="hobbies" id="music" value="music">
    <label for="music">음악</label>
    <input type="checkbox" name="hobbies" id="sleep" value="sleep">
    <label for="sleep">취침</label>
    <br>
    <!-- submit : <form> 태그 내에 입력된 데이터를 서버로 전달해 줍니다.-->
    <input type="submit" value="전송">
</form>

<h4>a 태그의 href 속성에 직접 파라미터를 쿼리스트링 형태로 작성하여 get 요청</h4>
<a href="querystring?name=정현민&get=12&birthday=2019-02-02&get=&gender=M&national=ko&hobbies=movie&hobbies=music&hobbies=sleep">
    쿼리스트링을 이용한 값 전달
</a>

<h4>form 태그를 이용한 post 방식 요청</h4>
<!-- method : <form> 태그의 method 속성은 폼 데이터(form data)가 서버로 제출될 때 사용되는 HTTP 메소드를 명시합니다. -->
<form action="formdata" method="post">
    <label>이름 : </label><input type="text" name="name">
    <br>

    <label>나이 : </label><input type="number" name="age">
    <br>

    <label>생일 : </label><input type="date" name="birthday">
    <br>

    <label>성별 : </label>
    <input type="radio" name="gender" id="male2" value="M">
    <label for="male">남자</label>

    <input type="radio" name="gender" id="female2" value="F">
    <label for="female">여자</label>
    <br>

    <label>국적 : </label>
    <select name="national">
        <option value="ko">한국</option>
        <option value="ch">중국</option>
        <option value="jp">일본</option>
        <option value="etc">기타</option>
    </select>
    <br>

    <label>취미 : </label>
    <input type="checkbox" name="hobbies" id="movie2" value="movie">
    <label for="movie2">영화</label>
    <input type="checkbox" name="hobbies" id="music2" value="music">
    <label for="music2">음악</label>
    <input type="checkbox" name="hobbies" id="sleep2" value="sleep">
    <label for="sleep2">취침</label>
    <br>

    <input type="submit" value="전송">
</form>


</body>
</html>