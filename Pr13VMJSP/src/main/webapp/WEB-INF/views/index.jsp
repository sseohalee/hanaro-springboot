<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="ko" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>자판기 프로그램</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="../static/index.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <div class="bg-red-700 pt-3 text-center font-semibold">
        <div class="bg-white m-3 rounded-t-lg">
            <h2 class="text-2xl font-bold text-red-700"><spring:message code="title" /></h2>
        </div>
        <div class="grid grid-cols-3 gap-3">
            <div class="text-xl bg-white text-red-700 rounded-r-lg ml-3"><spring:message code="product.list" /></div>
               <div class="text-white">
                  <a href="/changeLocale">한/영 전환</a>
               </div>
            <div class="text-white"> - </div>
        </div>
        <div class="bg-white m-3 p-3">
            <div>상품 목록이 비어있습니다.</div>
            <c:if test="${!empty(productList)}">
                <table class="w-full border-2 border-red-500">
                    <thead>
                        <tr>
                            <th><spring:message code="product.num" /></th>
                            <th><spring:message code="product.price" /></th>
                            <th><spring:message code="product.limitdate" /></th>
                            <th><spring:message code="product.edit" /></th>
                            <th><spring:message code="product.remove" /></th>
                            <th><spring:message code="product.num" /></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="product" items="${productList}" varStatus="status">
                            <tr>
                                <td class="py-2"><spring:message code="status.count" /></td>
                                <td><spring:message code="product.name" /></td>
                                <td><spring:message code="product.price" /></td>
                                <td><spring:message code="product.limit_date" /></td>
                                <td><a href="/update?index=${ status.index }" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-1 px-4 rounded-md m-1" role="button" text="수정"></a></td>
                                <td><a href="/delete?index=${ status.index }" onclick="return confirmAndNotify(this)" class="bg-red-500 hover:bg-red-700 text-white font-bold py-1 px-4 rounded-md m-1" role="button" text="삭제"></a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
        <div class="grid grid-cols-5">
            <div class="col-end-6 col-span-2 bg-white m-3 text-red-700 rounded-l-lg"><spring:message code="#{product.total(${listLength})}" /></div>
        </div>
        <button onclick="location.href='/add';" class="bg-red-500 text-white rounded-lg p-3 mb-3"-><spring:message code="#{product.addBtn}" /></button>

    </div>

    <script>
        function confirmAndNotify(link) {
            var confirmation = confirm("정말로 삭제하시겠습니까?");
            if (confirmation) {
              alert("삭제하였습니다!");
              // "확인"
              window.location.href = link.getAttribute("href");
            }
            return false;
       }
    </script>
</body>
</html>