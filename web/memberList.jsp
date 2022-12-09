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
<table width="500" border="1">
    <tr>
        <td>회원번호</td>
        <td>이름</td>
        <td>전화</td>
        <td>주소</td>
        <td>가입날짜</td>
        <td>도시</td>
        <td>등급</td>
    </tr>
    <c:forEach var="board" items="${list}">
        <tr>
            <td><a href="selectOne.do?custno=${board.custno}">${board.custno}</a></td>
            <td>${board.custname}</td>
            <td>${board.phone}</td>
            <td>${board.address}</td>
            <td>${board.joindate}</td>
            <td>${board.grade}</td>
            <td>${board.city}</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="7"><a href="join.do">글 작성</a></td>
    </tr>
</table>
<jsp:include page="footer.jsp"></jsp:include>
</center>
</body>
</html>
