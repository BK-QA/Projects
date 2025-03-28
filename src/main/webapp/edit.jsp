<%@ page import="com.Dao.todoDao" %>
<%@ page import="com.DB.DBCon" %>
<%@page errorPage="component/error.jsp" %>

<%@ page import="com.entity.entities" %><%--
  Created by IntelliJ IDEA.
  User: Bilal Khan
  Date: 3/19/2025
  Time: 7:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Todo</title>
</head>
<%@include file="component/all_css_boot_nav.jsp" %>
<body>
<%@include file="component/navbar.jsp" %>
<div class="container ">
    <div class="row p-5 m-2">
        <div class="col-md-6 offset-md-3">
            <div class="card">
                <div class="card-body shadow-lg bg-body rounded">
                    <%
                        int id = Integer.parseInt(request.getParameter("id"));
                        com.Dao.todoDao dao = new todoDao(DBCon.connectionProvider());
                        entities toDoById = dao.getToDoById(id);
                    %>
                    <h2 class="text-center text-success fw-bold">Update Todo</h2>
                    <form action="updateTodo" method="post">
                        <input type="hidden" name="id" value="<%=toDoById.getId()%>">
                        <div class="mb-3">
                            <label for="exampleInputEmail1" class="form-label text-dark">Name</label>
                            <input type="text" class="form-control" id="exampleInputEmail1"
                                   aria-describedby="emailHelp" name="username" placeholder="Enter your name" required
                                   value="<%=toDoById.getName()%>">
                            <%--                <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>--%>
                        </div>

                        <div class="mb-3">
                            <label for="exampleInputPassword1" class="form-label text-dark">Todo</label>
                            <input type="text" class="form-control" id="exampleInputPassword1" name="todo"
                                   placeholder="Enter your task " required value="<%=toDoById.getTodo()%>">
                        </div>
                        <select class="form-select p-2" aria-label="Default select example" name="status">
                            <%
                                if ("Pending....".equals(toDoById.getStatus())) {%>
                            <option value="Complete">Completed</option>
                            <option value="Pending....">---Pending---</option>

                            <%
                            } else {%>
                            <option value="Pending....">---Pending---</option>
                            <option value="Complete">Completed</option>
                            <% }
                            %>
                        </select>
                        <div class="text-center p-4 m-2">
                            <button type="submit" class="btn btn-md btn-outline-primary">Update</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
