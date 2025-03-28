<%@ page import="com.DB.DBCon" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.Dao.todoDao" %>
<%@ page import="java.util.List" %>
<%@page errorPage="component/error.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: Bilal Khan
  Date: 3/18/2025
  Time: 7:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page buffer="none" %>
<html>
<%--<head>--%>
<%--    <title>Todo App</title>--%>
<%--    <style>--%>
<%--        .dark-mode {--%>
<%--            background-color: black;--%>
<%--            color: white;--%>
<%--        }--%>
<%--    </style>--%>
</head>
<%@include file="component/all_css_boot_nav.jsp" %>
<body>
<%@include file="component/navbar.jsp" %>

<h1 class="text-center text-success fw-bold">TODO-APP</h1>
<%
    String msg = (String) session.getAttribute("successMsg");
    if (msg != null) {%>
<div class="alert alert-success" role="alert">
    <%= msg %>
</div>
<%
        session.removeAttribute("successMsg");
    }
%>
<%
    String fail = (String) session.getAttribute("failMsg");
    if (fail != null) {%>
<div class="alert alert-danger d-flex align-items-center" role="alert">
    <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Danger:">
        <use xlink:href="#exclamation-triangle-fill"/>
    </svg>
    <div>
        <%=fail%>
    </div>
</div>
<%
        session.removeAttribute("failMsg");
    }
%>

<div class="container" style="justify-content: center; margin-top: 50px">
    <div class="card-body shadow-lg bg-body rounded">
        <table class="table  table-bordered table-lg table-striped table-hover">
            <thead class="bg-success text-white">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Todo</th>
                <th scope="col">Status</th>
                <th scope="col">Actions</th>
            </tr>
            </thead>
            <tbody>
            <%
                com.Dao.todoDao dao = new todoDao(DBCon.connectionProvider());
                List<com.entity.entities> dtls = dao.getTodoDtls();
                for (com.entity.entities details : dtls) {%>
            <tr>
                <th scope="row"><%= details.getId()%>
                </th>
                <td scope="col"><%=details.getName()%>
                </td>
                <td><%=details.getTodo()%>
                </td>
                <td><%=details.getStatus()%>
                </td>
                <td>
                    <a href="edit.jsp?id=<%=details.getId()%>" class="btn btn-sm btn-success">Edit</a>
                    <a href="deleteTodo?id=<%=details.getId()%>" class="btn btn-sm btn-danger">Delete</a>
                </td>
            </tr>
            <%
                }
            %>

            </tbody>
        </table>
    </div>
</div>



</body>
<%--<script>--%>
<%--    function myFunction() {--%>
<%--        var element = document.body;--%>
<%--        element.classList.toggle("dark-mode");--%>
<%--    }--%>
<%--</script>--%>
</html>
