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
    <h1>Lista książek</h1>
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
                        <a href="${pageContext.request.contextPath}/admin/author?book_id=${book.id}">Dodaj autora</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <h2>Dodaj książkę</h2>
    <div class="container">
        <form action="?" method="post">
            <div class="form-group">
                <label for="title">tytuł</label>
                <input type="text" name="title" class="form-control" id="title" aria-describedby="emailHelp" placeholder="podaj tytuł ">
            </div>
            <div class="form-group">
                <label for="ISBN">ISBN</label>
                <input type="text" name="ISBN" class="form-control" id="ISBN" placeholder="wpisz ISBN z 13 znaków" maxlength="13" minlength="13">
            </div>
            <div class="form-group">
                <label for="publicationYear">rok publikacji</label>
                <input type="number" name="publicationYear" class="form-control" id="publicationYear" placeholder="rok publikacji" aria-valuemin="1900">
            </div>
            <button type="submit" class="btn btn-primary">Zapisz</button>
        </form>
    </div>
</div>

<%@include file="../body_end.jspf"%>
</body>
</html>
