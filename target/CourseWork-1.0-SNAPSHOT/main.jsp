<%@ page import="model.users.Guest" %>
<%@ page import="model.users.CommonUser" %>
<%@ page import="model.elements.Topic" %>
<%@ page import="java.util.Collection" %>
<%@ page import="model.users.Administrator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Головна сторінка -->
<html>
    <head>
        <title>Main page</title>
    </head>
    <body>
        <!-- Якщо список тем ще не переданий робить запит до сервлету Main -->
        <% if(request.getAttribute("topics") == null){
            request.getRequestDispatcher("/Main").forward(request, response);
        } %>

        <!-- Верхнє віконце що відображає ім'я користувача та пропонує увійти гостю та вийти зареєстрованому користувачу -->
        <div align="right">
            <p> You logged as <%=((CommonUser) request.getSession().getAttribute("role")).getName()%> </p>
            <% if(request.getSession().getAttribute("role") == null
                    || !(request.getSession().getAttribute("role") instanceof CommonUser)) { %>
                <form action="ToSignIn", method="get">
                    <input type="submit" value="Sing in">
                </form>
            <% } else { %>
                <form action="LogOut", method="post">
                    <input type="submit" value="Log out">
                </form>
            <% } %>
        </div>

        <!-- Кнопка створення теми, тільки для адміністраторів -->
        <% if(request.getSession().getAttribute("role") instanceof Administrator){ %>
        <form method="get" action="ToTopicCreator">
            <input type="submit" value="Create new topic">
        </form>
        <br>
        <%}%>

        <!-- Вивід усіх тем -->
        <% if(!((Collection<Topic>) request.getAttribute("topics")).isEmpty()){ %>
        <table cellpadding="4" border="2">
        <% for(Topic topic : (Collection<Topic>) request.getAttribute("topics")){ %>
            <tr>
                <th><h1><%=topic.getTheme()%></h1></th>
                <th>
                    <form method="get" action="GetTopic">
                        <input type="hidden" name="topicId" value="<%=topic.getId()%>">
                        <input type="submit" value="Read">
                    </form>
                <th>
                <% if(request.getSession().getAttribute("role") instanceof Administrator){ %>
                <th>
                    <form method="post" action="DeleteTopic">
                    <input type="hidden" name="topicId" value="<%=topic.getId()%>">
                    <input type="submit" value="Delete">
                </form>
                </th>
                <%}%>
            </tr>
        <%}%>
        </table>
        <% } else { %>
        <h1>No topics yet</h1>
        <% } %>
    </body>
</html>
