<%@ page import="java.util.ArrayList" %>
<%@ page import="org.example.models.Currency" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <th>Id</th>
            <th>Code</th>
            <th>Full name</th>
            <th>Sign</th>
        </tr>
        <c:forEach items="${currenciesFromServer}" var="currency">
            <tr>
                <td>${currency.id}</td>
                <td>${currency.code}</td>
                <td>${currency.fullName}</td>
                <td>${currency.sign}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>