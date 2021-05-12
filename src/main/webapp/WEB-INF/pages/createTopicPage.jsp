<%@ page import="java.util.ArrayList" %>
<%@ page import="model.users.CommonUser" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Create Topic</title>
    </head>
    <body>

        <!-- Верхнє віконце що відображає ім'я користувача та пропонує увійти гостю та вийти зареєстрованому користувачу -->
        <div align="right">

            <% if(request.getSession().getAttribute("role") == null
                    || !(request.getSession().getAttribute("role") instanceof CommonUser)) { %>
            <form action="ToSignIn", method="get">
                <input type="submit" value="Sing in">
            </form>
            <% } else { %>
            <p> You logged as <%=((CommonUser) request.getSession().getAttribute("role")).getName()%> </p>
            <form action="LogOut", method="post">
                <input type="submit" value="Log out">
            </form>
            <% } %>
        </div>

        <!-- Форма для створення теми -->
        <form action="CreateTopic", method="post">
            Input theme: <input type="text" name="theme">
            <br>
            Input start message: <textarea name="startMessage" cols="40" rows="3"></textarea>
            <br>
            <input type="submit" value="Create">
        </form>

        <form action="ToMain", method="get">
            <input type="submit" value="Back to main page">
        </form>

        <!-- Вивід повідомлень, якщо такі є -->
        <br>
        <% if(request.getAttribute("messages") != null){ %>
            <%for(String message : (ArrayList<String>) request.getAttribute("messages")){%>
                <%=message%>
                <br>
            <%}%>
        <%}%>
    </body>
</html>
