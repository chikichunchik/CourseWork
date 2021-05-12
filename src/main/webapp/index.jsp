<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Початкова сторінка, перенаправляє незареєстрованого користувача до сторінки реєстрації а зареєстрованого на головну -->
<html>
    <head>
        <title>Start redirect</title>
    </head>
    <body>
    <% if(request.getSession().getAttribute("role") == null ){
        request.getRequestDispatcher("WEB-INF/pages/registrationPage.jsp").forward(request, response);
    } else {
        response.sendRedirect("main.jsp");
    }%>

    </body>
</html>
