<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>연습문제</title>
</head>
<body>
  
  <c:forEach var="i" begin="1" end="100" step="1">
    <c:set var="sum" value="${sum+i}" />
  </c:forEach>
  <b>연습문제 1:</b> ${sum} <br><br>

  <b>연습문제 2:</b> <br>
  <c:forEach var="i" begin="1" end="9" step="1">
    7 x ${i} = ${7*i} <br>
  </c:forEach>

  <br><b>연습문제 3: </b><br>
  <c:forEach var="j" begin="1" end="100" step="1">
    <c:if test="${j%2==0 && j%5==0}">
      ${j} <br>
    </c:if>
  </c:forEach>
</body>
</html>