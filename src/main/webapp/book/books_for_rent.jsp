<%--
  Created by IntelliJ IDEA.
  User: cs
  Date: 13.10.2019
  Time: 09:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<%@include file="../head.jspf" %>
<body>
<%@include file="../navbar.jspf" %>
<div class="container-fluid mx-auto" style="width: 800px;">
    <h1>Lista książek do wypożyczenia</h1>
    <div class="container">
        <table class="table table-sm">
            <tr>
                <th>
                    id
                </th>
                <th>
                    tytuł
                </th>
                <th>
                    ISBN
                </th>
                <th>
                    rok wydania
                </th>
                <th>
                    autorzy
                </th>
                <th>
                    cena
                </th>
            </tr>
            <c:forEach items="${requestScope.books}" var="book">
                <tr>
                    <td>
                            ${book.id}
                    </td>
                    <td>
                            ${book.title}
                    </td>
                    <td>
                            ${book.ISBN}
                    </td>
                    <td>
                            ${book.publicationYear}
                    </td>
                    <td>
                        <c:forEach items="${book.authors}" var="author">
                            <p>${author.name}</p>
                        </c:forEach>
                    </td>
                    <td>
                            ${book.price}
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/cart/add?book_id=${book.id}">Dodaj do koszyka</a>
                        <a href="${pageContext.request.contextPath}/cart/remove?book_id=${book.id}">Usuń z koszyka</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<%@include file="../body_end.jspf"%>
</body>
</html>