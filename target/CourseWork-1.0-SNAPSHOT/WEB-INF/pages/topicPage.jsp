<%@ page import="model.elements.Topic" %>
<%@ page import="model.elements.Post" %>
<%@ page import="model.users.Administrator" %>
<%@ page import="model.users.CommonUser" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title><%=((Topic) request.getSession().getAttribute("currentTopic")).getTheme()%></title>
    </head>
    <body>
        <!-- Кнопка повернення на головну сторінку -->
        <form action="ToMain", method="get">
            <input type="submit" value="Back to main page">
        </form>

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

        <!-- Кнопка для зміни даної теми, тільки для адміністраторів -->
        <% if(request.getSession().getAttribute("role") instanceof Administrator){ %>
        <form action="ToChangeTopic", method="get">
            <input type="submit" value="Change topic">
        </form>
        <%}%>

        <!-- Вивід заголовку теми та початкового допису -->
        <h1><%=((Topic) request.getSession().getAttribute("currentTopic")).getTheme()%></h1>
        <br>
        <table cellpadding="4" border="2">
            <tr>
                <th>
                    <%=((Topic) request.getSession().getAttribute("currentTopic")).getAuthor().getName()%>:
                </th>
                <th>
                    <%=((Topic) request.getSession().getAttribute("currentTopic")).getStartMessage()%>
                </th>
            </tr>
        </table>
        <br> <br>

        <!-- Вивід дописів теми -->
        <% if(!(((Topic) request.getSession().getAttribute("currentTopic")).getPosts().isEmpty())){ %>
        <table cellpadding="4" border="2">
            <% for(Post post : ((Topic) request.getSession().getAttribute("currentTopic")).getPosts()) { %>
            <tr>
                <th>
                    <%=post.getAuthor().getName()%>:
                </th>
                <th>
                    <%=post.getMessage()%>
                </th>
                <% if(request.getSession().getAttribute("role") instanceof Administrator){ %>
                <th>
                    <form method="post" action="DeletePost">
                        <input type="hidden" name="postId" value="<%=post.getId()%>">
                        <input type="submit" value="Delete">
                    </form>
                </th>
                <%}%>
            </tr>
            <%}%>
        </table>
        <%} else {%>
            <h1> No messages yet </h1>
        <%}%>
        <br>

        <!-- Форма для залишення посту -->
        <% if(request.getSession().getAttribute("role") instanceof CommonUser){ %>
        <form action="LeavePost", method="post">
            <textarea name="usersMessage" cols="40" rows="3"></textarea>
            <br>
            <input type="submit" value="Leave message">
        </form>
        <%}%>

        <% if(request.getAttribute("errorMessages") != null){ %>
            <%for(String message : (ArrayList<String>) request.getAttribute("errorMessages")){%>
                <%=message%>
            <%}%>
        <%}%>
    </body>
</html>
