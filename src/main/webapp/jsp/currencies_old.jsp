<%@ page import="java.util.ArrayList" %>
<%@ page import="org.example.models.Currency" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    ArrayList<Currency> currencies = (ArrayList<Currency>) request.getAttribute("currenciesFromServer");
%>

    <table>
        <tr>
            <th>Id</th>
            <th>Code</th>
            <th>Full name</th>
            <th>Sign</th>
        </tr>
        <%
            for (Currency currency : currencies){
                %>
        <tr>
        <td><%=currency.getId()%></td>
        <td><%=currency.getCode()%></td>
        <td><%=currency.getFullName()%></td>
        <td><%=currency.getSign()%></td>
        </tr>
         <%}%>

    </table>

</body>
</html>