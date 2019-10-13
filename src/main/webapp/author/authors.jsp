<%--
  Created by IntelliJ IDEA.
  User: cs
  Date: 13.10.2019
  Time: 09:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="../head.jspf"%>
<body>
<%@include file="../navbar.jspf"%>
<div class="container-fluid mx-auto" style="width: 800px;">
    <h1>Lista autorów</h1>
    <div class="container">
        <table class="table table-sm">
            <tr>
               <th>
                   id
               </th>
                <th>
                    imię i nazwisko
                </th>
                <th>
                    kraj
                </th>
                <th>
                    akcje
                </th>
            </tr>
            <c:forEach items="${requestScope.authors}" var="aut">
                <tr>
                    <td>
                        ${aut.id}
                    </td>
                    <td>
                        ${aut.country}
                    </td>
                    <td>
                        ${aut.name}
                    </td>
                    <td>
                        <c:if test="${requestScope.book != null}">
                        <a href="${pageContext.request.contextPath}/admin/book/addAuthor?book_id=${requestScope.book.id}&author_id=${aut.id}">Dodaj autora do książki</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="container">
        <form action="?" method="post">
            <div class="form-group">
                <label for="name">imię i nazwisko</label>
                <input type="text" name="name" class="form-control" id="name" aria-describedby="emailHelp" placeholder="wpisz dane autora">
            </div>
            <div class="form-group">
                <label for="country">kraj pochodzenia</label>
                <input type="text" name="country" class="form-control" id="country" placeholder="kraj">
            </div>
            <c:if test="${requestScope.book != null}">
                <input type="hidden" name="book_id" value="${requestScope.book.id}">
            </c:if>
            <button type="submit" class="btn btn-primary">Zapisz</button>
        </form>
    </div>
</div>

<%@include file="../body_end.jspf"%>
</body>
</html>
