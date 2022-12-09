<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2022-12-08
  Time: 오후 5:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body style="align-content: center">
<center>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="nav.jsp"></jsp:include>
<table width="500" cellpadding="0" cellspacing="0" border="1">
    <form action="join_resist.do" method="post">
        -- form action : form태그에서 submit시 write.do로 이동하도록 설정하는부분
        <tr>
            <td>회원번호(자동발생)</td>
            <td><input type="text" name="custno" size="50"></td>
        </tr>
        <tr>
            <td>이름</td>
            <td><input type="text" name="custname" size="50"></td>
        </tr>
        <tr>
            <td>전화번호</td>
            <td><input type="text" name="phone" size="50"></td>
        </tr>
        <tr>
            <td>주소</td>
            <td><textarea name="address" rows="10"></textarea></td>
        </tr>
        <tr>
            <td>가입일</td>
            <td><input name="joindate" rows="10"></input></td>
        </tr>
        <tr>
            <td>등급</td>
            <td><input name="grade" size="10"></input></td>
        </tr>
        <tr>
            <td>도시코드</td>
            <td><input name="city" size="10"></input></td>
        </tr>
        <tr>
            <td colspan="2"> <input type="submit" value="입력">
                &nbsp;&nbsp;<a href="memberList.do">목록보기</a></td>
        </tr>
    </form>
</table>
<jsp:include page="footer.jsp"></jsp:include>
</center>
</body>
</html>
